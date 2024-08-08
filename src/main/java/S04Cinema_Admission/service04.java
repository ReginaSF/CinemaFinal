//Client Str
package S04Cinema_Admission;

import java.util.logging.Logger;

import S02Seat_Water.service02;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Declaring the service, 
public class service04 {
	private static final Logger logger = Logger.getLogger(service04.class.getName());
    private final int port = 50053; 
    private final Server server;

    public service04() {
        server = ServerBuilder.forPort(port)
                .addService(new TicketServiceImpl())
                .build();
    }

    public void start() throws Exception {
        server.start();
        logger.info("Server04Cinema_Admission is working on Port: " + server.getPort());
        System.out.println("Server started, listening on " + port);
      
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


class TicketServiceImpl extends TicketServiceGrpc.TicketServiceImplBase {

    @Override
    public StreamObserver<TicketRequest> enterTicketNumber(StreamObserver<TicketResponse> responseObserver) {
        return new StreamObserver<TicketRequest>() {
            private boolean accepted = true;
            private StringBuilder messageBuilder = new StringBuilder();

            @Override
            public void onNext(TicketRequest request) {
                  messageBuilder.append("Received ticket: ")
                        .append(request.getTicketNumber())
                        .append(" For ")
                        .append(request.getName())
                        .append("\n");

            }

            @Override
            public void onError(Throwable t) {
       
                System.err.println("Error : " + t.getMessage());
             
            }
            @Override
            public void onCompleted() {
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
