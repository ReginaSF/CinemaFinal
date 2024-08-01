package S02Seat_Water;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Implementación del servicio gRPC
public class service02 {

    private final int port = 50051;
    private final Server server;

    public service02() {
        // Crea una instancia del servicio implementado
        server = ServerBuilder.forPort(port)
                .addService(new S02SeatWaterServiceImpl())
                .build();
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            service02.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        final service02 server = new service02();
        server.start();
        server.blockUntilShutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}

// Implementación del servicio gRPC generado
class S02SeatWaterServiceImpl extends S02SeatWaterGrpc.S02SeatWaterImplBase {

    @Override
    public void activateWaterImmersiveFeature(ActivateRequest request, StreamObserver<ActivateResponse> responseObserver) {
        String choice = request.getChoice();
        String message;

        if ("yes".equalsIgnoreCase(choice)) {
            message = "Water immersive feature activated.";
        } else if ("no".equalsIgnoreCase(choice)) {
            message = "Water immersive feature deactivated.";
        } else {
            message = "Invalid choice. Please use 'yes' or 'no'.";
        }

        ActivateResponse response = ActivateResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
