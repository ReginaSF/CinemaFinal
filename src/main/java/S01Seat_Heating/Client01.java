
package S01Seat_Heating;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

import S01Seat_Heating.CinemaImmersiveGrpc.CinemaImmersiveBlockingStub;


public class Client01 {
    public static void main(String[] args) throws Exception {
        // Declaring the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext() // Use plaintext communication
                .build();
        //Unary RPC. We make the request on the blocking stub.
        CinemaImmersiveBlockingStub stub = CinemaImmersiveGrpc.newBlockingStub(channel);
        ActivateRequest request = ActivateRequest.newBuilder()
                .setName("A1") // Example seat name
                .build();
        //the client gets the response directly like a local method call
        ActivateResponse response = stub.activateHeating(request);
        System.out.println("Response: " + response.getMessage());

       
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS); // Closing the Channel.-DeadLine
    }
}
