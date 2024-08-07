package S03Cinema_Lights;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class client03 {

    private final ManagedChannel channel;
    private final CinemaLightsServiceGrpc.CinemaLightsServiceStub asyncStub;

    public client03(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() 
                .build();
        asyncStub = CinemaLightsServiceGrpc.newStub(channel);
    }

    public void controlLights() {     
        StreamObserver<LightsRequest> requestObserver = asyncStub.controlLights(new StreamObserver<LightsResponse>() {
            @Override
            public void onNext(LightsResponse response) {
                       System.out.println("Response received: " + response.getStatus());
            }
            @Override
            public void onError(Throwable t) {
                     System.err.println("Error: " + t);
            }
            @Override
            public void onCompleted() {
            		System.out.println("Server has completed processing.");
            }
        });

        // here i am inserting an Scanner to receive the user input
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Enter room number (or 'exit' to finish): ");
                String roomNumber = scanner.nextLine();

                if ("exit".equalsIgnoreCase(roomNumber)) {
                    break;
                }
                System.out.print("Enter command ('activate' or 'deactivate'): ");
                String command = scanner.nextLine();

                if (!"activate".equalsIgnoreCase(command) && !"deactivate".equalsIgnoreCase(command)) {
                    System.out.println("Invalid command. Please enter 'activate' or 'deactivate'.");
                    continue;
                }

                // Sending the request to the server 
                LightsRequest request = LightsRequest.newBuilder()
                        .setRoomNumber(roomNumber)
                        .setCommand(command)
                        .build();
                requestObserver.onNext(request);
            }

            // Checks no more requests
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            requestObserver.onError(e);
        } finally {
                      scanner.close();
        }
    }

    public static void main(String[] args) {
        client03 client = new client03("localhost", 50052);
        client.controlLights(); 
    }
}