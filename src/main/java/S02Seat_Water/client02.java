package S02Seat_Water;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class client02 {

    private final ManagedChannel channel;
    private final S02SeatWaterGrpc.S02SeatWaterBlockingStub blockingStub;

    public client02(String host, int port) {
      
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() 
                .build();
  
        blockingStub = S02SeatWaterGrpc.newBlockingStub(channel);
    }

    public void activateWaterImmersiveFeature(String choice) {
      
        ActivateRequest request = ActivateRequest.newBuilder()
                .setChoice(choice)
                .build();

    
        ActivateResponse response;
        try {
            response = blockingStub.activateWaterImmersiveFeature(request);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return;
        }

        System.out.println("Response: " + response.getMessage());
    }

    public static void main(String[] args) {
        // instantiating the client
        client02 client = new client02("localhost", 50051);

        // scanner to receive the req
        Scanner scanner = new Scanner(System.in);

        // checking the input
        System.out.println("Enter choice ('yes' or 'no'): ");
        String choice = scanner.nextLine();

        // calling the method
        if ("yes".equalsIgnoreCase(choice) || "no".equalsIgnoreCase(choice)) {
            client.activateWaterImmersiveFeature(choice);
        } else {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
        }

       
        scanner.close();
    }
}