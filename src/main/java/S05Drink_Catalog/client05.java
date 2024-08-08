//Serv. Streaming
package S05Drink_Catalog;

import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class client05 {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext() 
                .build();

        // Stub declaration:
        DrinkServiceGrpc.DrinkServiceBlockingStub blockingStub = DrinkServiceGrpc.newBlockingStub(channel);

        // Request with a list of drink IDs
        DrinkRequest request = DrinkRequest.newBuilder()
                .addDrinkIds(1)
                .addDrinkIds(2)
                .addDrinkIds(3)
                .build();

        // Send the request and receive a stream of responses
        try {
            System.out.println("Sending request for drink IDs...");
            Iterator<DrinkResponse> responses = blockingStub.offerDrinks(request);
            while (responses.hasNext()) {
                DrinkResponse response = responses.next();
                // Process each response
                System.out.println("Received response for drink ID " + response.getDrinkId() + ": " + response.getConfirmationMessage());
            }
        } catch (RuntimeException e) {
            System.err.println("Error during streaming: " + e.getMessage());
        }

        // Shutdown the channel
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
