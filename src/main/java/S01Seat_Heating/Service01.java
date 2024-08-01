package S01Seat_Heating;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Service01 {
    public static void main(String[] args) throws Exception {
        //Starting the server 01 here:
        Server server = ServerBuilder.forPort(9091)
            .addService(new CinemaImmersiveServiceImpl())
            .build()
            .start();

        System.out.println("Server_Heating is working on Port: " + server.getPort());
        server.awaitTermination();
    }
    static class CinemaImmersiveServiceImpl extends CinemaImmersiveGrpc.CinemaImmersiveImplBase {
        @Override
        public void activateHeating(ActivateRequest request,
                                    StreamObserver<ActivateResponse> responseObserver) {
            String name = request.getName();
            String message = "Seat heating has been updated";
            ActivateResponse response = ActivateResponse.newBuilder()
                .setMessage(message)
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}