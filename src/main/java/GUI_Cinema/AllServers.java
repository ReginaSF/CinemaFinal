package GUI_Cinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import S01Seat_Heating.CinemaImmersiveGrpc;
import S01Seat_Heating.ActivateRequest;
import S01Seat_Heating.ActivateResponse;

import S03Cinema_Lights.CinemaLightsServiceGrpc;
import S03Cinema_Lights.LightsRequest;
import S03Cinema_Lights.LightsResponse;

import S04Cinema_Admission.TicketServiceGrpc;
import S04Cinema_Admission.TicketRequest;
import S04Cinema_Admission.TicketResponse;

public class AllServers implements ActionListener {

    // heating
    private JTextField entryHeating, replyHeating;
    private ManagedChannel heatingChannel;
    private CinemaImmersiveGrpc.CinemaImmersiveBlockingStub heatingStub;
    
    //  lights
    private JTextField entryRoom, entryCommand, replyLights;
    private ManagedChannel lightsChannel;
    private CinemaLightsServiceGrpc.CinemaLightsServiceStub lightsStub;
    private StreamObserver<LightsRequest> requestObserver;

    //  tickets
    private JTextField entryTicketNumber, entryName, replyTicketStatus;
    private ManagedChannel ticketChannel;
    private TicketServiceGrpc.TicketServiceStub ticketStub;
    private StreamObserver<TicketRequest> ticketRequestObserver;

    // actions
    private JButton heatingButton, lightsButton, ticketButton;

    public AllServers() {
        //  gRPC 
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

        // StreamObserver for lights control
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

        // StreamObserver for ticket requests
        ticketRequestObserver = ticketStub.enterTicketNumber(new StreamObserver<TicketResponse>() {
            @Override
            public void onNext(TicketResponse response) {
                SwingUtilities.invokeLater(() -> replyTicketStatus.setText(response.getMessage()));
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> replyTicketStatus.setText("Error: " + t.getMessage()));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> replyTicketStatus.setText("Server has completed processing."));
            }
        });
    }

    private JPanel getServiceJPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    
        panel.add(createHeatingPanel());
        panel.add(createLightsPanel());
        panel.add(createTicketsPanel());

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

        ticketButton.addActionListener(this); 

        panel.add(ticketLabel);
        panel.add(entryTicketNumber);
        panel.add(nameLabel);
        panel.add(entryName);
        panel.add(ticketButton);
        panel.add(replyTicketStatus);

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

        //LightsRequest message
        LightsRequest request = LightsRequest.newBuilder()
                .setRoomNumber(roomNumber)
                .setCommand(command)
                .build();

        // Send the request
        requestObserver.onNext(request);

        // Complete request stream
        requestObserver.onCompleted();

    }

    private void handleTicketRequest() { // Collect ticket data from the GUI
    	int ticketNumber = Integer.parseInt(entryTicketNumber.getText());
        String userName = entryName.getText();

        // Create the TicketRequest message
        TicketRequest request = TicketRequest.newBuilder()
        		 .setTicketNumber(ticketNumber)
                 .setName(userName)
                 .build();
        // Send the TicketRequest to the server
        ticketRequestObserver.onNext(request);

        // Complete the request stream
        ticketRequestObserver.onCompleted();
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
