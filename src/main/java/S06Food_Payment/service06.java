//Bidirectional Streaming
package S06Food_Payment;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.logging.Logger;

import S05Drink_Catalog.service05;

public class service06 extends PaymentServiceGrpc.PaymentServiceImplBase {
	

    @Override
    public StreamObserver<PaymentRequest> processPayment(StreamObserver<PaymentResponse> responseObserver) {
        return new StreamObserver<PaymentRequest>() {
            @Override
            public void onNext(PaymentRequest request) {
                // Process the payment request
                System.out.println("Received payment request:");
                System.out.println("Card Number: " + request.getCardNumber());
                System.out.println("Cardholder: " + request.getCardholder());
                System.out.println("Security Number: " + request.getSecurityNumber());
                System.out.println("Issue Date: " + request.getIssueDate());

                // Generate responses based on input
                PaymentResponse response = PaymentResponse.newBuilder()
                        .setMessage("Payment accepted")
                        .setConfirmationNumber("123456789")
                        .setTicketNumber("987654321")
                        .build();
                
                // Send response
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) { //error handling               
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();      // Complete the stream
            }
        };
    }

    public static void main(String[] args) throws IOException, InterruptedException {
    	final Logger logger = Logger.getLogger(service06.class.getName());
        // Starting the server
        Server server = ServerBuilder.forPort(9090)
                .addService(new service06())
                .build()
                .start();
        logger.info("Server_06Food_Payment is working on Port: " + server.getPort());
        System.out.println("Server started, listening on 9090");

        // maintaining the server running : 
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server");
            server.shutdown();
            System.err.println("Server shut down");
        }));

        server.awaitTermination();
    }

}