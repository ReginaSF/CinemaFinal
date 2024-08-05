package S05Drink_Catalog;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class service05 {

    private final int port = 50051;
    private final Server server;

    public service05() {
        server = ServerBuilder.forPort(port)
                .addService(new DrinkServiceImpl())
                .build();
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("shutting down server");
            service05.this.stop();
            System.err.println("server stopped");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        final service05 server = new service05();
        server.start();
        server.blockUntilShutdown();
    }

    // Implementation of the DrinkService
    static class DrinkServiceImpl extends DrinkServiceGrpc.DrinkServiceImplBase {

        @Override
        public void offerDrinks(DrinkRequest request, StreamObserver<DrinkResponse> responseObserver) {
            // Process each drink ID in the request
            for (Integer drinkId : request.getDrinkIdsList()) {
                                
                // Confirming to the user:
                String confirmationMessage = "Drink ID " + drinkId + " is available.";
                
                // Sending the response
                DrinkResponse response = DrinkResponse.newBuilder()
                        .setDrinkId(drinkId)
                        .setConfirmationMessage(confirmationMessage)
                        .build();
                
                responseObserver.onNext(response);
            }
            
            responseObserver.onCompleted();
        }
    }
}
