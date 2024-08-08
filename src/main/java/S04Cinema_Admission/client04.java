
package S04Cinema_Admission;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class client04 {

    public static void main(String[] args) {
               ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()  
                .build();

        TicketServiceGrpc.TicketServiceStub stub = TicketServiceGrpc.newStub(channel);
        StreamObserver<TicketResponse> responseObserver = new StreamObserver<TicketResponse>() {
            @Override
            public void onNext(TicketResponse response) {
                System.out.println("Response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream is completed for cinema admission");
            }
        };

        StreamObserver<TicketRequest> requestObserver = stub.enterTicketNumber(responseObserver);

        Scanner scanner = new Scanner(System.in);
        String input;
      
        while (true) {
            System.out.print("Enter ticket number (or 'exit' to finish): ");
            input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            int ticketNumber;
            try {
                ticketNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Invalid ticket number. Please enter a valid number.");
                continue;
            }

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            requestObserver.onNext(TicketRequest.newBuilder()
                    .setTicketNumber(ticketNumber)
                    .setName(name)
                    .build());
        }
        
       
        requestObserver.onCompleted();
        	  System.out.println("Stream is completed for Cinema Admission");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        channel.shutdown();
        scanner.close();
    }
}
