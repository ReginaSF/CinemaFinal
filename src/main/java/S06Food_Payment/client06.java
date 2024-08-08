package S06Food_Payment;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class client06 {

    private final ManagedChannel channel;
    private final PaymentServiceGrpc.PaymentServiceStub asyncStub;

    public client06() {
    	channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() 
                .build();
        asyncStub = PaymentServiceGrpc.newStub(channel);
    }

    public void processPayment() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        //Giving the option to input the info to the user : 
        System.out.print("Enter Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Enter Cardholder Name: ");
        String cardholder = scanner.nextLine();

        System.out.print("Enter Security Number: ");
        String securityNumber = scanner.nextLine();

        System.out.print("Enter Issue Date (MM/YY): ");
        String issueDate = scanner.nextLine();

        CountDownLatch finishLatch = new CountDownLatch(1);

        // Streamobserver:
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
                System.err.println("Error occurred: " + t.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                //Took this from the math example form the exercise in class:
                System.out.println(LocalTime.now().toString() + ": Stream is completed.");
                finishLatch.countDown();
            }
        };

        // Create a request observer to send requests to the servers
        StreamObserver<PaymentRequest> requestObserver = asyncStub.processPayment(responseObserver);

        try {          
            PaymentRequest request = PaymentRequest.newBuilder()
                    .setCardNumber(cardNumber)
                    .setCardholder(cardholder)
                    .setSecurityNumber(securityNumber)
                    .setIssueDate(issueDate)
                    .build();
            requestObserver.onNext(request);

            // Completing the stream
            requestObserver.onCompleted();

            // Wait for the server to complete the response handling
            finishLatch.await(1, TimeUnit.MINUTES);

        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        } finally {
            // Shutdown the channel
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        client06 client = new client06();

        // Process the payment with user input
        client.processPayment();
    }
}
