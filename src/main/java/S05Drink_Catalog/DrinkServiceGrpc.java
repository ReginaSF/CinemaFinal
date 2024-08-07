package S05Drink_Catalog;

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
    comments = "Source: Method05.proto")
public final class DrinkServiceGrpc {

  private DrinkServiceGrpc() {}

  public static final String SERVICE_NAME = "cinema2.DrinkService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<S05Drink_Catalog.DrinkRequest,
      S05Drink_Catalog.DrinkResponse> getOfferDrinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OfferDrinks",
      requestType = S05Drink_Catalog.DrinkRequest.class,
      responseType = S05Drink_Catalog.DrinkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<S05Drink_Catalog.DrinkRequest,
      S05Drink_Catalog.DrinkResponse> getOfferDrinksMethod() {
    io.grpc.MethodDescriptor<S05Drink_Catalog.DrinkRequest, S05Drink_Catalog.DrinkResponse> getOfferDrinksMethod;
    if ((getOfferDrinksMethod = DrinkServiceGrpc.getOfferDrinksMethod) == null) {
      synchronized (DrinkServiceGrpc.class) {
        if ((getOfferDrinksMethod = DrinkServiceGrpc.getOfferDrinksMethod) == null) {
          DrinkServiceGrpc.getOfferDrinksMethod = getOfferDrinksMethod = 
              io.grpc.MethodDescriptor.<S05Drink_Catalog.DrinkRequest, S05Drink_Catalog.DrinkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cinema2.DrinkService", "OfferDrinks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  S05Drink_Catalog.DrinkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  S05Drink_Catalog.DrinkResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DrinkServiceMethodDescriptorSupplier("OfferDrinks"))
                  .build();
          }
        }
     }
     return getOfferDrinksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DrinkServiceStub newStub(io.grpc.Channel channel) {
    return new DrinkServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DrinkServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DrinkServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DrinkServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DrinkServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static abstract class DrinkServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Server streaming RPC to offer drinks based on the requested list
     * </pre>
     */
    public void offerDrinks(S05Drink_Catalog.DrinkRequest request,
        io.grpc.stub.StreamObserver<S05Drink_Catalog.DrinkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOfferDrinksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOfferDrinksMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                S05Drink_Catalog.DrinkRequest,
                S05Drink_Catalog.DrinkResponse>(
                  this, METHODID_OFFER_DRINKS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class DrinkServiceStub extends io.grpc.stub.AbstractStub<DrinkServiceStub> {
    private DrinkServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrinkServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrinkServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrinkServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server streaming RPC to offer drinks based on the requested list
     * </pre>
     */
    public void offerDrinks(S05Drink_Catalog.DrinkRequest request,
        io.grpc.stub.StreamObserver<S05Drink_Catalog.DrinkResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getOfferDrinksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class DrinkServiceBlockingStub extends io.grpc.stub.AbstractStub<DrinkServiceBlockingStub> {
    private DrinkServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrinkServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrinkServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrinkServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Server streaming RPC to offer drinks based on the requested list
     * </pre>
     */
    public java.util.Iterator<S05Drink_Catalog.DrinkResponse> offerDrinks(
        S05Drink_Catalog.DrinkRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getOfferDrinksMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class DrinkServiceFutureStub extends io.grpc.stub.AbstractStub<DrinkServiceFutureStub> {
    private DrinkServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DrinkServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DrinkServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DrinkServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_OFFER_DRINKS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DrinkServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DrinkServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OFFER_DRINKS:
          serviceImpl.offerDrinks((S05Drink_Catalog.DrinkRequest) request,
              (io.grpc.stub.StreamObserver<S05Drink_Catalog.DrinkResponse>) responseObserver);
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

  private static abstract class DrinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DrinkServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return S05Drink_Catalog.S05DrinkCatalog.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DrinkService");
    }
  }

  private static final class DrinkServiceFileDescriptorSupplier
      extends DrinkServiceBaseDescriptorSupplier {
    DrinkServiceFileDescriptorSupplier() {}
  }

  private static final class DrinkServiceMethodDescriptorSupplier
      extends DrinkServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DrinkServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DrinkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DrinkServiceFileDescriptorSupplier())
              .addMethod(getOfferDrinksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
