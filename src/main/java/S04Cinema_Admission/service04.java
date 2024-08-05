
package S04Cinema_Admission;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Implementación del servicio gRPC
public class service04 {

    private final int port = 50051; // Número de puerto
    private final Server server;

    public service04() {
        server = ServerBuilder.forPort(port)
                .addService(new TicketServiceImpl()) // Añadir la implementación del servicio
                .build();
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            service04.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        final service04 server = new service04();
        server.start();
        server.blockUntilShutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}

// Implementación del servicio gRPC
class TicketServiceImpl extends TicketServiceGrpc.TicketServiceImplBase {

    @Override
    public StreamObserver<TicketRequest> enterTicketNumber(StreamObserver<TicketResponse> responseObserver) {
        return new StreamObserver<TicketRequest>() {
            private boolean accepted = true; // Suponemos que el ticket es aceptado por defecto
            private StringBuilder messageBuilder = new StringBuilder();

            @Override
            public void onNext(TicketRequest request) {
                // Procesar cada solicitud (e.g., validar el número del ticket y el nombre)
                messageBuilder.append("Recibido ticket número ")
                        .append(request.getTicketNumber())
                        .append(" para ")
                        .append(request.getName())
                        .append("\n");

                // En una aplicación real, se validaría el ticket aquí y se ajustaría 'accepted' según corresponda
                // Por simplicidad, asumimos que todos los tickets son aceptados
            }

            @Override
            public void onError(Throwable t) {
                // Manejar errores
                System.err.println("Error al procesar solicitudes de tickets: " + t.getMessage());
                // Opcionalmente, ajustar 'accepted' en base al manejo de errores
            }

            @Override
            public void onCompleted() {
                // Enviar la respuesta final después de procesar todas las solicitudes
                TicketResponse response = TicketResponse.newBuilder()
                        .setAccepted(accepted)
                        .setMessage(messageBuilder.toString())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
