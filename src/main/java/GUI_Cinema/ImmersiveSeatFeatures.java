package GUI_Cinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import S01Seat_Heating.CinemaImmersiveGrpc;
import S01Seat_Heating.ActivateRequest;
import S01Seat_Heating.ActivateResponse;
import io.grpc.StatusRuntimeException;

public class ImmersiveSeatFeatures implements ActionListener {

    private JTextField entryHeating, replyHeating;
    private ManagedChannel channel;
    private CinemaImmersiveGrpc.CinemaImmersiveBlockingStub stub;

    public ImmersiveSeatFeatures() {
        // Initialize the gRPC client
        channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        stub = CinemaImmersiveGrpc.newBlockingStub(channel);
    }

    private JPanel getService1JPanel() {
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter seat for i.e. j8");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entryHeating = new JTextField("", 10);
        panel.add(entryHeating);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Seat Heating Req");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        replyHeating = new JTextField("", 10);
        replyHeating.setEditable(false);
        panel.add(replyHeating);

        panel.setLayout(boxlayout);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seatName = entryHeating.getText();
        String responseMessage = "Request failed"; // Default message in case of an error

        try {
            // Create the request
            ActivateRequest request = ActivateRequest.newBuilder()
                    .setName(seatName)
                    .build();

            // Call the service and get the response
            ActivateResponse response = stub.activateHeating(request);
            responseMessage = response.getMessage();

        } catch (StatusRuntimeException ex) {
            responseMessage = "RPC failed: " + ex.getStatus();
        }

        // Showing the response message for the heating req:
        replyHeating.setText(responseMessage);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seat Heating Controller");
        ImmersiveSeatFeatures controllerGUI = new ImmersiveSeatFeatures();
        frame.setContentPane(controllerGUI.getService1JPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}