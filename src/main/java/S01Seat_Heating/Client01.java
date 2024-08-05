
package S01Seat_Heating;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

import S01Seat_Heating.CinemaImmersiveGrpc.CinemaImmersiveBlockingStub;


public class Client01 {
    public static void main(String[] args) throws Exception {
        // Create a channel to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext() // Use plaintext communication
                .build();

        // Create a blocking stub to call the service
        CinemaImmersiveBlockingStub stub = CinemaImmersiveGrpc.newBlockingStub(channel);

        // Create the request
        ActivateRequest request = ActivateRequest.newBuilder()
                .setName("A1") // Example seat name
                .build();

        // Call the service and get the response
        ActivateResponse response = stub.activateHeating(request);

        // Print the response
        System.out.println("Response: " + response.getMessage());

        // Shutdown the channel
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
}
