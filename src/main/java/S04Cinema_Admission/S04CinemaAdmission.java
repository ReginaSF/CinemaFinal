// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Method04.proto

package S04Cinema_Admission;

public final class S04CinemaAdmission {
  private S04CinemaAdmission() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cinema2_TicketRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cinema2_TicketRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cinema2_TicketResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cinema2_TicketResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016Method04.proto\022\007cinema2\"4\n\rTicketReque" +
      "st\022\025\n\rticket_number\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\"" +
      "3\n\016TicketResponse\022\020\n\010accepted\030\001 \001(\010\022\017\n\007m" +
      "essage\030\002 \001(\t2W\n\rTicketService\022F\n\021EnterTi" +
      "cketNumber\022\026.cinema2.TicketRequest\032\027.cin" +
      "ema2.TicketResponse(\001B+\n\023S04Cinema_Admis" +
      "sionB\022S04CinemaAdmissionP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_cinema2_TicketRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cinema2_TicketRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cinema2_TicketRequest_descriptor,
        new java.lang.String[] { "TicketNumber", "Name", });
    internal_static_cinema2_TicketResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cinema2_TicketResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cinema2_TicketResponse_descriptor,
        new java.lang.String[] { "Accepted", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
