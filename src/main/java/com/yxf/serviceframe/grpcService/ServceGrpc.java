package com.yxf.serviceframe.grpcService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServceGrpc {

  private ServceGrpc() {}

  public static final String SERVICE_NAME = "Servce";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.yxf.serviceframe.entity.requestInfo,
      com.yxf.serviceframe.entity.responseInfo> getMethodMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "method",
      requestType = com.yxf.serviceframe.entity.requestInfo.class,
      responseType = com.yxf.serviceframe.entity.responseInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yxf.serviceframe.entity.requestInfo,
      com.yxf.serviceframe.entity.responseInfo> getMethodMethod() {
    io.grpc.MethodDescriptor<com.yxf.serviceframe.entity.requestInfo, com.yxf.serviceframe.entity.responseInfo> getMethodMethod;
    if ((getMethodMethod = ServceGrpc.getMethodMethod) == null) {
      synchronized (ServceGrpc.class) {
        if ((getMethodMethod = ServceGrpc.getMethodMethod) == null) {
          ServceGrpc.getMethodMethod = getMethodMethod =
              io.grpc.MethodDescriptor.<com.yxf.serviceframe.entity.requestInfo, com.yxf.serviceframe.entity.responseInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "method"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxf.serviceframe.entity.requestInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxf.serviceframe.entity.responseInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ServceMethodDescriptorSupplier("method"))
              .build();
        }
      }
    }
    return getMethodMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServceStub>() {
        @Override
        public ServceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServceStub(channel, callOptions);
        }
      };
    return ServceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServceBlockingStub>() {
        @Override
        public ServceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServceBlockingStub(channel, callOptions);
        }
      };
    return ServceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServceFutureStub>() {
        @Override
        public ServceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServceFutureStub(channel, callOptions);
        }
      };
    return ServceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void method(com.yxf.serviceframe.entity.requestInfo request,
        io.grpc.stub.StreamObserver<com.yxf.serviceframe.entity.responseInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMethodMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Servce.
   */
  public static abstract class ServceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return ServceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Servce.
   */
  public static final class ServceStub
      extends io.grpc.stub.AbstractAsyncStub<ServceStub> {
    private ServceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ServceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServceStub(channel, callOptions);
    }

    /**
     */
    public void method(com.yxf.serviceframe.entity.requestInfo request,
        io.grpc.stub.StreamObserver<com.yxf.serviceframe.entity.responseInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMethodMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Servce.
   */
  public static final class ServceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServceBlockingStub> {
    private ServceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ServceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yxf.serviceframe.entity.responseInfo method(com.yxf.serviceframe.entity.requestInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMethodMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Servce.
   */
  public static final class ServceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServceFutureStub> {
    private ServceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ServceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yxf.serviceframe.entity.responseInfo> method(
        com.yxf.serviceframe.entity.requestInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMethodMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_METHOD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_METHOD:
          serviceImpl.method((com.yxf.serviceframe.entity.requestInfo) request,
              (io.grpc.stub.StreamObserver<com.yxf.serviceframe.entity.responseInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getMethodMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.yxf.serviceframe.entity.requestInfo,
              com.yxf.serviceframe.entity.responseInfo>(
                service, METHODID_METHOD)))
        .build();
  }

  private static abstract class ServceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yxf.serviceframe.entity.Service.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Servce");
    }
  }

  private static final class ServceFileDescriptorSupplier
      extends ServceBaseDescriptorSupplier {
    ServceFileDescriptorSupplier() {}
  }

  private static final class ServceMethodDescriptorSupplier
      extends ServceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServceFileDescriptorSupplier())
              .addMethod(getMethodMethod())
              .build();
        }
      }
    }
    return result;
  }
}
