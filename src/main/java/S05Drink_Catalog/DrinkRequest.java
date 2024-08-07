// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Method05.proto

package S05Drink_Catalog;

/**
 * <pre>
 * Request message containing a list of drink IDs server Streaming. This rpc is to show a list of drinks and 
 * </pre>
 *
 * Protobuf type {@code cinema2.DrinkRequest}
 */
public  final class DrinkRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cinema2.DrinkRequest)
    DrinkRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DrinkRequest.newBuilder() to construct.
  private DrinkRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DrinkRequest() {
    drinkIds_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DrinkRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              drinkIds_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            drinkIds_.add(input.readInt32());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              drinkIds_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              drinkIds_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        drinkIds_ = java.util.Collections.unmodifiableList(drinkIds_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return S05Drink_Catalog.S05DrinkCatalog.internal_static_cinema2_DrinkRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return S05Drink_Catalog.S05DrinkCatalog.internal_static_cinema2_DrinkRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            S05Drink_Catalog.DrinkRequest.class, S05Drink_Catalog.DrinkRequest.Builder.class);
  }

  public static final int DRINK_IDS_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Integer> drinkIds_;
  /**
   * <pre>
   * List of drink IDs chosen by the client
   * </pre>
   *
   * <code>repeated int32 drink_ids = 1;</code>
   */
  public java.util.List<java.lang.Integer>
      getDrinkIdsList() {
    return drinkIds_;
  }
  /**
   * <pre>
   * List of drink IDs chosen by the client
   * </pre>
   *
   * <code>repeated int32 drink_ids = 1;</code>
   */
  public int getDrinkIdsCount() {
    return drinkIds_.size();
  }
  /**
   * <pre>
   * List of drink IDs chosen by the client
   * </pre>
   *
   * <code>repeated int32 drink_ids = 1;</code>
   */
  public int getDrinkIds(int index) {
    return drinkIds_.get(index);
  }
  private int drinkIdsMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getDrinkIdsList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(drinkIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < drinkIds_.size(); i++) {
      output.writeInt32NoTag(drinkIds_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < drinkIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(drinkIds_.get(i));
      }
      size += dataSize;
      if (!getDrinkIdsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      drinkIdsMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof S05Drink_Catalog.DrinkRequest)) {
      return super.equals(obj);
    }
    S05Drink_Catalog.DrinkRequest other = (S05Drink_Catalog.DrinkRequest) obj;

    boolean result = true;
    result = result && getDrinkIdsList()
        .equals(other.getDrinkIdsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDrinkIdsCount() > 0) {
      hash = (37 * hash) + DRINK_IDS_FIELD_NUMBER;
      hash = (53 * hash) + getDrinkIdsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static S05Drink_Catalog.DrinkRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static S05Drink_Catalog.DrinkRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static S05Drink_Catalog.DrinkRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static S05Drink_Catalog.DrinkRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(S05Drink_Catalog.DrinkRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Request message containing a list of drink IDs server Streaming. This rpc is to show a list of drinks and 
   * </pre>
   *
   * Protobuf type {@code cinema2.DrinkRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cinema2.DrinkRequest)
      S05Drink_Catalog.DrinkRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return S05Drink_Catalog.S05DrinkCatalog.internal_static_cinema2_DrinkRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return S05Drink_Catalog.S05DrinkCatalog.internal_static_cinema2_DrinkRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              S05Drink_Catalog.DrinkRequest.class, S05Drink_Catalog.DrinkRequest.Builder.class);
    }

    // Construct using S05Drink_Catalog.DrinkRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      drinkIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return S05Drink_Catalog.S05DrinkCatalog.internal_static_cinema2_DrinkRequest_descriptor;
    }

    @java.lang.Override
    public S05Drink_Catalog.DrinkRequest getDefaultInstanceForType() {
      return S05Drink_Catalog.DrinkRequest.getDefaultInstance();
    }

    @java.lang.Override
    public S05Drink_Catalog.DrinkRequest build() {
      S05Drink_Catalog.DrinkRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public S05Drink_Catalog.DrinkRequest buildPartial() {
      S05Drink_Catalog.DrinkRequest result = new S05Drink_Catalog.DrinkRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        drinkIds_ = java.util.Collections.unmodifiableList(drinkIds_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.drinkIds_ = drinkIds_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof S05Drink_Catalog.DrinkRequest) {
        return mergeFrom((S05Drink_Catalog.DrinkRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(S05Drink_Catalog.DrinkRequest other) {
      if (other == S05Drink_Catalog.DrinkRequest.getDefaultInstance()) return this;
      if (!other.drinkIds_.isEmpty()) {
        if (drinkIds_.isEmpty()) {
          drinkIds_ = other.drinkIds_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureDrinkIdsIsMutable();
          drinkIds_.addAll(other.drinkIds_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      S05Drink_Catalog.DrinkRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (S05Drink_Catalog.DrinkRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Integer> drinkIds_ = java.util.Collections.emptyList();
    private void ensureDrinkIdsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        drinkIds_ = new java.util.ArrayList<java.lang.Integer>(drinkIds_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getDrinkIdsList() {
      return java.util.Collections.unmodifiableList(drinkIds_);
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public int getDrinkIdsCount() {
      return drinkIds_.size();
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public int getDrinkIds(int index) {
      return drinkIds_.get(index);
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public Builder setDrinkIds(
        int index, int value) {
      ensureDrinkIdsIsMutable();
      drinkIds_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public Builder addDrinkIds(int value) {
      ensureDrinkIdsIsMutable();
      drinkIds_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public Builder addAllDrinkIds(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureDrinkIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, drinkIds_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * List of drink IDs chosen by the client
     * </pre>
     *
     * <code>repeated int32 drink_ids = 1;</code>
     */
    public Builder clearDrinkIds() {
      drinkIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:cinema2.DrinkRequest)
  }

  // @@protoc_insertion_point(class_scope:cinema2.DrinkRequest)
  private static final S05Drink_Catalog.DrinkRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new S05Drink_Catalog.DrinkRequest();
  }

  public static S05Drink_Catalog.DrinkRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DrinkRequest>
      PARSER = new com.google.protobuf.AbstractParser<DrinkRequest>() {
    @java.lang.Override
    public DrinkRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DrinkRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DrinkRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DrinkRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public S05Drink_Catalog.DrinkRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

