package GUI_Cinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

// Import your service stubs
import S01Seat_Heating.CinemaImmersiveGrpc;
import S01Seat_Heating.ActivateRequest;
import S01Seat_Heating.ActivateResponse;

import S03Cinema_Lights.CinemaLightsServiceGrpc;
import S03Cinema_Lights.LightsRequest;
import S03Cinema_Lights.LightsResponse;

import S04Cinema_Admission.TicketServiceGrpc;
import S04Cinema_Admission.TicketRequest;
import S04Cinema_Admission.TicketResponse;

import S05Drink_Catalog.DrinkServiceGrpc;
import S05Drink_Catalog.DrinkRequest;
import S05Drink_Catalog.DrinkResponse;

import S06Food_Payment.PaymentServiceGrpc;
import S06Food_Payment.PaymentRequest;
import S06Food_Payment.PaymentResponse;

public class AllServers implements ActionListener {

    // heating
    private JTextField entryHeating, replyHeating;
    private ManagedChannel heatingChannel;
    private CinemaImmersiveGrpc.CinemaImmersiveBlockingStub heatingStub;

    // lights
    private JTextField entryRoom, entryCommand, replyLights;
    private ManagedChannel lightsChannel;
    private CinemaLightsServiceGrpc.CinemaLightsServiceStub lightsStub;
    private StreamObserver<LightsRequest> requestObserver;

    // tickets
    private JTextField entryTicketNumber, entryName;
    JTextField replyTicketStatus;
	private JTextArea ticketLog;
    private ManagedChannel ticketChannel;
    private TicketServiceGrpc.TicketServiceStub ticketStub;
    private StreamObserver<TicketRequest> ticketRequestObserver;

    // drinks
    private JTextField entryDrinkIds;
    private JTextArea replyDrinkCatalog;
    private ManagedChannel drinkChannel;
    private DrinkServiceGrpc.DrinkServiceStub drinkStub;
    private StreamObserver<DrinkRequest> drinkRequestObserver;

    // payment
    private JTextField entryCardNumber, entryCardholder, entrySecurityNumber, entryIssueDate;
    private JTextArea replyPayment;
    private ManagedChannel paymentChannel;
    private PaymentServiceGrpc.PaymentServiceStub paymentStub;
    private StreamObserver<PaymentRequest> paymentRequestObserver;

    // actions
    private JButton heatingButton, lightsButton, ticketButton, drinkButton, paymentButton;

    public AllServers() {
        // gRPC clients
        heatingChannel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        heatingStub = CinemaImmersiveGrpc.newBlockingStub(heatingChannel);

        lightsChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        lightsStub = CinemaLightsServiceGrpc.newStub(lightsChannel);

        ticketChannel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();
        ticketStub = TicketServiceGrpc.newStub(ticketChannel);

        drinkChannel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();
        drinkStub = DrinkServiceGrpc.newStub(drinkChannel);

        paymentChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        paymentStub = PaymentServiceGrpc.newStub(paymentChannel);

        // Initialize StreamObserver for lights control
        requestObserver = lightsStub.controlLights(new StreamObserver<LightsResponse>() {
            @Override
            public void onNext(LightsResponse response) {
                SwingUtilities.invokeLater(() -> replyLights.setText(response.getStatus()));
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> replyLights.setText("Error: " + t.getMessage()));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> replyLights.setText("Server has completed processing."));
            }
        });

        //  StreamObserver for ticket requests
        ticketRequestObserver = ticketStub.enterTicketNumber(new StreamObserver<TicketResponse>() {
            @Override
            public void onNext(TicketResponse response) {
                SwingUtilities.invokeLater(() -> {
                    replyTicketStatus.setText(response.getMessage());
                    ticketLog.append("Received response: " + response.getMessage() + "\n");
                });
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> {
                    replyTicketStatus.setText("Error: " + t.getMessage());
                    ticketLog.append("Error: " + t.getMessage() + "\n");
                });
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> {
                    replyTicketStatus.setText("Server has completed processing.");
                    ticketLog.append("Server has completed processing.\n");
                });
            }
        });

        // StreamObserver for drink catalog
        drinkRequestObserver = new StreamObserver<DrinkRequest>() {
            public void onNext(DrinkResponse response) {
                SwingUtilities.invokeLater(() -> replyDrinkCatalog.append(response.getConfirmationMessage() + "\n"));
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> replyDrinkCatalog.append("Error: " + t.getMessage() + "\n"));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> replyDrinkCatalog.append("Server has completed processing.\n"));
            }

            @Override
            public void onNext(DrinkRequest value) {
                         }
        };

        // StreamObserver for payment service
        paymentRequestObserver = new StreamObserver<PaymentRequest>() {
            @Override
            public void onNext(PaymentRequest request) {
                SwingUtilities.invokeLater(() -> {
                    PaymentResponse response = PaymentResponse.newBuilder()
                            .setMessage("Payment accepted")
                            .setConfirmationNumber("123456789")
                            .setTicketNumber("987654321")
                            .build();
                    replyPayment.append("Payment accepted\n");
                });
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> replyPayment.append("Error: " + t.getMessage() + "\n"));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> replyPayment.append("Payment process completed.\n"));
            }
        };
    }

    private JPanel getServiceJPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      //Panels
        panel.add(createHeatingPanel());
        panel.add(createLightsPanel());
        panel.add(createTicketsPanel());
        panel.add(createDrinksPanel());
        panel.add(createPaymentPanel());
        return panel;
    }

    private JPanel createHeatingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter seat for heating (e.g., j8):");
        entryHeating = new JTextField("", 10);
        heatingButton = new JButton("Request Heating");
        replyHeating = new JTextField("", 20);
        replyHeating.setEditable(false);

        heatingButton.addActionListener(this);

        panel.add(label);
        panel.add(entryHeating);
        panel.add(heatingButton);
        panel.add(replyHeating);

        return panel;
    }

    private JPanel createLightsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel roomLabel = new JLabel("Enter room number:");
        entryRoom = new JTextField("", 5);
        JLabel commandLabel = new JLabel("Enter command:");
        entryCommand = new JTextField("", 10);
        lightsButton = new JButton("Send Lights Command");
        replyLights = new JTextField("", 30);
        replyLights.setEditable(false);

        lightsButton.addActionListener(this);  

        panel.add(roomLabel);
        panel.add(entryRoom);
        panel.add(commandLabel);
        panel.add(entryCommand);
        panel.add(lightsButton);
        panel.add(replyLights);

        return panel;
    }

    private JPanel createTicketsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel ticketLabel = new JLabel("Enter ticket number:");
        entryTicketNumber = new JTextField("", 10);
        JLabel nameLabel = new JLabel("Enter name:");
        entryName = new JTextField("", 10);
        ticketButton = new JButton("Submit Ticket");
        replyTicketStatus = new JTextField("", 30);
        replyTicketStatus.setEditable(false);

        // Add ticket log area
        ticketLog = new JTextArea(10, 30);
        ticketLog.setEditable(false);
        JScrollPane ticketLogScrollPane = new JScrollPane(ticketLog);

        ticketButton.addActionListener(this);  

        panel.add(ticketLabel);
        panel.add(entryTicketNumber);
        panel.add(nameLabel);
        panel.add(entryName);
        panel.add(ticketButton);
        panel.add(replyTicketStatus);
        panel.add(ticketLogScrollPane);

        return panel;
    }

    private JPanel createDrinksPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel drinkLabel = new JLabel("Enter drink IDs (comma-separated):");
        entryDrinkIds = new JTextField("", 20);
        drinkButton = new JButton("Submit Drink Request");
        replyDrinkCatalog = new JTextArea(10, 30);
        replyDrinkCatalog.setEditable(false);

        drinkButton.addActionListener(this); 

        panel.add(drinkLabel);
        panel.add(entryDrinkIds);
        panel.add(drinkButton);
        panel.add(new JScrollPane(replyDrinkCatalog));

        return panel;
    }

    private JPanel createPaymentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel cardNumberLabel = new JLabel("Enter card number:");
        entryCardNumber = new JTextField("", 16);
        JLabel cardholderLabel = new JLabel("Enter cardholder name:");
        entryCardholder = new JTextField("", 20);
        JLabel securityNumberLabel = new JLabel("Enter security number:");
        entrySecurityNumber = new JTextField("", 4);
        JLabel issueDateLabel = new JLabel("Enter issue date:");
        entryIssueDate = new JTextField("", 6);
        paymentButton = new JButton("Submit Payment");
        replyPayment = new JTextArea(10, 30);
        replyPayment.setEditable(false);

        paymentButton.addActionListener(this);  

        panel.add(cardNumberLabel);
        panel.add(entryCardNumber);
        panel.add(cardholderLabel);
        panel.add(entryCardholder);
        panel.add(securityNumberLabel);
        panel.add(entrySecurityNumber);
        panel.add(issueDateLabel);
        panel.add(entryIssueDate);
        panel.add(paymentButton);
        panel.add(new JScrollPane(replyPayment));

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == heatingButton) {
            handleHeatingRequest();
        } else if (source == lightsButton) {
            handleLightsRequest();
        } else if (source == ticketButton) {
            handleTicketRequest();
        } else if (source == drinkButton) {
            handleDrinkRequest();
        } else if (source == paymentButton) {
            handlePaymentRequest();
        }
    }

    private void handleHeatingRequest() {
        String seatName = entryHeating.getText();
        String responseMessage = "Request failed";

        try {
            ActivateRequest request = ActivateRequest.newBuilder()
                    .setName(seatName)
                    .build();
            ActivateResponse response = heatingStub.activateHeating(request);
            responseMessage = response.getMessage();
        } catch (StatusRuntimeException ex) {
            responseMessage = "RPC failed: " + ex.getStatus();
        }

        replyHeating.setText(responseMessage);
    }

    private void handleLightsRequest() {
        String roomNumber = entryRoom.getText();
        String command = entryCommand.getText();

        if (!"activate".equalsIgnoreCase(command) && !"deactivate".equalsIgnoreCase(command)) {
            replyLights.setText("Invalid command. Please enter 'activate' or 'deactivate'.");
            return;
        }

        // Create the LightsRequest message
        LightsRequest request = LightsRequest.newBuilder()
                .setRoomNumber(roomNumber)
                .setCommand(command)
                .build();

        // Send the request to the server
        requestObserver.onNext(request);
        requestObserver.onCompleted(); 
    }

    private void handleTicketRequest() {
        int ticketNumber = Integer.parseInt(entryTicketNumber.getText());
        String userName = entryName.getText();

        // Create the TicketRequest message
        TicketRequest request = TicketRequest.newBuilder()
                .setTicketNumber(ticketNumber)
                .setName(userName)
                .build();
        // Send the TicketRequest to the server
        ticketRequestObserver.onNext(request);
        ticketRequestObserver.onCompleted(); 
    }

    private void handleDrinkRequest() {
        String[] drinkIdsStr = entryDrinkIds.getText().split(",");
        for (String drinkIdStr : drinkIdsStr) {
            try {
                int drinkId = Integer.parseInt(drinkIdStr.trim());

                // DrinkRequest message
                DrinkRequest request = DrinkRequest.newBuilder()
                        .addDrinkIds(drinkId)
                        .build();

                //DrinkRequest to the server
                drinkRequestObserver.onNext(request);
            } catch (NumberFormatException e) {
                replyDrinkCatalog.append("Invalid drink ID: " + drinkIdStr + "\n");
            }
        }

        // Complete the request stream
        drinkRequestObserver.onCompleted();
    }

    private void handlePaymentRequest() {
        String cardNumber = entryCardNumber.getText();
        String cardholder = entryCardholder.getText();
        String securityNumber = entrySecurityNumber.getText();
        String issueDate = entryIssueDate.getText();

        // Create the PaymentRequest message
        PaymentRequest request = PaymentRequest.newBuilder()
                .setCardNumber(cardNumber)
                .setCardholder(cardholder)
                .setSecurityNumber(securityNumber)
                .setIssueDate(issueDate)
                .build();

        // Send the request to the server
        paymentRequestObserver.onNext(request);
        paymentRequestObserver.onCompleted(); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cinema");
        AllServers controllerGUI = new AllServers();
        frame.setContentPane(controllerGUI.getServiceJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
