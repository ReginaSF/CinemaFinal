package S03Cinema_Lights;

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
 * this rpc is based on client streaming, asking to the cinema supervisor to manage the lights of the hall
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Method03.proto")
public final class CinemaLightsServiceGrpc {

  private CinemaLightsServiceGrpc() {}

  public static final String SERVICE_NAME = "cinema2.CinemaLightsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<S03Cinema_Lights.LightsRequest,
      S03Cinema_Lights.LightsResponse> getControlLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLights",
      requestType = S03Cinema_Lights.LightsRequest.class,
      responseType = S03Cinema_Lights.LightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<S03Cinema_Lights.LightsRequest,
      S03Cinema_Lights.LightsResponse> getControlLightsMethod() {
    io.grpc.MethodDescriptor<S03Cinema_Lights.LightsRequest, S03Cinema_Lights.LightsResponse> getControlLightsMethod;
    if ((getControlLightsMethod = CinemaLightsServiceGrpc.getControlLightsMethod) == null) {
      synchronized (CinemaLightsServiceGrpc.class) {
        if ((getControlLightsMethod = CinemaLightsServiceGrpc.getControlLightsMethod) == null) {
          CinemaLightsServiceGrpc.getControlLightsMethod = getControlLightsMethod = 
              io.grpc.MethodDescriptor.<S03Cinema_Lights.LightsRequest, S03Cinema_Lights.LightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cinema2.CinemaLightsService", "ControlLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  S03Cinema_Lights.LightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  S03Cinema_Lights.LightsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaLightsServiceMethodDescriptorSupplier("ControlLights"))
                  .build();
          }
        }
     }
     return getControlLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CinemaLightsServiceStub newStub(io.grpc.Channel channel) {
    return new CinemaLightsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CinemaLightsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CinemaLightsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CinemaLightsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CinemaLightsServiceFutureStub(channel);
  }

  /**
   * <pre>
   * this rpc is based on client streaming, asking to the cinema supervisor to manage the lights of the hall
   * </pre>
   */
  public static abstract class CinemaLightsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<S03Cinema_Lights.LightsRequest> controlLights(
        io.grpc.stub.StreamObserver<S03Cinema_Lights.LightsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getControlLightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getControlLightsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                S03Cinema_Lights.LightsRequest,
                S03Cinema_Lights.LightsResponse>(
                  this, METHODID_CONTROL_LIGHTS)))
          .build();
    }
  }

  /**
   * <pre>
   * this rpc is based on client streaming, asking to the cinema supervisor to manage the lights of the hall
   * </pre>
   */
  public static final class CinemaLightsServiceStub extends io.grpc.stub.AbstractStub<CinemaLightsServiceStub> {
    private CinemaLightsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaLightsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaLightsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaLightsServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<S03Cinema_Lights.LightsRequest> controlLights(
        io.grpc.stub.StreamObserver<S03Cinema_Lights.LightsResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getControlLightsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * this rpc is based on client streaming, asking to the cinema supervisor to manage the lights of the hall
   * </pre>
   */
  public static final class CinemaLightsServiceBlockingStub extends io.grpc.stub.AbstractStub<CinemaLightsServiceBlockingStub> {
    private CinemaLightsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaLightsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaLightsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaLightsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * this rpc is based on client streaming, asking to the cinema supervisor to manage the lights of the hall
   * </pre>
   */
  public static final class CinemaLightsServiceFutureStub extends io.grpc.stub.AbstractStub<CinemaLightsServiceFutureStub> {
    private CinemaLightsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaLightsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaLightsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaLightsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CONTROL_LIGHTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaLightsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CinemaLightsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_LIGHTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlLights(
              (io.grpc.stub.StreamObserver<S03Cinema_Lights.LightsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CinemaLightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CinemaLightsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return S03Cinema_Lights.S03CinemaLights.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CinemaLightsService");
    }
  }

  private static final class CinemaLightsServiceFileDescriptorSupplier
      extends CinemaLightsServiceBaseDescriptorSupplier {
    CinemaLightsServiceFileDescriptorSupplier() {}
  }

  private static final class CinemaLightsServiceMethodDescriptorSupplier
      extends CinemaLightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CinemaLightsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CinemaLightsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CinemaLightsServiceFileDescriptorSupplier())
              .addMethod(getControlLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
