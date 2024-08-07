//Client Streaming
package S03Cinema_Lights;

import java.util.logging.Logger;

import S02Seat_Water.service02;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Service Implementation
class CinemaLightsServiceImpl extends CinemaLightsServiceGrpc.CinemaLightsServiceImplBase {

    @Override
    public StreamObserver<LightsRequest> controlLights(StreamObserver<LightsResponse> responseObserver) {
        return new StreamObserver<LightsRequest>() {
            private String status = "No lights command received";

            @Override
            public void onNext(LightsRequest request) {
                status = "Processing command for room " + request.getRoomNumber() + ": " + request.getCommand();
            }

            @Override
            public void onError(Throwable t) {
                status = "Error processing lights command";
            }

            @Override
            public void onCompleted() {
                LightsResponse response = LightsResponse.newBuilder()
                        .setStatus(status)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}

// Server Initialization and Startup
public class service03 {
	private static final Logger logger = Logger.getLogger(service03.class.getName());
    private final int port = 50052;
    private final Server server;

    public service03() {
        server = ServerBuilder.forPort(port)
                .addService(new CinemaLightsServiceImpl())
                .build();
    }

    public void start() throws Exception {
        server.start();
        logger.info("Server03Cinema_Lights is working on Port: " + server.getPort());
        System.out.println("Server started, listening on " + port);
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        final service03 server = new service03();
        server.start();
        server.blockUntilShutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

	public static void startS() {
		// TODO Auto-generated method stub
		
	}
}