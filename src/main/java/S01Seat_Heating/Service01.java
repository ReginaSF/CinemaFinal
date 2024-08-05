package S01Seat_Heating;

import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service01 {
    private static final Logger logger = Logger.getLogger(Service01.class.getName());

    public static void main(String[] args) throws Exception {
        // Starting the server 01 here:
        Server server = ServerBuilder.forPort(9091)
            .addService(new CinemaImmersiveServiceImpl())
            .build()
            .start();

        logger.info("Server_Heating is working on Port: " + server.getPort());
        System.out.println("Server_Heating is working on Port: " + server.getPort());

        server.awaitTermination();
    }

    static class CinemaImmersiveServiceImpl extends CinemaImmersiveGrpc.CinemaImmersiveImplBase {
        private static final Logger logger = Logger.getLogger(CinemaImmersiveServiceImpl.class.getName());

        @Override
        public void activateHeating(ActivateRequest request, StreamObserver<ActivateResponse> responseObserver) {
            String name = request.getName();
            String message = "Seat heating has been updated";
            ActivateResponse response = ActivateResponse.newBuilder()
                .setMessage(message)
                .build();

            logger.info("Received heating activation request for: " + name);
            System.out.println("Received heating activation request for: " + name);

            responseObserver.onNext(response); // To Return
            responseObserver.onCompleted();    // Finishes the rpc
        }
    }

	public static void startS() {
		// TODO Auto-generated method stub
		
	}
}