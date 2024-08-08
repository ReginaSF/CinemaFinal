//Unary
package S02Seat_Water;

import java.util.logging.Logger;

import S01Seat_Heating.Service01;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// starting server 2 here:
public class service02 {
	 private static final Logger logger = Logger.getLogger(service02.class.getName());
              	Server server = ServerBuilder.forPort(50051)
                .addService(new S02SeatWaterServiceImpl())
                .build();
        public void start() throws Exception {
        server.start();
     //inserting loggers to be sure the port is connecting:
        logger.info("Server_Water is working on Port: " + server.getPort());
        System.out.println("Server_Water is working on Port: " + server.getPort());
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

class S02SeatWaterServiceImpl extends S02SeatWaterGrpc.S02SeatWaterImplBase {
//Here activateWaterImmersive is the method on the proto which is triggering the water activation or deactivation, Asyncro behaviour
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