package GUI_Cinema;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import S02Seat_Water.S02SeatWaterGrpc;
import S02Seat_Water.ActivateRequest;
import S02Seat_Water.ActivateResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WaterGUI implements ActionListener {

    private JTextField entryHeating, replyHeating;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;
    private JTextField entry4, reply4;

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
        button.setActionCommand("Seat Heating Req");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        replyHeating = new JTextField("", 10);
        replyHeating.setEditable(false);
        panel.add(replyHeating);

        panel.setLayout(boxlayout);

        return panel;
    }

    private JPanel getService2JPanel() {
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter yes/no ");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("", 10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Water Immersive Feature Req");
        button.setActionCommand("Water Immersive Feature Req");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("", 10);
        reply2.setEditable(false);
        panel.add(reply2);

        panel.setLayout(boxlayout);

        return panel;
    }

    private JPanel getService3JPanel() {
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("", 10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("S3:RPC1");
        button.setActionCommand("S3:RPC1");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextField("", 10);
        reply3.setEditable(false);
        panel.add(reply3);

        panel.setLayout(boxlayout);

        return panel;
    }

    private JPanel getService4JPanel() {
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry4 = new JTextField("", 10);
        panel.add(entry4);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("S4:RPC1");
        button.setActionCommand("S4:RPC1");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply4 = new JTextField("", 10);
        reply4.setEditable(false);
        panel.add(reply4);

        panel.setLayout(boxlayout);

        return panel;
    }

    public static void main(String[] args) {
        WaterGUI gui = new WaterGUI();
        gui.build();
    }

    private void build() {
        JFrame frame = new JFrame("Service Controller Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(getService1JPanel());
        panel.add(getService2JPanel());
        panel.add(getService3JPanel());
        panel.add(getService4JPanel());

        frame.setSize(300, 300);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

    
        }
    

    private void handleWaterImmersiveFeatureRequest() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        S02SeatWaterGrpc.S02SeatWaterBlockingStub blockingStub = S02SeatWaterGrpc.newBlockingStub(channel);

        String choice = entry2.getText();
        ActivateRequest request = ActivateRequest.newBuilder().setChoice(choice).build();

        ActivateResponse response;
        try {
            response = blockingStub.activateWaterImmersiveFeature(request);
            reply2.setText(response.getMessage());
        } catch (Exception ex) {
            reply2.setText("RPC failed: " + ex.getMessage());
        } finally {
            channel.shutdown();
        }
    }
}
