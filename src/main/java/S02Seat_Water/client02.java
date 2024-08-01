package S02Seat_Water;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class client02 {

    private final ManagedChannel channel;
    private final S02SeatWaterGrpc.S02SeatWaterBlockingStub blockingStub;

    public client02(String host, int port) {
        // Crear un canal para conectar con el servidor gRPC
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // Deshabilita la encriptación para simplificar el ejemplo
                .build();
        // Crear un cliente de bloqueo basado en el canal
        blockingStub = S02SeatWaterGrpc.newBlockingStub(channel);
    }

    public void activateWaterImmersiveFeature(String choice) {
        // Crear la solicitud
        ActivateRequest request = ActivateRequest.newBuilder()
                .setChoice(choice)
                .build();

        // Enviar la solicitud al servidor y recibir la respuesta
        ActivateResponse response;
        try {
            response = blockingStub.activateWaterImmersiveFeature(request);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return;
        }

        // Imprimir la respuesta recibida del servidor
        System.out.println("Response: " + response.getMessage());
    }

    public static void main(String[] args) {
        // Crear una instancia del cliente
        client02 client = new client02("localhost", 50051);

        // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Leer la entrada del usuario
        System.out.println("Enter choice ('yes' or 'no'): ");
        String choice = scanner.nextLine();

        // Llamar al método del servicio gRPC
        if ("yes".equalsIgnoreCase(choice) || "no".equalsIgnoreCase(choice)) {
            client.activateWaterImmersiveFeature(choice);
        } else {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
