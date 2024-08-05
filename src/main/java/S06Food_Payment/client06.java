package S06Food_Payment;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class client06 {

    private final ManagedChannel channel;
    private final PaymentServiceGrpc.PaymentServiceStub asyncStub;

    public client06() {
        // Create a channel to the gRPC server
        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Use plaintext communication (non-encrypted)
                .build();
        asyncStub = PaymentServiceGrpc.newStub(channel);
    }

    public void processPayment(String cardNumber, String cardholder, String securityNumber, String issueDate) {
        // Create a response observer to handle server responses
        StreamObserver<PaymentResponse> responseObserver = new StreamObserver<PaymentResponse>() {
            @Override
            public void onNext(PaymentResponse response) {
                // Print the response from the server
                System.out.println("Response received:");
                System.out.println("Message: " + response.getMessage());
                System.out.println("Confirmation Number: " + response.getConfirmationNumber());
                System.out.println("Ticket Number: " + response.getTicketNumber());
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors
                System.err.println("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Signal that the response stream is complete
                System.out.println("Response stream completed.");
            }
        };

        // Create a request observer to send requests to the server
        StreamObserver<PaymentRequest> requestObserver = asyncStub.processPayment(responseObserver);

        try {
            // Send the payment request
            requestObserver.onNext(PaymentRequest.newBuilder()
                    .setCardNumber(cardNumber)
                    .setCardholder(cardholder)
                    .setSecurityNumber(securityNumber)
                    .setIssueDate(issueDate)
                    .build());
            // Complete the request stream
            requestObserver.onCompleted();

            // Wait for the response
            // Use more robust synchronization in a real-world scenario
            Thread.sleep(5000); // Adjust the wait time as needed

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while waiting for response: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        } finally {
            // Shutdown the channel
            channel.shutdown();
        }
    }

    public static void main(String[] args) {
        client06 client = new client06();

        // Sample payment details
        String cardNumber = "5445 6556 7856 8934";
        String cardholder = "Frida Sofia Swift";
        String securityNumber = "531";
        String issueDate = "09/26";

        // Process the payment
        client.processPayment(cardNumber, cardholder, securityNumber, issueDate);
    }
}