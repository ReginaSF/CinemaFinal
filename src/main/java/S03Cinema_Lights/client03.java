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
                .usePlaintext() // Deshabilita la encriptación para simplificar el ejemplo
                .build();
        asyncStub = CinemaLightsServiceGrpc.newStub(channel);
    }

    public void controlLights() {
        // Crear un StreamObserver para enviar datos al servidor
        StreamObserver<LightsRequest> requestObserver = asyncStub.controlLights(new StreamObserver<LightsResponse>() {
            @Override
            public void onNext(LightsResponse response) {
                // Imprimir la respuesta del servidor
                System.out.println("Response received: " + response.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                // Manejar errores
                System.err.println("Error: " + t);
            }

            @Override
            public void onCompleted() {
                // Informar que el servidor ha completado el procesamiento
                System.out.println("Server has completed processing.");
            }
        });

        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                // Leer la entrada del usuario
                System.out.print("Enter room number (or 'exit' to finish): ");
                String roomNumber = scanner.nextLine();

                if ("exit".equalsIgnoreCase(roomNumber)) {
                    break;
                }

                System.out.print("Enter command ('activate' or 'deactivate'): ");
                String command = scanner.nextLine();

                // Validar el comando
                if (!"activate".equalsIgnoreCase(command) && !"deactivate".equalsIgnoreCase(command)) {
                    System.out.println("Invalid command. Please enter 'activate' or 'deactivate'.");
                    continue;
                }

                // Enviar la solicitud al servidor
                LightsRequest request = LightsRequest.newBuilder()
                        .setRoomNumber(roomNumber)
                        .setCommand(command)
                        .build();
                requestObserver.onNext(request);
            }

            // Marcar el final de las solicitudes
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            requestObserver.onError(e);
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }

    public static void main(String[] args) {
        client03 client = new client03("localhost", 50051);
        client.controlLights();
    }
}
