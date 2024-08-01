package S02Seat_Water;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Method02.proto")
public final class S02SeatWaterGrpc {

  private S02SeatWaterGrpc() {}

  public static final String SERVICE_NAME = "cinema2.S02SeatWater";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<S02Seat_Water.ActivateRequest,
      S02Seat_Water.ActivateResponse> getActivateWaterImmersiveFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateWaterImmersiveFeature",
      requestType = S02Seat_Water.ActivateRequest.class,
      responseType = S02Seat_Water.ActivateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<S02Seat_Water.ActivateRequest,
      S02Seat_Water.ActivateResponse> getActivateWaterImmersiveFeatureMethod() {
    io.grpc.MethodDescriptor<S02Seat_Water.ActivateRequest, S02Seat_Water.ActivateResponse> getActivateWaterImmersiveFeatureMethod;
    if ((getActivateWaterImmersiveFeatureMethod = S02SeatWaterGrpc.getActivateWaterImmersiveFeatureMethod) == null) {
      synchronized (S02SeatWaterGrpc.class) {
        if ((getActivateWaterImmersiveFeatureMethod = S02SeatWaterGrpc.getActivateWaterImmersiveFeatureMethod) == null) {
          S02SeatWaterGrpc.getActivateWaterImmersiveFeatureMethod = getActivateWaterImmersiveFeatureMethod = 
              io.grpc.MethodDescriptor.<S02Seat_Water.ActivateRequest, S02Seat_Water.ActivateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cinema2.S02SeatWater", "ActivateWaterImmersiveFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  S02Seat_Water.ActivateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  S02Seat_Water.ActivateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new S02SeatWaterMethodDescriptorSupplier("ActivateWaterImmersiveFeature"))
                  .build();
          }
        }
     }
     return getActivateWaterImmersiveFeatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static S02SeatWaterStub newStub(io.grpc.Channel channel) {
    return new S02SeatWaterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static S02SeatWaterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new S02SeatWaterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static S02SeatWaterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new S02SeatWaterFutureStub(channel);
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static abstract class S02SeatWaterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC method to activate the water immersive feature
     * </pre>
     */
    public void activateWaterImmersiveFeature(S02Seat_Water.ActivateRequest request,
        io.grpc.stub.StreamObserver<S02Seat_Water.ActivateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateWaterImmersiveFeatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActivateWaterImmersiveFeatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                S02Seat_Water.ActivateRequest,
                S02Seat_Water.ActivateResponse>(
                  this, METHODID_ACTIVATE_WATER_IMMERSIVE_FEATURE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class S02SeatWaterStub extends io.grpc.stub.AbstractStub<S02SeatWaterStub> {
    private S02SeatWaterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private S02SeatWaterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected S02SeatWaterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new S02SeatWaterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC method to activate the water immersive feature
     * </pre>
     */
    public void activateWaterImmersiveFeature(S02Seat_Water.ActivateRequest request,
        io.grpc.stub.StreamObserver<S02Seat_Water.ActivateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateWaterImmersiveFeatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class S02SeatWaterBlockingStub extends io.grpc.stub.AbstractStub<S02SeatWaterBlockingStub> {
    private S02SeatWaterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private S02SeatWaterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected S02SeatWaterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new S02SeatWaterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC method to activate the water immersive feature
     * </pre>
     */
    public S02Seat_Water.ActivateResponse activateWaterImmersiveFeature(S02Seat_Water.ActivateRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateWaterImmersiveFeatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class S02SeatWaterFutureStub extends io.grpc.stub.AbstractStub<S02SeatWaterFutureStub> {
    private S02SeatWaterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private S02SeatWaterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected S02SeatWaterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new S02SeatWaterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC method to activate the water immersive feature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<S02Seat_Water.ActivateResponse> activateWaterImmersiveFeature(
        S02Seat_Water.ActivateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateWaterImmersiveFeatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTIVATE_WATER_IMMERSIVE_FEATURE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final S02SeatWaterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(S02SeatWaterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTIVATE_WATER_IMMERSIVE_FEATURE:
          serviceImpl.activateWaterImmersiveFeature((S02Seat_Water.ActivateRequest) request,
              (io.grpc.stub.StreamObserver<S02Seat_Water.ActivateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class S02SeatWaterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    S02SeatWaterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return S02Seat_Water.Serv02Seat_Water.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("S02SeatWater");
    }
  }

  private static final class S02SeatWaterFileDescriptorSupplier
      extends S02SeatWaterBaseDescriptorSupplier {
    S02SeatWaterFileDescriptorSupplier() {}
  }

  private static final class S02SeatWaterMethodDescriptorSupplier
      extends S02SeatWaterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    S02SeatWaterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (S02SeatWaterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new S02SeatWaterFileDescriptorSupplier())
              .addMethod(getActivateWaterImmersiveFeatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
