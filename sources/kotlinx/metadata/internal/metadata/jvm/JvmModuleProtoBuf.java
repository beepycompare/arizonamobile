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
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.LazyStringArrayList;
import kotlinx.metadata.internal.protobuf.LazyStringList;
import kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder;
import kotlinx.metadata.internal.protobuf.Parser;
import kotlinx.metadata.internal.protobuf.ProtocolStringList;
/* loaded from: classes5.dex */
public final class JvmModuleProtoBuf {

    /* loaded from: classes5.dex */
    public interface ModuleOrBuilder extends MessageLiteOrBuilder {
        ProtoBuf.Annotation getAnnotation(int i);

        int getAnnotationCount();

        List<ProtoBuf.Annotation> getAnnotationList();

        String getJvmPackageName(int i);

        ByteString getJvmPackageNameBytes(int i);

        int getJvmPackageNameCount();

        ProtocolStringList getJvmPackageNameList();

        PackageParts getMetadataParts(int i);

        int getMetadataPartsCount();

        List<PackageParts> getMetadataPartsList();

        ProtoBuf.Class getOptionalAnnotationClass(int i);

        int getOptionalAnnotationClassCount();

        List<ProtoBuf.Class> getOptionalAnnotationClassList();

        PackageParts getPackageParts(int i);

        int getPackagePartsCount();

        List<PackageParts> getPackagePartsList();

        ProtoBuf.QualifiedNameTable getQualifiedNameTable();

        ProtoBuf.StringTable getStringTable();

        boolean hasQualifiedNameTable();

        boolean hasStringTable();
    }

    /* loaded from: classes5.dex */
    public interface PackagePartsOrBuilder extends MessageLiteOrBuilder {
        int getClassWithJvmPackageNameMultifileFacadeShortNameId(int i);

        int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount();

        List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList();

        int getClassWithJvmPackageNamePackageId(int i);

        int getClassWithJvmPackageNamePackageIdCount();

        List<Integer> getClassWithJvmPackageNamePackageIdList();

        String getClassWithJvmPackageNameShortName(int i);

        ByteString getClassWithJvmPackageNameShortNameBytes(int i);

        int getClassWithJvmPackageNameShortNameCount();

        ProtocolStringList getClassWithJvmPackageNameShortNameList();

        String getMultifileFacadeShortName(int i);

        ByteString getMultifileFacadeShortNameBytes(int i);

        int getMultifileFacadeShortNameCount();

        int getMultifileFacadeShortNameId(int i);

        int getMultifileFacadeShortNameIdCount();

        List<Integer> getMultifileFacadeShortNameIdList();

        ProtocolStringList getMultifileFacadeShortNameList();

        String getPackageFqName();

        ByteString getPackageFqNameBytes();

        String getShortClassName(int i);

        ByteString getShortClassNameBytes(int i);

        int getShortClassNameCount();

        ProtocolStringList getShortClassNameList();

        boolean hasPackageFqName();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private JvmModuleProtoBuf() {
    }

    /* loaded from: classes5.dex */
    public static final class Module extends GeneratedMessageLite implements ModuleOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 6;
        public static final int JVM_PACKAGE_NAME_FIELD_NUMBER = 3;
        public static final int METADATA_PARTS_FIELD_NUMBER = 2;
        public static final int OPTIONAL_ANNOTATION_CLASS_FIELD_NUMBER = 16;
        public static final int PACKAGE_PARTS_FIELD_NUMBER = 1;
        public static Parser<Module> PARSER = new AbstractParser<Module>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.Module.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Module parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Module(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int QUALIFIED_NAME_TABLE_FIELD_NUMBER = 5;
        public static final int STRING_TABLE_FIELD_NUMBER = 4;
        private static final Module defaultInstance;
        private static final long serialVersionUID = 0;
        private List<ProtoBuf.Annotation> annotation_;
        private int bitField0_;
        private LazyStringList jvmPackageName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<PackageParts> metadataParts_;
        private List<ProtoBuf.Class> optionalAnnotationClass_;
        private List<PackageParts> packageParts_;
        private ProtoBuf.QualifiedNameTable qualifiedNameTable_;
        private ProtoBuf.StringTable stringTable_;
        private final ByteString unknownFields;

        private Module(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Module(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Module getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Module getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Module(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
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
                                    this.packageParts_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.packageParts_.add(codedInputStream.readMessage(PackageParts.PARSER, extensionRegistryLite));
                            } else if (readTag == 18) {
                                if (!(z2 & true)) {
                                    this.metadataParts_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.metadataParts_.add(codedInputStream.readMessage(PackageParts.PARSER, extensionRegistryLite));
                            } else if (readTag != 26) {
                                if (readTag == 34) {
                                    builder = (this.bitField0_ & 1) == 1 ? this.stringTable_.toBuilder() : null;
                                    ProtoBuf.StringTable stringTable = (ProtoBuf.StringTable) codedInputStream.readMessage(ProtoBuf.StringTable.PARSER, extensionRegistryLite);
                                    this.stringTable_ = stringTable;
                                    if (builder != null) {
                                        builder.mergeFrom(stringTable);
                                        this.stringTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (readTag == 42) {
                                    builder = (this.bitField0_ & 2) == 2 ? this.qualifiedNameTable_.toBuilder() : null;
                                    ProtoBuf.QualifiedNameTable qualifiedNameTable = (ProtoBuf.QualifiedNameTable) codedInputStream.readMessage(ProtoBuf.QualifiedNameTable.PARSER, extensionRegistryLite);
                                    this.qualifiedNameTable_ = qualifiedNameTable;
                                    if (builder != null) {
                                        builder.mergeFrom(qualifiedNameTable);
                                        this.qualifiedNameTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 50) {
                                    if (!(z2 & true)) {
                                        this.annotation_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.annotation_.add(codedInputStream.readMessage(ProtoBuf.Annotation.PARSER, extensionRegistryLite));
                                } else if (readTag != 130) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.optionalAnnotationClass_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.optionalAnnotationClass_.add(codedInputStream.readMessage(ProtoBuf.Class.PARSER, extensionRegistryLite));
                                }
                            } else {
                                ByteString readBytes = codedInputStream.readBytes();
                                if (!(z2 & true)) {
                                    this.jvmPackageName_ = new LazyStringArrayList();
                                    z2 |= true;
                                }
                                this.jvmPackageName_.add(readBytes);
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                    }
                    if (z2 & true) {
                        this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
                    }
                    if (z2 & true) {
                        this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
                    }
                    if (z2 & true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z2 & true) {
                        this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
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
            }
            if (z2 & true) {
                this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
            }
            if (z2 & true) {
                this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
            }
            if (z2 & true) {
                this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
            }
            if (z2 & true) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if (z2 & true) {
                this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
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
            Module module = new Module(true);
            defaultInstance = module;
            module.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Module> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<PackageParts> getPackagePartsList() {
            return this.packageParts_;
        }

        public List<? extends PackagePartsOrBuilder> getPackagePartsOrBuilderList() {
            return this.packageParts_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getPackagePartsCount() {
            return this.packageParts_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public PackageParts getPackageParts(int i) {
            return this.packageParts_.get(i);
        }

        public PackagePartsOrBuilder getPackagePartsOrBuilder(int i) {
            return this.packageParts_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<PackageParts> getMetadataPartsList() {
            return this.metadataParts_;
        }

        public List<? extends PackagePartsOrBuilder> getMetadataPartsOrBuilderList() {
            return this.metadataParts_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getMetadataPartsCount() {
            return this.metadataParts_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public PackageParts getMetadataParts(int i) {
            return this.metadataParts_.get(i);
        }

        public PackagePartsOrBuilder getMetadataPartsOrBuilder(int i) {
            return this.metadataParts_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtocolStringList getJvmPackageNameList() {
            return this.jvmPackageName_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getJvmPackageNameCount() {
            return this.jvmPackageName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public String getJvmPackageName(int i) {
            return (String) this.jvmPackageName_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ByteString getJvmPackageNameBytes(int i) {
            return this.jvmPackageName_.getByteString(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public boolean hasStringTable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.StringTable getStringTable() {
            return this.stringTable_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public boolean hasQualifiedNameTable() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.QualifiedNameTable getQualifiedNameTable() {
            return this.qualifiedNameTable_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<ProtoBuf.Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public List<? extends ProtoBuf.AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.Annotation getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        public ProtoBuf.AnnotationOrBuilder getAnnotationOrBuilder(int i) {
            return this.annotation_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<ProtoBuf.Class> getOptionalAnnotationClassList() {
            return this.optionalAnnotationClass_;
        }

        public List<? extends ProtoBuf.ClassOrBuilder> getOptionalAnnotationClassOrBuilderList() {
            return this.optionalAnnotationClass_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getOptionalAnnotationClassCount() {
            return this.optionalAnnotationClass_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.Class getOptionalAnnotationClass(int i) {
            return this.optionalAnnotationClass_.get(i);
        }

        public ProtoBuf.ClassOrBuilder getOptionalAnnotationClassOrBuilder(int i) {
            return this.optionalAnnotationClass_.get(i);
        }

        private void initFields() {
            this.packageParts_ = Collections.emptyList();
            this.metadataParts_ = Collections.emptyList();
            this.jvmPackageName_ = LazyStringArrayList.EMPTY;
            this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
            this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
            this.annotation_ = Collections.emptyList();
            this.optionalAnnotationClass_ = Collections.emptyList();
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
            for (int i = 0; i < getPackagePartsCount(); i++) {
                if (!getPackageParts(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getMetadataPartsCount(); i2++) {
                if (!getMetadataParts(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasQualifiedNameTable() && !getQualifiedNameTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i3 = 0; i3 < getAnnotationCount(); i3++) {
                if (!getAnnotation(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getOptionalAnnotationClassCount(); i4++) {
                if (!getOptionalAnnotationClass(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.packageParts_.size(); i++) {
                codedOutputStream.writeMessage(1, this.packageParts_.get(i));
            }
            for (int i2 = 0; i2 < this.metadataParts_.size(); i2++) {
                codedOutputStream.writeMessage(2, this.metadataParts_.get(i2));
            }
            for (int i3 = 0; i3 < this.jvmPackageName_.size(); i3++) {
                codedOutputStream.writeBytes(3, this.jvmPackageName_.getByteString(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(4, this.stringTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(5, this.qualifiedNameTable_);
            }
            for (int i4 = 0; i4 < this.annotation_.size(); i4++) {
                codedOutputStream.writeMessage(6, this.annotation_.get(i4));
            }
            for (int i5 = 0; i5 < this.optionalAnnotationClass_.size(); i5++) {
                codedOutputStream.writeMessage(16, this.optionalAnnotationClass_.get(i5));
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
            for (int i3 = 0; i3 < this.packageParts_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.packageParts_.get(i3));
            }
            for (int i4 = 0; i4 < this.metadataParts_.size(); i4++) {
                i2 += CodedOutputStream.computeMessageSize(2, this.metadataParts_.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.jvmPackageName_.size(); i6++) {
                i5 += CodedOutputStream.computeBytesSizeNoTag(this.jvmPackageName_.getByteString(i6));
            }
            int size = i2 + i5 + getJvmPackageNameList().size();
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeMessageSize(4, this.stringTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(5, this.qualifiedNameTable_);
            }
            for (int i7 = 0; i7 < this.annotation_.size(); i7++) {
                size += CodedOutputStream.computeMessageSize(6, this.annotation_.get(i7));
            }
            for (int i8 = 0; i8 < this.optionalAnnotationClass_.size(); i8++) {
                size += CodedOutputStream.computeMessageSize(16, this.optionalAnnotationClass_.get(i8));
            }
            int size2 = size + this.unknownFields.size();
            this.memoizedSerializedSize = size2;
            return size2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Module parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Module parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Module parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Module parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Module parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Module parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Module parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Module parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Module parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Module parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$100();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Module module) {
            return newBuilder().mergeFrom(module);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Module, Builder> implements ModuleOrBuilder {
            private int bitField0_;
            private List<PackageParts> packageParts_ = Collections.emptyList();
            private List<PackageParts> metadataParts_ = Collections.emptyList();
            private LazyStringList jvmPackageName_ = LazyStringArrayList.EMPTY;
            private ProtoBuf.StringTable stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
            private ProtoBuf.QualifiedNameTable qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
            private List<ProtoBuf.Annotation> annotation_ = Collections.emptyList();
            private List<ProtoBuf.Class> optionalAnnotationClass_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$100() {
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
                this.packageParts_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.metadataParts_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.jvmPackageName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
                this.bitField0_ &= -9;
                this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= -17;
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.optionalAnnotationClass_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Module getDefaultInstanceForType() {
                return Module.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Module build() {
                Module buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Module buildPartial() {
                Module module = new Module(this);
                int i = this.bitField0_;
                if ((i & 1) == 1) {
                    this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                    this.bitField0_ &= -2;
                }
                module.packageParts_ = this.packageParts_;
                if ((this.bitField0_ & 2) == 2) {
                    this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
                    this.bitField0_ &= -3;
                }
                module.metadataParts_ = this.metadataParts_;
                if ((this.bitField0_ & 4) == 4) {
                    this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
                    this.bitField0_ &= -5;
                }
                module.jvmPackageName_ = this.jvmPackageName_;
                int i2 = (i & 8) != 8 ? 0 : 1;
                module.stringTable_ = this.stringTable_;
                if ((i & 16) == 16) {
                    i2 |= 2;
                }
                module.qualifiedNameTable_ = this.qualifiedNameTable_;
                if ((this.bitField0_ & 32) == 32) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -33;
                }
                module.annotation_ = this.annotation_;
                if ((this.bitField0_ & 64) == 64) {
                    this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
                    this.bitField0_ &= -65;
                }
                module.optionalAnnotationClass_ = this.optionalAnnotationClass_;
                module.bitField0_ = i2;
                return module;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Module module) {
                if (module == Module.getDefaultInstance()) {
                    return this;
                }
                if (!module.packageParts_.isEmpty()) {
                    if (this.packageParts_.isEmpty()) {
                        this.packageParts_ = module.packageParts_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePackagePartsIsMutable();
                        this.packageParts_.addAll(module.packageParts_);
                    }
                }
                if (!module.metadataParts_.isEmpty()) {
                    if (this.metadataParts_.isEmpty()) {
                        this.metadataParts_ = module.metadataParts_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureMetadataPartsIsMutable();
                        this.metadataParts_.addAll(module.metadataParts_);
                    }
                }
                if (!module.jvmPackageName_.isEmpty()) {
                    if (this.jvmPackageName_.isEmpty()) {
                        this.jvmPackageName_ = module.jvmPackageName_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureJvmPackageNameIsMutable();
                        this.jvmPackageName_.addAll(module.jvmPackageName_);
                    }
                }
                if (module.hasStringTable()) {
                    mergeStringTable(module.getStringTable());
                }
                if (module.hasQualifiedNameTable()) {
                    mergeQualifiedNameTable(module.getQualifiedNameTable());
                }
                if (!module.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = module.annotation_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureAnnotationIsMutable();
                        this.annotation_.addAll(module.annotation_);
                    }
                }
                if (!module.optionalAnnotationClass_.isEmpty()) {
                    if (this.optionalAnnotationClass_.isEmpty()) {
                        this.optionalAnnotationClass_ = module.optionalAnnotationClass_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureOptionalAnnotationClassIsMutable();
                        this.optionalAnnotationClass_.addAll(module.optionalAnnotationClass_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(module.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getPackagePartsCount(); i++) {
                    if (!getPackageParts(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getMetadataPartsCount(); i2++) {
                    if (!getMetadataParts(i2).isInitialized()) {
                        return false;
                    }
                }
                if (!hasQualifiedNameTable() || getQualifiedNameTable().isInitialized()) {
                    for (int i3 = 0; i3 < getAnnotationCount(); i3++) {
                        if (!getAnnotation(i3).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i4 = 0; i4 < getOptionalAnnotationClassCount(); i4++) {
                        if (!getOptionalAnnotationClass(i4).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Module module = null;
                try {
                    try {
                        Module parsePartialFrom = Module.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Module module2 = (Module) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            module = module2;
                            if (module != null) {
                                mergeFrom(module);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (module != null) {
                    }
                    throw th;
                }
            }

            private void ensurePackagePartsIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.packageParts_ = new ArrayList(this.packageParts_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<PackageParts> getPackagePartsList() {
                return Collections.unmodifiableList(this.packageParts_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getPackagePartsCount() {
                return this.packageParts_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public PackageParts getPackageParts(int i) {
                return this.packageParts_.get(i);
            }

            public Builder setPackageParts(int i, PackageParts packageParts) {
                packageParts.getClass();
                ensurePackagePartsIsMutable();
                this.packageParts_.set(i, packageParts);
                return this;
            }

            public Builder setPackageParts(int i, PackageParts.Builder builder) {
                ensurePackagePartsIsMutable();
                this.packageParts_.set(i, builder.build());
                return this;
            }

            public Builder addPackageParts(PackageParts packageParts) {
                packageParts.getClass();
                ensurePackagePartsIsMutable();
                this.packageParts_.add(packageParts);
                return this;
            }

            public Builder addPackageParts(int i, PackageParts packageParts) {
                packageParts.getClass();
                ensurePackagePartsIsMutable();
                this.packageParts_.add(i, packageParts);
                return this;
            }

            public Builder addPackageParts(PackageParts.Builder builder) {
                ensurePackagePartsIsMutable();
                this.packageParts_.add(builder.build());
                return this;
            }

            public Builder addPackageParts(int i, PackageParts.Builder builder) {
                ensurePackagePartsIsMutable();
                this.packageParts_.add(i, builder.build());
                return this;
            }

            public Builder addAllPackageParts(Iterable<? extends PackageParts> iterable) {
                ensurePackagePartsIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.packageParts_);
                return this;
            }

            public Builder clearPackageParts() {
                this.packageParts_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removePackageParts(int i) {
                ensurePackagePartsIsMutable();
                this.packageParts_.remove(i);
                return this;
            }

            private void ensureMetadataPartsIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.metadataParts_ = new ArrayList(this.metadataParts_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<PackageParts> getMetadataPartsList() {
                return Collections.unmodifiableList(this.metadataParts_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getMetadataPartsCount() {
                return this.metadataParts_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public PackageParts getMetadataParts(int i) {
                return this.metadataParts_.get(i);
            }

            public Builder setMetadataParts(int i, PackageParts packageParts) {
                packageParts.getClass();
                ensureMetadataPartsIsMutable();
                this.metadataParts_.set(i, packageParts);
                return this;
            }

            public Builder setMetadataParts(int i, PackageParts.Builder builder) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.set(i, builder.build());
                return this;
            }

            public Builder addMetadataParts(PackageParts packageParts) {
                packageParts.getClass();
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(packageParts);
                return this;
            }

            public Builder addMetadataParts(int i, PackageParts packageParts) {
                packageParts.getClass();
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(i, packageParts);
                return this;
            }

            public Builder addMetadataParts(PackageParts.Builder builder) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(builder.build());
                return this;
            }

            public Builder addMetadataParts(int i, PackageParts.Builder builder) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(i, builder.build());
                return this;
            }

            public Builder addAllMetadataParts(Iterable<? extends PackageParts> iterable) {
                ensureMetadataPartsIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.metadataParts_);
                return this;
            }

            public Builder clearMetadataParts() {
                this.metadataParts_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeMetadataParts(int i) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.remove(i);
                return this;
            }

            private void ensureJvmPackageNameIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.jvmPackageName_ = new LazyStringArrayList(this.jvmPackageName_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtocolStringList getJvmPackageNameList() {
                return this.jvmPackageName_.getUnmodifiableView();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getJvmPackageNameCount() {
                return this.jvmPackageName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public String getJvmPackageName(int i) {
                return (String) this.jvmPackageName_.get(i);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ByteString getJvmPackageNameBytes(int i) {
                return this.jvmPackageName_.getByteString(i);
            }

            public Builder setJvmPackageName(int i, String str) {
                str.getClass();
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.set(i, str);
                return this;
            }

            public Builder addJvmPackageName(String str) {
                str.getClass();
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.add(str);
                return this;
            }

            public Builder addAllJvmPackageName(Iterable<String> iterable) {
                ensureJvmPackageNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.jvmPackageName_);
                return this;
            }

            public Builder clearJvmPackageName() {
                this.jvmPackageName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                return this;
            }

            public Builder addJvmPackageNameBytes(ByteString byteString) {
                byteString.getClass();
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.add(byteString);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public boolean hasStringTable() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.StringTable getStringTable() {
                return this.stringTable_;
            }

            public Builder setStringTable(ProtoBuf.StringTable stringTable) {
                stringTable.getClass();
                this.stringTable_ = stringTable;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setStringTable(ProtoBuf.StringTable.Builder builder) {
                this.stringTable_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeStringTable(ProtoBuf.StringTable stringTable) {
                if ((this.bitField0_ & 8) == 8 && this.stringTable_ != ProtoBuf.StringTable.getDefaultInstance()) {
                    this.stringTable_ = ProtoBuf.StringTable.newBuilder(this.stringTable_).mergeFrom(stringTable).buildPartial();
                } else {
                    this.stringTable_ = stringTable;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearStringTable() {
                this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public boolean hasQualifiedNameTable() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.QualifiedNameTable getQualifiedNameTable() {
                return this.qualifiedNameTable_;
            }

            public Builder setQualifiedNameTable(ProtoBuf.QualifiedNameTable qualifiedNameTable) {
                qualifiedNameTable.getClass();
                this.qualifiedNameTable_ = qualifiedNameTable;
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setQualifiedNameTable(ProtoBuf.QualifiedNameTable.Builder builder) {
                this.qualifiedNameTable_ = builder.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeQualifiedNameTable(ProtoBuf.QualifiedNameTable qualifiedNameTable) {
                if ((this.bitField0_ & 16) == 16 && this.qualifiedNameTable_ != ProtoBuf.QualifiedNameTable.getDefaultInstance()) {
                    this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.newBuilder(this.qualifiedNameTable_).mergeFrom(qualifiedNameTable).buildPartial();
                } else {
                    this.qualifiedNameTable_ = qualifiedNameTable;
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder clearQualifiedNameTable() {
                this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<ProtoBuf.Annotation> getAnnotationList() {
                return Collections.unmodifiableList(this.annotation_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.Annotation getAnnotation(int i) {
                return this.annotation_.get(i);
            }

            public Builder setAnnotation(int i, ProtoBuf.Annotation annotation) {
                annotation.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.set(i, annotation);
                return this;
            }

            public Builder setAnnotation(int i, ProtoBuf.Annotation.Builder builder) {
                ensureAnnotationIsMutable();
                this.annotation_.set(i, builder.build());
                return this;
            }

            public Builder addAnnotation(ProtoBuf.Annotation annotation) {
                annotation.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.add(annotation);
                return this;
            }

            public Builder addAnnotation(int i, ProtoBuf.Annotation annotation) {
                annotation.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.add(i, annotation);
                return this;
            }

            public Builder addAnnotation(ProtoBuf.Annotation.Builder builder) {
                ensureAnnotationIsMutable();
                this.annotation_.add(builder.build());
                return this;
            }

            public Builder addAnnotation(int i, ProtoBuf.Annotation.Builder builder) {
                ensureAnnotationIsMutable();
                this.annotation_.add(i, builder.build());
                return this;
            }

            public Builder addAllAnnotation(Iterable<? extends ProtoBuf.Annotation> iterable) {
                ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.annotation_);
                return this;
            }

            public Builder clearAnnotation() {
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder removeAnnotation(int i) {
                ensureAnnotationIsMutable();
                this.annotation_.remove(i);
                return this;
            }

            private void ensureOptionalAnnotationClassIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.optionalAnnotationClass_ = new ArrayList(this.optionalAnnotationClass_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<ProtoBuf.Class> getOptionalAnnotationClassList() {
                return Collections.unmodifiableList(this.optionalAnnotationClass_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getOptionalAnnotationClassCount() {
                return this.optionalAnnotationClass_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.Class getOptionalAnnotationClass(int i) {
                return this.optionalAnnotationClass_.get(i);
            }

            public Builder setOptionalAnnotationClass(int i, ProtoBuf.Class r3) {
                r3.getClass();
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.set(i, r3);
                return this;
            }

            public Builder setOptionalAnnotationClass(int i, ProtoBuf.Class.Builder builder) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.set(i, builder.build());
                return this;
            }

            public Builder addOptionalAnnotationClass(ProtoBuf.Class r2) {
                r2.getClass();
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(r2);
                return this;
            }

            public Builder addOptionalAnnotationClass(int i, ProtoBuf.Class r3) {
                r3.getClass();
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(i, r3);
                return this;
            }

            public Builder addOptionalAnnotationClass(ProtoBuf.Class.Builder builder) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(builder.build());
                return this;
            }

            public Builder addOptionalAnnotationClass(int i, ProtoBuf.Class.Builder builder) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(i, builder.build());
                return this;
            }

            public Builder addAllOptionalAnnotationClass(Iterable<? extends ProtoBuf.Class> iterable) {
                ensureOptionalAnnotationClassIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.optionalAnnotationClass_);
                return this;
            }

            public Builder clearOptionalAnnotationClass() {
                this.optionalAnnotationClass_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder removeOptionalAnnotationClass(int i) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class PackageParts extends GeneratedMessageLite implements PackagePartsOrBuilder {
        public static final int CLASS_WITH_JVM_PACKAGE_NAME_MULTIFILE_FACADE_SHORT_NAME_ID_FIELD_NUMBER = 7;
        public static final int CLASS_WITH_JVM_PACKAGE_NAME_PACKAGE_ID_FIELD_NUMBER = 6;
        public static final int CLASS_WITH_JVM_PACKAGE_NAME_SHORT_NAME_FIELD_NUMBER = 5;
        public static final int MULTIFILE_FACADE_SHORT_NAME_FIELD_NUMBER = 4;
        public static final int MULTIFILE_FACADE_SHORT_NAME_ID_FIELD_NUMBER = 3;
        public static final int PACKAGE_FQ_NAME_FIELD_NUMBER = 1;
        public static Parser<PackageParts> PARSER = new AbstractParser<PackageParts>() { // from class: kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackageParts.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public PackageParts parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageParts(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SHORT_CLASS_NAME_FIELD_NUMBER = 2;
        private static final PackageParts defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize;
        private List<Integer> classWithJvmPackageNameMultifileFacadeShortNameId_;
        private int classWithJvmPackageNamePackageIdMemoizedSerializedSize;
        private List<Integer> classWithJvmPackageNamePackageId_;
        private LazyStringList classWithJvmPackageNameShortName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multifileFacadeShortNameIdMemoizedSerializedSize;
        private List<Integer> multifileFacadeShortNameId_;
        private LazyStringList multifileFacadeShortName_;
        private Object packageFqName_;
        private LazyStringList shortClassName_;
        private final ByteString unknownFields;

        private PackageParts(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PackageParts(boolean z) {
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageParts getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public PackageParts getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
        private PackageParts(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r7 = 16;
                if (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    ByteString readBytes = codedInputStream.readBytes();
                                    this.bitField0_ |= 1;
                                    this.packageFqName_ = readBytes;
                                    break;
                                case 18:
                                    ByteString readBytes2 = codedInputStream.readBytes();
                                    if (!(z2 & true)) {
                                        this.shortClassName_ = new LazyStringArrayList();
                                        z2 |= true;
                                    }
                                    this.shortClassName_.add(readBytes2);
                                    break;
                                case 24:
                                    if (!(z2 & true)) {
                                        this.multifileFacadeShortNameId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.multifileFacadeShortNameId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    break;
                                case 26:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multifileFacadeShortNameId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multifileFacadeShortNameId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    break;
                                case 34:
                                    ByteString readBytes3 = codedInputStream.readBytes();
                                    if (!(z2 & true)) {
                                        this.multifileFacadeShortName_ = new LazyStringArrayList();
                                        z2 |= true;
                                    }
                                    this.multifileFacadeShortName_.add(readBytes3);
                                    break;
                                case 42:
                                    ByteString readBytes4 = codedInputStream.readBytes();
                                    if (!(z2 & true)) {
                                        this.classWithJvmPackageNameShortName_ = new LazyStringArrayList();
                                        z2 |= true;
                                    }
                                    this.classWithJvmPackageNameShortName_.add(readBytes4);
                                    break;
                                case 48:
                                    if (!(z2 & true)) {
                                        this.classWithJvmPackageNamePackageId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    break;
                                case 50:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.classWithJvmPackageNamePackageId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                    break;
                                case 56:
                                    if (!(z2 & true)) {
                                        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    break;
                                case 58:
                                    int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit3);
                                    break;
                                default:
                                    r7 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                    if (r7 != 0) {
                                        break;
                                    } else {
                                        z = true;
                                        break;
                                    }
                            }
                        } catch (Throwable th) {
                            if (z2 & true) {
                                this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
                            }
                            if (z2 & true) {
                                this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
                            }
                            if (z2 & true) {
                                this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
                            }
                            if ((z2 & true) == r7) {
                                this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
                            }
                            if (z2 & true) {
                                this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
                            }
                            if (z2 & true) {
                                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
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
                } else {
                    if (z2 & true) {
                        this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
                    }
                    if (z2 & true) {
                        this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
                    }
                    if (z2 & true) {
                        this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
                    }
                    if (z2 & true) {
                        this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
                    }
                    if (z2 & true) {
                        this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
                    }
                    if (z2 & true) {
                        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
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
                    return;
                }
            }
        }

        static {
            PackageParts packageParts = new PackageParts(true);
            defaultInstance = packageParts;
            packageParts.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<PackageParts> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public boolean hasPackageFqName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getPackageFqName() {
            Object obj = this.packageFqName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.packageFqName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getPackageFqNameBytes() {
            Object obj = this.packageFqName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.packageFqName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ProtocolStringList getShortClassNameList() {
            return this.shortClassName_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getShortClassNameCount() {
            return this.shortClassName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getShortClassName(int i) {
            return (String) this.shortClassName_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getShortClassNameBytes(int i) {
            return this.shortClassName_.getByteString(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public List<Integer> getMultifileFacadeShortNameIdList() {
            return this.multifileFacadeShortNameId_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getMultifileFacadeShortNameIdCount() {
            return this.multifileFacadeShortNameId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getMultifileFacadeShortNameId(int i) {
            return this.multifileFacadeShortNameId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ProtocolStringList getMultifileFacadeShortNameList() {
            return this.multifileFacadeShortName_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getMultifileFacadeShortNameCount() {
            return this.multifileFacadeShortName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getMultifileFacadeShortName(int i) {
            return (String) this.multifileFacadeShortName_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getMultifileFacadeShortNameBytes(int i) {
            return this.multifileFacadeShortName_.getByteString(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ProtocolStringList getClassWithJvmPackageNameShortNameList() {
            return this.classWithJvmPackageNameShortName_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNameShortNameCount() {
            return this.classWithJvmPackageNameShortName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getClassWithJvmPackageNameShortName(int i) {
            return (String) this.classWithJvmPackageNameShortName_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getClassWithJvmPackageNameShortNameBytes(int i) {
            return this.classWithJvmPackageNameShortName_.getByteString(i);
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList() {
            return this.classWithJvmPackageNameMultifileFacadeShortNameId_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount() {
            return this.classWithJvmPackageNameMultifileFacadeShortNameId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNameMultifileFacadeShortNameId(int i) {
            return this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public List<Integer> getClassWithJvmPackageNamePackageIdList() {
            return this.classWithJvmPackageNamePackageId_;
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNamePackageIdCount() {
            return this.classWithJvmPackageNamePackageId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNamePackageId(int i) {
            return this.classWithJvmPackageNamePackageId_.get(i).intValue();
        }

        private void initFields() {
            this.packageFqName_ = "";
            this.shortClassName_ = LazyStringArrayList.EMPTY;
            this.multifileFacadeShortNameId_ = Collections.emptyList();
            this.multifileFacadeShortName_ = LazyStringArrayList.EMPTY;
            this.classWithJvmPackageNameShortName_ = LazyStringArrayList.EMPTY;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
            this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
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
            if (!hasPackageFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getPackageFqNameBytes());
            }
            for (int i = 0; i < this.shortClassName_.size(); i++) {
                codedOutputStream.writeBytes(2, this.shortClassName_.getByteString(i));
            }
            if (getMultifileFacadeShortNameIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(26);
                codedOutputStream.writeRawVarint32(this.multifileFacadeShortNameIdMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.multifileFacadeShortNameId_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.multifileFacadeShortNameId_.get(i2).intValue());
            }
            for (int i3 = 0; i3 < this.multifileFacadeShortName_.size(); i3++) {
                codedOutputStream.writeBytes(4, this.multifileFacadeShortName_.getByteString(i3));
            }
            for (int i4 = 0; i4 < this.classWithJvmPackageNameShortName_.size(); i4++) {
                codedOutputStream.writeBytes(5, this.classWithJvmPackageNameShortName_.getByteString(i4));
            }
            if (getClassWithJvmPackageNamePackageIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(50);
                codedOutputStream.writeRawVarint32(this.classWithJvmPackageNamePackageIdMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.classWithJvmPackageNamePackageId_.size(); i5++) {
                codedOutputStream.writeInt32NoTag(this.classWithJvmPackageNamePackageId_.get(i5).intValue());
            }
            if (getClassWithJvmPackageNameMultifileFacadeShortNameIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(58);
                codedOutputStream.writeRawVarint32(this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.classWithJvmPackageNameMultifileFacadeShortNameId_.size(); i6++) {
                codedOutputStream.writeInt32NoTag(this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(i6).intValue());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBytesSize(1, getPackageFqNameBytes()) : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.shortClassName_.size(); i3++) {
                i2 += CodedOutputStream.computeBytesSizeNoTag(this.shortClassName_.getByteString(i3));
            }
            int size = computeBytesSize + i2 + getShortClassNameList().size();
            int i4 = 0;
            for (int i5 = 0; i5 < this.multifileFacadeShortNameId_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.multifileFacadeShortNameId_.get(i5).intValue());
            }
            int i6 = size + i4;
            if (!getMultifileFacadeShortNameIdList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.multifileFacadeShortNameIdMemoizedSerializedSize = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < this.multifileFacadeShortName_.size(); i8++) {
                i7 += CodedOutputStream.computeBytesSizeNoTag(this.multifileFacadeShortName_.getByteString(i8));
            }
            int size2 = i6 + i7 + getMultifileFacadeShortNameList().size();
            int i9 = 0;
            for (int i10 = 0; i10 < this.classWithJvmPackageNameShortName_.size(); i10++) {
                i9 += CodedOutputStream.computeBytesSizeNoTag(this.classWithJvmPackageNameShortName_.getByteString(i10));
            }
            int size3 = size2 + i9 + getClassWithJvmPackageNameShortNameList().size();
            int i11 = 0;
            for (int i12 = 0; i12 < this.classWithJvmPackageNamePackageId_.size(); i12++) {
                i11 += CodedOutputStream.computeInt32SizeNoTag(this.classWithJvmPackageNamePackageId_.get(i12).intValue());
            }
            int i13 = size3 + i11;
            if (!getClassWithJvmPackageNamePackageIdList().isEmpty()) {
                i13 = i13 + 1 + CodedOutputStream.computeInt32SizeNoTag(i11);
            }
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = i11;
            int i14 = 0;
            for (int i15 = 0; i15 < this.classWithJvmPackageNameMultifileFacadeShortNameId_.size(); i15++) {
                i14 += CodedOutputStream.computeInt32SizeNoTag(this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(i15).intValue());
            }
            int i16 = i13 + i14;
            if (!getClassWithJvmPackageNameMultifileFacadeShortNameIdList().isEmpty()) {
                i16 = i16 + 1 + CodedOutputStream.computeInt32SizeNoTag(i14);
            }
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = i14;
            int size4 = i16 + this.unknownFields.size();
            this.memoizedSerializedSize = size4;
            return size4;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PackageParts parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PackageParts parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PackageParts parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PackageParts parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PackageParts parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static PackageParts parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PackageParts parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PackageParts parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PackageParts parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PackageParts parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$1300();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PackageParts packageParts) {
            return newBuilder().mergeFrom(packageParts);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<PackageParts, Builder> implements PackagePartsOrBuilder {
            private int bitField0_;
            private Object packageFqName_ = "";
            private LazyStringList shortClassName_ = LazyStringArrayList.EMPTY;
            private List<Integer> multifileFacadeShortNameId_ = Collections.emptyList();
            private LazyStringList multifileFacadeShortName_ = LazyStringArrayList.EMPTY;
            private LazyStringList classWithJvmPackageNameShortName_ = LazyStringArrayList.EMPTY;
            private List<Integer> classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
            private List<Integer> classWithJvmPackageNamePackageId_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$1300() {
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
                this.packageFqName_ = "";
                this.bitField0_ &= -2;
                this.shortClassName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -3;
                this.multifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.multifileFacadeShortName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -9;
                this.classWithJvmPackageNameShortName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -17;
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public PackageParts getDefaultInstanceForType() {
                return PackageParts.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public PackageParts build() {
                PackageParts buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public PackageParts buildPartial() {
                PackageParts packageParts = new PackageParts(this);
                int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
                packageParts.packageFqName_ = this.packageFqName_;
                if ((this.bitField0_ & 2) == 2) {
                    this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
                    this.bitField0_ &= -3;
                }
                packageParts.shortClassName_ = this.shortClassName_;
                if ((this.bitField0_ & 4) == 4) {
                    this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
                    this.bitField0_ &= -5;
                }
                packageParts.multifileFacadeShortNameId_ = this.multifileFacadeShortNameId_;
                if ((this.bitField0_ & 8) == 8) {
                    this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
                    this.bitField0_ &= -9;
                }
                packageParts.multifileFacadeShortName_ = this.multifileFacadeShortName_;
                if ((this.bitField0_ & 16) == 16) {
                    this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
                    this.bitField0_ &= -17;
                }
                packageParts.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_;
                if ((this.bitField0_ & 32) == 32) {
                    this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                    this.bitField0_ &= -33;
                }
                packageParts.classWithJvmPackageNameMultifileFacadeShortNameId_ = this.classWithJvmPackageNameMultifileFacadeShortNameId_;
                if ((this.bitField0_ & 64) == 64) {
                    this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
                    this.bitField0_ &= -65;
                }
                packageParts.classWithJvmPackageNamePackageId_ = this.classWithJvmPackageNamePackageId_;
                packageParts.bitField0_ = i;
                return packageParts;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(PackageParts packageParts) {
                if (packageParts == PackageParts.getDefaultInstance()) {
                    return this;
                }
                if (packageParts.hasPackageFqName()) {
                    this.bitField0_ |= 1;
                    this.packageFqName_ = packageParts.packageFqName_;
                }
                if (!packageParts.shortClassName_.isEmpty()) {
                    if (this.shortClassName_.isEmpty()) {
                        this.shortClassName_ = packageParts.shortClassName_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureShortClassNameIsMutable();
                        this.shortClassName_.addAll(packageParts.shortClassName_);
                    }
                }
                if (!packageParts.multifileFacadeShortNameId_.isEmpty()) {
                    if (this.multifileFacadeShortNameId_.isEmpty()) {
                        this.multifileFacadeShortNameId_ = packageParts.multifileFacadeShortNameId_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureMultifileFacadeShortNameIdIsMutable();
                        this.multifileFacadeShortNameId_.addAll(packageParts.multifileFacadeShortNameId_);
                    }
                }
                if (!packageParts.multifileFacadeShortName_.isEmpty()) {
                    if (this.multifileFacadeShortName_.isEmpty()) {
                        this.multifileFacadeShortName_ = packageParts.multifileFacadeShortName_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureMultifileFacadeShortNameIsMutable();
                        this.multifileFacadeShortName_.addAll(packageParts.multifileFacadeShortName_);
                    }
                }
                if (!packageParts.classWithJvmPackageNameShortName_.isEmpty()) {
                    if (this.classWithJvmPackageNameShortName_.isEmpty()) {
                        this.classWithJvmPackageNameShortName_ = packageParts.classWithJvmPackageNameShortName_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureClassWithJvmPackageNameShortNameIsMutable();
                        this.classWithJvmPackageNameShortName_.addAll(packageParts.classWithJvmPackageNameShortName_);
                    }
                }
                if (!packageParts.classWithJvmPackageNameMultifileFacadeShortNameId_.isEmpty()) {
                    if (this.classWithJvmPackageNameMultifileFacadeShortNameId_.isEmpty()) {
                        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = packageParts.classWithJvmPackageNameMultifileFacadeShortNameId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                        this.classWithJvmPackageNameMultifileFacadeShortNameId_.addAll(packageParts.classWithJvmPackageNameMultifileFacadeShortNameId_);
                    }
                }
                if (!packageParts.classWithJvmPackageNamePackageId_.isEmpty()) {
                    if (this.classWithJvmPackageNamePackageId_.isEmpty()) {
                        this.classWithJvmPackageNamePackageId_ = packageParts.classWithJvmPackageNamePackageId_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureClassWithJvmPackageNamePackageIdIsMutable();
                        this.classWithJvmPackageNamePackageId_.addAll(packageParts.classWithJvmPackageNamePackageId_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(packageParts.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasPackageFqName();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageParts packageParts = null;
                try {
                    try {
                        PackageParts parsePartialFrom = PackageParts.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        PackageParts packageParts2 = (PackageParts) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            packageParts = packageParts2;
                            if (packageParts != null) {
                                mergeFrom(packageParts);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (packageParts != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public boolean hasPackageFqName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getPackageFqName() {
                Object obj = this.packageFqName_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.packageFqName_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getPackageFqNameBytes() {
                Object obj = this.packageFqName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.packageFqName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setPackageFqName(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.packageFqName_ = str;
                return this;
            }

            public Builder clearPackageFqName() {
                this.bitField0_ &= -2;
                this.packageFqName_ = PackageParts.getDefaultInstance().getPackageFqName();
                return this;
            }

            public Builder setPackageFqNameBytes(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 1;
                this.packageFqName_ = byteString;
                return this;
            }

            private void ensureShortClassNameIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.shortClassName_ = new LazyStringArrayList(this.shortClassName_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ProtocolStringList getShortClassNameList() {
                return this.shortClassName_.getUnmodifiableView();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getShortClassNameCount() {
                return this.shortClassName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getShortClassName(int i) {
                return (String) this.shortClassName_.get(i);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getShortClassNameBytes(int i) {
                return this.shortClassName_.getByteString(i);
            }

            public Builder setShortClassName(int i, String str) {
                str.getClass();
                ensureShortClassNameIsMutable();
                this.shortClassName_.set(i, str);
                return this;
            }

            public Builder addShortClassName(String str) {
                str.getClass();
                ensureShortClassNameIsMutable();
                this.shortClassName_.add(str);
                return this;
            }

            public Builder addAllShortClassName(Iterable<String> iterable) {
                ensureShortClassNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.shortClassName_);
                return this;
            }

            public Builder clearShortClassName() {
                this.shortClassName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -3;
                return this;
            }

            public Builder addShortClassNameBytes(ByteString byteString) {
                byteString.getClass();
                ensureShortClassNameIsMutable();
                this.shortClassName_.add(byteString);
                return this;
            }

            private void ensureMultifileFacadeShortNameIdIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.multifileFacadeShortNameId_ = new ArrayList(this.multifileFacadeShortNameId_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public List<Integer> getMultifileFacadeShortNameIdList() {
                return Collections.unmodifiableList(this.multifileFacadeShortNameId_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getMultifileFacadeShortNameIdCount() {
                return this.multifileFacadeShortNameId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getMultifileFacadeShortNameId(int i) {
                return this.multifileFacadeShortNameId_.get(i).intValue();
            }

            public Builder setMultifileFacadeShortNameId(int i, int i2) {
                ensureMultifileFacadeShortNameIdIsMutable();
                this.multifileFacadeShortNameId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addMultifileFacadeShortNameId(int i) {
                ensureMultifileFacadeShortNameIdIsMutable();
                this.multifileFacadeShortNameId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllMultifileFacadeShortNameId(Iterable<? extends Integer> iterable) {
                ensureMultifileFacadeShortNameIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.multifileFacadeShortNameId_);
                return this;
            }

            public Builder clearMultifileFacadeShortNameId() {
                this.multifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            private void ensureMultifileFacadeShortNameIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.multifileFacadeShortName_ = new LazyStringArrayList(this.multifileFacadeShortName_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ProtocolStringList getMultifileFacadeShortNameList() {
                return this.multifileFacadeShortName_.getUnmodifiableView();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getMultifileFacadeShortNameCount() {
                return this.multifileFacadeShortName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getMultifileFacadeShortName(int i) {
                return (String) this.multifileFacadeShortName_.get(i);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getMultifileFacadeShortNameBytes(int i) {
                return this.multifileFacadeShortName_.getByteString(i);
            }

            public Builder setMultifileFacadeShortName(int i, String str) {
                str.getClass();
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.set(i, str);
                return this;
            }

            public Builder addMultifileFacadeShortName(String str) {
                str.getClass();
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.add(str);
                return this;
            }

            public Builder addAllMultifileFacadeShortName(Iterable<String> iterable) {
                ensureMultifileFacadeShortNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.multifileFacadeShortName_);
                return this;
            }

            public Builder clearMultifileFacadeShortName() {
                this.multifileFacadeShortName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -9;
                return this;
            }

            public Builder addMultifileFacadeShortNameBytes(ByteString byteString) {
                byteString.getClass();
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.add(byteString);
                return this;
            }

            private void ensureClassWithJvmPackageNameShortNameIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.classWithJvmPackageNameShortName_ = new LazyStringArrayList(this.classWithJvmPackageNameShortName_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ProtocolStringList getClassWithJvmPackageNameShortNameList() {
                return this.classWithJvmPackageNameShortName_.getUnmodifiableView();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNameShortNameCount() {
                return this.classWithJvmPackageNameShortName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getClassWithJvmPackageNameShortName(int i) {
                return (String) this.classWithJvmPackageNameShortName_.get(i);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getClassWithJvmPackageNameShortNameBytes(int i) {
                return this.classWithJvmPackageNameShortName_.getByteString(i);
            }

            public Builder setClassWithJvmPackageNameShortName(int i, String str) {
                str.getClass();
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.set(i, str);
                return this;
            }

            public Builder addClassWithJvmPackageNameShortName(String str) {
                str.getClass();
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.add(str);
                return this;
            }

            public Builder addAllClassWithJvmPackageNameShortName(Iterable<String> iterable) {
                ensureClassWithJvmPackageNameShortNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.classWithJvmPackageNameShortName_);
                return this;
            }

            public Builder clearClassWithJvmPackageNameShortName() {
                this.classWithJvmPackageNameShortName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -17;
                return this;
            }

            public Builder addClassWithJvmPackageNameShortNameBytes(ByteString byteString) {
                byteString.getClass();
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.add(byteString);
                return this;
            }

            private void ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList() {
                return Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount() {
                return this.classWithJvmPackageNameMultifileFacadeShortNameId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNameMultifileFacadeShortNameId(int i) {
                return this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(i).intValue();
            }

            public Builder setClassWithJvmPackageNameMultifileFacadeShortNameId(int i, int i2) {
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                this.classWithJvmPackageNameMultifileFacadeShortNameId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addClassWithJvmPackageNameMultifileFacadeShortNameId(int i) {
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllClassWithJvmPackageNameMultifileFacadeShortNameId(Iterable<? extends Integer> iterable) {
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                return this;
            }

            public Builder clearClassWithJvmPackageNameMultifileFacadeShortNameId() {
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            private void ensureClassWithJvmPackageNamePackageIdIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.classWithJvmPackageNamePackageId_ = new ArrayList(this.classWithJvmPackageNamePackageId_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public List<Integer> getClassWithJvmPackageNamePackageIdList() {
                return Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNamePackageIdCount() {
                return this.classWithJvmPackageNamePackageId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNamePackageId(int i) {
                return this.classWithJvmPackageNamePackageId_.get(i).intValue();
            }

            public Builder setClassWithJvmPackageNamePackageId(int i, int i2) {
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                this.classWithJvmPackageNamePackageId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addClassWithJvmPackageNamePackageId(int i) {
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllClassWithJvmPackageNamePackageId(Iterable<? extends Integer> iterable) {
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.classWithJvmPackageNamePackageId_);
                return this;
            }

            public Builder clearClassWithJvmPackageNamePackageId() {
                this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }
        }
    }
}
