package kotlinx.metadata.internal.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.protobuf.AbstractMessageLite;
import kotlinx.metadata.internal.protobuf.AbstractParser;
import kotlinx.metadata.internal.protobuf.ByteString;
import kotlinx.metadata.internal.protobuf.CodedInputStream;
import kotlinx.metadata.internal.protobuf.CodedOutputStream;
import kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.Internal;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder;
import kotlinx.metadata.internal.protobuf.Parser;
import kotlinx.metadata.internal.protobuf.WireFormat;
/* loaded from: classes5.dex */
public final class JvmProtoBuf {
    public static final int ANONYMOUS_OBJECT_ORIGIN_NAME_FIELD_NUMBER = 103;
    public static final int CLASS_LOCAL_VARIABLE_FIELD_NUMBER = 102;
    public static final int CLASS_MODULE_NAME_FIELD_NUMBER = 101;
    public static final int CONSTRUCTOR_SIGNATURE_FIELD_NUMBER = 100;
    public static final int FLAGS_FIELD_NUMBER = 101;
    public static final int IS_RAW_FIELD_NUMBER = 101;
    public static final int JVM_CLASS_FLAGS_FIELD_NUMBER = 104;
    public static final int LAMBDA_CLASS_ORIGIN_NAME_FIELD_NUMBER = 101;
    public static final int METHOD_SIGNATURE_FIELD_NUMBER = 100;
    public static final int PACKAGE_LOCAL_VARIABLE_FIELD_NUMBER = 102;
    public static final int PACKAGE_MODULE_NAME_FIELD_NUMBER = 101;
    public static final int PROPERTY_SIGNATURE_FIELD_NUMBER = 100;
    public static final int TYPE_ANNOTATION_FIELD_NUMBER = 100;
    public static final int TYPE_PARAMETER_ANNOTATION_FIELD_NUMBER = 100;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmMethodSignature.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmMethodSignature.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmPropertySignature.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), false, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Property.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Property.class);

    /* loaded from: classes5.dex */
    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
        int getDesc();

        int getName();

        boolean hasDesc();

        boolean hasName();
    }

    /* loaded from: classes5.dex */
    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
        int getDesc();

        int getName();

        boolean hasDesc();

        boolean hasName();
    }

    /* loaded from: classes5.dex */
    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
        JvmMethodSignature getDelegateMethod();

        JvmFieldSignature getField();

        JvmMethodSignature getGetter();

        JvmMethodSignature getSetter();

        JvmMethodSignature getSyntheticMethod();

        boolean hasDelegateMethod();

        boolean hasField();

        boolean hasGetter();

        boolean hasSetter();

        boolean hasSyntheticMethod();
    }

    /* loaded from: classes5.dex */
    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
        int getLocalName(int i);

        int getLocalNameCount();

        List<Integer> getLocalNameList();

        StringTableTypes.Record getRecord(int i);

        int getRecordCount();

        List<StringTableTypes.Record> getRecordList();
    }

    private JvmProtoBuf() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(constructorSignature);
        extensionRegistryLite.add(methodSignature);
        extensionRegistryLite.add(lambdaClassOriginName);
        extensionRegistryLite.add(propertySignature);
        extensionRegistryLite.add(flags);
        extensionRegistryLite.add(typeAnnotation);
        extensionRegistryLite.add(isRaw);
        extensionRegistryLite.add(typeParameterAnnotation);
        extensionRegistryLite.add(classModuleName);
        extensionRegistryLite.add(classLocalVariable);
        extensionRegistryLite.add(anonymousObjectOriginName);
        extensionRegistryLite.add(jvmClassFlags);
        extensionRegistryLite.add(packageModuleName);
        extensionRegistryLite.add(packageLocalVariable);
    }

    /* loaded from: classes5.dex */
    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static final int LOCAL_NAME_FIELD_NUMBER = 5;
        public static Parser<StringTableTypes> PARSER = new AbstractParser<StringTableTypes>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public StringTableTypes parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTableTypes(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECORD_FIELD_NUMBER = 1;
        private static final StringTableTypes defaultInstance;
        private static final long serialVersionUID = 0;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final ByteString unknownFields;

        /* loaded from: classes5.dex */
        public interface RecordOrBuilder extends MessageLiteOrBuilder {
            Record.Operation getOperation();

            int getPredefinedIndex();

            int getRange();

            int getReplaceChar(int i);

            int getReplaceCharCount();

            List<Integer> getReplaceCharList();

            String getString();

            ByteString getStringBytes();

            int getSubstringIndex(int i);

            int getSubstringIndexCount();

            List<Integer> getSubstringIndexList();

            boolean hasOperation();

            boolean hasPredefinedIndex();

            boolean hasRange();

            boolean hasString();
        }

        private StringTableTypes(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTableTypes(boolean z) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private StringTableTypes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!(z2 & true)) {
                                    this.record_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.record_.add(codedInputStream.readMessage(Record.PARSER, extensionRegistryLite));
                            } else if (readTag == 40) {
                                if (!(z2 & true)) {
                                    this.localName_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localName_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.record_ = Collections.unmodifiableList(this.record_);
                        }
                        if (z2 & true) {
                            this.localName_ = Collections.unmodifiableList(this.localName_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = newOutput.toByteString();
                            throw th2;
                        }
                        this.unknownFields = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z2 & true) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if (z2 & true) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes(true);
            defaultInstance = stringTableTypes;
            stringTableTypes.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static final int OPERATION_FIELD_NUMBER = 3;
            public static Parser<Record> PARSER = new AbstractParser<Record>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.1
                @Override // kotlinx.metadata.internal.protobuf.Parser
                public Record parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Record(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int PREDEFINED_INDEX_FIELD_NUMBER = 2;
            public static final int RANGE_FIELD_NUMBER = 1;
            public static final int REPLACE_CHAR_FIELD_NUMBER = 5;
            public static final int STRING_FIELD_NUMBER = 6;
            public static final int SUBSTRING_INDEX_FIELD_NUMBER = 4;
            private static final Record defaultInstance;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final ByteString unknownFields;

            private Record(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Record(boolean z) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Record(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.range_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    int readEnum = codedInputStream.readEnum();
                                    Operation valueOf = Operation.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = valueOf;
                                    }
                                } else if (readTag == 32) {
                                    if (!(z2 & true)) {
                                        this.substringIndex_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (readTag == 34) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 40) {
                                    if (!(z2 & true)) {
                                        this.replaceChar_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (readTag == 42) {
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                } else if (readTag != 50) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    ByteString readBytes = codedInputStream.readBytes();
                                    this.bitField0_ |= 4;
                                    this.string_ = readBytes;
                                }
                            }
                            z = true;
                        } catch (Throwable th) {
                            if (z2 & true) {
                                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                            }
                            if (z2 & true) {
                                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                            }
                            try {
                                newInstance.flush();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.unknownFields = newOutput.toByteString();
                                throw th2;
                            }
                            this.unknownFields = newOutput.toByteString();
                            makeExtensionsImmutable();
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                }
                if (z2 & true) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if (z2 & true) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = newOutput.toByteString();
                    throw th3;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
            }

            static {
                Record record = new Record(true);
                defaultInstance = record;
                record.initFields();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
            public Parser<Record> getParserForType() {
                return PARSER;
            }

            /* loaded from: classes5.dex */
            public enum Operation implements Internal.EnumLite {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);
                
                public static final int DESC_TO_CLASS_ID_VALUE = 2;
                public static final int INTERNAL_TO_CLASS_ID_VALUE = 1;
                public static final int NONE_VALUE = 0;
                private static Internal.EnumLiteMap<Operation> internalValueMap = new Internal.EnumLiteMap<Operation>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                    public Operation findValueByNumber(int i) {
                        return Operation.valueOf(i);
                    }
                };
                private final int value;

                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                return null;
                            }
                            return DESC_TO_CLASS_ID;
                        }
                        return INTERNAL_TO_CLASS_ID;
                    }
                    return NONE;
                }

                public static Internal.EnumLiteMap<Operation> internalGetValueMap() {
                    return internalValueMap;
                }

                Operation(int i, int i2) {
                    this.value = i2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public int getRange() {
                return this.range_;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.string_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public ByteString getStringBytes() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.string_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public Operation getOperation() {
                return this.operation_;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public int getSubstringIndex(int i) {
                return this.substringIndex_.get(i).intValue();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
            public int getReplaceChar(int i) {
                return this.replaceChar_.get(i).intValue();
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeEnum(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.writeRawVarint32(34);
                    codedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
                }
                for (int i = 0; i < this.substringIndex_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.substringIndex_.get(i).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.writeRawVarint32(42);
                    codedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.replaceChar_.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.replaceChar_.get(i2).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeBytes(6, getStringBytes());
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.range_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeInt32Size += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.substringIndex_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i3).intValue());
                }
                int i4 = computeInt32Size + i2;
                if (!getSubstringIndexList().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
                }
                this.substringIndexMemoizedSerializedSize = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.replaceChar_.size(); i6++) {
                    i5 += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i6).intValue());
                }
                int i7 = i4 + i5;
                if (!getReplaceCharList().isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(i5);
                }
                this.replaceCharMemoizedSerializedSize = i5;
                if ((this.bitField0_ & 4) == 4) {
                    i7 += CodedOutputStream.computeBytesSize(6, getStringBytes());
                }
                int size = i7 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Record parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Record parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Record parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Record parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Record parseFrom(InputStream inputStream) throws IOException {
                return PARSER.parseFrom(inputStream);
            }

            public static Record parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(inputStream, extensionRegistryLite);
            }

            public static Record parseDelimitedFrom(InputStream inputStream) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream);
            }

            public static Record parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public static Record parseFrom(CodedInputStream codedInputStream) throws IOException {
                return PARSER.parseFrom(codedInputStream);
            }

            public static Record parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return Builder.access$200();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Record record) {
                return newBuilder().mergeFrom(record);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                private int bitField0_;
                private int predefinedIndex_;
                private int range_ = 1;
                private Object string_ = "";
                private Operation operation_ = Operation.NONE;
                private List<Integer> substringIndex_ = Collections.emptyList();
                private List<Integer> replaceChar_ = Collections.emptyList();

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                static /* synthetic */ Builder access$200() {
                    return create();
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Builder clear() {
                    super.clear();
                    this.range_ = 1;
                    int i = this.bitField0_;
                    this.predefinedIndex_ = 0;
                    this.string_ = "";
                    this.bitField0_ = i & (-8);
                    this.operation_ = Operation.NONE;
                    this.bitField0_ &= -9;
                    this.substringIndex_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    this.replaceChar_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Record build() {
                    Record buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Record buildPartial() {
                    Record record = new Record(this);
                    int i = this.bitField0_;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    record.range_ = this.range_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    record.predefinedIndex_ = this.predefinedIndex_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    record.string_ = this.string_;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    record.operation_ = this.operation_;
                    if ((this.bitField0_ & 16) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        this.bitField0_ &= -17;
                    }
                    record.substringIndex_ = this.substringIndex_;
                    if ((this.bitField0_ & 32) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        this.bitField0_ &= -33;
                    }
                    record.replaceChar_ = this.replaceChar_;
                    record.bitField0_ = i2;
                    return record;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Record record) {
                    if (record == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (record.hasRange()) {
                        setRange(record.getRange());
                    }
                    if (record.hasPredefinedIndex()) {
                        setPredefinedIndex(record.getPredefinedIndex());
                    }
                    if (record.hasString()) {
                        this.bitField0_ |= 4;
                        this.string_ = record.string_;
                    }
                    if (record.hasOperation()) {
                        setOperation(record.getOperation());
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.substringIndex_.isEmpty()) {
                            this.substringIndex_ = record.substringIndex_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureSubstringIndexIsMutable();
                            this.substringIndex_.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.replaceChar_.isEmpty()) {
                            this.replaceChar_ = record.replaceChar_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureReplaceCharIsMutable();
                            this.replaceChar_.addAll(record.replaceChar_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(record.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Record record = null;
                    try {
                        try {
                            Record parsePartialFrom = Record.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Record record2 = (Record) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                record = record2;
                                if (record != null) {
                                    mergeFrom(record);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (record != null) {
                        }
                        throw th;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public boolean hasRange() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public int getRange() {
                    return this.range_;
                }

                public Builder setRange(int i) {
                    this.bitField0_ |= 1;
                    this.range_ = i;
                    return this;
                }

                public Builder clearRange() {
                    this.bitField0_ &= -2;
                    this.range_ = 1;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public boolean hasPredefinedIndex() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public int getPredefinedIndex() {
                    return this.predefinedIndex_;
                }

                public Builder setPredefinedIndex(int i) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = i;
                    return this;
                }

                public Builder clearPredefinedIndex() {
                    this.bitField0_ &= -3;
                    this.predefinedIndex_ = 0;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public boolean hasString() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public String getString() {
                    Object obj = this.string_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.string_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public ByteString getStringBytes() {
                    Object obj = this.string_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.string_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setString(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.string_ = str;
                    return this;
                }

                public Builder clearString() {
                    this.bitField0_ &= -5;
                    this.string_ = Record.getDefaultInstance().getString();
                    return this;
                }

                public Builder setStringBytes(ByteString byteString) {
                    byteString.getClass();
                    this.bitField0_ |= 4;
                    this.string_ = byteString;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public boolean hasOperation() {
                    return (this.bitField0_ & 8) == 8;
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public Operation getOperation() {
                    return this.operation_;
                }

                public Builder setOperation(Operation operation) {
                    operation.getClass();
                    this.bitField0_ |= 8;
                    this.operation_ = operation;
                    return this;
                }

                public Builder clearOperation() {
                    this.bitField0_ &= -9;
                    this.operation_ = Operation.NONE;
                    return this;
                }

                private void ensureSubstringIndexIsMutable() {
                    if ((this.bitField0_ & 16) != 16) {
                        this.substringIndex_ = new ArrayList(this.substringIndex_);
                        this.bitField0_ |= 16;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public List<Integer> getSubstringIndexList() {
                    return Collections.unmodifiableList(this.substringIndex_);
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public int getSubstringIndexCount() {
                    return this.substringIndex_.size();
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public int getSubstringIndex(int i) {
                    return this.substringIndex_.get(i).intValue();
                }

                public Builder setSubstringIndex(int i, int i2) {
                    ensureSubstringIndexIsMutable();
                    this.substringIndex_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Builder addSubstringIndex(int i) {
                    ensureSubstringIndexIsMutable();
                    this.substringIndex_.add(Integer.valueOf(i));
                    return this;
                }

                public Builder addAllSubstringIndex(Iterable<? extends Integer> iterable) {
                    ensureSubstringIndexIsMutable();
                    AbstractMessageLite.Builder.addAll(iterable, this.substringIndex_);
                    return this;
                }

                public Builder clearSubstringIndex() {
                    this.substringIndex_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    return this;
                }

                private void ensureReplaceCharIsMutable() {
                    if ((this.bitField0_ & 32) != 32) {
                        this.replaceChar_ = new ArrayList(this.replaceChar_);
                        this.bitField0_ |= 32;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public List<Integer> getReplaceCharList() {
                    return Collections.unmodifiableList(this.replaceChar_);
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public int getReplaceCharCount() {
                    return this.replaceChar_.size();
                }

                @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypes.RecordOrBuilder
                public int getReplaceChar(int i) {
                    return this.replaceChar_.get(i).intValue();
                }

                public Builder setReplaceChar(int i, int i2) {
                    ensureReplaceCharIsMutable();
                    this.replaceChar_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Builder addReplaceChar(int i) {
                    ensureReplaceCharIsMutable();
                    this.replaceChar_.add(Integer.valueOf(i));
                    return this;
                }

                public Builder addAllReplaceChar(Iterable<? extends Integer> iterable) {
                    ensureReplaceCharIsMutable();
                    AbstractMessageLite.Builder.addAll(iterable, this.replaceChar_);
                    return this;
                }

                public Builder clearReplaceChar() {
                    this.replaceChar_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    return this;
                }
            }
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
        public List<Record> getRecordList() {
            return this.record_;
        }

        public List<? extends RecordOrBuilder> getRecordOrBuilderList() {
            return this.record_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
        public int getRecordCount() {
            return this.record_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
        public Record getRecord(int i) {
            return this.record_.get(i);
        }

        public RecordOrBuilder getRecordOrBuilder(int i) {
            return this.record_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
        public int getLocalNameCount() {
            return this.localName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
        public int getLocalName(int i) {
            return this.localName_.get(i).intValue();
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.record_.size(); i++) {
                codedOutputStream.writeMessage(1, this.record_.get(i));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localName_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.localName_.get(i2).intValue());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.record_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.record_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.localName_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i5).intValue());
            }
            int i6 = i2 + i4;
            if (!getLocalNameList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.localNameMemoizedSerializedSize = i4;
            int size = i6 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static StringTableTypes parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static StringTableTypes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StringTableTypes parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static StringTableTypes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static StringTableTypes parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static StringTableTypes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static StringTableTypes parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static StringTableTypes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$1200();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StringTableTypes stringTableTypes) {
            return newBuilder().mergeFrom(stringTableTypes);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            private int bitField0_;
            private List<Record> record_ = Collections.emptyList();
            private List<Integer> localName_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$1200() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.record_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.localName_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public StringTableTypes build() {
                StringTableTypes buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public StringTableTypes buildPartial() {
                StringTableTypes stringTableTypes = new StringTableTypes(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                    this.bitField0_ &= -2;
                }
                stringTableTypes.record_ = this.record_;
                if ((this.bitField0_ & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
                    this.bitField0_ &= -3;
                }
                stringTableTypes.localName_ = this.localName_;
                return stringTableTypes;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.record_.isEmpty()) {
                        this.record_ = stringTableTypes.record_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordIsMutable();
                        this.record_.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.localName_.isEmpty()) {
                        this.localName_ = stringTableTypes.localName_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureLocalNameIsMutable();
                        this.localName_.addAll(stringTableTypes.localName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTableTypes.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTableTypes stringTableTypes = null;
                try {
                    try {
                        StringTableTypes parsePartialFrom = StringTableTypes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        StringTableTypes stringTableTypes2 = (StringTableTypes) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            stringTableTypes = stringTableTypes2;
                            if (stringTableTypes != null) {
                                mergeFrom(stringTableTypes);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (stringTableTypes != null) {
                    }
                    throw th;
                }
            }

            private void ensureRecordIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.record_ = new ArrayList(this.record_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
            public List<Record> getRecordList() {
                return Collections.unmodifiableList(this.record_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
            public int getRecordCount() {
                return this.record_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
            public Record getRecord(int i) {
                return this.record_.get(i);
            }

            public Builder setRecord(int i, Record record) {
                record.getClass();
                ensureRecordIsMutable();
                this.record_.set(i, record);
                return this;
            }

            public Builder setRecord(int i, Record.Builder builder) {
                ensureRecordIsMutable();
                this.record_.set(i, builder.build());
                return this;
            }

            public Builder addRecord(Record record) {
                record.getClass();
                ensureRecordIsMutable();
                this.record_.add(record);
                return this;
            }

            public Builder addRecord(int i, Record record) {
                record.getClass();
                ensureRecordIsMutable();
                this.record_.add(i, record);
                return this;
            }

            public Builder addRecord(Record.Builder builder) {
                ensureRecordIsMutable();
                this.record_.add(builder.build());
                return this;
            }

            public Builder addRecord(int i, Record.Builder builder) {
                ensureRecordIsMutable();
                this.record_.add(i, builder.build());
                return this;
            }

            public Builder addAllRecord(Iterable<? extends Record> iterable) {
                ensureRecordIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.record_);
                return this;
            }

            public Builder clearRecord() {
                this.record_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeRecord(int i) {
                ensureRecordIsMutable();
                this.record_.remove(i);
                return this;
            }

            private void ensureLocalNameIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.localName_ = new ArrayList(this.localName_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
            public List<Integer> getLocalNameList() {
                return Collections.unmodifiableList(this.localName_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
            public int getLocalNameCount() {
                return this.localName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.StringTableTypesOrBuilder
            public int getLocalName(int i) {
                return this.localName_.get(i).intValue();
            }

            public Builder setLocalName(int i, int i2) {
                ensureLocalNameIsMutable();
                this.localName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addLocalName(int i) {
                ensureLocalNameIsMutable();
                this.localName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllLocalName(Iterable<? extends Integer> iterable) {
                ensureLocalNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.localName_);
                return this;
            }

            public Builder clearLocalName() {
                this.localName_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static final int DESC_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static Parser<JvmMethodSignature> PARSER = new AbstractParser<JvmMethodSignature>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignature.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public JvmMethodSignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(codedInputStream, extensionRegistryLite);
            }
        };
        private static final JvmMethodSignature defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        private JvmMethodSignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmMethodSignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        private JvmMethodSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            } else if (readTag != 16) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = codedInputStream.readInt32();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(true);
            defaultInstance = jvmMethodSignature;
            jvmMethodSignature.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
        public int getDesc() {
            return this.desc_;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JvmMethodSignature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static JvmMethodSignature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static JvmMethodSignature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static JvmMethodSignature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static JvmMethodSignature parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static JvmMethodSignature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static JvmMethodSignature parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static JvmMethodSignature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static JvmMethodSignature parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static JvmMethodSignature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$1800();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JvmMethodSignature jvmMethodSignature) {
            return newBuilder().mergeFrom(jvmMethodSignature);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$1800() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.name_ = 0;
                int i = this.bitField0_;
                this.desc_ = 0;
                this.bitField0_ = i & (-4);
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public JvmMethodSignature build() {
                JvmMethodSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public JvmMethodSignature buildPartial() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                jvmMethodSignature.name_ = this.name_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmMethodSignature.desc_ = this.desc_;
                jvmMethodSignature.bitField0_ = i2;
                return jvmMethodSignature;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    setName(jvmMethodSignature.getName());
                }
                if (jvmMethodSignature.hasDesc()) {
                    setDesc(jvmMethodSignature.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(jvmMethodSignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmMethodSignature jvmMethodSignature = null;
                try {
                    try {
                        JvmMethodSignature parsePartialFrom = JvmMethodSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            jvmMethodSignature = jvmMethodSignature2;
                            if (jvmMethodSignature != null) {
                                mergeFrom(jvmMethodSignature);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jvmMethodSignature != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 1;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
            public boolean hasDesc() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmMethodSignatureOrBuilder
            public int getDesc() {
                return this.desc_;
            }

            public Builder setDesc(int i) {
                this.bitField0_ |= 2;
                this.desc_ = i;
                return this;
            }

            public Builder clearDesc() {
                this.bitField0_ &= -3;
                this.desc_ = 0;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static final int DESC_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static Parser<JvmFieldSignature> PARSER = new AbstractParser<JvmFieldSignature>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignature.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public JvmFieldSignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(codedInputStream, extensionRegistryLite);
            }
        };
        private static final JvmFieldSignature defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        private JvmFieldSignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmFieldSignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        private JvmFieldSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            } else if (readTag != 16) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = codedInputStream.readInt32();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(true);
            defaultInstance = jvmFieldSignature;
            jvmFieldSignature.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
        public int getDesc() {
            return this.desc_;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JvmFieldSignature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static JvmFieldSignature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static JvmFieldSignature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static JvmFieldSignature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static JvmFieldSignature parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static JvmFieldSignature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static JvmFieldSignature parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static JvmFieldSignature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static JvmFieldSignature parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static JvmFieldSignature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$2500();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JvmFieldSignature jvmFieldSignature) {
            return newBuilder().mergeFrom(jvmFieldSignature);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$2500() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.name_ = 0;
                int i = this.bitField0_;
                this.desc_ = 0;
                this.bitField0_ = i & (-4);
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public JvmFieldSignature build() {
                JvmFieldSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public JvmFieldSignature buildPartial() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                jvmFieldSignature.name_ = this.name_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmFieldSignature.desc_ = this.desc_;
                jvmFieldSignature.bitField0_ = i2;
                return jvmFieldSignature;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    setName(jvmFieldSignature.getName());
                }
                if (jvmFieldSignature.hasDesc()) {
                    setDesc(jvmFieldSignature.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(jvmFieldSignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmFieldSignature jvmFieldSignature = null;
                try {
                    try {
                        JvmFieldSignature parsePartialFrom = JvmFieldSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        JvmFieldSignature jvmFieldSignature2 = (JvmFieldSignature) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            jvmFieldSignature = jvmFieldSignature2;
                            if (jvmFieldSignature != null) {
                                mergeFrom(jvmFieldSignature);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jvmFieldSignature != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 1;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
            public boolean hasDesc() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmFieldSignatureOrBuilder
            public int getDesc() {
                return this.desc_;
            }

            public Builder setDesc(int i) {
                this.bitField0_ |= 2;
                this.desc_ = i;
                return this;
            }

            public Builder clearDesc() {
                this.bitField0_ &= -3;
                this.desc_ = 0;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static final int DELEGATE_METHOD_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int GETTER_FIELD_NUMBER = 3;
        public static Parser<JvmPropertySignature> PARSER = new AbstractParser<JvmPropertySignature>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignature.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public JvmPropertySignature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SETTER_FIELD_NUMBER = 4;
        public static final int SYNTHETIC_METHOD_FIELD_NUMBER = 2;
        private static final JvmPropertySignature defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private JvmMethodSignature delegateMethod_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final ByteString unknownFields;

        private JvmPropertySignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmPropertySignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        private JvmPropertySignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                    JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) codedInputStream.readMessage(JvmFieldSignature.PARSER, extensionRegistryLite);
                                    this.field_ = jvmFieldSignature;
                                    if (builder != null) {
                                        builder.mergeFrom(jvmFieldSignature);
                                        this.field_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (readTag == 18) {
                                    builder = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                    JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                                    this.syntheticMethod_ = jvmMethodSignature;
                                    if (builder != null) {
                                        builder.mergeFrom(jvmMethodSignature);
                                        this.syntheticMethod_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 26) {
                                    builder = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                    JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                                    this.getter_ = jvmMethodSignature2;
                                    if (builder != null) {
                                        builder.mergeFrom(jvmMethodSignature2);
                                        this.getter_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (readTag == 34) {
                                    builder = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                    JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                                    this.setter_ = jvmMethodSignature3;
                                    if (builder != null) {
                                        builder.mergeFrom(jvmMethodSignature3);
                                        this.setter_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                } else if (readTag != 42) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    builder = (this.bitField0_ & 16) == 16 ? this.delegateMethod_.toBuilder() : null;
                                    JvmMethodSignature jvmMethodSignature4 = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                                    this.delegateMethod_ = jvmMethodSignature4;
                                    if (builder != null) {
                                        builder.mergeFrom(jvmMethodSignature4);
                                        this.delegateMethod_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
            makeExtensionsImmutable();
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(true);
            defaultInstance = jvmPropertySignature;
            jvmPropertySignature.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public JvmFieldSignature getField() {
            return this.field_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public boolean hasSyntheticMethod() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public boolean hasDelegateMethod() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(5, this.delegateMethod_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, this.delegateMethod_);
            }
            int size = computeMessageSize + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JvmPropertySignature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static JvmPropertySignature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static JvmPropertySignature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static JvmPropertySignature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static JvmPropertySignature parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static JvmPropertySignature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static JvmPropertySignature parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static JvmPropertySignature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static JvmPropertySignature parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static JvmPropertySignature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$3200();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JvmPropertySignature jvmPropertySignature) {
            return newBuilder().mergeFrom(jvmPropertySignature);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            private int bitField0_;
            private JvmFieldSignature field_ = JvmFieldSignature.getDefaultInstance();
            private JvmMethodSignature syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature getter_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature setter_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature delegateMethod_ = JvmMethodSignature.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$3200() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.bitField0_ &= -2;
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -3;
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -5;
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -9;
                this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public JvmPropertySignature build() {
                JvmPropertySignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public JvmPropertySignature buildPartial() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                jvmPropertySignature.field_ = this.field_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmPropertySignature.syntheticMethod_ = this.syntheticMethod_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jvmPropertySignature.getter_ = this.getter_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jvmPropertySignature.setter_ = this.setter_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                jvmPropertySignature.delegateMethod_ = this.delegateMethod_;
                jvmPropertySignature.bitField0_ = i2;
                return jvmPropertySignature;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmPropertySignature.hasField()) {
                    mergeField(jvmPropertySignature.getField());
                }
                if (jvmPropertySignature.hasSyntheticMethod()) {
                    mergeSyntheticMethod(jvmPropertySignature.getSyntheticMethod());
                }
                if (jvmPropertySignature.hasGetter()) {
                    mergeGetter(jvmPropertySignature.getGetter());
                }
                if (jvmPropertySignature.hasSetter()) {
                    mergeSetter(jvmPropertySignature.getSetter());
                }
                if (jvmPropertySignature.hasDelegateMethod()) {
                    mergeDelegateMethod(jvmPropertySignature.getDelegateMethod());
                }
                setUnknownFields(getUnknownFields().concat(jvmPropertySignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmPropertySignature jvmPropertySignature = null;
                try {
                    try {
                        JvmPropertySignature parsePartialFrom = JvmPropertySignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        JvmPropertySignature jvmPropertySignature2 = (JvmPropertySignature) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            jvmPropertySignature = jvmPropertySignature2;
                            if (jvmPropertySignature != null) {
                                mergeFrom(jvmPropertySignature);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jvmPropertySignature != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public boolean hasField() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public JvmFieldSignature getField() {
                return this.field_;
            }

            public Builder setField(JvmFieldSignature jvmFieldSignature) {
                jvmFieldSignature.getClass();
                this.field_ = jvmFieldSignature;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setField(JvmFieldSignature.Builder builder) {
                this.field_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeField(JvmFieldSignature jvmFieldSignature) {
                if ((this.bitField0_ & 1) == 1 && this.field_ != JvmFieldSignature.getDefaultInstance()) {
                    this.field_ = JvmFieldSignature.newBuilder(this.field_).mergeFrom(jvmFieldSignature).buildPartial();
                } else {
                    this.field_ = jvmFieldSignature;
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder clearField() {
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public boolean hasSyntheticMethod() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public JvmMethodSignature getSyntheticMethod() {
                return this.syntheticMethod_;
            }

            public Builder setSyntheticMethod(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.syntheticMethod_ = jvmMethodSignature;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setSyntheticMethod(JvmMethodSignature.Builder builder) {
                this.syntheticMethod_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 2) == 2 && this.syntheticMethod_ != JvmMethodSignature.getDefaultInstance()) {
                    this.syntheticMethod_ = JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(jvmMethodSignature).buildPartial();
                } else {
                    this.syntheticMethod_ = jvmMethodSignature;
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearSyntheticMethod() {
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public boolean hasGetter() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public JvmMethodSignature getGetter() {
                return this.getter_;
            }

            public Builder setGetter(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.getter_ = jvmMethodSignature;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setGetter(JvmMethodSignature.Builder builder) {
                this.getter_ = builder.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeGetter(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 4) == 4 && this.getter_ != JvmMethodSignature.getDefaultInstance()) {
                    this.getter_ = JvmMethodSignature.newBuilder(this.getter_).mergeFrom(jvmMethodSignature).buildPartial();
                } else {
                    this.getter_ = jvmMethodSignature;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearGetter() {
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public boolean hasSetter() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public JvmMethodSignature getSetter() {
                return this.setter_;
            }

            public Builder setSetter(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.setter_ = jvmMethodSignature;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setSetter(JvmMethodSignature.Builder builder) {
                this.setter_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeSetter(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 8) == 8 && this.setter_ != JvmMethodSignature.getDefaultInstance()) {
                    this.setter_ = JvmMethodSignature.newBuilder(this.setter_).mergeFrom(jvmMethodSignature).buildPartial();
                } else {
                    this.setter_ = jvmMethodSignature;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearSetter() {
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public boolean hasDelegateMethod() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf.JvmPropertySignatureOrBuilder
            public JvmMethodSignature getDelegateMethod() {
                return this.delegateMethod_;
            }

            public Builder setDelegateMethod(JvmMethodSignature jvmMethodSignature) {
                jvmMethodSignature.getClass();
                this.delegateMethod_ = jvmMethodSignature;
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setDelegateMethod(JvmMethodSignature.Builder builder) {
                this.delegateMethod_ = builder.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeDelegateMethod(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 16) == 16 && this.delegateMethod_ != JvmMethodSignature.getDefaultInstance()) {
                    this.delegateMethod_ = JvmMethodSignature.newBuilder(this.delegateMethod_).mergeFrom(jvmMethodSignature).buildPartial();
                } else {
                    this.delegateMethod_ = jvmMethodSignature;
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder clearDelegateMethod() {
                this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }
        }
    }
}
