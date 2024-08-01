package S04Cinema_Admission;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class client04 {

    public static void main(String[] args) {
        // Crear un canal para conectarse al servidor
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()  // Usar texto sin cifrar (inseguro para producción)
                .build();

        // Crear un stub para el servicio
        TicketServiceGrpc.TicketServiceStub stub = TicketServiceGrpc.newStub(channel);

        // Crear un observador de respuesta
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

        // Crear un observador de solicitud
        StreamObserver<TicketRequest> requestObserver = stub.enterTicketNumber(responseObserver);

        // Crear un scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        String input;
        
        // Leer y enviar solicitudes hasta que el usuario decida salir
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

            // Enviar la solicitud
            requestObserver.onNext(TicketRequest.newBuilder()
                    .setTicketNumber(ticketNumber)
                    .setName(name)
                    .build());
        }
        
        // Finalizar el stream de solicitudes
        requestObserver.onCompleted();
        
        // Esperar un tiempo para que el servidor procese la respuesta
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cerrar el canal
        channel.shutdown();
        scanner.close();
    }
}
