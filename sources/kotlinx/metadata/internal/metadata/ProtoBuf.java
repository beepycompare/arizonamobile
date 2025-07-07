package kotlinx.metadata.internal.metadata;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import kotlinx.metadata.internal.protobuf.AbstractMessageLite;
import kotlinx.metadata.internal.protobuf.AbstractParser;
import kotlinx.metadata.internal.protobuf.ByteString;
import kotlinx.metadata.internal.protobuf.CodedInputStream;
import kotlinx.metadata.internal.protobuf.CodedOutputStream;
import kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.Internal;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.LazyStringArrayList;
import kotlinx.metadata.internal.protobuf.LazyStringList;
import kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder;
import kotlinx.metadata.internal.protobuf.Parser;
import kotlinx.metadata.internal.protobuf.ProtocolStringList;
/* loaded from: classes5.dex */
public final class ProtoBuf {

    /* loaded from: classes5.dex */
    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
        Annotation.Argument getArgument(int i);

        int getArgumentCount();

        List<Annotation.Argument> getArgumentList();

        int getId();

        boolean hasId();
    }

    /* loaded from: classes5.dex */
    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Class> {
        int getCompanionObjectName();

        Constructor getConstructor(int i);

        int getConstructorCount();

        List<Constructor> getConstructorList();

        Type getContextReceiverType(int i);

        int getContextReceiverTypeCount();

        int getContextReceiverTypeId(int i);

        int getContextReceiverTypeIdCount();

        List<Integer> getContextReceiverTypeIdList();

        List<Type> getContextReceiverTypeList();

        EnumEntry getEnumEntry(int i);

        int getEnumEntryCount();

        List<EnumEntry> getEnumEntryList();

        int getFlags();

        int getFqName();

        Function getFunction(int i);

        int getFunctionCount();

        List<Function> getFunctionList();

        int getInlineClassUnderlyingPropertyName();

        Type getInlineClassUnderlyingType();

        int getInlineClassUnderlyingTypeId();

        int getMultiFieldValueClassUnderlyingName(int i);

        int getMultiFieldValueClassUnderlyingNameCount();

        List<Integer> getMultiFieldValueClassUnderlyingNameList();

        Type getMultiFieldValueClassUnderlyingType(int i);

        int getMultiFieldValueClassUnderlyingTypeCount();

        int getMultiFieldValueClassUnderlyingTypeId(int i);

        int getMultiFieldValueClassUnderlyingTypeIdCount();

        List<Integer> getMultiFieldValueClassUnderlyingTypeIdList();

        List<Type> getMultiFieldValueClassUnderlyingTypeList();

        int getNestedClassName(int i);

        int getNestedClassNameCount();

        List<Integer> getNestedClassNameList();

        Property getProperty(int i);

        int getPropertyCount();

        List<Property> getPropertyList();

        int getSealedSubclassFqName(int i);

        int getSealedSubclassFqNameCount();

        List<Integer> getSealedSubclassFqNameList();

        Type getSupertype(int i);

        int getSupertypeCount();

        int getSupertypeId(int i);

        int getSupertypeIdCount();

        List<Integer> getSupertypeIdList();

        List<Type> getSupertypeList();

        TypeAlias getTypeAlias(int i);

        int getTypeAliasCount();

        List<TypeAlias> getTypeAliasList();

        TypeParameter getTypeParameter(int i);

        int getTypeParameterCount();

        List<TypeParameter> getTypeParameterList();

        TypeTable getTypeTable();

        int getVersionRequirement(int i);

        int getVersionRequirementCount();

        List<Integer> getVersionRequirementList();

        VersionRequirementTable getVersionRequirementTable();

        boolean hasCompanionObjectName();

        boolean hasFlags();

        boolean hasFqName();

        boolean hasInlineClassUnderlyingPropertyName();

        boolean hasInlineClassUnderlyingType();

        boolean hasInlineClassUnderlyingTypeId();

        boolean hasTypeTable();

        boolean hasVersionRequirementTable();
    }

    /* loaded from: classes5.dex */
    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Constructor> {
        int getFlags();

        ValueParameter getValueParameter(int i);

        int getValueParameterCount();

        List<ValueParameter> getValueParameterList();

        int getVersionRequirement(int i);

        int getVersionRequirementCount();

        List<Integer> getVersionRequirementList();

        boolean hasFlags();
    }

    /* loaded from: classes5.dex */
    public interface ContractOrBuilder extends MessageLiteOrBuilder {
        Effect getEffect(int i);

        int getEffectCount();

        List<Effect> getEffectList();
    }

    /* loaded from: classes5.dex */
    public interface EffectOrBuilder extends MessageLiteOrBuilder {
        Expression getConclusionOfConditionalEffect();

        Expression getEffectConstructorArgument(int i);

        int getEffectConstructorArgumentCount();

        List<Expression> getEffectConstructorArgumentList();

        Effect.EffectType getEffectType();

        Effect.InvocationKind getKind();

        boolean hasConclusionOfConditionalEffect();

        boolean hasEffectType();

        boolean hasKind();
    }

    /* loaded from: classes5.dex */
    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumEntry> {
        int getName();

        boolean hasName();
    }

    /* loaded from: classes5.dex */
    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
        Expression getAndArgument(int i);

        int getAndArgumentCount();

        List<Expression> getAndArgumentList();

        Expression.ConstantValue getConstantValue();

        int getFlags();

        Type getIsInstanceType();

        int getIsInstanceTypeId();

        Expression getOrArgument(int i);

        int getOrArgumentCount();

        List<Expression> getOrArgumentList();

        int getValueParameterReference();

        boolean hasConstantValue();

        boolean hasFlags();

        boolean hasIsInstanceType();

        boolean hasIsInstanceTypeId();

        boolean hasValueParameterReference();
    }

    /* loaded from: classes5.dex */
    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Function> {
        Type getContextReceiverType(int i);

        int getContextReceiverTypeCount();

        int getContextReceiverTypeId(int i);

        int getContextReceiverTypeIdCount();

        List<Integer> getContextReceiverTypeIdList();

        List<Type> getContextReceiverTypeList();

        Contract getContract();

        int getFlags();

        int getName();

        int getOldFlags();

        Type getReceiverType();

        int getReceiverTypeId();

        Type getReturnType();

        int getReturnTypeId();

        TypeParameter getTypeParameter(int i);

        int getTypeParameterCount();

        List<TypeParameter> getTypeParameterList();

        TypeTable getTypeTable();

        ValueParameter getValueParameter(int i);

        int getValueParameterCount();

        List<ValueParameter> getValueParameterList();

        int getVersionRequirement(int i);

        int getVersionRequirementCount();

        List<Integer> getVersionRequirementList();

        boolean hasContract();

        boolean hasFlags();

        boolean hasName();

        boolean hasOldFlags();

        boolean hasReceiverType();

        boolean hasReceiverTypeId();

        boolean hasReturnType();

        boolean hasReturnTypeId();

        boolean hasTypeTable();
    }

    /* loaded from: classes5.dex */
    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<PackageFragment> {
        Class getClass_(int i);

        int getClass_Count();

        List<Class> getClass_List();

        Package getPackage();

        QualifiedNameTable getQualifiedNames();

        StringTable getStrings();

        boolean hasPackage();

        boolean hasQualifiedNames();

        boolean hasStrings();
    }

    /* loaded from: classes5.dex */
    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Package> {
        Function getFunction(int i);

        int getFunctionCount();

        List<Function> getFunctionList();

        Property getProperty(int i);

        int getPropertyCount();

        List<Property> getPropertyList();

        TypeAlias getTypeAlias(int i);

        int getTypeAliasCount();

        List<TypeAlias> getTypeAliasList();

        TypeTable getTypeTable();

        VersionRequirementTable getVersionRequirementTable();

        boolean hasTypeTable();

        boolean hasVersionRequirementTable();
    }

    /* loaded from: classes5.dex */
    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Property> {
        Type getContextReceiverType(int i);

        int getContextReceiverTypeCount();

        int getContextReceiverTypeId(int i);

        int getContextReceiverTypeIdCount();

        List<Integer> getContextReceiverTypeIdList();

        List<Type> getContextReceiverTypeList();

        int getFlags();

        int getGetterFlags();

        int getName();

        int getOldFlags();

        Type getReceiverType();

        int getReceiverTypeId();

        Type getReturnType();

        int getReturnTypeId();

        int getSetterFlags();

        ValueParameter getSetterValueParameter();

        TypeParameter getTypeParameter(int i);

        int getTypeParameterCount();

        List<TypeParameter> getTypeParameterList();

        int getVersionRequirement(int i);

        int getVersionRequirementCount();

        List<Integer> getVersionRequirementList();

        boolean hasFlags();

        boolean hasGetterFlags();

        boolean hasName();

        boolean hasOldFlags();

        boolean hasReceiverType();

        boolean hasReceiverTypeId();

        boolean hasReturnType();

        boolean hasReturnTypeId();

        boolean hasSetterFlags();

        boolean hasSetterValueParameter();
    }

    /* loaded from: classes5.dex */
    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
        QualifiedNameTable.QualifiedName getQualifiedName(int i);

        int getQualifiedNameCount();

        List<QualifiedNameTable.QualifiedName> getQualifiedNameList();
    }

    /* loaded from: classes5.dex */
    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
        String getString(int i);

        ByteString getStringBytes(int i);

        int getStringCount();

        ProtocolStringList getStringList();
    }

    /* loaded from: classes5.dex */
    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<TypeAlias> {
        Annotation getAnnotation(int i);

        int getAnnotationCount();

        List<Annotation> getAnnotationList();

        Type getExpandedType();

        int getExpandedTypeId();

        int getFlags();

        int getName();

        TypeParameter getTypeParameter(int i);

        int getTypeParameterCount();

        List<TypeParameter> getTypeParameterList();

        Type getUnderlyingType();

        int getUnderlyingTypeId();

        int getVersionRequirement(int i);

        int getVersionRequirementCount();

        List<Integer> getVersionRequirementList();

        boolean hasExpandedType();

        boolean hasExpandedTypeId();

        boolean hasFlags();

        boolean hasName();

        boolean hasUnderlyingType();

        boolean hasUnderlyingTypeId();
    }

    /* loaded from: classes5.dex */
    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Type> {
        Type getAbbreviatedType();

        int getAbbreviatedTypeId();

        Type.Argument getArgument(int i);

        int getArgumentCount();

        List<Type.Argument> getArgumentList();

        int getClassName();

        int getFlags();

        int getFlexibleTypeCapabilitiesId();

        Type getFlexibleUpperBound();

        int getFlexibleUpperBoundId();

        boolean getNullable();

        Type getOuterType();

        int getOuterTypeId();

        int getTypeAliasName();

        int getTypeParameter();

        int getTypeParameterName();

        boolean hasAbbreviatedType();

        boolean hasAbbreviatedTypeId();

        boolean hasClassName();

        boolean hasFlags();

        boolean hasFlexibleTypeCapabilitiesId();

        boolean hasFlexibleUpperBound();

        boolean hasFlexibleUpperBoundId();

        boolean hasNullable();

        boolean hasOuterType();

        boolean hasOuterTypeId();

        boolean hasTypeAliasName();

        boolean hasTypeParameter();

        boolean hasTypeParameterName();
    }

    /* loaded from: classes5.dex */
    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<TypeParameter> {
        int getId();

        int getName();

        boolean getReified();

        Type getUpperBound(int i);

        int getUpperBoundCount();

        int getUpperBoundId(int i);

        int getUpperBoundIdCount();

        List<Integer> getUpperBoundIdList();

        List<Type> getUpperBoundList();

        TypeParameter.Variance getVariance();

        boolean hasId();

        boolean hasName();

        boolean hasReified();

        boolean hasVariance();
    }

    /* loaded from: classes5.dex */
    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
        int getFirstNullable();

        Type getType(int i);

        int getTypeCount();

        List<Type> getTypeList();

        boolean hasFirstNullable();
    }

    /* loaded from: classes5.dex */
    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ValueParameter> {
        int getFlags();

        int getName();

        Type getType();

        int getTypeId();

        Type getVarargElementType();

        int getVarargElementTypeId();

        boolean hasFlags();

        boolean hasName();

        boolean hasType();

        boolean hasTypeId();

        boolean hasVarargElementType();

        boolean hasVarargElementTypeId();
    }

    /* loaded from: classes5.dex */
    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
        int getErrorCode();

        VersionRequirement.Level getLevel();

        int getMessage();

        int getVersion();

        int getVersionFull();

        VersionRequirement.VersionKind getVersionKind();

        boolean hasErrorCode();

        boolean hasLevel();

        boolean hasMessage();

        boolean hasVersion();

        boolean hasVersionFull();

        boolean hasVersionKind();
    }

    /* loaded from: classes5.dex */
    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
        VersionRequirement getRequirement(int i);

        int getRequirementCount();

        List<VersionRequirement> getRequirementList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ProtoBuf() {
    }

    /* loaded from: classes5.dex */
    public enum Modality implements Internal.EnumLite {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);
        
        public static final int ABSTRACT_VALUE = 2;
        public static final int FINAL_VALUE = 0;
        public static final int OPEN_VALUE = 1;
        public static final int SEALED_VALUE = 3;
        private static Internal.EnumLiteMap<Modality> internalValueMap = new Internal.EnumLiteMap<Modality>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Modality.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
            public Modality findValueByNumber(int i) {
                return Modality.valueOf(i);
            }
        };
        private final int value;

        @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return SEALED;
                    }
                    return ABSTRACT;
                }
                return OPEN;
            }
            return FINAL;
        }

        public static Internal.EnumLiteMap<Modality> internalGetValueMap() {
            return internalValueMap;
        }

        Modality(int i, int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes5.dex */
    public enum Visibility implements Internal.EnumLite {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);
        
        public static final int INTERNAL_VALUE = 0;
        public static final int LOCAL_VALUE = 5;
        public static final int PRIVATE_TO_THIS_VALUE = 4;
        public static final int PRIVATE_VALUE = 1;
        public static final int PROTECTED_VALUE = 2;
        public static final int PUBLIC_VALUE = 3;
        private static Internal.EnumLiteMap<Visibility> internalValueMap = new Internal.EnumLiteMap<Visibility>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Visibility.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
            public Visibility findValueByNumber(int i) {
                return Visibility.valueOf(i);
            }
        };
        private final int value;

        @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return LOCAL;
                            }
                            return PRIVATE_TO_THIS;
                        }
                        return PUBLIC;
                    }
                    return PROTECTED;
                }
                return PRIVATE;
            }
            return INTERNAL;
        }

        public static Internal.EnumLiteMap<Visibility> internalGetValueMap() {
            return internalValueMap;
        }

        Visibility(int i, int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes5.dex */
    public enum MemberKind implements Internal.EnumLite {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);
        
        public static final int DECLARATION_VALUE = 0;
        public static final int DELEGATION_VALUE = 2;
        public static final int FAKE_OVERRIDE_VALUE = 1;
        public static final int SYNTHESIZED_VALUE = 3;
        private static Internal.EnumLiteMap<MemberKind> internalValueMap = new Internal.EnumLiteMap<MemberKind>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.MemberKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
            public MemberKind findValueByNumber(int i) {
                return MemberKind.valueOf(i);
            }
        };
        private final int value;

        @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return SYNTHESIZED;
                    }
                    return DELEGATION;
                }
                return FAKE_OVERRIDE;
            }
            return DECLARATION;
        }

        public static Internal.EnumLiteMap<MemberKind> internalGetValueMap() {
            return internalValueMap;
        }

        MemberKind(int i, int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes5.dex */
    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER = new AbstractParser<StringTable>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.StringTable.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public StringTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTable(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int STRING_FIELD_NUMBER = 1;
        private static final StringTable defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private LazyStringList string_;
        private final ByteString unknownFields;

        private StringTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        private StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                ByteString readBytes = codedInputStream.readBytes();
                                if (!z2) {
                                    this.string_ = new LazyStringArrayList();
                                    z2 = true;
                                }
                                this.string_.add(readBytes);
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        if (z2) {
                            this.string_ = this.string_.getUnmodifiableView();
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
            if (z2) {
                this.string_ = this.string_.getUnmodifiableView();
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
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
        public ProtocolStringList getStringList() {
            return this.string_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
        public int getStringCount() {
            return this.string_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
        public String getString(int i) {
            return (String) this.string_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
        public ByteString getStringBytes(int i) {
            return this.string_.getByteString(i);
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
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
            for (int i = 0; i < this.string_.size(); i++) {
                codedOutputStream.writeBytes(1, this.string_.getByteString(i));
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
            for (int i3 = 0; i3 < this.string_.size(); i3++) {
                i2 += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i3));
            }
            int size = i2 + getStringList().size() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static StringTable parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static StringTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static StringTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static StringTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static StringTable parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static StringTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static StringTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static StringTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static StringTable parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static StringTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$100();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StringTable stringTable) {
            return newBuilder().mergeFrom(stringTable);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_ = LazyStringArrayList.EMPTY;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
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
                this.string_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public StringTable build() {
                StringTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public StringTable buildPartial() {
                StringTable stringTable = new StringTable(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                stringTable.string_ = this.string_;
                return stringTable;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = stringTable.string_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureStringIsMutable();
                        this.string_.addAll(stringTable.string_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTable stringTable = null;
                try {
                    try {
                        StringTable parsePartialFrom = StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        StringTable stringTable2 = (StringTable) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            stringTable = stringTable2;
                            if (stringTable != null) {
                                mergeFrom(stringTable);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (stringTable != null) {
                    }
                    throw th;
                }
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new LazyStringArrayList(this.string_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
            public ProtocolStringList getStringList() {
                return this.string_.getUnmodifiableView();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
            public int getStringCount() {
                return this.string_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
            public String getString(int i) {
                return (String) this.string_.get(i);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.StringTableOrBuilder
            public ByteString getStringBytes(int i) {
                return this.string_.getByteString(i);
            }

            public Builder setString(int i, String str) {
                str.getClass();
                ensureStringIsMutable();
                this.string_.set(i, str);
                return this;
            }

            public Builder addString(String str) {
                str.getClass();
                ensureStringIsMutable();
                this.string_.add(str);
                return this;
            }

            public Builder addAllString(Iterable<String> iterable) {
                ensureStringIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.string_);
                return this;
            }

            public Builder clearString() {
                this.string_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                return this;
            }

            public Builder addStringBytes(ByteString byteString) {
                byteString.getClass();
                ensureStringIsMutable();
                this.string_.add(byteString);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER = new AbstractParser<QualifiedNameTable>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public QualifiedNameTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int QUALIFIED_NAME_FIELD_NUMBER = 1;
        private static final QualifiedNameTable defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final ByteString unknownFields;

        /* loaded from: classes5.dex */
        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
            QualifiedName.Kind getKind();

            int getParentQualifiedName();

            int getShortName();

            boolean hasKind();

            boolean hasParentQualifiedName();

            boolean hasShortName();
        }

        private QualifiedNameTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QualifiedNameTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!z2) {
                                        this.qualifiedName_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.qualifiedName_.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
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
                    if (z2) {
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            if (z2) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static final int KIND_FIELD_NUMBER = 3;
            public static final int PARENT_QUALIFIED_NAME_FIELD_NUMBER = 1;
            public static Parser<QualifiedName> PARSER = new AbstractParser<QualifiedName>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.1
                @Override // kotlinx.metadata.internal.protobuf.Parser
                public QualifiedName parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new QualifiedName(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int SHORT_NAME_FIELD_NUMBER = 2;
            private static final QualifiedName defaultInstance;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final ByteString unknownFields;

            private QualifiedName(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private QualifiedName(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            private QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.parentQualifiedName_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = codedInputStream.readInt32();
                                } else if (readTag != 24) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int readEnum = codedInputStream.readEnum();
                                    Kind valueOf = Kind.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = valueOf;
                                    }
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
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            /* loaded from: classes5.dex */
            public enum Kind implements Internal.EnumLite {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);
                
                public static final int CLASS_VALUE = 0;
                public static final int LOCAL_VALUE = 2;
                public static final int PACKAGE_VALUE = 1;
                private static Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                    public Kind findValueByNumber(int i) {
                        return Kind.valueOf(i);
                    }
                };
                private final int value;

                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                return null;
                            }
                            return LOCAL;
                        }
                        return PACKAGE;
                    }
                    return CLASS;
                }

                public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
                    return internalValueMap;
                }

                Kind(int i, int i2) {
                    this.value = i2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
            public boolean hasShortName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
            public int getShortName() {
                return this.shortName_;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
            public Kind getKind() {
                return this.kind_;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
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
                if (!hasShortName()) {
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
                    codedOutputStream.writeInt32(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeEnum(3, this.kind_.getNumber());
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
                }
                int size = computeInt32Size + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static QualifiedName parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static QualifiedName parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static QualifiedName parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static QualifiedName parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static QualifiedName parseFrom(InputStream inputStream) throws IOException {
                return PARSER.parseFrom(inputStream);
            }

            public static QualifiedName parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(inputStream, extensionRegistryLite);
            }

            public static QualifiedName parseDelimitedFrom(InputStream inputStream) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream);
            }

            public static QualifiedName parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public static QualifiedName parseFrom(CodedInputStream codedInputStream) throws IOException {
                return PARSER.parseFrom(codedInputStream);
            }

            public static QualifiedName parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return Builder.access$700();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(QualifiedName qualifiedName) {
                return newBuilder().mergeFrom(qualifiedName);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private int shortName_;
                private int parentQualifiedName_ = -1;
                private Kind kind_ = Kind.PACKAGE;

                private void maybeForceBuilderInitialization() {
                }

                static /* synthetic */ Builder access$700() {
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
                    this.parentQualifiedName_ = -1;
                    int i = this.bitField0_;
                    this.shortName_ = 0;
                    this.bitField0_ = i & (-4);
                    this.kind_ = Kind.PACKAGE;
                    this.bitField0_ &= -5;
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public QualifiedName buildPartial() {
                    QualifiedName qualifiedName = new QualifiedName(this);
                    int i = this.bitField0_;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    qualifiedName.shortName_ = this.shortName_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    qualifiedName.kind_ = this.kind_;
                    qualifiedName.bitField0_ = i2;
                    return qualifiedName;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        setParentQualifiedName(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        setShortName(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        setKind(qualifiedName.getKind());
                    }
                    setUnknownFields(getUnknownFields().concat(qualifiedName.unknownFields));
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return hasShortName();
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    QualifiedName qualifiedName = null;
                    try {
                        try {
                            QualifiedName parsePartialFrom = QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            QualifiedName qualifiedName2 = (QualifiedName) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                qualifiedName = qualifiedName2;
                                if (qualifiedName != null) {
                                    mergeFrom(qualifiedName);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (qualifiedName != null) {
                        }
                        throw th;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
                public boolean hasParentQualifiedName() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
                public int getParentQualifiedName() {
                    return this.parentQualifiedName_;
                }

                public Builder setParentQualifiedName(int i) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = i;
                    return this;
                }

                public Builder clearParentQualifiedName() {
                    this.bitField0_ &= -2;
                    this.parentQualifiedName_ = -1;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
                public boolean hasShortName() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
                public int getShortName() {
                    return this.shortName_;
                }

                public Builder setShortName(int i) {
                    this.bitField0_ |= 2;
                    this.shortName_ = i;
                    return this;
                }

                public Builder clearShortName() {
                    this.bitField0_ &= -3;
                    this.shortName_ = 0;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
                public boolean hasKind() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
                public Kind getKind() {
                    return this.kind_;
                }

                public Builder setKind(Kind kind) {
                    kind.getClass();
                    this.bitField0_ |= 4;
                    this.kind_ = kind;
                    return this;
                }

                public Builder clearKind() {
                    this.bitField0_ &= -5;
                    this.kind_ = Kind.PACKAGE;
                    return this;
                }
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTableOrBuilder
        public List<QualifiedName> getQualifiedNameList() {
            return this.qualifiedName_;
        }

        public List<? extends QualifiedNameOrBuilder> getQualifiedNameOrBuilderList() {
            return this.qualifiedName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTableOrBuilder
        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTableOrBuilder
        public QualifiedName getQualifiedName(int i) {
            return this.qualifiedName_.get(i);
        }

        public QualifiedNameOrBuilder getQualifiedNameOrBuilder(int i) {
            return this.qualifiedName_.get(i);
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
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
            for (int i = 0; i < getQualifiedNameCount(); i++) {
                if (!getQualifiedName(i).isInitialized()) {
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
            for (int i = 0; i < this.qualifiedName_.size(); i++) {
                codedOutputStream.writeMessage(1, this.qualifiedName_.get(i));
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
            for (int i3 = 0; i3 < this.qualifiedName_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i3));
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static QualifiedNameTable parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static QualifiedNameTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static QualifiedNameTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static QualifiedNameTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static QualifiedNameTable parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static QualifiedNameTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static QualifiedNameTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static QualifiedNameTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static QualifiedNameTable parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static QualifiedNameTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$1400();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().mergeFrom(qualifiedNameTable);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$1400() {
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
                this.qualifiedName_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public QualifiedNameTable build() {
                QualifiedNameTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public QualifiedNameTable buildPartial() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= -2;
                }
                qualifiedNameTable.qualifiedName_ = this.qualifiedName_;
                return qualifiedNameTable;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = qualifiedNameTable.qualifiedName_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureQualifiedNameIsMutable();
                        this.qualifiedName_.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(qualifiedNameTable.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getQualifiedNameCount(); i++) {
                    if (!getQualifiedName(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                QualifiedNameTable qualifiedNameTable = null;
                try {
                    try {
                        QualifiedNameTable parsePartialFrom = QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        QualifiedNameTable qualifiedNameTable2 = (QualifiedNameTable) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            qualifiedNameTable = qualifiedNameTable2;
                            if (qualifiedNameTable != null) {
                                mergeFrom(qualifiedNameTable);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (qualifiedNameTable != null) {
                    }
                    throw th;
                }
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTableOrBuilder
            public List<QualifiedName> getQualifiedNameList() {
                return Collections.unmodifiableList(this.qualifiedName_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTableOrBuilder
            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.QualifiedNameTableOrBuilder
            public QualifiedName getQualifiedName(int i) {
                return this.qualifiedName_.get(i);
            }

            public Builder setQualifiedName(int i, QualifiedName qualifiedName) {
                qualifiedName.getClass();
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.set(i, qualifiedName);
                return this;
            }

            public Builder setQualifiedName(int i, QualifiedName.Builder builder) {
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.set(i, builder.build());
                return this;
            }

            public Builder addQualifiedName(QualifiedName qualifiedName) {
                qualifiedName.getClass();
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(qualifiedName);
                return this;
            }

            public Builder addQualifiedName(int i, QualifiedName qualifiedName) {
                qualifiedName.getClass();
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(i, qualifiedName);
                return this;
            }

            public Builder addQualifiedName(QualifiedName.Builder builder) {
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(builder.build());
                return this;
            }

            public Builder addQualifiedName(int i, QualifiedName.Builder builder) {
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(i, builder.build());
                return this;
            }

            public Builder addAllQualifiedName(Iterable<? extends QualifiedName> iterable) {
                ensureQualifiedNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.qualifiedName_);
                return this;
            }

            public Builder clearQualifiedName() {
                this.qualifiedName_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeQualifiedName(int i) {
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static final int ARGUMENT_FIELD_NUMBER = 2;
        public static final int ID_FIELD_NUMBER = 1;
        public static Parser<Annotation> PARSER = new AbstractParser<Annotation>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Annotation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Annotation(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Annotation defaultInstance;
        private static final long serialVersionUID = 0;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        /* loaded from: classes5.dex */
        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
            int getNameId();

            Argument.Value getValue();

            boolean hasNameId();

            boolean hasValue();
        }

        private Annotation(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Annotation(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.id_ = codedInputStream.readInt32();
                                } else if (readTag != 18) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.argument_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
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
                    if (z2 & true) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static final int NAME_ID_FIELD_NUMBER = 1;
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.1
                @Override // kotlinx.metadata.internal.protobuf.Parser
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int VALUE_FIELD_NUMBER = 2;
            private static final Argument defaultInstance;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final ByteString unknownFields;
            private Value value_;

            /* loaded from: classes5.dex */
            public interface ValueOrBuilder extends MessageLiteOrBuilder {
                Annotation getAnnotation();

                int getArrayDimensionCount();

                Value getArrayElement(int i);

                int getArrayElementCount();

                List<Value> getArrayElementList();

                int getClassId();

                double getDoubleValue();

                int getEnumValueId();

                int getFlags();

                float getFloatValue();

                long getIntValue();

                int getStringValue();

                Value.Type getType();

                boolean hasAnnotation();

                boolean hasArrayDimensionCount();

                boolean hasClassId();

                boolean hasDoubleValue();

                boolean hasEnumValueId();

                boolean hasFlags();

                boolean hasFloatValue();

                boolean hasIntValue();

                boolean hasStringValue();

                boolean hasType();
            }

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (readTag == 8) {
                                        this.bitField0_ |= 1;
                                        this.nameId_ = codedInputStream.readInt32();
                                    } else if (readTag != 18) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                        Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                        this.value_ = value;
                                        if (builder != null) {
                                            builder.mergeFrom(value);
                                            this.value_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
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
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            /* loaded from: classes5.dex */
            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static final int ANNOTATION_FIELD_NUMBER = 8;
                public static final int ARRAY_DIMENSION_COUNT_FIELD_NUMBER = 11;
                public static final int ARRAY_ELEMENT_FIELD_NUMBER = 9;
                public static final int CLASS_ID_FIELD_NUMBER = 6;
                public static final int DOUBLE_VALUE_FIELD_NUMBER = 4;
                public static final int ENUM_VALUE_ID_FIELD_NUMBER = 7;
                public static final int FLAGS_FIELD_NUMBER = 10;
                public static final int FLOAT_VALUE_FIELD_NUMBER = 3;
                public static final int INT_VALUE_FIELD_NUMBER = 2;
                public static Parser<Value> PARSER = new AbstractParser<Value>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.Value.1
                    @Override // kotlinx.metadata.internal.protobuf.Parser
                    public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Value(codedInputStream, extensionRegistryLite);
                    }
                };
                public static final int STRING_VALUE_FIELD_NUMBER = 5;
                public static final int TYPE_FIELD_NUMBER = 1;
                private static final Value defaultInstance;
                private static final long serialVersionUID = 0;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final ByteString unknownFields;

                private Value(GeneratedMessageLite.Builder builder) {
                    super(builder);
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = builder.getUnknownFields();
                }

                private Value(boolean z) {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r5v0 */
                /* JADX WARN: Type inference failed for: r5v1 */
                /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
                private Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output newOutput = ByteString.newOutput();
                    CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        ?? r5 = 256;
                        if (!z) {
                            try {
                                try {
                                    int readTag = codedInputStream.readTag();
                                    switch (readTag) {
                                        case 0:
                                            break;
                                        case 8:
                                            int readEnum = codedInputStream.readEnum();
                                            Type valueOf = Type.valueOf(readEnum);
                                            if (valueOf == null) {
                                                newInstance.writeRawVarint32(readTag);
                                                newInstance.writeRawVarint32(readEnum);
                                            } else {
                                                this.bitField0_ |= 1;
                                                this.type_ = valueOf;
                                                continue;
                                            }
                                        case 16:
                                            this.bitField0_ |= 2;
                                            this.intValue_ = codedInputStream.readSInt64();
                                            continue;
                                        case 29:
                                            this.bitField0_ |= 4;
                                            this.floatValue_ = codedInputStream.readFloat();
                                            continue;
                                        case 33:
                                            this.bitField0_ |= 8;
                                            this.doubleValue_ = codedInputStream.readDouble();
                                            continue;
                                        case 40:
                                            this.bitField0_ |= 16;
                                            this.stringValue_ = codedInputStream.readInt32();
                                            continue;
                                        case 48:
                                            this.bitField0_ |= 32;
                                            this.classId_ = codedInputStream.readInt32();
                                            continue;
                                        case 56:
                                            this.bitField0_ |= 64;
                                            this.enumValueId_ = codedInputStream.readInt32();
                                            continue;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                            Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                            Annotation annotation = (Annotation) codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite);
                                            this.annotation_ = annotation;
                                            if (builder != null) {
                                                builder.mergeFrom(annotation);
                                                this.annotation_ = builder.buildPartial();
                                            }
                                            this.bitField0_ |= 128;
                                            continue;
                                        case 74:
                                            if (!(z2 & true)) {
                                                this.arrayElement_ = new ArrayList();
                                                z2 = true;
                                            }
                                            this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                            continue;
                                        case 80:
                                            this.bitField0_ |= 512;
                                            this.flags_ = codedInputStream.readInt32();
                                            continue;
                                        case 88:
                                            this.bitField0_ |= 256;
                                            this.arrayDimensionCount_ = codedInputStream.readInt32();
                                            continue;
                                        default:
                                            r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                            if (r5 == 0) {
                                                break;
                                            } else {
                                                continue;
                                            }
                                    }
                                    z = true;
                                } catch (Throwable th) {
                                    if ((z2 & true) == r5) {
                                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                /* loaded from: classes5.dex */
                public enum Type implements Internal.EnumLite {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);
                    
                    public static final int ANNOTATION_VALUE = 11;
                    public static final int ARRAY_VALUE = 12;
                    public static final int BOOLEAN_VALUE = 7;
                    public static final int BYTE_VALUE = 0;
                    public static final int CHAR_VALUE = 1;
                    public static final int CLASS_VALUE = 9;
                    public static final int DOUBLE_VALUE = 6;
                    public static final int ENUM_VALUE = 10;
                    public static final int FLOAT_VALUE = 5;
                    public static final int INT_VALUE = 3;
                    public static final int LONG_VALUE = 4;
                    public static final int SHORT_VALUE = 2;
                    public static final int STRING_VALUE = 8;
                    private static Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.Value.Type.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                        public Type findValueByNumber(int i) {
                            return Type.valueOf(i);
                        }
                    };
                    private final int value;

                    @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i) {
                        switch (i) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }

                    public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                        return internalValueMap;
                    }

                    Type(int i, int i2) {
                        this.value = i2;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasType() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public Type getType() {
                    return this.type_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public float getFloatValue() {
                    return this.floatValue_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public int getStringValue() {
                    return this.stringValue_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public int getClassId() {
                    return this.classId_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public List<? extends ValueOrBuilder> getArrayElementOrBuilderList() {
                    return this.arrayElement_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public Value getArrayElement(int i) {
                    return this.arrayElement_.get(i);
                }

                public ValueOrBuilder getArrayElementOrBuilder(int i) {
                    return this.arrayElement_.get(i);
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                public int getFlags() {
                    return this.flags_;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
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
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                    for (int i = 0; i < getArrayElementCount(); i++) {
                        if (!getArrayElement(i).isInitialized()) {
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
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.writeEnum(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.writeSInt64(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.writeFloat(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.writeDouble(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.writeInt32(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.writeInt32(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.writeInt32(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.writeMessage(8, this.annotation_);
                    }
                    for (int i = 0; i < this.arrayElement_.size(); i++) {
                        codedOutputStream.writeMessage(9, this.arrayElement_.get(i));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.writeInt32(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.writeRawBytes(this.unknownFields);
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite
                public int getSerializedSize() {
                    int i = this.memoizedSerializedSize;
                    if (i != -1) {
                        return i;
                    }
                    int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        computeEnumSize += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        computeEnumSize += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        computeEnumSize += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        computeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
                    }
                    for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                        computeEnumSize += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i2));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                    }
                    int size = computeEnumSize + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
                protected Object writeReplace() throws ObjectStreamException {
                    return super.writeReplace();
                }

                public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString);
                }

                public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(byteString, extensionRegistryLite);
                }

                public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr);
                }

                public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(bArr, extensionRegistryLite);
                }

                public static Value parseFrom(InputStream inputStream) throws IOException {
                    return PARSER.parseFrom(inputStream);
                }

                public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return PARSER.parseFrom(inputStream, extensionRegistryLite);
                }

                public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return PARSER.parseDelimitedFrom(inputStream);
                }

                public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
                }

                public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return PARSER.parseFrom(codedInputStream);
                }

                public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
                }

                public static Builder newBuilder() {
                    return Builder.access$2100();
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                public static Builder newBuilder(Value value) {
                    return newBuilder().mergeFrom(value);
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite
                public Builder toBuilder() {
                    return newBuilder(this);
                }

                /* loaded from: classes5.dex */
                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private int arrayDimensionCount_;
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_ = Type.BYTE;
                    private Annotation annotation_ = Annotation.getDefaultInstance();
                    private List<Value> arrayElement_ = Collections.emptyList();

                    private void maybeForceBuilderInitialization() {
                    }

                    static /* synthetic */ Builder access$2100() {
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
                        this.type_ = Type.BYTE;
                        int i = this.bitField0_;
                        this.intValue_ = 0L;
                        this.floatValue_ = 0.0f;
                        this.doubleValue_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        this.stringValue_ = 0;
                        this.classId_ = 0;
                        this.enumValueId_ = 0;
                        this.bitField0_ = i & (-128);
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.bitField0_ &= -129;
                        this.arrayElement_ = Collections.emptyList();
                        int i2 = this.bitField0_;
                        this.arrayDimensionCount_ = 0;
                        this.flags_ = 0;
                        this.bitField0_ = i2 & (-1793);
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                    public Builder clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                    public Value build() {
                        Value buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw newUninitializedMessageException(buildPartial);
                    }

                    @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                    public Value buildPartial() {
                        Value value = new Value(this);
                        int i = this.bitField0_;
                        int i2 = (i & 1) != 1 ? 0 : 1;
                        value.type_ = this.type_;
                        if ((i & 2) == 2) {
                            i2 |= 2;
                        }
                        value.intValue_ = this.intValue_;
                        if ((i & 4) == 4) {
                            i2 |= 4;
                        }
                        value.floatValue_ = this.floatValue_;
                        if ((i & 8) == 8) {
                            i2 |= 8;
                        }
                        value.doubleValue_ = this.doubleValue_;
                        if ((i & 16) == 16) {
                            i2 |= 16;
                        }
                        value.stringValue_ = this.stringValue_;
                        if ((i & 32) == 32) {
                            i2 |= 32;
                        }
                        value.classId_ = this.classId_;
                        if ((i & 64) == 64) {
                            i2 |= 64;
                        }
                        value.enumValueId_ = this.enumValueId_;
                        if ((i & 128) == 128) {
                            i2 |= 128;
                        }
                        value.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= -257;
                        }
                        value.arrayElement_ = this.arrayElement_;
                        if ((i & 512) == 512) {
                            i2 |= 256;
                        }
                        value.arrayDimensionCount_ = this.arrayDimensionCount_;
                        if ((i & 1024) == 1024) {
                            i2 |= 512;
                        }
                        value.flags_ = this.flags_;
                        value.bitField0_ = i2;
                        return value;
                    }

                    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
                    public Builder mergeFrom(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            setType(value.getType());
                        }
                        if (value.hasIntValue()) {
                            setIntValue(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            setFloatValue(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            setDoubleValue(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            setStringValue(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            setClassId(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            setEnumValueId(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            mergeAnnotation(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = value.arrayElement_;
                                this.bitField0_ &= -257;
                            } else {
                                ensureArrayElementIsMutable();
                                this.arrayElement_.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            setArrayDimensionCount(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            setFlags(value.getFlags());
                        }
                        setUnknownFields(getUnknownFields().concat(value.unknownFields));
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        if (!hasAnnotation() || getAnnotation().isInitialized()) {
                            for (int i = 0; i < getArrayElementCount(); i++) {
                                if (!getArrayElement(i).isInitialized()) {
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
                        Value value = null;
                        try {
                            try {
                                Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                                if (parsePartialFrom != null) {
                                    mergeFrom(parsePartialFrom);
                                }
                                return this;
                            } catch (InvalidProtocolBufferException e) {
                                Value value2 = (Value) e.getUnfinishedMessage();
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    value = value2;
                                    if (value != null) {
                                        mergeFrom(value);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (value != null) {
                            }
                            throw th;
                        }
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasType() {
                        return (this.bitField0_ & 1) == 1;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public Type getType() {
                        return this.type_;
                    }

                    public Builder setType(Type type) {
                        type.getClass();
                        this.bitField0_ |= 1;
                        this.type_ = type;
                        return this;
                    }

                    public Builder clearType() {
                        this.bitField0_ &= -2;
                        this.type_ = Type.BYTE;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasIntValue() {
                        return (this.bitField0_ & 2) == 2;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public long getIntValue() {
                        return this.intValue_;
                    }

                    public Builder setIntValue(long j) {
                        this.bitField0_ |= 2;
                        this.intValue_ = j;
                        return this;
                    }

                    public Builder clearIntValue() {
                        this.bitField0_ &= -3;
                        this.intValue_ = 0L;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasFloatValue() {
                        return (this.bitField0_ & 4) == 4;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public float getFloatValue() {
                        return this.floatValue_;
                    }

                    public Builder setFloatValue(float f) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = f;
                        return this;
                    }

                    public Builder clearFloatValue() {
                        this.bitField0_ &= -5;
                        this.floatValue_ = 0.0f;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasDoubleValue() {
                        return (this.bitField0_ & 8) == 8;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public double getDoubleValue() {
                        return this.doubleValue_;
                    }

                    public Builder setDoubleValue(double d) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = d;
                        return this;
                    }

                    public Builder clearDoubleValue() {
                        this.bitField0_ &= -9;
                        this.doubleValue_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasStringValue() {
                        return (this.bitField0_ & 16) == 16;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public int getStringValue() {
                        return this.stringValue_;
                    }

                    public Builder setStringValue(int i) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = i;
                        return this;
                    }

                    public Builder clearStringValue() {
                        this.bitField0_ &= -17;
                        this.stringValue_ = 0;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasClassId() {
                        return (this.bitField0_ & 32) == 32;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public int getClassId() {
                        return this.classId_;
                    }

                    public Builder setClassId(int i) {
                        this.bitField0_ |= 32;
                        this.classId_ = i;
                        return this;
                    }

                    public Builder clearClassId() {
                        this.bitField0_ &= -33;
                        this.classId_ = 0;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasEnumValueId() {
                        return (this.bitField0_ & 64) == 64;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public int getEnumValueId() {
                        return this.enumValueId_;
                    }

                    public Builder setEnumValueId(int i) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = i;
                        return this;
                    }

                    public Builder clearEnumValueId() {
                        this.bitField0_ &= -65;
                        this.enumValueId_ = 0;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasAnnotation() {
                        return (this.bitField0_ & 128) == 128;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Builder setAnnotation(Annotation annotation) {
                        annotation.getClass();
                        this.annotation_ = annotation;
                        this.bitField0_ |= 128;
                        return this;
                    }

                    public Builder setAnnotation(Builder builder) {
                        this.annotation_ = builder.build();
                        this.bitField0_ |= 128;
                        return this;
                    }

                    public Builder mergeAnnotation(Annotation annotation) {
                        if ((this.bitField0_ & 128) == 128 && this.annotation_ != Annotation.getDefaultInstance()) {
                            this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(annotation).buildPartial();
                        } else {
                            this.annotation_ = annotation;
                        }
                        this.bitField0_ |= 128;
                        return this;
                    }

                    public Builder clearAnnotation() {
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.bitField0_ &= -129;
                        return this;
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 256) != 256) {
                            this.arrayElement_ = new ArrayList(this.arrayElement_);
                            this.bitField0_ |= 256;
                        }
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public List<Value> getArrayElementList() {
                        return Collections.unmodifiableList(this.arrayElement_);
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public Value getArrayElement(int i) {
                        return this.arrayElement_.get(i);
                    }

                    public Builder setArrayElement(int i, Value value) {
                        value.getClass();
                        ensureArrayElementIsMutable();
                        this.arrayElement_.set(i, value);
                        return this;
                    }

                    public Builder setArrayElement(int i, Builder builder) {
                        ensureArrayElementIsMutable();
                        this.arrayElement_.set(i, builder.build());
                        return this;
                    }

                    public Builder addArrayElement(Value value) {
                        value.getClass();
                        ensureArrayElementIsMutable();
                        this.arrayElement_.add(value);
                        return this;
                    }

                    public Builder addArrayElement(int i, Value value) {
                        value.getClass();
                        ensureArrayElementIsMutable();
                        this.arrayElement_.add(i, value);
                        return this;
                    }

                    public Builder addArrayElement(Builder builder) {
                        ensureArrayElementIsMutable();
                        this.arrayElement_.add(builder.build());
                        return this;
                    }

                    public Builder addArrayElement(int i, Builder builder) {
                        ensureArrayElementIsMutable();
                        this.arrayElement_.add(i, builder.build());
                        return this;
                    }

                    public Builder addAllArrayElement(Iterable<? extends Value> iterable) {
                        ensureArrayElementIsMutable();
                        AbstractMessageLite.Builder.addAll(iterable, this.arrayElement_);
                        return this;
                    }

                    public Builder clearArrayElement() {
                        this.arrayElement_ = Collections.emptyList();
                        this.bitField0_ &= -257;
                        return this;
                    }

                    public Builder removeArrayElement(int i) {
                        ensureArrayElementIsMutable();
                        this.arrayElement_.remove(i);
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasArrayDimensionCount() {
                        return (this.bitField0_ & 512) == 512;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public int getArrayDimensionCount() {
                        return this.arrayDimensionCount_;
                    }

                    public Builder setArrayDimensionCount(int i) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = i;
                        return this;
                    }

                    public Builder clearArrayDimensionCount() {
                        this.bitField0_ &= -513;
                        this.arrayDimensionCount_ = 0;
                        return this;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public boolean hasFlags() {
                        return (this.bitField0_ & 1024) == 1024;
                    }

                    @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.Argument.ValueOrBuilder
                    public int getFlags() {
                        return this.flags_;
                    }

                    public Builder setFlags(int i) {
                        this.bitField0_ |= 1024;
                        this.flags_ = i;
                        return this;
                    }

                    public Builder clearFlags() {
                        this.bitField0_ &= -1025;
                        this.flags_ = 0;
                        return this;
                    }
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
            public Value getValue() {
                return this.value_;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
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
                if (!hasNameId()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.value_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.nameId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(2, this.value_);
                }
                int size = computeInt32Size + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Argument parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Argument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Argument parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Argument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Argument parseFrom(InputStream inputStream) throws IOException {
                return PARSER.parseFrom(inputStream);
            }

            public static Argument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(inputStream, extensionRegistryLite);
            }

            public static Argument parseDelimitedFrom(InputStream inputStream) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream);
            }

            public static Argument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public static Argument parseFrom(CodedInputStream codedInputStream) throws IOException {
                return PARSER.parseFrom(codedInputStream);
            }

            public static Argument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return Builder.access$3600();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.getDefaultInstance();

                private void maybeForceBuilderInitialization() {
                }

                static /* synthetic */ Builder access$3600() {
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
                    this.nameId_ = 0;
                    this.bitField0_ &= -2;
                    this.value_ = Value.getDefaultInstance();
                    this.bitField0_ &= -3;
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Argument buildPartial() {
                    Argument argument = new Argument(this);
                    int i = this.bitField0_;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    argument.nameId_ = this.nameId_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    argument.value_ = this.value_;
                    argument.bitField0_ = i2;
                    return argument;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        setNameId(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        mergeValue(argument.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return hasNameId() && hasValue() && getValue().isInitialized();
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument = null;
                    try {
                        try {
                            Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Argument argument2 = (Argument) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                argument = argument2;
                                if (argument != null) {
                                    mergeFrom(argument);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (argument != null) {
                        }
                        throw th;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
                public boolean hasNameId() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
                public int getNameId() {
                    return this.nameId_;
                }

                public Builder setNameId(int i) {
                    this.bitField0_ |= 1;
                    this.nameId_ = i;
                    return this;
                }

                public Builder clearNameId() {
                    this.bitField0_ &= -2;
                    this.nameId_ = 0;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
                public boolean hasValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Annotation.ArgumentOrBuilder
                public Value getValue() {
                    return this.value_;
                }

                public Builder setValue(Value value) {
                    value.getClass();
                    this.value_ = value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setValue(Value.Builder builder) {
                    this.value_ = builder.build();
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder mergeValue(Value value) {
                    if ((this.bitField0_ & 2) == 2 && this.value_ != Value.getDefaultInstance()) {
                        this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                    } else {
                        this.value_ = value;
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder clearValue() {
                    this.value_ = Value.getDefaultInstance();
                    this.bitField0_ &= -3;
                    return this;
                }
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public List<? extends ArgumentOrBuilder> getArgumentOrBuilderList() {
            return this.argument_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
        public int getArgumentCount() {
            return this.argument_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
        public Argument getArgument(int i) {
            return this.argument_.get(i);
        }

        public ArgumentOrBuilder getArgumentOrBuilder(int i) {
            return this.argument_.get(i);
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
            for (int i2 = 0; i2 < this.argument_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Annotation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Annotation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Annotation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Annotation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Annotation parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Annotation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Annotation parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Annotation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Annotation parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Annotation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$4200();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Annotation annotation) {
            return newBuilder().mergeFrom(annotation);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int id_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$4200() {
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
                this.id_ = 0;
                this.bitField0_ &= -2;
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Annotation build() {
                Annotation buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Annotation buildPartial() {
                Annotation annotation = new Annotation(this);
                int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
                annotation.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -3;
                }
                annotation.argument_ = this.argument_;
                annotation.bitField0_ = i;
                return annotation;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    setId(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = annotation.argument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(annotation.argument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(annotation.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId()) {
                    for (int i = 0; i < getArgumentCount(); i++) {
                        if (!getArgument(i).isInitialized()) {
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
                Annotation annotation = null;
                try {
                    try {
                        Annotation parsePartialFrom = Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Annotation annotation2 = (Annotation) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            annotation = annotation2;
                            if (annotation != null) {
                                mergeFrom(annotation);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (annotation != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int i) {
                this.bitField0_ |= 1;
                this.id_ = i;
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= -2;
                this.id_ = 0;
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
            public List<Argument> getArgumentList() {
                return Collections.unmodifiableList(this.argument_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.AnnotationOrBuilder
            public Argument getArgument(int i) {
                return this.argument_.get(i);
            }

            public Builder setArgument(int i, Argument argument) {
                argument.getClass();
                ensureArgumentIsMutable();
                this.argument_.set(i, argument);
                return this;
            }

            public Builder setArgument(int i, Argument.Builder builder) {
                ensureArgumentIsMutable();
                this.argument_.set(i, builder.build());
                return this;
            }

            public Builder addArgument(Argument argument) {
                argument.getClass();
                ensureArgumentIsMutable();
                this.argument_.add(argument);
                return this;
            }

            public Builder addArgument(int i, Argument argument) {
                argument.getClass();
                ensureArgumentIsMutable();
                this.argument_.add(i, argument);
                return this;
            }

            public Builder addArgument(Argument.Builder builder) {
                ensureArgumentIsMutable();
                this.argument_.add(builder.build());
                return this;
            }

            public Builder addArgument(int i, Argument.Builder builder) {
                ensureArgumentIsMutable();
                this.argument_.add(i, builder.build());
                return this;
            }

            public Builder addAllArgument(Iterable<? extends Argument> iterable) {
                ensureArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.argument_);
                return this;
            }

            public Builder clearArgument() {
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeArgument(int i) {
                ensureArgumentIsMutable();
                this.argument_.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static final int ABBREVIATED_TYPE_FIELD_NUMBER = 13;
        public static final int ABBREVIATED_TYPE_ID_FIELD_NUMBER = 14;
        public static final int ARGUMENT_FIELD_NUMBER = 2;
        public static final int CLASS_NAME_FIELD_NUMBER = 6;
        public static final int FLAGS_FIELD_NUMBER = 1;
        public static final int FLEXIBLE_TYPE_CAPABILITIES_ID_FIELD_NUMBER = 4;
        public static final int FLEXIBLE_UPPER_BOUND_FIELD_NUMBER = 5;
        public static final int FLEXIBLE_UPPER_BOUND_ID_FIELD_NUMBER = 8;
        public static final int NULLABLE_FIELD_NUMBER = 3;
        public static final int OUTER_TYPE_FIELD_NUMBER = 10;
        public static final int OUTER_TYPE_ID_FIELD_NUMBER = 11;
        public static Parser<Type> PARSER = new AbstractParser<Type>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Type.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Type parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Type(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_ALIAS_NAME_FIELD_NUMBER = 12;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 7;
        public static final int TYPE_PARAMETER_NAME_FIELD_NUMBER = 9;
        private static final Type defaultInstance;
        private static final long serialVersionUID = 0;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final ByteString unknownFields;

        /* loaded from: classes5.dex */
        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
            Argument.Projection getProjection();

            Type getType();

            int getTypeId();

            boolean hasProjection();

            boolean hasType();

            boolean hasTypeId();
        }

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Type(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builder;
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
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.bitField0_ |= 4096;
                                    this.flags_ = codedInputStream.readInt32();
                                    continue;
                                case 18:
                                    if (!z2) {
                                        this.argument_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                                    continue;
                                case 24:
                                    this.bitField0_ |= 1;
                                    this.nullable_ = codedInputStream.readBool();
                                    continue;
                                case 32:
                                    this.bitField0_ |= 2;
                                    this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                                    continue;
                                case 42:
                                    builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                    Type type = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                    this.flexibleUpperBound_ = type;
                                    if (builder != null) {
                                        builder.mergeFrom(type);
                                        this.flexibleUpperBound_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                    continue;
                                case 48:
                                    this.bitField0_ |= 16;
                                    this.className_ = codedInputStream.readInt32();
                                    continue;
                                case 56:
                                    this.bitField0_ |= 32;
                                    this.typeParameter_ = codedInputStream.readInt32();
                                    continue;
                                case 64:
                                    this.bitField0_ |= 8;
                                    this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                                    continue;
                                case 72:
                                    this.bitField0_ |= 64;
                                    this.typeParameterName_ = codedInputStream.readInt32();
                                    continue;
                                case 82:
                                    builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                    Type type2 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                    this.outerType_ = type2;
                                    if (builder != null) {
                                        builder.mergeFrom(type2);
                                        this.outerType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 256;
                                    continue;
                                case 88:
                                    this.bitField0_ |= 512;
                                    this.outerTypeId_ = codedInputStream.readInt32();
                                    continue;
                                case 96:
                                    this.bitField0_ |= 128;
                                    this.typeAliasName_ = codedInputStream.readInt32();
                                    continue;
                                case 106:
                                    builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                    Type type3 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                    this.abbreviatedType_ = type3;
                                    if (builder != null) {
                                        builder.mergeFrom(type3);
                                        this.abbreviatedType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1024;
                                    continue;
                                case 112:
                                    this.bitField0_ |= 2048;
                                    this.abbreviatedTypeId_ = codedInputStream.readInt32();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
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
                    if (z2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
            if (z2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Type> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new AbstractParser<Argument>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Type.Argument.1
                @Override // kotlinx.metadata.internal.protobuf.Parser
                public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int PROJECTION_FIELD_NUMBER = 1;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int TYPE_ID_FIELD_NUMBER = 3;
            private static final Argument defaultInstance;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final ByteString unknownFields;

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (readTag == 8) {
                                        int readEnum = codedInputStream.readEnum();
                                        Projection valueOf = Projection.valueOf(readEnum);
                                        if (valueOf == null) {
                                            newInstance.writeRawVarint32(readTag);
                                            newInstance.writeRawVarint32(readEnum);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.projection_ = valueOf;
                                        }
                                    } else if (readTag == 18) {
                                        Builder builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.type_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                    } else if (readTag != 24) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.typeId_ = codedInputStream.readInt32();
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
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            /* loaded from: classes5.dex */
            public enum Projection implements Internal.EnumLite {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);
                
                public static final int INV_VALUE = 2;
                public static final int IN_VALUE = 0;
                public static final int OUT_VALUE = 1;
                public static final int STAR_VALUE = 3;
                private static Internal.EnumLiteMap<Projection> internalValueMap = new Internal.EnumLiteMap<Projection>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Type.Argument.Projection.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                    public Projection findValueByNumber(int i) {
                        return Projection.valueOf(i);
                    }
                };
                private final int value;

                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return null;
                                }
                                return STAR;
                            }
                            return INV;
                        }
                        return OUT;
                    }
                    return IN;
                }

                public static Internal.EnumLiteMap<Projection> internalGetValueMap() {
                    return internalValueMap;
                }

                Projection(int i, int i2) {
                    this.value = i2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
            public Projection getProjection() {
                return this.projection_;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
            public Type getType() {
                return this.type_;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
            public boolean hasTypeId() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
            public int getTypeId() {
                return this.typeId_;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
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
                if (hasType() && !getType().isInitialized()) {
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
                    codedOutputStream.writeEnum(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeInt32(3, this.typeId_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.projection_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(3, this.typeId_);
                }
                int size = computeEnumSize + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Argument parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Argument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Argument parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Argument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Argument parseFrom(InputStream inputStream) throws IOException {
                return PARSER.parseFrom(inputStream);
            }

            public static Argument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(inputStream, extensionRegistryLite);
            }

            public static Argument parseDelimitedFrom(InputStream inputStream) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream);
            }

            public static Argument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public static Argument parseFrom(CodedInputStream codedInputStream) throws IOException {
                return PARSER.parseFrom(codedInputStream);
            }

            public static Argument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return Builder.access$5000();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int typeId_;
                private Projection projection_ = Projection.INV;
                private Type type_ = Type.getDefaultInstance();

                private void maybeForceBuilderInitialization() {
                }

                static /* synthetic */ Builder access$5000() {
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
                    this.projection_ = Projection.INV;
                    this.bitField0_ &= -2;
                    this.type_ = Type.getDefaultInstance();
                    int i = this.bitField0_;
                    this.typeId_ = 0;
                    this.bitField0_ = i & (-7);
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException(buildPartial);
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
                public Argument buildPartial() {
                    Argument argument = new Argument(this);
                    int i = this.bitField0_;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    argument.projection_ = this.projection_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    argument.type_ = this.type_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    argument.typeId_ = this.typeId_;
                    argument.bitField0_ = i2;
                    return argument;
                }

                @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        setProjection(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        mergeType(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        setTypeId(argument.getTypeId());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                    return this;
                }

                @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return !hasType() || getType().isInitialized();
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Argument argument = null;
                    try {
                        try {
                            Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Argument argument2 = (Argument) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                argument = argument2;
                                if (argument != null) {
                                    mergeFrom(argument);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (argument != null) {
                        }
                        throw th;
                    }
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
                public boolean hasProjection() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
                public Projection getProjection() {
                    return this.projection_;
                }

                public Builder setProjection(Projection projection) {
                    projection.getClass();
                    this.bitField0_ |= 1;
                    this.projection_ = projection;
                    return this;
                }

                public Builder clearProjection() {
                    this.bitField0_ &= -2;
                    this.projection_ = Projection.INV;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
                public boolean hasType() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
                public Type getType() {
                    return this.type_;
                }

                public Builder setType(Type type) {
                    type.getClass();
                    this.type_ = type;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setType(Builder builder) {
                    this.type_ = builder.build();
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder mergeType(Type type) {
                    if ((this.bitField0_ & 2) == 2 && this.type_ != Type.getDefaultInstance()) {
                        this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                    } else {
                        this.type_ = type;
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder clearType() {
                    this.type_ = Type.getDefaultInstance();
                    this.bitField0_ &= -3;
                    return this;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
                public boolean hasTypeId() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override // kotlinx.metadata.internal.metadata.ProtoBuf.Type.ArgumentOrBuilder
                public int getTypeId() {
                    return this.typeId_;
                }

                public Builder setTypeId(int i) {
                    this.bitField0_ |= 4;
                    this.typeId_ = i;
                    return this;
                }

                public Builder clearTypeId() {
                    this.bitField0_ &= -5;
                    this.typeId_ = 0;
                    return this;
                }
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public List<? extends ArgumentOrBuilder> getArgumentOrBuilderList() {
            return this.argument_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getArgumentCount() {
            return this.argument_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public Argument getArgument(int i) {
            return this.argument_.get(i);
        }

        public ArgumentOrBuilder getArgumentOrBuilder(int i) {
            return this.argument_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean getNullable() {
            return this.nullable_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getClassName() {
            return this.className_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getTypeParameter() {
            return this.typeParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public Type getOuterType() {
            return this.outerType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
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
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                codedOutputStream.writeMessage(2, this.argument_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeMessage(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            for (int i2 = 0; i2 < this.argument_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeBoolSize(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeInt32Size += CodedOutputStream.computeMessageSize(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                computeInt32Size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                computeInt32Size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
            }
            int extensionsSerializedSize = computeInt32Size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Type parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Type parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Type parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Type parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Type parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$5700();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Type type) {
            return newBuilder().mergeFrom(type);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private boolean nullable_;
            private int outerTypeId_;
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;
            private List<Argument> argument_ = Collections.emptyList();
            private Type flexibleUpperBound_ = Type.getDefaultInstance();
            private Type outerType_ = Type.getDefaultInstance();
            private Type abbreviatedType_ = Type.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$5700() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.argument_ = Collections.emptyList();
                int i = this.bitField0_;
                this.nullable_ = false;
                this.flexibleTypeCapabilitiesId_ = 0;
                this.bitField0_ = i & (-8);
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                int i2 = this.bitField0_;
                this.flexibleUpperBoundId_ = 0;
                this.className_ = 0;
                this.typeParameter_ = 0;
                this.typeParameterName_ = 0;
                this.typeAliasName_ = 0;
                this.bitField0_ = i2 & (-505);
                this.outerType_ = Type.getDefaultInstance();
                int i3 = this.bitField0_;
                this.outerTypeId_ = 0;
                this.bitField0_ = i3 & (-1537);
                this.abbreviatedType_ = Type.getDefaultInstance();
                int i4 = this.bitField0_;
                this.abbreviatedTypeId_ = 0;
                this.flags_ = 0;
                this.bitField0_ = i4 & (-14337);
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Type build() {
                Type buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Type buildPartial() {
                Type type = new Type(this);
                int i = this.bitField0_;
                if ((i & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -2;
                }
                type.argument_ = this.argument_;
                int i2 = (i & 2) != 2 ? 0 : 1;
                type.nullable_ = this.nullable_;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                type.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                type.className_ = this.className_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                type.typeParameter_ = this.typeParameter_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                type.typeParameterName_ = this.typeParameterName_;
                if ((i & 256) == 256) {
                    i2 |= 128;
                }
                type.typeAliasName_ = this.typeAliasName_;
                if ((i & 512) == 512) {
                    i2 |= 256;
                }
                type.outerType_ = this.outerType_;
                if ((i & 1024) == 1024) {
                    i2 |= 512;
                }
                type.outerTypeId_ = this.outerTypeId_;
                if ((i & 2048) == 2048) {
                    i2 |= 1024;
                }
                type.abbreviatedType_ = this.abbreviatedType_;
                if ((i & 4096) == 4096) {
                    i2 |= 2048;
                }
                type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((i & 8192) == 8192) {
                    i2 |= 4096;
                }
                type.flags_ = this.flags_;
                type.bitField0_ = i2;
                return type;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = type.argument_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureArgumentIsMutable();
                        this.argument_.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    setNullable(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    setFlexibleTypeCapabilitiesId(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    mergeFlexibleUpperBound(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    setFlexibleUpperBoundId(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    setClassName(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    setTypeParameter(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    setTypeParameterName(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    setTypeAliasName(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    mergeOuterType(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    setOuterTypeId(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    mergeAbbreviatedType(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    setAbbreviatedTypeId(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    setFlags(type.getFlags());
                }
                mergeExtensionFields(type);
                setUnknownFields(getUnknownFields().concat(type.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getArgumentCount(); i++) {
                    if (!getArgument(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasFlexibleUpperBound() || getFlexibleUpperBound().isInitialized()) {
                    if (!hasOuterType() || getOuterType().isInitialized()) {
                        return (!hasAbbreviatedType() || getAbbreviatedType().isInitialized()) && extensionsAreInitialized();
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Type type = null;
                try {
                    try {
                        Type parsePartialFrom = Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Type type2 = (Type) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            type = type2;
                            if (type != null) {
                                mergeFrom(type);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (type != null) {
                    }
                    throw th;
                }
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public List<Argument> getArgumentList() {
                return Collections.unmodifiableList(this.argument_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public Argument getArgument(int i) {
                return this.argument_.get(i);
            }

            public Builder setArgument(int i, Argument argument) {
                argument.getClass();
                ensureArgumentIsMutable();
                this.argument_.set(i, argument);
                return this;
            }

            public Builder setArgument(int i, Argument.Builder builder) {
                ensureArgumentIsMutable();
                this.argument_.set(i, builder.build());
                return this;
            }

            public Builder addArgument(Argument argument) {
                argument.getClass();
                ensureArgumentIsMutable();
                this.argument_.add(argument);
                return this;
            }

            public Builder addArgument(int i, Argument argument) {
                argument.getClass();
                ensureArgumentIsMutable();
                this.argument_.add(i, argument);
                return this;
            }

            public Builder addArgument(Argument.Builder builder) {
                ensureArgumentIsMutable();
                this.argument_.add(builder.build());
                return this;
            }

            public Builder addArgument(int i, Argument.Builder builder) {
                ensureArgumentIsMutable();
                this.argument_.add(i, builder.build());
                return this;
            }

            public Builder addAllArgument(Iterable<? extends Argument> iterable) {
                ensureArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.argument_);
                return this;
            }

            public Builder clearArgument() {
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeArgument(int i) {
                ensureArgumentIsMutable();
                this.argument_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasNullable() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean getNullable() {
                return this.nullable_;
            }

            public Builder setNullable(boolean z) {
                this.bitField0_ |= 2;
                this.nullable_ = z;
                return this;
            }

            public Builder clearNullable() {
                this.bitField0_ &= -3;
                this.nullable_ = false;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasFlexibleTypeCapabilitiesId() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getFlexibleTypeCapabilitiesId() {
                return this.flexibleTypeCapabilitiesId_;
            }

            public Builder setFlexibleTypeCapabilitiesId(int i) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = i;
                return this;
            }

            public Builder clearFlexibleTypeCapabilitiesId() {
                this.bitField0_ &= -5;
                this.flexibleTypeCapabilitiesId_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasFlexibleUpperBound() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Builder setFlexibleUpperBound(Type type) {
                type.getClass();
                this.flexibleUpperBound_ = type;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setFlexibleUpperBound(Builder builder) {
                this.flexibleUpperBound_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeFlexibleUpperBound(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.flexibleUpperBound_ != Type.getDefaultInstance()) {
                    this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(type).buildPartial();
                } else {
                    this.flexibleUpperBound_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearFlexibleUpperBound() {
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasFlexibleUpperBoundId() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getFlexibleUpperBoundId() {
                return this.flexibleUpperBoundId_;
            }

            public Builder setFlexibleUpperBoundId(int i) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = i;
                return this;
            }

            public Builder clearFlexibleUpperBoundId() {
                this.bitField0_ &= -17;
                this.flexibleUpperBoundId_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasClassName() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getClassName() {
                return this.className_;
            }

            public Builder setClassName(int i) {
                this.bitField0_ |= 32;
                this.className_ = i;
                return this;
            }

            public Builder clearClassName() {
                this.bitField0_ &= -33;
                this.className_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasTypeParameter() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getTypeParameter() {
                return this.typeParameter_;
            }

            public Builder setTypeParameter(int i) {
                this.bitField0_ |= 64;
                this.typeParameter_ = i;
                return this;
            }

            public Builder clearTypeParameter() {
                this.bitField0_ &= -65;
                this.typeParameter_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasTypeParameterName() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getTypeParameterName() {
                return this.typeParameterName_;
            }

            public Builder setTypeParameterName(int i) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = i;
                return this;
            }

            public Builder clearTypeParameterName() {
                this.bitField0_ &= -129;
                this.typeParameterName_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasTypeAliasName() {
                return (this.bitField0_ & 256) == 256;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getTypeAliasName() {
                return this.typeAliasName_;
            }

            public Builder setTypeAliasName(int i) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = i;
                return this;
            }

            public Builder clearTypeAliasName() {
                this.bitField0_ &= -257;
                this.typeAliasName_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasOuterType() {
                return (this.bitField0_ & 512) == 512;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public Type getOuterType() {
                return this.outerType_;
            }

            public Builder setOuterType(Type type) {
                type.getClass();
                this.outerType_ = type;
                this.bitField0_ |= 512;
                return this;
            }

            public Builder setOuterType(Builder builder) {
                this.outerType_ = builder.build();
                this.bitField0_ |= 512;
                return this;
            }

            public Builder mergeOuterType(Type type) {
                if ((this.bitField0_ & 512) == 512 && this.outerType_ != Type.getDefaultInstance()) {
                    this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(type).buildPartial();
                } else {
                    this.outerType_ = type;
                }
                this.bitField0_ |= 512;
                return this;
            }

            public Builder clearOuterType() {
                this.outerType_ = Type.getDefaultInstance();
                this.bitField0_ &= -513;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasOuterTypeId() {
                return (this.bitField0_ & 1024) == 1024;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getOuterTypeId() {
                return this.outerTypeId_;
            }

            public Builder setOuterTypeId(int i) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = i;
                return this;
            }

            public Builder clearOuterTypeId() {
                this.bitField0_ &= -1025;
                this.outerTypeId_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasAbbreviatedType() {
                return (this.bitField0_ & 2048) == 2048;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Builder setAbbreviatedType(Type type) {
                type.getClass();
                this.abbreviatedType_ = type;
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setAbbreviatedType(Builder builder) {
                this.abbreviatedType_ = builder.build();
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder mergeAbbreviatedType(Type type) {
                if ((this.bitField0_ & 2048) == 2048 && this.abbreviatedType_ != Type.getDefaultInstance()) {
                    this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(type).buildPartial();
                } else {
                    this.abbreviatedType_ = type;
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder clearAbbreviatedType() {
                this.abbreviatedType_ = Type.getDefaultInstance();
                this.bitField0_ &= -2049;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasAbbreviatedTypeId() {
                return (this.bitField0_ & 4096) == 4096;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getAbbreviatedTypeId() {
                return this.abbreviatedTypeId_;
            }

            public Builder setAbbreviatedTypeId(int i) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = i;
                return this;
            }

            public Builder clearAbbreviatedTypeId() {
                this.bitField0_ &= -4097;
                this.abbreviatedTypeId_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 8192) == 8192;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 8192;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -8193;
                this.flags_ = 0;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        public static Parser<TypeParameter> PARSER = new AbstractParser<TypeParameter>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameter.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public TypeParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeParameter(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REIFIED_FIELD_NUMBER = 3;
        public static final int UPPER_BOUND_FIELD_NUMBER = 5;
        public static final int UPPER_BOUND_ID_FIELD_NUMBER = 6;
        public static final int VARIANCE_FIELD_NUMBER = 4;
        private static final TypeParameter defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private TypeParameter(boolean z) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.id_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.reified_ = codedInputStream.readBool();
                                } else if (readTag == 32) {
                                    int readEnum = codedInputStream.readEnum();
                                    Variance valueOf = Variance.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.variance_ = valueOf;
                                    }
                                } else if (readTag == 42) {
                                    if (!(z2 & true)) {
                                        this.upperBound_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.upperBound_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                } else if (readTag == 48) {
                                    if (!(z2 & true)) {
                                        this.upperBoundId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (readTag != 50) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.upperBoundId_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
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
                    if (z2 & true) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if (z2 & true) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if (z2 & true) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public enum Variance implements Internal.EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);
            
            public static final int INV_VALUE = 2;
            public static final int IN_VALUE = 0;
            public static final int OUT_VALUE = 1;
            private static Internal.EnumLiteMap<Variance> internalValueMap = new Internal.EnumLiteMap<Variance>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameter.Variance.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public Variance findValueByNumber(int i) {
                    return Variance.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return INV;
                    }
                    return OUT;
                }
                return IN;
            }

            public static Internal.EnumLiteMap<Variance> internalGetValueMap() {
                return internalValueMap;
            }

            Variance(int i, int i2) {
                this.value = i2;
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public boolean getReified() {
            return this.reified_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public Variance getVariance() {
            return this.variance_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public List<? extends TypeOrBuilder> getUpperBoundOrBuilderList() {
            return this.upperBound_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public Type getUpperBound(int i) {
            return this.upperBound_.get(i);
        }

        public TypeOrBuilder getUpperBoundOrBuilder(int i) {
            return this.upperBound_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public int getUpperBoundIdCount() {
            return this.upperBoundId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
        public int getUpperBoundId(int i) {
            return this.upperBoundId_.get(i).intValue();
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i = 0; i < getUpperBoundCount(); i++) {
                    if (!getUpperBound(i).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeEnum(4, this.variance_.getNumber());
            }
            for (int i = 0; i < this.upperBound_.size(); i++) {
                codedOutputStream.writeMessage(5, this.upperBound_.get(i));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(50);
                codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.upperBoundId_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i2).intValue());
            }
            newExtensionWriter.writeUntil(1000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBoolSize(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
            }
            for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i2));
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.upperBoundId_.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i4).intValue());
            }
            int i5 = computeInt32Size + i3;
            if (!getUpperBoundIdList().isEmpty()) {
                i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(i3);
            }
            this.upperBoundIdMemoizedSerializedSize = i3;
            int extensionsSerializedSize = i5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TypeParameter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static TypeParameter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TypeParameter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static TypeParameter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TypeParameter parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static TypeParameter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TypeParameter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TypeParameter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TypeParameter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TypeParameter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$7600();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeParameter typeParameter) {
            return newBuilder().mergeFrom(typeParameter);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private Variance variance_ = Variance.INV;
            private List<Type> upperBound_ = Collections.emptyList();
            private List<Integer> upperBoundId_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$7600() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.id_ = 0;
                int i = this.bitField0_;
                this.name_ = 0;
                this.reified_ = false;
                this.bitField0_ = i & (-8);
                this.variance_ = Variance.INV;
                this.bitField0_ &= -9;
                this.upperBound_ = Collections.emptyList();
                this.bitField0_ &= -17;
                this.upperBoundId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public TypeParameter build() {
                TypeParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public TypeParameter buildPartial() {
                TypeParameter typeParameter = new TypeParameter(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                typeParameter.id_ = this.id_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                typeParameter.name_ = this.name_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                typeParameter.reified_ = this.reified_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                typeParameter.variance_ = this.variance_;
                if ((this.bitField0_ & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= -17;
                }
                typeParameter.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= -33;
                }
                typeParameter.upperBoundId_ = this.upperBoundId_;
                typeParameter.bitField0_ = i2;
                return typeParameter;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    setId(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    setName(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    setReified(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    setVariance(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = typeParameter.upperBound_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUpperBoundIsMutable();
                        this.upperBound_.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = typeParameter.upperBoundId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureUpperBoundIdIsMutable();
                        this.upperBoundId_.addAll(typeParameter.upperBoundId_);
                    }
                }
                mergeExtensionFields(typeParameter);
                setUnknownFields(getUnknownFields().concat(typeParameter.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() && hasName()) {
                    for (int i = 0; i < getUpperBoundCount(); i++) {
                        if (!getUpperBound(i).isInitialized()) {
                            return false;
                        }
                    }
                    return extensionsAreInitialized();
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeParameter typeParameter = null;
                try {
                    try {
                        TypeParameter parsePartialFrom = TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        TypeParameter typeParameter2 = (TypeParameter) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            typeParameter = typeParameter2;
                            if (typeParameter != null) {
                                mergeFrom(typeParameter);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (typeParameter != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int i) {
                this.bitField0_ |= 1;
                this.id_ = i;
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= -2;
                this.id_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -3;
                this.name_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public boolean hasReified() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public boolean getReified() {
                return this.reified_;
            }

            public Builder setReified(boolean z) {
                this.bitField0_ |= 4;
                this.reified_ = z;
                return this;
            }

            public Builder clearReified() {
                this.bitField0_ &= -5;
                this.reified_ = false;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public boolean hasVariance() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public Variance getVariance() {
                return this.variance_;
            }

            public Builder setVariance(Variance variance) {
                variance.getClass();
                this.bitField0_ |= 8;
                this.variance_ = variance;
                return this;
            }

            public Builder clearVariance() {
                this.bitField0_ &= -9;
                this.variance_ = Variance.INV;
                return this;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.upperBound_ = new ArrayList(this.upperBound_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public List<Type> getUpperBoundList() {
                return Collections.unmodifiableList(this.upperBound_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public Type getUpperBound(int i) {
                return this.upperBound_.get(i);
            }

            public Builder setUpperBound(int i, Type type) {
                type.getClass();
                ensureUpperBoundIsMutable();
                this.upperBound_.set(i, type);
                return this;
            }

            public Builder setUpperBound(int i, Type.Builder builder) {
                ensureUpperBoundIsMutable();
                this.upperBound_.set(i, builder.build());
                return this;
            }

            public Builder addUpperBound(Type type) {
                type.getClass();
                ensureUpperBoundIsMutable();
                this.upperBound_.add(type);
                return this;
            }

            public Builder addUpperBound(int i, Type type) {
                type.getClass();
                ensureUpperBoundIsMutable();
                this.upperBound_.add(i, type);
                return this;
            }

            public Builder addUpperBound(Type.Builder builder) {
                ensureUpperBoundIsMutable();
                this.upperBound_.add(builder.build());
                return this;
            }

            public Builder addUpperBound(int i, Type.Builder builder) {
                ensureUpperBoundIsMutable();
                this.upperBound_.add(i, builder.build());
                return this;
            }

            public Builder addAllUpperBound(Iterable<? extends Type> iterable) {
                ensureUpperBoundIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.upperBound_);
                return this;
            }

            public Builder clearUpperBound() {
                this.upperBound_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder removeUpperBound(int i) {
                ensureUpperBoundIsMutable();
                this.upperBound_.remove(i);
                return this;
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public List<Integer> getUpperBoundIdList() {
                return Collections.unmodifiableList(this.upperBoundId_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public int getUpperBoundIdCount() {
                return this.upperBoundId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeParameterOrBuilder
            public int getUpperBoundId(int i) {
                return this.upperBoundId_.get(i).intValue();
            }

            public Builder setUpperBoundId(int i, int i2) {
                ensureUpperBoundIdIsMutable();
                this.upperBoundId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addUpperBoundId(int i) {
                ensureUpperBoundIdIsMutable();
                this.upperBoundId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllUpperBoundId(Iterable<? extends Integer> iterable) {
                ensureUpperBoundIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.upperBoundId_);
                return this;
            }

            public Builder clearUpperBoundId() {
                this.upperBoundId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static final int COMPANION_OBJECT_NAME_FIELD_NUMBER = 4;
        public static final int CONSTRUCTOR_FIELD_NUMBER = 8;
        public static final int CONTEXT_RECEIVER_TYPE_FIELD_NUMBER = 20;
        public static final int CONTEXT_RECEIVER_TYPE_ID_FIELD_NUMBER = 21;
        public static final int ENUM_ENTRY_FIELD_NUMBER = 13;
        public static final int FLAGS_FIELD_NUMBER = 1;
        public static final int FQ_NAME_FIELD_NUMBER = 3;
        public static final int FUNCTION_FIELD_NUMBER = 9;
        public static final int INLINE_CLASS_UNDERLYING_PROPERTY_NAME_FIELD_NUMBER = 17;
        public static final int INLINE_CLASS_UNDERLYING_TYPE_FIELD_NUMBER = 18;
        public static final int INLINE_CLASS_UNDERLYING_TYPE_ID_FIELD_NUMBER = 19;
        public static final int MULTI_FIELD_VALUE_CLASS_UNDERLYING_NAME_FIELD_NUMBER = 22;
        public static final int MULTI_FIELD_VALUE_CLASS_UNDERLYING_TYPE_FIELD_NUMBER = 23;
        public static final int MULTI_FIELD_VALUE_CLASS_UNDERLYING_TYPE_ID_FIELD_NUMBER = 24;
        public static final int NESTED_CLASS_NAME_FIELD_NUMBER = 7;
        public static Parser<Class> PARSER = new AbstractParser<Class>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Class.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Class parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Class(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PROPERTY_FIELD_NUMBER = 10;
        public static final int SEALED_SUBCLASS_FQ_NAME_FIELD_NUMBER = 16;
        public static final int SUPERTYPE_FIELD_NUMBER = 6;
        public static final int SUPERTYPE_ID_FIELD_NUMBER = 2;
        public static final int TYPE_ALIAS_FIELD_NUMBER = 11;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 5;
        public static final int TYPE_TABLE_FIELD_NUMBER = 30;
        public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;
        public static final int VERSION_REQUIREMENT_TABLE_FIELD_NUMBER = 32;
        private static final Class defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> extendableBuilder) {
            super(extendableBuilder);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Class(boolean z) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            boolean z = true;
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                boolean z4 = z;
                if (!z2) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                    continue;
                                    z = z4;
                                case 16:
                                    if (!(z3 & true)) {
                                        this.supertypeId_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case 18:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.supertypeId_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    continue;
                                    z = z4;
                                    break;
                                case 24:
                                    this.bitField0_ |= 2;
                                    this.fqName_ = codedInputStream.readInt32();
                                    continue;
                                    z = z4;
                                case 32:
                                    this.bitField0_ |= 4;
                                    this.companionObjectName_ = codedInputStream.readInt32();
                                    continue;
                                    z = z4;
                                case 42:
                                    if (!(z3 & true)) {
                                        this.typeParameter_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 50:
                                    if (!(z3 & true)) {
                                        this.supertype_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.supertype_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 56:
                                    if (!(z3 & true)) {
                                        this.nestedClassName_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case 58:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.nestedClassName_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                    continue;
                                    z = z4;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    if (!(z3 & true)) {
                                        this.constructor_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.constructor_.add(codedInputStream.readMessage(Constructor.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 74:
                                    if (!(z3 & true)) {
                                        this.function_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.function_.add(codedInputStream.readMessage(Function.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 82:
                                    if (!(z3 & true)) {
                                        this.property_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.property_.add(codedInputStream.readMessage(Property.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 90:
                                    if (!(z3 & true)) {
                                        this.typeAlias_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.typeAlias_.add(codedInputStream.readMessage(TypeAlias.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 106:
                                    if (!(z3 & true)) {
                                        this.enumEntry_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.enumEntry_.add(codedInputStream.readMessage(EnumEntry.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 128:
                                    if (!(z3 & true)) {
                                        this.sealedSubclassFqName_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                    int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.sealedSubclassFqName_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit3);
                                    continue;
                                    z = z4;
                                    break;
                                case TsExtractor.TS_STREAM_TYPE_DTS_HD /* 136 */:
                                    this.bitField0_ |= 8;
                                    this.inlineClassUnderlyingPropertyName_ = codedInputStream.readInt32();
                                    continue;
                                    z = z4;
                                case 146:
                                    Type.Builder builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                                    Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                    this.inlineClassUnderlyingType_ = type;
                                    if (builder != 0) {
                                        builder.mergeFrom(type);
                                        this.inlineClassUnderlyingType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                    continue;
                                    z = z4;
                                case BuiltInsProtoBuf.PROPERTY_GETTER_ANNOTATION_FIELD_NUMBER /* 152 */:
                                    this.bitField0_ |= 32;
                                    this.inlineClassUnderlyingTypeId_ = codedInputStream.readInt32();
                                    continue;
                                    z = z4;
                                case 162:
                                    if (!(z3 & true)) {
                                        this.contextReceiverType_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.contextReceiverType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 168:
                                    if (!(z3 & true)) {
                                        this.contextReceiverTypeId_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case 170:
                                    int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.contextReceiverTypeId_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit4);
                                    continue;
                                    z = z4;
                                    break;
                                case 176:
                                    if (!(z3 & true)) {
                                        this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case 178:
                                    int pushLimit5 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multiFieldValueClassUnderlyingName_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit5);
                                    continue;
                                    z = z4;
                                    break;
                                case 186:
                                    if (!(z3 & true)) {
                                        this.multiFieldValueClassUnderlyingType_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.multiFieldValueClassUnderlyingType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    continue;
                                    z = z4;
                                case 192:
                                    if (!(z3 & true)) {
                                        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case DownloaderService.STATUS_WAITING_TO_RETRY /* 194 */:
                                    int pushLimit6 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit6);
                                    continue;
                                    z = z4;
                                    break;
                                case 242:
                                    GeneratedMessageLite.Builder builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                                    TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                    this.typeTable_ = typeTable;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(typeTable);
                                        this.typeTable_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 64;
                                    continue;
                                    z = z4;
                                case 248:
                                    if (!(z3 & true)) {
                                        this.versionRequirement_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                    z = z4;
                                case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                    int pushLimit7 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z3 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        z3 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit7);
                                    continue;
                                    z = z4;
                                    break;
                                case 258:
                                    try {
                                        GeneratedMessageLite.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                                        VersionRequirementTable versionRequirementTable = (VersionRequirementTable) codedInputStream.readMessage(VersionRequirementTable.PARSER, extensionRegistryLite);
                                        this.versionRequirementTable_ = versionRequirementTable;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(versionRequirementTable);
                                            this.versionRequirementTable_ = builder3.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                        z = z4;
                                    } catch (InvalidProtocolBufferException e) {
                                        e = e;
                                        throw e.setUnfinishedMessage(this);
                                    } catch (IOException e2) {
                                        e = e2;
                                        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (z3 & true) {
                                            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                                        }
                                        if (z3 & true) {
                                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                                        }
                                        if (z3 & true) {
                                            this.supertype_ = Collections.unmodifiableList(this.supertype_);
                                        }
                                        if (z3 & true) {
                                            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                                        }
                                        if (z3 & true) {
                                            this.constructor_ = Collections.unmodifiableList(this.constructor_);
                                        }
                                        if (z3 & true) {
                                            this.function_ = Collections.unmodifiableList(this.function_);
                                        }
                                        if (z3 & true) {
                                            this.property_ = Collections.unmodifiableList(this.property_);
                                        }
                                        if (z3 & true) {
                                            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                                        }
                                        if (z3 & true) {
                                            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                                        }
                                        if (z3 & true) {
                                            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                                        }
                                        if (z3 & true) {
                                            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                                        }
                                        if (z3 & true) {
                                            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                                        }
                                        if (z3 & true) {
                                            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                                        }
                                        if (z3 & true) {
                                            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                                        }
                                        if (z3 & true) {
                                            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                                        }
                                        if (z3 & true) {
                                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                                default:
                                    if (parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        continue;
                                        z = z4;
                                    }
                                    break;
                            }
                            z2 = z4;
                            z = z4;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } else {
                    if (z3 & true) {
                        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    }
                    if (z3 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z3 & true) {
                        this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    }
                    if (z3 & true) {
                        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    }
                    if (z3 & true) {
                        this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    }
                    if (z3 & true) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (z3 & true) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (z3 & true) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    if (z3 & true) {
                        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    }
                    if (z3 & true) {
                        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    }
                    if (z3 & true) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (z3 & true) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (z3 & true) {
                        this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    }
                    if (z3 & true) {
                        this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    }
                    if (z3 & true) {
                        this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    }
                    if (z3 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th4) {
                        this.unknownFields = newOutput.toByteString();
                        throw th4;
                    }
                    this.unknownFields = newOutput.toByteString();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }

        static {
            Class r0 = new Class(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Class> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public enum Kind implements Internal.EnumLite {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);
            
            public static final int ANNOTATION_CLASS_VALUE = 4;
            public static final int CLASS_VALUE = 0;
            public static final int COMPANION_OBJECT_VALUE = 6;
            public static final int ENUM_CLASS_VALUE = 2;
            public static final int ENUM_ENTRY_VALUE = 3;
            public static final int INTERFACE_VALUE = 1;
            public static final int OBJECT_VALUE = 5;
            private static Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Class.Kind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public Kind findValueByNumber(int i) {
                    return Kind.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i) {
                switch (i) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
                return internalValueMap;
            }

            Kind(int i, int i2) {
                this.value = i2;
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getFqName() {
            return this.fqName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int i) {
            return this.typeParameter_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public List<? extends TypeOrBuilder> getSupertypeOrBuilderList() {
            return this.supertype_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Type getSupertype(int i) {
            return this.supertype_.get(i);
        }

        public TypeOrBuilder getSupertypeOrBuilder(int i) {
            return this.supertype_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getSupertypeIdCount() {
            return this.supertypeId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getSupertypeId(int i) {
            return this.supertypeId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getNestedClassNameCount() {
            return this.nestedClassName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getNestedClassName(int i) {
            return this.nestedClassName_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public List<? extends TypeOrBuilder> getContextReceiverTypeOrBuilderList() {
            return this.contextReceiverType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Type getContextReceiverType(int i) {
            return this.contextReceiverType_.get(i);
        }

        public TypeOrBuilder getContextReceiverTypeOrBuilder(int i) {
            return this.contextReceiverType_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getContextReceiverTypeIdCount() {
            return this.contextReceiverTypeId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getContextReceiverTypeId(int i) {
            return this.contextReceiverTypeId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public List<? extends ConstructorOrBuilder> getConstructorOrBuilderList() {
            return this.constructor_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getConstructorCount() {
            return this.constructor_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Constructor getConstructor(int i) {
            return this.constructor_.get(i);
        }

        public ConstructorOrBuilder getConstructorOrBuilder(int i) {
            return this.constructor_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Function> getFunctionList() {
            return this.function_;
        }

        public List<? extends FunctionOrBuilder> getFunctionOrBuilderList() {
            return this.function_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getFunctionCount() {
            return this.function_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Function getFunction(int i) {
            return this.function_.get(i);
        }

        public FunctionOrBuilder getFunctionOrBuilder(int i) {
            return this.function_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<? extends PropertyOrBuilder> getPropertyOrBuilderList() {
            return this.property_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getPropertyCount() {
            return this.property_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Property getProperty(int i) {
            return this.property_.get(i);
        }

        public PropertyOrBuilder getPropertyOrBuilder(int i) {
            return this.property_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public List<? extends TypeAliasOrBuilder> getTypeAliasOrBuilderList() {
            return this.typeAlias_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public TypeAlias getTypeAlias(int i) {
            return this.typeAlias_.get(i);
        }

        public TypeAliasOrBuilder getTypeAliasOrBuilder(int i) {
            return this.typeAlias_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public List<? extends EnumEntryOrBuilder> getEnumEntryOrBuilderList() {
            return this.enumEntry_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public EnumEntry getEnumEntry(int i) {
            return this.enumEntry_.get(i);
        }

        public EnumEntryOrBuilder getEnumEntryOrBuilder(int i) {
            return this.enumEntry_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getSealedSubclassFqNameCount() {
            return this.sealedSubclassFqName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getSealedSubclassFqName(int i) {
            return this.sealedSubclassFqName_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getMultiFieldValueClassUnderlyingName(int i) {
            return this.multiFieldValueClassUnderlyingName_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public List<? extends TypeOrBuilder> getMultiFieldValueClassUnderlyingTypeOrBuilderList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public Type getMultiFieldValueClassUnderlyingType(int i) {
            return this.multiFieldValueClassUnderlyingType_.get(i);
        }

        public TypeOrBuilder getMultiFieldValueClassUnderlyingTypeOrBuilder(int i) {
            return this.multiFieldValueClassUnderlyingType_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getMultiFieldValueClassUnderlyingTypeId(int i) {
            return this.multiFieldValueClassUnderlyingTypeId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getVersionRequirementCount() {
            return this.versionRequirement_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public int getVersionRequirement(int i) {
            return this.versionRequirement_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
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
            if (!hasFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
                if (!getSupertype(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getContextReceiverTypeCount(); i3++) {
                if (!getContextReceiverType(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                if (!getConstructor(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                if (!getFunction(i5).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                if (!getProperty(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                if (!getTypeAlias(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                if (!getEnumEntry(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i9 = 0; i9 < getMultiFieldValueClassUnderlyingTypeCount(); i9++) {
                if (!getMultiFieldValueClassUnderlyingType(i9).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(18);
                codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i = 0; i < this.supertypeId_.size(); i++) {
                codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(4, this.companionObjectName_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
            }
            for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
                codedOutputStream.writeMessage(6, this.supertype_.get(i3));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(58);
                codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
                codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
            }
            for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
                codedOutputStream.writeMessage(8, this.constructor_.get(i5));
            }
            for (int i6 = 0; i6 < this.function_.size(); i6++) {
                codedOutputStream.writeMessage(9, this.function_.get(i6));
            }
            for (int i7 = 0; i7 < this.property_.size(); i7++) {
                codedOutputStream.writeMessage(10, this.property_.get(i7));
            }
            for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
                codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
            }
            for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
                codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
                codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i11 = 0; i11 < this.contextReceiverType_.size(); i11++) {
                codedOutputStream.writeMessage(20, this.contextReceiverType_.get(i11));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(170);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i12 = 0; i12 < this.contextReceiverTypeId_.size(); i12++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i12).intValue());
            }
            if (getMultiFieldValueClassUnderlyingNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(178);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
            }
            for (int i13 = 0; i13 < this.multiFieldValueClassUnderlyingName_.size(); i13++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(i13).intValue());
            }
            for (int i14 = 0; i14 < this.multiFieldValueClassUnderlyingType_.size(); i14++) {
                codedOutputStream.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(i14));
            }
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(DownloaderService.STATUS_WAITING_TO_RETRY);
                codedOutputStream.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
            }
            for (int i15 = 0; i15 < this.multiFieldValueClassUnderlyingTypeId_.size(); i15++) {
                codedOutputStream.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i15).intValue());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i16 = 0; i16 < this.versionRequirement_.size(); i16++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i16).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.supertypeId_.size(); i3++) {
                i2 += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i3).intValue());
            }
            int i4 = computeInt32Size + i2;
            if (!getSupertypeIdList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
            }
            this.supertypeIdMemoizedSerializedSize = i2;
            if ((this.bitField0_ & 2) == 2) {
                i4 += CodedOutputStream.computeInt32Size(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i4 += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
            }
            for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
                i4 += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i5));
            }
            for (int i6 = 0; i6 < this.supertype_.size(); i6++) {
                i4 += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i6));
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.nestedClassName_.size(); i8++) {
                i7 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i8).intValue());
            }
            int i9 = i4 + i7;
            if (!getNestedClassNameList().isEmpty()) {
                i9 = i9 + 1 + CodedOutputStream.computeInt32SizeNoTag(i7);
            }
            this.nestedClassNameMemoizedSerializedSize = i7;
            for (int i10 = 0; i10 < this.constructor_.size(); i10++) {
                i9 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i10));
            }
            for (int i11 = 0; i11 < this.function_.size(); i11++) {
                i9 += CodedOutputStream.computeMessageSize(9, this.function_.get(i11));
            }
            for (int i12 = 0; i12 < this.property_.size(); i12++) {
                i9 += CodedOutputStream.computeMessageSize(10, this.property_.get(i12));
            }
            for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
                i9 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i13));
            }
            for (int i14 = 0; i14 < this.enumEntry_.size(); i14++) {
                i9 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i14));
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.sealedSubclassFqName_.size(); i16++) {
                i15 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i16).intValue());
            }
            int i17 = i9 + i15;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i17 = i17 + 2 + CodedOutputStream.computeInt32SizeNoTag(i15);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i15;
            if ((this.bitField0_ & 8) == 8) {
                i17 += CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i17 += CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i17 += CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
            }
            for (int i18 = 0; i18 < this.contextReceiverType_.size(); i18++) {
                i17 += CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(i18));
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.contextReceiverTypeId_.size(); i20++) {
                i19 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i20).intValue());
            }
            int i21 = i17 + i19;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i21 = i21 + 2 + CodedOutputStream.computeInt32SizeNoTag(i19);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i19;
            int i22 = 0;
            for (int i23 = 0; i23 < this.multiFieldValueClassUnderlyingName_.size(); i23++) {
                i22 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(i23).intValue());
            }
            int i24 = i21 + i22;
            if (!getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
                i24 = i24 + 2 + CodedOutputStream.computeInt32SizeNoTag(i22);
            }
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = i22;
            for (int i25 = 0; i25 < this.multiFieldValueClassUnderlyingType_.size(); i25++) {
                i24 += CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(i25));
            }
            int i26 = 0;
            for (int i27 = 0; i27 < this.multiFieldValueClassUnderlyingTypeId_.size(); i27++) {
                i26 += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i27).intValue());
            }
            int i28 = i24 + i26;
            if (!getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
                i28 = i28 + 2 + CodedOutputStream.computeInt32SizeNoTag(i26);
            }
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = i26;
            if ((this.bitField0_ & 64) == 64) {
                i28 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i29 = 0;
            for (int i30 = 0; i30 < this.versionRequirement_.size(); i30++) {
                i29 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i30).intValue());
            }
            int size = i28 + i29 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Class parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Class parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Class parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Class parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Class parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Class parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Class parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Class parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Class parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Class parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$8700();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Class r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private int fqName_;
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private int flags_ = 6;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private Type inlineClassUnderlyingType_ = Type.getDefaultInstance();
            private List<Integer> multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            private List<Type> multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            private List<Integer> multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$8700() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.flags_ = 6;
                int i = this.bitField0_;
                this.fqName_ = 0;
                this.companionObjectName_ = 0;
                this.bitField0_ = i & (-8);
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -9;
                this.supertype_ = Collections.emptyList();
                this.bitField0_ &= -17;
                this.supertypeId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.nestedClassName_ = Collections.emptyList();
                this.bitField0_ &= -65;
                this.contextReceiverType_ = Collections.emptyList();
                this.bitField0_ &= -129;
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.bitField0_ &= -257;
                this.constructor_ = Collections.emptyList();
                this.bitField0_ &= -513;
                this.function_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                this.property_ = Collections.emptyList();
                this.bitField0_ &= -2049;
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= -4097;
                this.enumEntry_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                this.sealedSubclassFqName_ = Collections.emptyList();
                int i2 = this.bitField0_;
                this.inlineClassUnderlyingPropertyName_ = 0;
                this.bitField0_ = i2 & (-49153);
                this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
                int i3 = this.bitField0_;
                this.inlineClassUnderlyingTypeId_ = 0;
                this.bitField0_ = i3 & (-196609);
                this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
                this.bitField0_ &= -262145;
                this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
                this.bitField0_ &= -524289;
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
                this.bitField0_ &= -1048577;
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= -2097153;
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -4194305;
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                this.bitField0_ &= -8388609;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Class build() {
                Class buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Class buildPartial() {
                Class r0 = new Class(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                r0.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                r0.fqName_ = this.fqName_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                r0.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -9;
                }
                r0.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= -17;
                }
                r0.supertype_ = this.supertype_;
                if ((this.bitField0_ & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= -33;
                }
                r0.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= -65;
                }
                r0.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 128) == 128) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -129;
                }
                r0.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -257;
                }
                r0.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 512) == 512) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= -513;
                }
                r0.constructor_ = this.constructor_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -1025;
                }
                r0.function_ = this.function_;
                if ((this.bitField0_ & 2048) == 2048) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -2049;
                }
                r0.property_ = this.property_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -4097;
                }
                r0.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= -8193;
                }
                r0.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 16384) == 16384) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= -16385;
                }
                r0.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((i & 32768) == 32768) {
                    i2 |= 8;
                }
                r0.inlineClassUnderlyingPropertyName_ = this.inlineClassUnderlyingPropertyName_;
                if ((i & 65536) == 65536) {
                    i2 |= 16;
                }
                r0.inlineClassUnderlyingType_ = this.inlineClassUnderlyingType_;
                if ((i & 131072) == 131072) {
                    i2 |= 32;
                }
                r0.inlineClassUnderlyingTypeId_ = this.inlineClassUnderlyingTypeId_;
                if ((this.bitField0_ & 262144) == 262144) {
                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ &= -262145;
                }
                r0.multiFieldValueClassUnderlyingName_ = this.multiFieldValueClassUnderlyingName_;
                if ((this.bitField0_ & 524288) == 524288) {
                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ &= -524289;
                }
                r0.multiFieldValueClassUnderlyingType_ = this.multiFieldValueClassUnderlyingType_;
                if ((this.bitField0_ & 1048576) == 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ &= -1048577;
                }
                r0.multiFieldValueClassUnderlyingTypeId_ = this.multiFieldValueClassUnderlyingTypeId_;
                if ((i & 2097152) == 2097152) {
                    i2 |= 64;
                }
                r0.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4194304) == 4194304) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4194305;
                }
                r0.versionRequirement_ = this.versionRequirement_;
                if ((i & 8388608) == 8388608) {
                    i2 |= 128;
                }
                r0.versionRequirementTable_ = this.versionRequirementTable_;
                r0.bitField0_ = i2;
                return r0;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Class r3) {
                if (r3 == Class.getDefaultInstance()) {
                    return this;
                }
                if (r3.hasFlags()) {
                    setFlags(r3.getFlags());
                }
                if (r3.hasFqName()) {
                    setFqName(r3.getFqName());
                }
                if (r3.hasCompanionObjectName()) {
                    setCompanionObjectName(r3.getCompanionObjectName());
                }
                if (!r3.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = r3.typeParameter_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(r3.typeParameter_);
                    }
                }
                if (!r3.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = r3.supertype_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureSupertypeIsMutable();
                        this.supertype_.addAll(r3.supertype_);
                    }
                }
                if (!r3.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = r3.supertypeId_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureSupertypeIdIsMutable();
                        this.supertypeId_.addAll(r3.supertypeId_);
                    }
                }
                if (!r3.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = r3.nestedClassName_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureNestedClassNameIsMutable();
                        this.nestedClassName_.addAll(r3.nestedClassName_);
                    }
                }
                if (!r3.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = r3.contextReceiverType_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(r3.contextReceiverType_);
                    }
                }
                if (!r3.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = r3.contextReceiverTypeId_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(r3.contextReceiverTypeId_);
                    }
                }
                if (!r3.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = r3.constructor_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureConstructorIsMutable();
                        this.constructor_.addAll(r3.constructor_);
                    }
                }
                if (!r3.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = r3.function_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(r3.function_);
                    }
                }
                if (!r3.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = r3.property_;
                        this.bitField0_ &= -2049;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(r3.property_);
                    }
                }
                if (!r3.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = r3.typeAlias_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(r3.typeAlias_);
                    }
                }
                if (!r3.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = r3.enumEntry_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureEnumEntryIsMutable();
                        this.enumEntry_.addAll(r3.enumEntry_);
                    }
                }
                if (!r3.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = r3.sealedSubclassFqName_;
                        this.bitField0_ &= -16385;
                    } else {
                        ensureSealedSubclassFqNameIsMutable();
                        this.sealedSubclassFqName_.addAll(r3.sealedSubclassFqName_);
                    }
                }
                if (r3.hasInlineClassUnderlyingPropertyName()) {
                    setInlineClassUnderlyingPropertyName(r3.getInlineClassUnderlyingPropertyName());
                }
                if (r3.hasInlineClassUnderlyingType()) {
                    mergeInlineClassUnderlyingType(r3.getInlineClassUnderlyingType());
                }
                if (r3.hasInlineClassUnderlyingTypeId()) {
                    setInlineClassUnderlyingTypeId(r3.getInlineClassUnderlyingTypeId());
                }
                if (!r3.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingName_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingName_ = r3.multiFieldValueClassUnderlyingName_;
                        this.bitField0_ &= -262145;
                    } else {
                        ensureMultiFieldValueClassUnderlyingNameIsMutable();
                        this.multiFieldValueClassUnderlyingName_.addAll(r3.multiFieldValueClassUnderlyingName_);
                    }
                }
                if (!r3.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingType_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingType_ = r3.multiFieldValueClassUnderlyingType_;
                        this.bitField0_ &= -524289;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                        this.multiFieldValueClassUnderlyingType_.addAll(r3.multiFieldValueClassUnderlyingType_);
                    }
                }
                if (!r3.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingTypeId_ = r3.multiFieldValueClassUnderlyingTypeId_;
                        this.bitField0_ &= -1048577;
                    } else {
                        ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                        this.multiFieldValueClassUnderlyingTypeId_.addAll(r3.multiFieldValueClassUnderlyingTypeId_);
                    }
                }
                if (r3.hasTypeTable()) {
                    mergeTypeTable(r3.getTypeTable());
                }
                if (!r3.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = r3.versionRequirement_;
                        this.bitField0_ &= -4194305;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(r3.versionRequirement_);
                    }
                }
                if (r3.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(r3.getVersionRequirementTable());
                }
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(r3.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasFqName()) {
                    for (int i = 0; i < getTypeParameterCount(); i++) {
                        if (!getTypeParameter(i).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
                        if (!getSupertype(i2).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i3 = 0; i3 < getContextReceiverTypeCount(); i3++) {
                        if (!getContextReceiverType(i3).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                        if (!getConstructor(i4).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                        if (!getFunction(i5).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                        if (!getProperty(i6).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                        if (!getTypeAlias(i7).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                        if (!getEnumEntry(i8).isInitialized()) {
                            return false;
                        }
                    }
                    if (!hasInlineClassUnderlyingType() || getInlineClassUnderlyingType().isInitialized()) {
                        for (int i9 = 0; i9 < getMultiFieldValueClassUnderlyingTypeCount(); i9++) {
                            if (!getMultiFieldValueClassUnderlyingType(i9).isInitialized()) {
                                return false;
                            }
                        }
                        return (!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized();
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Class r0 = null;
                try {
                    try {
                        Class parsePartialFrom = Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Class r4 = (Class) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            r0 = r4;
                            if (r0 != null) {
                                mergeFrom(r0);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r0 != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 6;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasFqName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getFqName() {
                return this.fqName_;
            }

            public Builder setFqName(int i) {
                this.bitField0_ |= 2;
                this.fqName_ = i;
                return this;
            }

            public Builder clearFqName() {
                this.bitField0_ &= -3;
                this.fqName_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasCompanionObjectName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getCompanionObjectName() {
                return this.companionObjectName_;
            }

            public Builder setCompanionObjectName(int i) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = i;
                return this;
            }

            public Builder clearCompanionObjectName() {
                this.bitField0_ &= -5;
                this.companionObjectName_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public Builder setTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, typeParameter);
                return this;
            }

            public Builder setTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, builder.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(typeParameter);
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, typeParameter);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(builder.build());
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, builder.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> iterable) {
                ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder removeTypeParameter(int i) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.remove(i);
                return this;
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.supertype_ = new ArrayList(this.supertype_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Type> getSupertypeList() {
                return Collections.unmodifiableList(this.supertype_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Type getSupertype(int i) {
                return this.supertype_.get(i);
            }

            public Builder setSupertype(int i, Type type) {
                type.getClass();
                ensureSupertypeIsMutable();
                this.supertype_.set(i, type);
                return this;
            }

            public Builder setSupertype(int i, Type.Builder builder) {
                ensureSupertypeIsMutable();
                this.supertype_.set(i, builder.build());
                return this;
            }

            public Builder addSupertype(Type type) {
                type.getClass();
                ensureSupertypeIsMutable();
                this.supertype_.add(type);
                return this;
            }

            public Builder addSupertype(int i, Type type) {
                type.getClass();
                ensureSupertypeIsMutable();
                this.supertype_.add(i, type);
                return this;
            }

            public Builder addSupertype(Type.Builder builder) {
                ensureSupertypeIsMutable();
                this.supertype_.add(builder.build());
                return this;
            }

            public Builder addSupertype(int i, Type.Builder builder) {
                ensureSupertypeIsMutable();
                this.supertype_.add(i, builder.build());
                return this;
            }

            public Builder addAllSupertype(Iterable<? extends Type> iterable) {
                ensureSupertypeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.supertype_);
                return this;
            }

            public Builder clearSupertype() {
                this.supertype_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder removeSupertype(int i) {
                ensureSupertypeIsMutable();
                this.supertype_.remove(i);
                return this;
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.supertypeId_ = new ArrayList(this.supertypeId_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getSupertypeIdList() {
                return Collections.unmodifiableList(this.supertypeId_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getSupertypeIdCount() {
                return this.supertypeId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getSupertypeId(int i) {
                return this.supertypeId_.get(i).intValue();
            }

            public Builder setSupertypeId(int i, int i2) {
                ensureSupertypeIdIsMutable();
                this.supertypeId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addSupertypeId(int i) {
                ensureSupertypeIdIsMutable();
                this.supertypeId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllSupertypeId(Iterable<? extends Integer> iterable) {
                ensureSupertypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.supertypeId_);
                return this;
            }

            public Builder clearSupertypeId() {
                this.supertypeId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getNestedClassNameList() {
                return Collections.unmodifiableList(this.nestedClassName_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getNestedClassNameCount() {
                return this.nestedClassName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getNestedClassName(int i) {
                return this.nestedClassName_.get(i).intValue();
            }

            public Builder setNestedClassName(int i, int i2) {
                ensureNestedClassNameIsMutable();
                this.nestedClassName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addNestedClassName(int i) {
                ensureNestedClassNameIsMutable();
                this.nestedClassName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllNestedClassName(Iterable<? extends Integer> iterable) {
                ensureNestedClassNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.nestedClassName_);
                return this;
            }

            public Builder clearNestedClassName() {
                this.nestedClassName_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Type> getContextReceiverTypeList() {
                return Collections.unmodifiableList(this.contextReceiverType_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Type getContextReceiverType(int i) {
                return this.contextReceiverType_.get(i);
            }

            public Builder setContextReceiverType(int i, Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.set(i, type);
                return this;
            }

            public Builder setContextReceiverType(int i, Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.set(i, builder.build());
                return this;
            }

            public Builder addContextReceiverType(Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(type);
                return this;
            }

            public Builder addContextReceiverType(int i, Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(i, type);
                return this;
            }

            public Builder addContextReceiverType(Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(builder.build());
                return this;
            }

            public Builder addContextReceiverType(int i, Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(i, builder.build());
                return this;
            }

            public Builder addAllContextReceiverType(Iterable<? extends Type> iterable) {
                ensureContextReceiverTypeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.contextReceiverType_);
                return this;
            }

            public Builder clearContextReceiverType() {
                this.contextReceiverType_ = Collections.emptyList();
                this.bitField0_ &= -129;
                return this;
            }

            public Builder removeContextReceiverType(int i) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.remove(i);
                return this;
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getContextReceiverTypeIdList() {
                return Collections.unmodifiableList(this.contextReceiverTypeId_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getContextReceiverTypeIdCount() {
                return this.contextReceiverTypeId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getContextReceiverTypeId(int i) {
                return this.contextReceiverTypeId_.get(i).intValue();
            }

            public Builder setContextReceiverTypeId(int i, int i2) {
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addContextReceiverTypeId(int i) {
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllContextReceiverTypeId(Iterable<? extends Integer> iterable) {
                ensureContextReceiverTypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.contextReceiverTypeId_);
                return this;
            }

            public Builder clearContextReceiverTypeId() {
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.bitField0_ &= -257;
                return this;
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.constructor_ = new ArrayList(this.constructor_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Constructor> getConstructorList() {
                return Collections.unmodifiableList(this.constructor_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getConstructorCount() {
                return this.constructor_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Constructor getConstructor(int i) {
                return this.constructor_.get(i);
            }

            public Builder setConstructor(int i, Constructor constructor) {
                constructor.getClass();
                ensureConstructorIsMutable();
                this.constructor_.set(i, constructor);
                return this;
            }

            public Builder setConstructor(int i, Constructor.Builder builder) {
                ensureConstructorIsMutable();
                this.constructor_.set(i, builder.build());
                return this;
            }

            public Builder addConstructor(Constructor constructor) {
                constructor.getClass();
                ensureConstructorIsMutable();
                this.constructor_.add(constructor);
                return this;
            }

            public Builder addConstructor(int i, Constructor constructor) {
                constructor.getClass();
                ensureConstructorIsMutable();
                this.constructor_.add(i, constructor);
                return this;
            }

            public Builder addConstructor(Constructor.Builder builder) {
                ensureConstructorIsMutable();
                this.constructor_.add(builder.build());
                return this;
            }

            public Builder addConstructor(int i, Constructor.Builder builder) {
                ensureConstructorIsMutable();
                this.constructor_.add(i, builder.build());
                return this;
            }

            public Builder addAllConstructor(Iterable<? extends Constructor> iterable) {
                ensureConstructorIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.constructor_);
                return this;
            }

            public Builder clearConstructor() {
                this.constructor_ = Collections.emptyList();
                this.bitField0_ &= -513;
                return this;
            }

            public Builder removeConstructor(int i) {
                ensureConstructorIsMutable();
                this.constructor_.remove(i);
                return this;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1024;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Function> getFunctionList() {
                return Collections.unmodifiableList(this.function_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getFunctionCount() {
                return this.function_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Function getFunction(int i) {
                return this.function_.get(i);
            }

            public Builder setFunction(int i, Function function) {
                function.getClass();
                ensureFunctionIsMutable();
                this.function_.set(i, function);
                return this;
            }

            public Builder setFunction(int i, Function.Builder builder) {
                ensureFunctionIsMutable();
                this.function_.set(i, builder.build());
                return this;
            }

            public Builder addFunction(Function function) {
                function.getClass();
                ensureFunctionIsMutable();
                this.function_.add(function);
                return this;
            }

            public Builder addFunction(int i, Function function) {
                function.getClass();
                ensureFunctionIsMutable();
                this.function_.add(i, function);
                return this;
            }

            public Builder addFunction(Function.Builder builder) {
                ensureFunctionIsMutable();
                this.function_.add(builder.build());
                return this;
            }

            public Builder addFunction(int i, Function.Builder builder) {
                ensureFunctionIsMutable();
                this.function_.add(i, builder.build());
                return this;
            }

            public Builder addAllFunction(Iterable<? extends Function> iterable) {
                ensureFunctionIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.function_);
                return this;
            }

            public Builder clearFunction() {
                this.function_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                return this;
            }

            public Builder removeFunction(int i) {
                ensureFunctionIsMutable();
                this.function_.remove(i);
                return this;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) != 2048) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2048;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Property> getPropertyList() {
                return Collections.unmodifiableList(this.property_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getPropertyCount() {
                return this.property_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Property getProperty(int i) {
                return this.property_.get(i);
            }

            public Builder setProperty(int i, Property property) {
                property.getClass();
                ensurePropertyIsMutable();
                this.property_.set(i, property);
                return this;
            }

            public Builder setProperty(int i, Property.Builder builder) {
                ensurePropertyIsMutable();
                this.property_.set(i, builder.build());
                return this;
            }

            public Builder addProperty(Property property) {
                property.getClass();
                ensurePropertyIsMutable();
                this.property_.add(property);
                return this;
            }

            public Builder addProperty(int i, Property property) {
                property.getClass();
                ensurePropertyIsMutable();
                this.property_.add(i, property);
                return this;
            }

            public Builder addProperty(Property.Builder builder) {
                ensurePropertyIsMutable();
                this.property_.add(builder.build());
                return this;
            }

            public Builder addProperty(int i, Property.Builder builder) {
                ensurePropertyIsMutable();
                this.property_.add(i, builder.build());
                return this;
            }

            public Builder addAllProperty(Iterable<? extends Property> iterable) {
                ensurePropertyIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.property_);
                return this;
            }

            public Builder clearProperty() {
                this.property_ = Collections.emptyList();
                this.bitField0_ &= -2049;
                return this;
            }

            public Builder removeProperty(int i) {
                ensurePropertyIsMutable();
                this.property_.remove(i);
                return this;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4096;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<TypeAlias> getTypeAliasList() {
                return Collections.unmodifiableList(this.typeAlias_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public TypeAlias getTypeAlias(int i) {
                return this.typeAlias_.get(i);
            }

            public Builder setTypeAlias(int i, TypeAlias typeAlias) {
                typeAlias.getClass();
                ensureTypeAliasIsMutable();
                this.typeAlias_.set(i, typeAlias);
                return this;
            }

            public Builder setTypeAlias(int i, TypeAlias.Builder builder) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.set(i, builder.build());
                return this;
            }

            public Builder addTypeAlias(TypeAlias typeAlias) {
                typeAlias.getClass();
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(typeAlias);
                return this;
            }

            public Builder addTypeAlias(int i, TypeAlias typeAlias) {
                typeAlias.getClass();
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(i, typeAlias);
                return this;
            }

            public Builder addTypeAlias(TypeAlias.Builder builder) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(builder.build());
                return this;
            }

            public Builder addTypeAlias(int i, TypeAlias.Builder builder) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(i, builder.build());
                return this;
            }

            public Builder addAllTypeAlias(Iterable<? extends TypeAlias> iterable) {
                ensureTypeAliasIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.typeAlias_);
                return this;
            }

            public Builder clearTypeAlias() {
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= -4097;
                return this;
            }

            public Builder removeTypeAlias(int i) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.remove(i);
                return this;
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.enumEntry_ = new ArrayList(this.enumEntry_);
                    this.bitField0_ |= 8192;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<EnumEntry> getEnumEntryList() {
                return Collections.unmodifiableList(this.enumEntry_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public EnumEntry getEnumEntry(int i) {
                return this.enumEntry_.get(i);
            }

            public Builder setEnumEntry(int i, EnumEntry enumEntry) {
                enumEntry.getClass();
                ensureEnumEntryIsMutable();
                this.enumEntry_.set(i, enumEntry);
                return this;
            }

            public Builder setEnumEntry(int i, EnumEntry.Builder builder) {
                ensureEnumEntryIsMutable();
                this.enumEntry_.set(i, builder.build());
                return this;
            }

            public Builder addEnumEntry(EnumEntry enumEntry) {
                enumEntry.getClass();
                ensureEnumEntryIsMutable();
                this.enumEntry_.add(enumEntry);
                return this;
            }

            public Builder addEnumEntry(int i, EnumEntry enumEntry) {
                enumEntry.getClass();
                ensureEnumEntryIsMutable();
                this.enumEntry_.add(i, enumEntry);
                return this;
            }

            public Builder addEnumEntry(EnumEntry.Builder builder) {
                ensureEnumEntryIsMutable();
                this.enumEntry_.add(builder.build());
                return this;
            }

            public Builder addEnumEntry(int i, EnumEntry.Builder builder) {
                ensureEnumEntryIsMutable();
                this.enumEntry_.add(i, builder.build());
                return this;
            }

            public Builder addAllEnumEntry(Iterable<? extends EnumEntry> iterable) {
                ensureEnumEntryIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.enumEntry_);
                return this;
            }

            public Builder clearEnumEntry() {
                this.enumEntry_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                return this;
            }

            public Builder removeEnumEntry(int i) {
                ensureEnumEntryIsMutable();
                this.enumEntry_.remove(i);
                return this;
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) != 16384) {
                    this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                    this.bitField0_ |= 16384;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getSealedSubclassFqNameList() {
                return Collections.unmodifiableList(this.sealedSubclassFqName_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getSealedSubclassFqNameCount() {
                return this.sealedSubclassFqName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getSealedSubclassFqName(int i) {
                return this.sealedSubclassFqName_.get(i).intValue();
            }

            public Builder setSealedSubclassFqName(int i, int i2) {
                ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addSealedSubclassFqName(int i) {
                ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllSealedSubclassFqName(Iterable<? extends Integer> iterable) {
                ensureSealedSubclassFqNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.sealedSubclassFqName_);
                return this;
            }

            public Builder clearSealedSubclassFqName() {
                this.sealedSubclassFqName_ = Collections.emptyList();
                this.bitField0_ &= -16385;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasInlineClassUnderlyingPropertyName() {
                return (this.bitField0_ & 32768) == 32768;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getInlineClassUnderlyingPropertyName() {
                return this.inlineClassUnderlyingPropertyName_;
            }

            public Builder setInlineClassUnderlyingPropertyName(int i) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = i;
                return this;
            }

            public Builder clearInlineClassUnderlyingPropertyName() {
                this.bitField0_ &= -32769;
                this.inlineClassUnderlyingPropertyName_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasInlineClassUnderlyingType() {
                return (this.bitField0_ & 65536) == 65536;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Builder setInlineClassUnderlyingType(Type type) {
                type.getClass();
                this.inlineClassUnderlyingType_ = type;
                this.bitField0_ |= 65536;
                return this;
            }

            public Builder setInlineClassUnderlyingType(Type.Builder builder) {
                this.inlineClassUnderlyingType_ = builder.build();
                this.bitField0_ |= 65536;
                return this;
            }

            public Builder mergeInlineClassUnderlyingType(Type type) {
                if ((this.bitField0_ & 65536) == 65536 && this.inlineClassUnderlyingType_ != Type.getDefaultInstance()) {
                    this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(type).buildPartial();
                } else {
                    this.inlineClassUnderlyingType_ = type;
                }
                this.bitField0_ |= 65536;
                return this;
            }

            public Builder clearInlineClassUnderlyingType() {
                this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
                this.bitField0_ &= -65537;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasInlineClassUnderlyingTypeId() {
                return (this.bitField0_ & 131072) == 131072;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getInlineClassUnderlyingTypeId() {
                return this.inlineClassUnderlyingTypeId_;
            }

            public Builder setInlineClassUnderlyingTypeId(int i) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = i;
                return this;
            }

            public Builder clearInlineClassUnderlyingTypeId() {
                this.bitField0_ &= -131073;
                this.inlineClassUnderlyingTypeId_ = 0;
                return this;
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) != 262144) {
                    this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ |= 262144;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
                return Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getMultiFieldValueClassUnderlyingNameCount() {
                return this.multiFieldValueClassUnderlyingName_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getMultiFieldValueClassUnderlyingName(int i) {
                return this.multiFieldValueClassUnderlyingName_.get(i).intValue();
            }

            public Builder setMultiFieldValueClassUnderlyingName(int i, int i2) {
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                this.multiFieldValueClassUnderlyingName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addMultiFieldValueClassUnderlyingName(int i) {
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllMultiFieldValueClassUnderlyingName(Iterable<? extends Integer> iterable) {
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.multiFieldValueClassUnderlyingName_);
                return this;
            }

            public Builder clearMultiFieldValueClassUnderlyingName() {
                this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
                this.bitField0_ &= -262145;
                return this;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) != 524288) {
                    this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ |= 524288;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
                return Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public Type getMultiFieldValueClassUnderlyingType(int i) {
                return this.multiFieldValueClassUnderlyingType_.get(i);
            }

            public Builder setMultiFieldValueClassUnderlyingType(int i, Type type) {
                type.getClass();
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.set(i, type);
                return this;
            }

            public Builder setMultiFieldValueClassUnderlyingType(int i, Type.Builder builder) {
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.set(i, builder.build());
                return this;
            }

            public Builder addMultiFieldValueClassUnderlyingType(Type type) {
                type.getClass();
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.add(type);
                return this;
            }

            public Builder addMultiFieldValueClassUnderlyingType(int i, Type type) {
                type.getClass();
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.add(i, type);
                return this;
            }

            public Builder addMultiFieldValueClassUnderlyingType(Type.Builder builder) {
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.add(builder.build());
                return this;
            }

            public Builder addMultiFieldValueClassUnderlyingType(int i, Type.Builder builder) {
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.add(i, builder.build());
                return this;
            }

            public Builder addAllMultiFieldValueClassUnderlyingType(Iterable<? extends Type> iterable) {
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.multiFieldValueClassUnderlyingType_);
                return this;
            }

            public Builder clearMultiFieldValueClassUnderlyingType() {
                this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
                this.bitField0_ &= -524289;
                return this;
            }

            public Builder removeMultiFieldValueClassUnderlyingType(int i) {
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.remove(i);
                return this;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) != 1048576) {
                    this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ |= 1048576;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
                return Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getMultiFieldValueClassUnderlyingTypeIdCount() {
                return this.multiFieldValueClassUnderlyingTypeId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getMultiFieldValueClassUnderlyingTypeId(int i) {
                return this.multiFieldValueClassUnderlyingTypeId_.get(i).intValue();
            }

            public Builder setMultiFieldValueClassUnderlyingTypeId(int i, int i2) {
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                this.multiFieldValueClassUnderlyingTypeId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addMultiFieldValueClassUnderlyingTypeId(int i) {
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllMultiFieldValueClassUnderlyingTypeId(Iterable<? extends Integer> iterable) {
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.multiFieldValueClassUnderlyingTypeId_);
                return this;
            }

            public Builder clearMultiFieldValueClassUnderlyingTypeId() {
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
                this.bitField0_ &= -1048577;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasTypeTable() {
                return (this.bitField0_ & 2097152) == 2097152;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder setTypeTable(TypeTable typeTable) {
                typeTable.getClass();
                this.typeTable_ = typeTable;
                this.bitField0_ |= 2097152;
                return this;
            }

            public Builder setTypeTable(TypeTable.Builder builder) {
                this.typeTable_ = builder.build();
                this.bitField0_ |= 2097152;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2097152) == 2097152 && this.typeTable_ != TypeTable.getDefaultInstance()) {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                } else {
                    this.typeTable_ = typeTable;
                }
                this.bitField0_ |= 2097152;
                return this;
            }

            public Builder clearTypeTable() {
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= -2097153;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) != 4194304) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4194304;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public List<Integer> getVersionRequirementList() {
                return Collections.unmodifiableList(this.versionRequirement_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getVersionRequirementCount() {
                return this.versionRequirement_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public int getVersionRequirement(int i) {
                return this.versionRequirement_.get(i).intValue();
            }

            public Builder setVersionRequirement(int i, int i2) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addVersionRequirement(int i) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllVersionRequirement(Iterable<? extends Integer> iterable) {
                ensureVersionRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.versionRequirement_);
                return this;
            }

            public Builder clearVersionRequirement() {
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -4194305;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public boolean hasVersionRequirementTable() {
                return (this.bitField0_ & 8388608) == 8388608;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ClassOrBuilder
            public VersionRequirementTable getVersionRequirementTable() {
                return this.versionRequirementTable_;
            }

            public Builder setVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                versionRequirementTable.getClass();
                this.versionRequirementTable_ = versionRequirementTable;
                this.bitField0_ |= 8388608;
                return this;
            }

            public Builder setVersionRequirementTable(VersionRequirementTable.Builder builder) {
                this.versionRequirementTable_ = builder.build();
                this.bitField0_ |= 8388608;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 8388608) == 8388608 && this.versionRequirementTable_ != VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                } else {
                    this.versionRequirementTable_ = versionRequirementTable;
                }
                this.bitField0_ |= 8388608;
                return this;
            }

            public Builder clearVersionRequirementTable() {
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                this.bitField0_ &= -8388609;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static final int FUNCTION_FIELD_NUMBER = 3;
        public static Parser<Package> PARSER = new AbstractParser<Package>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Package.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Package parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Package(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PROPERTY_FIELD_NUMBER = 4;
        public static final int TYPE_ALIAS_FIELD_NUMBER = 5;
        public static final int TYPE_TABLE_FIELD_NUMBER = 30;
        public static final int VERSION_REQUIREMENT_TABLE_FIELD_NUMBER = 32;
        private static final Package defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Package(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Package(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 26) {
                                if (!(z2 & true)) {
                                    this.function_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.function_.add(codedInputStream.readMessage(Function.PARSER, extensionRegistryLite));
                            } else if (readTag == 34) {
                                if (!(z2 & true)) {
                                    this.property_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.property_.add(codedInputStream.readMessage(Property.PARSER, extensionRegistryLite));
                            } else if (readTag != 42) {
                                if (readTag == 242) {
                                    builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                    TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                    this.typeTable_ = typeTable;
                                    if (builder != null) {
                                        builder.mergeFrom(typeTable);
                                        this.typeTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (readTag != 258) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    builder = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                    VersionRequirementTable versionRequirementTable = (VersionRequirementTable) codedInputStream.readMessage(VersionRequirementTable.PARSER, extensionRegistryLite);
                                    this.versionRequirementTable_ = versionRequirementTable;
                                    if (builder != null) {
                                        builder.mergeFrom(versionRequirementTable);
                                        this.versionRequirementTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.typeAlias_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.typeAlias_.add(codedInputStream.readMessage(TypeAlias.PARSER, extensionRegistryLite));
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.function_ = Collections.unmodifiableList(this.function_);
                        }
                        if (z2 & true) {
                            this.property_ = Collections.unmodifiableList(this.property_);
                        }
                        if (z2 & true) {
                            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (z2 & true) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (z2 & true) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
            Package r0 = new Package(true);
            defaultInstance = r0;
            r0.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Package> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public List<Function> getFunctionList() {
            return this.function_;
        }

        public List<? extends FunctionOrBuilder> getFunctionOrBuilderList() {
            return this.function_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public int getFunctionCount() {
            return this.function_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public Function getFunction(int i) {
            return this.function_.get(i);
        }

        public FunctionOrBuilder getFunctionOrBuilder(int i) {
            return this.function_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<? extends PropertyOrBuilder> getPropertyOrBuilderList() {
            return this.property_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public int getPropertyCount() {
            return this.property_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public Property getProperty(int i) {
            return this.property_.get(i);
        }

        public PropertyOrBuilder getPropertyOrBuilder(int i) {
            return this.property_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public List<? extends TypeAliasOrBuilder> getTypeAliasOrBuilderList() {
            return this.typeAlias_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public TypeAlias getTypeAlias(int i) {
            return this.typeAlias_.get(i);
        }

        public TypeAliasOrBuilder getTypeAliasOrBuilder(int i) {
            return this.typeAlias_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
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
            for (int i = 0; i < getFunctionCount(); i++) {
                if (!getFunction(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getPropertyCount(); i2++) {
                if (!getProperty(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
                if (!getTypeAlias(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.function_.size(); i++) {
                codedOutputStream.writeMessage(3, this.function_.get(i));
            }
            for (int i2 = 0; i2 < this.property_.size(); i2++) {
                codedOutputStream.writeMessage(4, this.property_.get(i2));
            }
            for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
                codedOutputStream.writeMessage(5, this.typeAlias_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(32, this.versionRequirementTable_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.function_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(3, this.function_.get(i3));
            }
            for (int i4 = 0; i4 < this.property_.size(); i4++) {
                i2 += CodedOutputStream.computeMessageSize(4, this.property_.get(i4));
            }
            for (int i5 = 0; i5 < this.typeAlias_.size(); i5++) {
                i2 += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i5));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = i2 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Package parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Package parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Package parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Package parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Package parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Package parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Package parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Package parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Package parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Package parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$11600();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Package r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$11600() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.function_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.property_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= -9;
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Package build() {
                Package buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Package buildPartial() {
                Package r0 = new Package(this);
                int i = this.bitField0_;
                if ((i & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -2;
                }
                r0.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -3;
                }
                r0.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -5;
                }
                r0.typeAlias_ = this.typeAlias_;
                int i2 = (i & 8) != 8 ? 0 : 1;
                r0.typeTable_ = this.typeTable_;
                if ((i & 16) == 16) {
                    i2 |= 2;
                }
                r0.versionRequirementTable_ = this.versionRequirementTable_;
                r0.bitField0_ = i2;
                return r0;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Package r3) {
                if (r3 == Package.getDefaultInstance()) {
                    return this;
                }
                if (!r3.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = r3.function_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFunctionIsMutable();
                        this.function_.addAll(r3.function_);
                    }
                }
                if (!r3.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = r3.property_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePropertyIsMutable();
                        this.property_.addAll(r3.property_);
                    }
                }
                if (!r3.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = r3.typeAlias_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(r3.typeAlias_);
                    }
                }
                if (r3.hasTypeTable()) {
                    mergeTypeTable(r3.getTypeTable());
                }
                if (r3.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(r3.getVersionRequirementTable());
                }
                mergeExtensionFields(r3);
                setUnknownFields(getUnknownFields().concat(r3.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getFunctionCount(); i++) {
                    if (!getFunction(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getPropertyCount(); i2++) {
                    if (!getProperty(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
                    if (!getTypeAlias(i3).isInitialized()) {
                        return false;
                    }
                }
                return (!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Package r0 = null;
                try {
                    try {
                        Package parsePartialFrom = Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Package r4 = (Package) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            r0 = r4;
                            if (r0 != null) {
                                mergeFrom(r0);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r0 != null) {
                    }
                    throw th;
                }
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public List<Function> getFunctionList() {
                return Collections.unmodifiableList(this.function_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public int getFunctionCount() {
                return this.function_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public Function getFunction(int i) {
                return this.function_.get(i);
            }

            public Builder setFunction(int i, Function function) {
                function.getClass();
                ensureFunctionIsMutable();
                this.function_.set(i, function);
                return this;
            }

            public Builder setFunction(int i, Function.Builder builder) {
                ensureFunctionIsMutable();
                this.function_.set(i, builder.build());
                return this;
            }

            public Builder addFunction(Function function) {
                function.getClass();
                ensureFunctionIsMutable();
                this.function_.add(function);
                return this;
            }

            public Builder addFunction(int i, Function function) {
                function.getClass();
                ensureFunctionIsMutable();
                this.function_.add(i, function);
                return this;
            }

            public Builder addFunction(Function.Builder builder) {
                ensureFunctionIsMutable();
                this.function_.add(builder.build());
                return this;
            }

            public Builder addFunction(int i, Function.Builder builder) {
                ensureFunctionIsMutable();
                this.function_.add(i, builder.build());
                return this;
            }

            public Builder addAllFunction(Iterable<? extends Function> iterable) {
                ensureFunctionIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.function_);
                return this;
            }

            public Builder clearFunction() {
                this.function_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeFunction(int i) {
                ensureFunctionIsMutable();
                this.function_.remove(i);
                return this;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public List<Property> getPropertyList() {
                return Collections.unmodifiableList(this.property_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public int getPropertyCount() {
                return this.property_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public Property getProperty(int i) {
                return this.property_.get(i);
            }

            public Builder setProperty(int i, Property property) {
                property.getClass();
                ensurePropertyIsMutable();
                this.property_.set(i, property);
                return this;
            }

            public Builder setProperty(int i, Property.Builder builder) {
                ensurePropertyIsMutable();
                this.property_.set(i, builder.build());
                return this;
            }

            public Builder addProperty(Property property) {
                property.getClass();
                ensurePropertyIsMutable();
                this.property_.add(property);
                return this;
            }

            public Builder addProperty(int i, Property property) {
                property.getClass();
                ensurePropertyIsMutable();
                this.property_.add(i, property);
                return this;
            }

            public Builder addProperty(Property.Builder builder) {
                ensurePropertyIsMutable();
                this.property_.add(builder.build());
                return this;
            }

            public Builder addProperty(int i, Property.Builder builder) {
                ensurePropertyIsMutable();
                this.property_.add(i, builder.build());
                return this;
            }

            public Builder addAllProperty(Iterable<? extends Property> iterable) {
                ensurePropertyIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.property_);
                return this;
            }

            public Builder clearProperty() {
                this.property_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeProperty(int i) {
                ensurePropertyIsMutable();
                this.property_.remove(i);
                return this;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public List<TypeAlias> getTypeAliasList() {
                return Collections.unmodifiableList(this.typeAlias_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public TypeAlias getTypeAlias(int i) {
                return this.typeAlias_.get(i);
            }

            public Builder setTypeAlias(int i, TypeAlias typeAlias) {
                typeAlias.getClass();
                ensureTypeAliasIsMutable();
                this.typeAlias_.set(i, typeAlias);
                return this;
            }

            public Builder setTypeAlias(int i, TypeAlias.Builder builder) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.set(i, builder.build());
                return this;
            }

            public Builder addTypeAlias(TypeAlias typeAlias) {
                typeAlias.getClass();
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(typeAlias);
                return this;
            }

            public Builder addTypeAlias(int i, TypeAlias typeAlias) {
                typeAlias.getClass();
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(i, typeAlias);
                return this;
            }

            public Builder addTypeAlias(TypeAlias.Builder builder) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(builder.build());
                return this;
            }

            public Builder addTypeAlias(int i, TypeAlias.Builder builder) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.add(i, builder.build());
                return this;
            }

            public Builder addAllTypeAlias(Iterable<? extends TypeAlias> iterable) {
                ensureTypeAliasIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.typeAlias_);
                return this;
            }

            public Builder clearTypeAlias() {
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder removeTypeAlias(int i) {
                ensureTypeAliasIsMutable();
                this.typeAlias_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public boolean hasTypeTable() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder setTypeTable(TypeTable typeTable) {
                typeTable.getClass();
                this.typeTable_ = typeTable;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setTypeTable(TypeTable.Builder builder) {
                this.typeTable_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 8) == 8 && this.typeTable_ != TypeTable.getDefaultInstance()) {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                } else {
                    this.typeTable_ = typeTable;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearTypeTable() {
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public boolean hasVersionRequirementTable() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageOrBuilder
            public VersionRequirementTable getVersionRequirementTable() {
                return this.versionRequirementTable_;
            }

            public Builder setVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                versionRequirementTable.getClass();
                this.versionRequirementTable_ = versionRequirementTable;
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setVersionRequirementTable(VersionRequirementTable.Builder builder) {
                this.versionRequirementTable_ = builder.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 16) == 16 && this.versionRequirementTable_ != VersionRequirementTable.getDefaultInstance()) {
                    this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(versionRequirementTable).buildPartial();
                } else {
                    this.versionRequirementTable_ = versionRequirementTable;
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder clearVersionRequirementTable() {
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static final int FIRST_NULLABLE_FIELD_NUMBER = 2;
        public static Parser<TypeTable> PARSER = new AbstractParser<TypeTable>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.TypeTable.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public TypeTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeTable(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final TypeTable defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final ByteString unknownFields;

        private TypeTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!z2) {
                                        this.type_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.type_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                } else if (readTag != 16) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 1;
                                    this.firstNullable_ = codedInputStream.readInt32();
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
                    if (z2) {
                        this.type_ = Collections.unmodifiableList(this.type_);
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
            if (z2) {
                this.type_ = Collections.unmodifiableList(this.type_);
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
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
        public List<Type> getTypeList() {
            return this.type_;
        }

        public List<? extends TypeOrBuilder> getTypeOrBuilderList() {
            return this.type_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
        public int getTypeCount() {
            return this.type_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
        public Type getType(int i) {
            return this.type_.get(i);
        }

        public TypeOrBuilder getTypeOrBuilder(int i) {
            return this.type_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
        public boolean hasFirstNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
        public int getFirstNullable() {
            return this.firstNullable_;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
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
            for (int i = 0; i < getTypeCount(); i++) {
                if (!getType(i).isInitialized()) {
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
            for (int i = 0; i < this.type_.size(); i++) {
                codedOutputStream.writeMessage(1, this.type_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.firstNullable_);
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
            for (int i3 = 0; i3 < this.type_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.type_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TypeTable parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static TypeTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TypeTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static TypeTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TypeTable parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static TypeTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TypeTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TypeTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TypeTable parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TypeTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$12600();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeTable typeTable) {
            return newBuilder().mergeFrom(typeTable);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private List<Type> type_ = Collections.emptyList();
            private int firstNullable_ = -1;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$12600() {
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
                this.type_ = Collections.emptyList();
                int i = this.bitField0_;
                this.firstNullable_ = -1;
                this.bitField0_ = i & (-4);
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public TypeTable build() {
                TypeTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public TypeTable buildPartial() {
                TypeTable typeTable = new TypeTable(this);
                int i = this.bitField0_;
                if ((i & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= -2;
                }
                typeTable.type_ = this.type_;
                int i2 = (i & 2) != 2 ? 0 : 1;
                typeTable.firstNullable_ = this.firstNullable_;
                typeTable.bitField0_ = i2;
                return typeTable;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = typeTable.type_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTypeIsMutable();
                        this.type_.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    setFirstNullable(typeTable.getFirstNullable());
                }
                setUnknownFields(getUnknownFields().concat(typeTable.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getTypeCount(); i++) {
                    if (!getType(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeTable typeTable = null;
                try {
                    try {
                        TypeTable parsePartialFrom = TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        TypeTable typeTable2 = (TypeTable) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            typeTable = typeTable2;
                            if (typeTable != null) {
                                mergeFrom(typeTable);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (typeTable != null) {
                    }
                    throw th;
                }
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
            public List<Type> getTypeList() {
                return Collections.unmodifiableList(this.type_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
            public int getTypeCount() {
                return this.type_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
            public Type getType(int i) {
                return this.type_.get(i);
            }

            public Builder setType(int i, Type type) {
                type.getClass();
                ensureTypeIsMutable();
                this.type_.set(i, type);
                return this;
            }

            public Builder setType(int i, Type.Builder builder) {
                ensureTypeIsMutable();
                this.type_.set(i, builder.build());
                return this;
            }

            public Builder addType(Type type) {
                type.getClass();
                ensureTypeIsMutable();
                this.type_.add(type);
                return this;
            }

            public Builder addType(int i, Type type) {
                type.getClass();
                ensureTypeIsMutable();
                this.type_.add(i, type);
                return this;
            }

            public Builder addType(Type.Builder builder) {
                ensureTypeIsMutable();
                this.type_.add(builder.build());
                return this;
            }

            public Builder addType(int i, Type.Builder builder) {
                ensureTypeIsMutable();
                this.type_.add(i, builder.build());
                return this;
            }

            public Builder addAllType(Iterable<? extends Type> iterable) {
                ensureTypeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.type_);
                return this;
            }

            public Builder clearType() {
                this.type_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeType(int i) {
                ensureTypeIsMutable();
                this.type_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
            public boolean hasFirstNullable() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeTableOrBuilder
            public int getFirstNullable() {
                return this.firstNullable_;
            }

            public Builder setFirstNullable(int i) {
                this.bitField0_ |= 2;
                this.firstNullable_ = i;
                return this;
            }

            public Builder clearFirstNullable() {
                this.bitField0_ &= -3;
                this.firstNullable_ = -1;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static final int FLAGS_FIELD_NUMBER = 1;
        public static Parser<Constructor> PARSER = new AbstractParser<Constructor>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Constructor.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Constructor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Constructor(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int VALUE_PARAMETER_FIELD_NUMBER = 2;
        public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;
        private static final Constructor defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Constructor(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    if (!(z2 & true)) {
                                        this.valueParameter_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.valueParameter_.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                                } else if (readTag == 248) {
                                    if (!(z2 & true)) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (readTag != 250) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
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
                    if (z2 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if (z2 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<? extends ValueParameterOrBuilder> getValueParameterOrBuilderList() {
            return this.valueParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public ValueParameter getValueParameter(int i) {
            return this.valueParameter_.get(i);
        }

        public ValueParameterOrBuilder getValueParameterOrBuilder(int i) {
            return this.valueParameter_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public int getVersionRequirementCount() {
            return this.versionRequirement_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
        public int getVersionRequirement(int i) {
            return this.versionRequirement_.get(i).intValue();
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
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
            for (int i = 0; i < getValueParameterCount(); i++) {
                if (!getValueParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            for (int i = 0; i < this.valueParameter_.size(); i++) {
                codedOutputStream.writeMessage(2, this.valueParameter_.get(i));
            }
            for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i2));
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
            }
            int size = computeInt32Size + i3 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Constructor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Constructor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Constructor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Constructor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Constructor parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Constructor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Constructor parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Constructor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Constructor parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Constructor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$13300();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Constructor constructor) {
            return newBuilder().mergeFrom(constructor);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$13300() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.flags_ = 6;
                this.bitField0_ &= -2;
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Constructor build() {
                Constructor buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Constructor buildPartial() {
                Constructor constructor = new Constructor(this);
                int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
                constructor.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -3;
                }
                constructor.valueParameter_ = this.valueParameter_;
                if ((this.bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -5;
                }
                constructor.versionRequirement_ = this.versionRequirement_;
                constructor.bitField0_ = i;
                return constructor;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    setFlags(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = constructor.valueParameter_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = constructor.versionRequirement_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(constructor.versionRequirement_);
                    }
                }
                mergeExtensionFields(constructor);
                setUnknownFields(getUnknownFields().concat(constructor.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getValueParameterCount(); i++) {
                    if (!getValueParameter(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Constructor constructor = null;
                try {
                    try {
                        Constructor parsePartialFrom = Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Constructor constructor2 = (Constructor) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            constructor = constructor2;
                            if (constructor != null) {
                                mergeFrom(constructor);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (constructor != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 6;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public List<ValueParameter> getValueParameterList() {
                return Collections.unmodifiableList(this.valueParameter_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public ValueParameter getValueParameter(int i) {
                return this.valueParameter_.get(i);
            }

            public Builder setValueParameter(int i, ValueParameter valueParameter) {
                valueParameter.getClass();
                ensureValueParameterIsMutable();
                this.valueParameter_.set(i, valueParameter);
                return this;
            }

            public Builder setValueParameter(int i, ValueParameter.Builder builder) {
                ensureValueParameterIsMutable();
                this.valueParameter_.set(i, builder.build());
                return this;
            }

            public Builder addValueParameter(ValueParameter valueParameter) {
                valueParameter.getClass();
                ensureValueParameterIsMutable();
                this.valueParameter_.add(valueParameter);
                return this;
            }

            public Builder addValueParameter(int i, ValueParameter valueParameter) {
                valueParameter.getClass();
                ensureValueParameterIsMutable();
                this.valueParameter_.add(i, valueParameter);
                return this;
            }

            public Builder addValueParameter(ValueParameter.Builder builder) {
                ensureValueParameterIsMutable();
                this.valueParameter_.add(builder.build());
                return this;
            }

            public Builder addValueParameter(int i, ValueParameter.Builder builder) {
                ensureValueParameterIsMutable();
                this.valueParameter_.add(i, builder.build());
                return this;
            }

            public Builder addAllValueParameter(Iterable<? extends ValueParameter> iterable) {
                ensureValueParameterIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.valueParameter_);
                return this;
            }

            public Builder clearValueParameter() {
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeValueParameter(int i) {
                ensureValueParameterIsMutable();
                this.valueParameter_.remove(i);
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public List<Integer> getVersionRequirementList() {
                return Collections.unmodifiableList(this.versionRequirement_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public int getVersionRequirementCount() {
                return this.versionRequirement_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ConstructorOrBuilder
            public int getVersionRequirement(int i) {
                return this.versionRequirement_.get(i).intValue();
            }

            public Builder setVersionRequirement(int i, int i2) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addVersionRequirement(int i) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllVersionRequirement(Iterable<? extends Integer> iterable) {
                ensureVersionRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.versionRequirement_);
                return this;
            }

            public Builder clearVersionRequirement() {
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static final int CONTEXT_RECEIVER_TYPE_FIELD_NUMBER = 10;
        public static final int CONTEXT_RECEIVER_TYPE_ID_FIELD_NUMBER = 11;
        public static final int CONTRACT_FIELD_NUMBER = 32;
        public static final int FLAGS_FIELD_NUMBER = 9;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int OLD_FLAGS_FIELD_NUMBER = 1;
        public static Parser<Function> PARSER = new AbstractParser<Function>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Function.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Function parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Function(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECEIVER_TYPE_FIELD_NUMBER = 5;
        public static final int RECEIVER_TYPE_ID_FIELD_NUMBER = 8;
        public static final int RETURN_TYPE_FIELD_NUMBER = 3;
        public static final int RETURN_TYPE_ID_FIELD_NUMBER = 7;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 4;
        public static final int TYPE_TABLE_FIELD_NUMBER = 30;
        public static final int VALUE_PARAMETER_FIELD_NUMBER = 6;
        public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;
        private static final Function defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Function(boolean z) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private Function(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r5 = 1024;
                if (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.bitField0_ |= 2;
                                    this.oldFlags_ = codedInputStream.readInt32();
                                    continue;
                                case 16:
                                    this.bitField0_ |= 4;
                                    this.name_ = codedInputStream.readInt32();
                                    continue;
                                case 26:
                                    Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                    Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                    this.returnType_ = type;
                                    if (builder != null) {
                                        builder.mergeFrom(type);
                                        this.returnType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                    continue;
                                case 34:
                                    boolean z3 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z3) {
                                        this.typeParameter_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    continue;
                                case 42:
                                    Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                    Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                    this.receiverType_ = type2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(type2);
                                        this.receiverType_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 32;
                                    continue;
                                case 50:
                                    boolean z4 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z4) {
                                        this.valueParameter_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.valueParameter_.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                                    continue;
                                case 56:
                                    this.bitField0_ |= 16;
                                    this.returnTypeId_ = codedInputStream.readInt32();
                                    continue;
                                case 64:
                                    this.bitField0_ |= 64;
                                    this.receiverTypeId_ = codedInputStream.readInt32();
                                    continue;
                                case 72:
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                    continue;
                                case 82:
                                    boolean z5 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z5) {
                                        this.contextReceiverType_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.contextReceiverType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                    continue;
                                case 88:
                                    boolean z6 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z6) {
                                        this.contextReceiverTypeId_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                case 90:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    boolean z7 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z7) {
                                        z2 = z2;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.contextReceiverTypeId_ = new ArrayList();
                                            z2 = (z2 ? 1 : 0) | true;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    continue;
                                case 242:
                                    TypeTable.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                                    TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                    this.typeTable_ = typeTable;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(typeTable);
                                        this.typeTable_ = builder3.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    continue;
                                case 248:
                                    boolean z8 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z8) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 = (z2 ? 1 : 0) | true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    boolean z9 = (z2 ? 1 : 0) & true;
                                    z2 = z2;
                                    if (!z9) {
                                        z2 = z2;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 = (z2 ? 1 : 0) | true;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                    continue;
                                case 258:
                                    Contract.Builder builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                                    Contract contract = (Contract) codedInputStream.readMessage(Contract.PARSER, extensionRegistryLite);
                                    this.contract_ = contract;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(contract);
                                        this.contract_ = builder4.buildPartial();
                                    }
                                    this.bitField0_ |= 256;
                                    continue;
                                default:
                                    r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                    if (r5 == 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if ((z2 ? 1 : 0) & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((z2 ? 1 : 0) & true) == r5) {
                            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                        }
                        if ((z2 ? 1 : 0) & true) {
                            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                        }
                        if ((z2 ? 1 : 0) & true) {
                            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                        }
                        if ((z2 ? 1 : 0) & true) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } else {
                    if ((z2 ? 1 : 0) & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Function> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public Type getReturnType() {
            return this.returnType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int i) {
            return this.typeParameter_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public Type getReceiverType() {
            return this.receiverType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public List<? extends TypeOrBuilder> getContextReceiverTypeOrBuilderList() {
            return this.contextReceiverType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public Type getContextReceiverType(int i) {
            return this.contextReceiverType_.get(i);
        }

        public TypeOrBuilder getContextReceiverTypeOrBuilder(int i) {
            return this.contextReceiverType_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getContextReceiverTypeIdCount() {
            return this.contextReceiverTypeId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getContextReceiverTypeId(int i) {
            return this.contextReceiverTypeId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<? extends ValueParameterOrBuilder> getValueParameterOrBuilderList() {
            return this.valueParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public ValueParameter getValueParameter(int i) {
            return this.valueParameter_.get(i);
        }

        public ValueParameterOrBuilder getValueParameterOrBuilder(int i) {
            return this.valueParameter_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getVersionRequirementCount() {
            return this.versionRequirement_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public int getVersionRequirement(int i) {
            return this.versionRequirement_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
        public Contract getContract() {
            return this.contract_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                    if (!getContextReceiverType(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                    if (!getValueParameter(i3).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasContract() && !getContract().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
                codedOutputStream.writeMessage(6, this.valueParameter_.get(i2));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(9, this.flags_);
            }
            for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
                codedOutputStream.writeMessage(10, this.contextReceiverType_.get(i3));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(90);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.contextReceiverTypeId_.size(); i4++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i4).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(30, this.typeTable_);
            }
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i5).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(32, this.contract_);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i3));
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.flags_);
            }
            for (int i4 = 0; i4 < this.contextReceiverType_.size(); i4++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.contextReceiverTypeId_.size(); i6++) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i6).intValue());
            }
            int i7 = computeInt32Size + i5;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(i5);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i5;
            if ((this.bitField0_ & 128) == 128) {
                i7 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.versionRequirement_.size(); i9++) {
                i8 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i9).intValue());
            }
            int size = i7 + i8 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.computeMessageSize(32, this.contract_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Function parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Function parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Function parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Function parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Function parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Function parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Function parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Function parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Function parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$14100();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Function function) {
            return newBuilder().mergeFrom(function);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private int name_;
            private int receiverTypeId_;
            private int returnTypeId_;
            private int flags_ = 6;
            private int oldFlags_ = 6;
            private Type returnType_ = Type.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private Contract contract_ = Contract.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$14100() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.flags_ = 6;
                int i = this.bitField0_;
                this.oldFlags_ = 6;
                this.name_ = 0;
                this.bitField0_ = i & (-8);
                this.returnType_ = Type.getDefaultInstance();
                int i2 = this.bitField0_;
                this.returnTypeId_ = 0;
                this.bitField0_ = i2 & (-25);
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.receiverType_ = Type.getDefaultInstance();
                int i3 = this.bitField0_;
                this.receiverTypeId_ = 0;
                this.bitField0_ = i3 & (-193);
                this.contextReceiverType_ = Collections.emptyList();
                this.bitField0_ &= -257;
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.bitField0_ &= -513;
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= -2049;
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -4097;
                this.contract_ = Contract.getDefaultInstance();
                this.bitField0_ &= -8193;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Function build() {
                Function buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Function buildPartial() {
                Function function = new Function(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                function.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                function.oldFlags_ = this.oldFlags_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                function.name_ = this.name_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                function.returnType_ = this.returnType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                function.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                function.typeParameter_ = this.typeParameter_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                function.receiverType_ = this.receiverType_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                function.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                function.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                function.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -1025;
                }
                function.valueParameter_ = this.valueParameter_;
                if ((i & 2048) == 2048) {
                    i2 |= 128;
                }
                function.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -4097;
                }
                function.versionRequirement_ = this.versionRequirement_;
                if ((i & 8192) == 8192) {
                    i2 |= 256;
                }
                function.contract_ = this.contract_;
                function.bitField0_ = i2;
                return function;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    setFlags(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    setOldFlags(function.getOldFlags());
                }
                if (function.hasName()) {
                    setName(function.getName());
                }
                if (function.hasReturnType()) {
                    mergeReturnType(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    setReturnTypeId(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = function.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    mergeReceiverType(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    setReceiverTypeId(function.getReceiverTypeId());
                }
                if (!function.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = function.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(function.contextReceiverType_);
                    }
                }
                if (!function.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = function.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(function.contextReceiverTypeId_);
                    }
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = function.valueParameter_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    mergeTypeTable(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = function.versionRequirement_;
                        this.bitField0_ &= -4097;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    mergeContract(function.getContract());
                }
                mergeExtensionFields(function);
                setUnknownFields(getUnknownFields().concat(function.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName()) {
                    if (!hasReturnType() || getReturnType().isInitialized()) {
                        for (int i = 0; i < getTypeParameterCount(); i++) {
                            if (!getTypeParameter(i).isInitialized()) {
                                return false;
                            }
                        }
                        if (!hasReceiverType() || getReceiverType().isInitialized()) {
                            for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                                if (!getContextReceiverType(i2).isInitialized()) {
                                    return false;
                                }
                            }
                            for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                                if (!getValueParameter(i3).isInitialized()) {
                                    return false;
                                }
                            }
                            if (!hasTypeTable() || getTypeTable().isInitialized()) {
                                return (!hasContract() || getContract().isInitialized()) && extensionsAreInitialized();
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Function function = null;
                try {
                    try {
                        Function parsePartialFrom = Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Function function2 = (Function) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            function = function2;
                            if (function != null) {
                                mergeFrom(function);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (function != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 6;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasOldFlags() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getOldFlags() {
                return this.oldFlags_;
            }

            public Builder setOldFlags(int i) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i;
                return this;
            }

            public Builder clearOldFlags() {
                this.bitField0_ &= -3;
                this.oldFlags_ = 6;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -5;
                this.name_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder setReturnType(Type type) {
                type.getClass();
                this.returnType_ = type;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnType(Type.Builder builder) {
                this.returnType_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance()) {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                } else {
                    this.returnType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearReturnType() {
                this.returnType_ = Type.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasReturnTypeId() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getReturnTypeId() {
                return this.returnTypeId_;
            }

            public Builder setReturnTypeId(int i) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i;
                return this;
            }

            public Builder clearReturnTypeId() {
                this.bitField0_ &= -17;
                this.returnTypeId_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public Builder setTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, typeParameter);
                return this;
            }

            public Builder setTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, builder.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(typeParameter);
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, typeParameter);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(builder.build());
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, builder.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> iterable) {
                ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder removeTypeParameter(int i) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasReceiverType() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder setReceiverType(Type type) {
                type.getClass();
                this.receiverType_ = type;
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setReceiverType(Type.Builder builder) {
                this.receiverType_ = builder.build();
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) == 64 && this.receiverType_ != Type.getDefaultInstance()) {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                } else {
                    this.receiverType_ = type;
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder clearReceiverType() {
                this.receiverType_ = Type.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasReceiverTypeId() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getReceiverTypeId() {
                return this.receiverTypeId_;
            }

            public Builder setReceiverTypeId(int i) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i;
                return this;
            }

            public Builder clearReceiverTypeId() {
                this.bitField0_ &= -129;
                this.receiverTypeId_ = 0;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public List<Type> getContextReceiverTypeList() {
                return Collections.unmodifiableList(this.contextReceiverType_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public Type getContextReceiverType(int i) {
                return this.contextReceiverType_.get(i);
            }

            public Builder setContextReceiverType(int i, Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.set(i, type);
                return this;
            }

            public Builder setContextReceiverType(int i, Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.set(i, builder.build());
                return this;
            }

            public Builder addContextReceiverType(Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(type);
                return this;
            }

            public Builder addContextReceiverType(int i, Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(i, type);
                return this;
            }

            public Builder addContextReceiverType(Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(builder.build());
                return this;
            }

            public Builder addContextReceiverType(int i, Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(i, builder.build());
                return this;
            }

            public Builder addAllContextReceiverType(Iterable<? extends Type> iterable) {
                ensureContextReceiverTypeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.contextReceiverType_);
                return this;
            }

            public Builder clearContextReceiverType() {
                this.contextReceiverType_ = Collections.emptyList();
                this.bitField0_ &= -257;
                return this;
            }

            public Builder removeContextReceiverType(int i) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.remove(i);
                return this;
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public List<Integer> getContextReceiverTypeIdList() {
                return Collections.unmodifiableList(this.contextReceiverTypeId_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getContextReceiverTypeIdCount() {
                return this.contextReceiverTypeId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getContextReceiverTypeId(int i) {
                return this.contextReceiverTypeId_.get(i).intValue();
            }

            public Builder setContextReceiverTypeId(int i, int i2) {
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addContextReceiverTypeId(int i) {
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllContextReceiverTypeId(Iterable<? extends Integer> iterable) {
                ensureContextReceiverTypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.contextReceiverTypeId_);
                return this;
            }

            public Builder clearContextReceiverTypeId() {
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.bitField0_ &= -513;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 1024;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public List<ValueParameter> getValueParameterList() {
                return Collections.unmodifiableList(this.valueParameter_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public ValueParameter getValueParameter(int i) {
                return this.valueParameter_.get(i);
            }

            public Builder setValueParameter(int i, ValueParameter valueParameter) {
                valueParameter.getClass();
                ensureValueParameterIsMutable();
                this.valueParameter_.set(i, valueParameter);
                return this;
            }

            public Builder setValueParameter(int i, ValueParameter.Builder builder) {
                ensureValueParameterIsMutable();
                this.valueParameter_.set(i, builder.build());
                return this;
            }

            public Builder addValueParameter(ValueParameter valueParameter) {
                valueParameter.getClass();
                ensureValueParameterIsMutable();
                this.valueParameter_.add(valueParameter);
                return this;
            }

            public Builder addValueParameter(int i, ValueParameter valueParameter) {
                valueParameter.getClass();
                ensureValueParameterIsMutable();
                this.valueParameter_.add(i, valueParameter);
                return this;
            }

            public Builder addValueParameter(ValueParameter.Builder builder) {
                ensureValueParameterIsMutable();
                this.valueParameter_.add(builder.build());
                return this;
            }

            public Builder addValueParameter(int i, ValueParameter.Builder builder) {
                ensureValueParameterIsMutable();
                this.valueParameter_.add(i, builder.build());
                return this;
            }

            public Builder addAllValueParameter(Iterable<? extends ValueParameter> iterable) {
                ensureValueParameterIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.valueParameter_);
                return this;
            }

            public Builder clearValueParameter() {
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                return this;
            }

            public Builder removeValueParameter(int i) {
                ensureValueParameterIsMutable();
                this.valueParameter_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasTypeTable() {
                return (this.bitField0_ & 2048) == 2048;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder setTypeTable(TypeTable typeTable) {
                typeTable.getClass();
                this.typeTable_ = typeTable;
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setTypeTable(TypeTable.Builder builder) {
                this.typeTable_ = builder.build();
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.bitField0_ & 2048) == 2048 && this.typeTable_ != TypeTable.getDefaultInstance()) {
                    this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(typeTable).buildPartial();
                } else {
                    this.typeTable_ = typeTable;
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder clearTypeTable() {
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= -2049;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4096;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public List<Integer> getVersionRequirementList() {
                return Collections.unmodifiableList(this.versionRequirement_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getVersionRequirementCount() {
                return this.versionRequirement_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public int getVersionRequirement(int i) {
                return this.versionRequirement_.get(i).intValue();
            }

            public Builder setVersionRequirement(int i, int i2) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addVersionRequirement(int i) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllVersionRequirement(Iterable<? extends Integer> iterable) {
                ensureVersionRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.versionRequirement_);
                return this;
            }

            public Builder clearVersionRequirement() {
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -4097;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public boolean hasContract() {
                return (this.bitField0_ & 8192) == 8192;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.FunctionOrBuilder
            public Contract getContract() {
                return this.contract_;
            }

            public Builder setContract(Contract contract) {
                contract.getClass();
                this.contract_ = contract;
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder setContract(Contract.Builder builder) {
                this.contract_ = builder.build();
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder mergeContract(Contract contract) {
                if ((this.bitField0_ & 8192) == 8192 && this.contract_ != Contract.getDefaultInstance()) {
                    this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(contract).buildPartial();
                } else {
                    this.contract_ = contract;
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public Builder clearContract() {
                this.contract_ = Contract.getDefaultInstance();
                this.bitField0_ &= -8193;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static final int CONTEXT_RECEIVER_TYPE_FIELD_NUMBER = 12;
        public static final int CONTEXT_RECEIVER_TYPE_ID_FIELD_NUMBER = 13;
        public static final int FLAGS_FIELD_NUMBER = 11;
        public static final int GETTER_FLAGS_FIELD_NUMBER = 7;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int OLD_FLAGS_FIELD_NUMBER = 1;
        public static Parser<Property> PARSER = new AbstractParser<Property>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Property.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Property(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RECEIVER_TYPE_FIELD_NUMBER = 5;
        public static final int RECEIVER_TYPE_ID_FIELD_NUMBER = 10;
        public static final int RETURN_TYPE_FIELD_NUMBER = 3;
        public static final int RETURN_TYPE_ID_FIELD_NUMBER = 9;
        public static final int SETTER_FLAGS_FIELD_NUMBER = 8;
        public static final int SETTER_VALUE_PARAMETER_FIELD_NUMBER = 6;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 4;
        public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;
        private static final Property defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> extendableBuilder) {
            super(extendableBuilder);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Property(boolean z) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r5 = 256;
                if (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = codedInputStream.readInt32();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = codedInputStream.readInt32();
                                        continue;
                                    case 26:
                                        Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.returnType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 8;
                                        continue;
                                    case 34:
                                        boolean z3 = (z2 ? 1 : 0) & true;
                                        z2 = z2;
                                        if (!z3) {
                                            this.typeParameter_ = new ArrayList();
                                            z2 = (z2 ? 1 : 0) | true;
                                        }
                                        this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                        continue;
                                    case 42:
                                        Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(type2);
                                            this.receiverType_ = builder2.buildPartial();
                                        }
                                        this.bitField0_ |= 32;
                                        continue;
                                    case 50:
                                        ValueParameter.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                        ValueParameter valueParameter = (ValueParameter) codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite);
                                        this.setterValueParameter_ = valueParameter;
                                        if (builder3 != null) {
                                            builder3.mergeFrom(valueParameter);
                                            this.setterValueParameter_ = builder3.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 256;
                                        this.getterFlags_ = codedInputStream.readInt32();
                                        continue;
                                    case 64:
                                        this.bitField0_ |= 512;
                                        this.setterFlags_ = codedInputStream.readInt32();
                                        continue;
                                    case 72:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = codedInputStream.readInt32();
                                        continue;
                                    case 80:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = codedInputStream.readInt32();
                                        continue;
                                    case 88:
                                        this.bitField0_ |= 1;
                                        this.flags_ = codedInputStream.readInt32();
                                        continue;
                                    case 98:
                                        boolean z4 = (z2 ? 1 : 0) & true;
                                        z2 = z2;
                                        if (!z4) {
                                            this.contextReceiverType_ = new ArrayList();
                                            z2 = (z2 ? 1 : 0) | true;
                                        }
                                        this.contextReceiverType_.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                                        continue;
                                    case 104:
                                        boolean z5 = (z2 ? 1 : 0) & true;
                                        z2 = z2;
                                        if (!z5) {
                                            this.contextReceiverTypeId_ = new ArrayList();
                                            z2 = (z2 ? 1 : 0) | true;
                                        }
                                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        continue;
                                    case 106:
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        boolean z6 = (z2 ? 1 : 0) & true;
                                        z2 = z2;
                                        if (!z6) {
                                            z2 = z2;
                                            if (codedInputStream.getBytesUntilLimit() > 0) {
                                                this.contextReceiverTypeId_ = new ArrayList();
                                                z2 = (z2 ? 1 : 0) | true;
                                            }
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                        continue;
                                    case 248:
                                        boolean z7 = (z2 ? 1 : 0) & true;
                                        z2 = z2;
                                        if (!z7) {
                                            this.versionRequirement_ = new ArrayList();
                                            z2 = (z2 ? 1 : 0) | true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        continue;
                                    case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                        int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        boolean z8 = (z2 ? 1 : 0) & true;
                                        z2 = z2;
                                        if (!z8) {
                                            z2 = z2;
                                            if (codedInputStream.getBytesUntilLimit() > 0) {
                                                this.versionRequirement_ = new ArrayList();
                                                z2 = (z2 ? 1 : 0) | true;
                                            }
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                        }
                                        codedInputStream.popLimit(pushLimit2);
                                        continue;
                                    default:
                                        r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
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
                        if ((z2 ? 1 : 0) & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((z2 ? 1 : 0) & true) == r5) {
                            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                        }
                        if ((z2 ? 1 : 0) & true) {
                            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                        }
                        if ((z2 ? 1 : 0) & true) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } else {
                    if ((z2 ? 1 : 0) & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if ((z2 ? 1 : 0) & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Property> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public Type getReturnType() {
            return this.returnType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int i) {
            return this.typeParameter_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public Type getReceiverType() {
            return this.receiverType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public List<? extends TypeOrBuilder> getContextReceiverTypeOrBuilderList() {
            return this.contextReceiverType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public Type getContextReceiverType(int i) {
            return this.contextReceiverType_.get(i);
        }

        public TypeOrBuilder getContextReceiverTypeOrBuilder(int i) {
            return this.contextReceiverType_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getContextReceiverTypeIdCount() {
            return this.contextReceiverTypeId_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getContextReceiverTypeId(int i) {
            return this.contextReceiverTypeId_.get(i).intValue();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getGetterFlags() {
            return this.getterFlags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getSetterFlags() {
            return this.setterFlags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getVersionRequirementCount() {
            return this.versionRequirement_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
        public int getVersionRequirement(int i) {
            return this.versionRequirement_.get(i).intValue();
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                    if (!getContextReceiverType(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(3, this.returnType_);
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt32(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt32(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(11, this.flags_);
            }
            for (int i2 = 0; i2 < this.contextReceiverType_.size(); i2++) {
                codedOutputStream.writeMessage(12, this.contextReceiverType_.get(i2));
            }
            if (getContextReceiverTypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(106);
                codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.contextReceiverTypeId_.size(); i3++) {
                codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i3).intValue());
            }
            for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i4).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
            }
            for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.contextReceiverTypeId_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i5).intValue());
            }
            int i6 = computeInt32Size + i4;
            if (!getContextReceiverTypeIdList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
                i7 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i8).intValue());
            }
            int size = i6 + i7 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Property parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Property parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Property parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Property parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Property parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Property parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Property parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Property parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Property parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Property parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$16000();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Property property) {
            return newBuilder().mergeFrom(property);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private int getterFlags_;
            private int name_;
            private int receiverTypeId_;
            private int returnTypeId_;
            private int setterFlags_;
            private int flags_ = 518;
            private int oldFlags_ = 2054;
            private Type returnType_ = Type.getDefaultInstance();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private ValueParameter setterValueParameter_ = ValueParameter.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$16000() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.flags_ = 518;
                int i = this.bitField0_;
                this.oldFlags_ = 2054;
                this.name_ = 0;
                this.bitField0_ = i & (-8);
                this.returnType_ = Type.getDefaultInstance();
                int i2 = this.bitField0_;
                this.returnTypeId_ = 0;
                this.bitField0_ = i2 & (-25);
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.receiverType_ = Type.getDefaultInstance();
                int i3 = this.bitField0_;
                this.receiverTypeId_ = 0;
                this.bitField0_ = i3 & (-193);
                this.contextReceiverType_ = Collections.emptyList();
                this.bitField0_ &= -257;
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.bitField0_ &= -513;
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                int i4 = this.bitField0_;
                this.getterFlags_ = 0;
                this.setterFlags_ = 0;
                this.bitField0_ = i4 & (-7169);
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Property build() {
                Property buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Property buildPartial() {
                Property property = new Property(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                property.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                property.oldFlags_ = this.oldFlags_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                property.name_ = this.name_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                property.returnType_ = this.returnType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                property.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                property.typeParameter_ = this.typeParameter_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                property.receiverType_ = this.receiverType_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                property.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= -257;
                }
                property.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= -513;
                }
                property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((i & 1024) == 1024) {
                    i2 |= 128;
                }
                property.setterValueParameter_ = this.setterValueParameter_;
                if ((i & 2048) == 2048) {
                    i2 |= 256;
                }
                property.getterFlags_ = this.getterFlags_;
                if ((i & 4096) == 4096) {
                    i2 |= 512;
                }
                property.setterFlags_ = this.setterFlags_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -8193;
                }
                property.versionRequirement_ = this.versionRequirement_;
                property.bitField0_ = i2;
                return property;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    setFlags(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    setOldFlags(property.getOldFlags());
                }
                if (property.hasName()) {
                    setName(property.getName());
                }
                if (property.hasReturnType()) {
                    mergeReturnType(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    setReturnTypeId(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = property.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    mergeReceiverType(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    setReceiverTypeId(property.getReceiverTypeId());
                }
                if (!property.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = property.contextReceiverType_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(property.contextReceiverType_);
                    }
                }
                if (!property.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = property.contextReceiverTypeId_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(property.contextReceiverTypeId_);
                    }
                }
                if (property.hasSetterValueParameter()) {
                    mergeSetterValueParameter(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    setGetterFlags(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    setSetterFlags(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = property.versionRequirement_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(property.versionRequirement_);
                    }
                }
                mergeExtensionFields(property);
                setUnknownFields(getUnknownFields().concat(property.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName()) {
                    if (!hasReturnType() || getReturnType().isInitialized()) {
                        for (int i = 0; i < getTypeParameterCount(); i++) {
                            if (!getTypeParameter(i).isInitialized()) {
                                return false;
                            }
                        }
                        if (!hasReceiverType() || getReceiverType().isInitialized()) {
                            for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
                                if (!getContextReceiverType(i2).isInitialized()) {
                                    return false;
                                }
                            }
                            return (!hasSetterValueParameter() || getSetterValueParameter().isInitialized()) && extensionsAreInitialized();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Property property = null;
                try {
                    try {
                        Property parsePartialFrom = Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Property property2 = (Property) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            property = property2;
                            if (property != null) {
                                mergeFrom(property);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (property != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 518;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasOldFlags() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getOldFlags() {
                return this.oldFlags_;
            }

            public Builder setOldFlags(int i) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i;
                return this;
            }

            public Builder clearOldFlags() {
                this.bitField0_ &= -3;
                this.oldFlags_ = 2054;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -5;
                this.name_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder setReturnType(Type type) {
                type.getClass();
                this.returnType_ = type;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnType(Type.Builder builder) {
                this.returnType_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance()) {
                    this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(type).buildPartial();
                } else {
                    this.returnType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearReturnType() {
                this.returnType_ = Type.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasReturnTypeId() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getReturnTypeId() {
                return this.returnTypeId_;
            }

            public Builder setReturnTypeId(int i) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i;
                return this;
            }

            public Builder clearReturnTypeId() {
                this.bitField0_ &= -17;
                this.returnTypeId_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public Builder setTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, typeParameter);
                return this;
            }

            public Builder setTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, builder.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(typeParameter);
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, typeParameter);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(builder.build());
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, builder.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> iterable) {
                ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder removeTypeParameter(int i) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasReceiverType() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder setReceiverType(Type type) {
                type.getClass();
                this.receiverType_ = type;
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setReceiverType(Type.Builder builder) {
                this.receiverType_ = builder.build();
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.bitField0_ & 64) == 64 && this.receiverType_ != Type.getDefaultInstance()) {
                    this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(type).buildPartial();
                } else {
                    this.receiverType_ = type;
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder clearReceiverType() {
                this.receiverType_ = Type.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasReceiverTypeId() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getReceiverTypeId() {
                return this.receiverTypeId_;
            }

            public Builder setReceiverTypeId(int i) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i;
                return this;
            }

            public Builder clearReceiverTypeId() {
                this.bitField0_ &= -129;
                this.receiverTypeId_ = 0;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public List<Type> getContextReceiverTypeList() {
                return Collections.unmodifiableList(this.contextReceiverType_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public Type getContextReceiverType(int i) {
                return this.contextReceiverType_.get(i);
            }

            public Builder setContextReceiverType(int i, Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.set(i, type);
                return this;
            }

            public Builder setContextReceiverType(int i, Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.set(i, builder.build());
                return this;
            }

            public Builder addContextReceiverType(Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(type);
                return this;
            }

            public Builder addContextReceiverType(int i, Type type) {
                type.getClass();
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(i, type);
                return this;
            }

            public Builder addContextReceiverType(Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(builder.build());
                return this;
            }

            public Builder addContextReceiverType(int i, Type.Builder builder) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.add(i, builder.build());
                return this;
            }

            public Builder addAllContextReceiverType(Iterable<? extends Type> iterable) {
                ensureContextReceiverTypeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.contextReceiverType_);
                return this;
            }

            public Builder clearContextReceiverType() {
                this.contextReceiverType_ = Collections.emptyList();
                this.bitField0_ &= -257;
                return this;
            }

            public Builder removeContextReceiverType(int i) {
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.remove(i);
                return this;
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public List<Integer> getContextReceiverTypeIdList() {
                return Collections.unmodifiableList(this.contextReceiverTypeId_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getContextReceiverTypeIdCount() {
                return this.contextReceiverTypeId_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getContextReceiverTypeId(int i) {
                return this.contextReceiverTypeId_.get(i).intValue();
            }

            public Builder setContextReceiverTypeId(int i, int i2) {
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addContextReceiverTypeId(int i) {
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllContextReceiverTypeId(Iterable<? extends Integer> iterable) {
                ensureContextReceiverTypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.contextReceiverTypeId_);
                return this;
            }

            public Builder clearContextReceiverTypeId() {
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.bitField0_ &= -513;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasSetterValueParameter() {
                return (this.bitField0_ & 1024) == 1024;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public Builder setSetterValueParameter(ValueParameter valueParameter) {
                valueParameter.getClass();
                this.setterValueParameter_ = valueParameter;
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder setSetterValueParameter(ValueParameter.Builder builder) {
                this.setterValueParameter_ = builder.build();
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder mergeSetterValueParameter(ValueParameter valueParameter) {
                if ((this.bitField0_ & 1024) == 1024 && this.setterValueParameter_ != ValueParameter.getDefaultInstance()) {
                    this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(valueParameter).buildPartial();
                } else {
                    this.setterValueParameter_ = valueParameter;
                }
                this.bitField0_ |= 1024;
                return this;
            }

            public Builder clearSetterValueParameter() {
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                this.bitField0_ &= -1025;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasGetterFlags() {
                return (this.bitField0_ & 2048) == 2048;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getGetterFlags() {
                return this.getterFlags_;
            }

            public Builder setGetterFlags(int i) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = i;
                return this;
            }

            public Builder clearGetterFlags() {
                this.bitField0_ &= -2049;
                this.getterFlags_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public boolean hasSetterFlags() {
                return (this.bitField0_ & 4096) == 4096;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getSetterFlags() {
                return this.setterFlags_;
            }

            public Builder setSetterFlags(int i) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = i;
                return this;
            }

            public Builder clearSetterFlags() {
                this.bitField0_ &= -4097;
                this.setterFlags_ = 0;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 8192;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public List<Integer> getVersionRequirementList() {
                return Collections.unmodifiableList(this.versionRequirement_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getVersionRequirementCount() {
                return this.versionRequirement_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PropertyOrBuilder
            public int getVersionRequirement(int i) {
                return this.versionRequirement_.get(i).intValue();
            }

            public Builder setVersionRequirement(int i, int i2) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addVersionRequirement(int i) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllVersionRequirement(Iterable<? extends Integer> iterable) {
                ensureVersionRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.versionRequirement_);
                return this;
            }

            public Builder clearVersionRequirement() {
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static final int FLAGS_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        public static Parser<ValueParameter> PARSER = new AbstractParser<ValueParameter>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameter.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public ValueParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ValueParameter(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_FIELD_NUMBER = 3;
        public static final int TYPE_ID_FIELD_NUMBER = 5;
        public static final int VARARG_ELEMENT_TYPE_FIELD_NUMBER = 4;
        public static final int VARARG_ELEMENT_TYPE_ID_FIELD_NUMBER = 6;
        private static final ValueParameter defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final ByteString unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private ValueParameter(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Type.Builder builder;
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
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                } else if (readTag != 16) {
                                    if (readTag == 26) {
                                        builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                        Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.mergeFrom(type);
                                            this.type_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (readTag == 34) {
                                        builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                        Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                        this.varargElementType_ = type2;
                                        if (builder != null) {
                                            builder.mergeFrom(type2);
                                            this.varargElementType_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 16;
                                    } else if (readTag == 40) {
                                        this.bitField0_ |= 8;
                                        this.typeId_ = codedInputStream.readInt32();
                                    } else if (readTag != 48) {
                                        if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.varargElementTypeId_ = codedInputStream.readInt32();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readInt32();
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
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public Type getType() {
            return this.type_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public int getTypeId() {
            return this.typeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.varargElementTypeId_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
            }
            int extensionsSerializedSize = computeInt32Size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ValueParameter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ValueParameter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ValueParameter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ValueParameter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ValueParameter parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ValueParameter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ValueParameter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ValueParameter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ValueParameter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ValueParameter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$17900();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ValueParameter valueParameter) {
            return newBuilder().mergeFrom(valueParameter);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private int varargElementTypeId_;
            private Type type_ = Type.getDefaultInstance();
            private Type varargElementType_ = Type.getDefaultInstance();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$17900() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.flags_ = 0;
                int i = this.bitField0_;
                this.name_ = 0;
                this.bitField0_ = i & (-4);
                this.type_ = Type.getDefaultInstance();
                int i2 = this.bitField0_;
                this.typeId_ = 0;
                this.bitField0_ = i2 & (-13);
                this.varargElementType_ = Type.getDefaultInstance();
                int i3 = this.bitField0_;
                this.varargElementTypeId_ = 0;
                this.bitField0_ = i3 & (-49);
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public ValueParameter buildPartial() {
                ValueParameter valueParameter = new ValueParameter(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                valueParameter.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                valueParameter.name_ = this.name_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                valueParameter.type_ = this.type_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                valueParameter.typeId_ = this.typeId_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                valueParameter.varargElementType_ = this.varargElementType_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                valueParameter.varargElementTypeId_ = this.varargElementTypeId_;
                valueParameter.bitField0_ = i2;
                return valueParameter;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    setFlags(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    setName(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    mergeType(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    setTypeId(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    mergeVarargElementType(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    setVarargElementTypeId(valueParameter.getVarargElementTypeId());
                }
                mergeExtensionFields(valueParameter);
                setUnknownFields(getUnknownFields().concat(valueParameter.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName()) {
                    if (!hasType() || getType().isInitialized()) {
                        return (!hasVarargElementType() || getVarargElementType().isInitialized()) && extensionsAreInitialized();
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ValueParameter valueParameter = null;
                try {
                    try {
                        ValueParameter parsePartialFrom = ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        ValueParameter valueParameter2 = (ValueParameter) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            valueParameter = valueParameter2;
                            if (valueParameter != null) {
                                mergeFrom(valueParameter);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (valueParameter != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -3;
                this.name_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public boolean hasType() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public Type getType() {
                return this.type_;
            }

            public Builder setType(Type type) {
                type.getClass();
                this.type_ = type;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setType(Type.Builder builder) {
                this.type_ = builder.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeType(Type type) {
                if ((this.bitField0_ & 4) == 4 && this.type_ != Type.getDefaultInstance()) {
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(type).buildPartial();
                } else {
                    this.type_ = type;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearType() {
                this.type_ = Type.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public boolean hasTypeId() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public int getTypeId() {
                return this.typeId_;
            }

            public Builder setTypeId(int i) {
                this.bitField0_ |= 8;
                this.typeId_ = i;
                return this;
            }

            public Builder clearTypeId() {
                this.bitField0_ &= -9;
                this.typeId_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public boolean hasVarargElementType() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public Builder setVarargElementType(Type type) {
                type.getClass();
                this.varargElementType_ = type;
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setVarargElementType(Type.Builder builder) {
                this.varargElementType_ = builder.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeVarargElementType(Type type) {
                if ((this.bitField0_ & 16) == 16 && this.varargElementType_ != Type.getDefaultInstance()) {
                    this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(type).buildPartial();
                } else {
                    this.varargElementType_ = type;
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder clearVarargElementType() {
                this.varargElementType_ = Type.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public boolean hasVarargElementTypeId() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ValueParameterOrBuilder
            public int getVarargElementTypeId() {
                return this.varargElementTypeId_;
            }

            public Builder setVarargElementTypeId(int i) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = i;
                return this;
            }

            public Builder clearVarargElementTypeId() {
                this.bitField0_ &= -33;
                this.varargElementTypeId_ = 0;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 8;
        public static final int EXPANDED_TYPE_FIELD_NUMBER = 6;
        public static final int EXPANDED_TYPE_ID_FIELD_NUMBER = 7;
        public static final int FLAGS_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        public static Parser<TypeAlias> PARSER = new AbstractParser<TypeAlias>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.TypeAlias.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public TypeAlias parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeAlias(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 3;
        public static final int UNDERLYING_TYPE_FIELD_NUMBER = 4;
        public static final int UNDERLYING_TYPE_ID_FIELD_NUMBER = 5;
        public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;
        private static final TypeAlias defaultInstance;
        private static final long serialVersionUID = 0;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private TypeAlias(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Type.Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (true) {
                ?? r5 = 128;
                if (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.readInt32();
                                    continue;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.readInt32();
                                    continue;
                                case 26:
                                    if (!(z2 & true)) {
                                        this.typeParameter_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.typeParameter_.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                                    continue;
                                case 34:
                                    builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                    Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                    this.underlyingType_ = type;
                                    if (builder != null) {
                                        builder.mergeFrom(type);
                                        this.underlyingType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                    continue;
                                case 40:
                                    this.bitField0_ |= 8;
                                    this.underlyingTypeId_ = codedInputStream.readInt32();
                                    continue;
                                case 50:
                                    builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                    Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                    this.expandedType_ = type2;
                                    if (builder != null) {
                                        builder.mergeFrom(type2);
                                        this.expandedType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                    continue;
                                case 56:
                                    this.bitField0_ |= 32;
                                    this.expandedTypeId_ = codedInputStream.readInt32();
                                    continue;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    if (!(z2 & true)) {
                                        this.annotation_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.annotation_.add(codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite));
                                    continue;
                                case 248:
                                    if (!(z2 & true)) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    continue;
                                case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    continue;
                                    break;
                                default:
                                    r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                    if (r5 == 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (Throwable th) {
                            if (z2 & true) {
                                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                            }
                            if ((z2 & true) == r5) {
                                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                            }
                            if (z2 & true) {
                                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z2 & true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getName() {
            return this.name_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int i) {
            return this.typeParameter_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public Type getExpandedType() {
            return this.expandedType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public Annotation getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        public AnnotationOrBuilder getAnnotationOrBuilder(int i) {
            return this.annotation_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getVersionRequirementCount() {
            return this.versionRequirement_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
        public int getVersionRequirement(int i) {
            return this.versionRequirement_.get(i).intValue();
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasExpandedType() && !getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
                    if (!getAnnotation(i2).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.name_);
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.writeMessage(3, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(7, this.expandedTypeId_);
            }
            for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
                codedOutputStream.writeMessage(8, this.annotation_.get(i2));
            }
            for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
                codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
            }
            for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i5).intValue());
            }
            int size = computeInt32Size + i4 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TypeAlias parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static TypeAlias parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TypeAlias parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static TypeAlias parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TypeAlias parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static TypeAlias parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TypeAlias parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TypeAlias parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$19000();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TypeAlias typeAlias) {
            return newBuilder().mergeFrom(typeAlias);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private int bitField0_;
            private int expandedTypeId_;
            private int name_;
            private int underlyingTypeId_;
            private int flags_ = 6;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type underlyingType_ = Type.getDefaultInstance();
            private Type expandedType_ = Type.getDefaultInstance();
            private List<Annotation> annotation_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$19000() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.flags_ = 6;
                int i = this.bitField0_;
                this.name_ = 0;
                this.bitField0_ = i & (-4);
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.underlyingType_ = Type.getDefaultInstance();
                int i2 = this.bitField0_;
                this.underlyingTypeId_ = 0;
                this.bitField0_ = i2 & (-25);
                this.expandedType_ = Type.getDefaultInstance();
                int i3 = this.bitField0_;
                this.expandedTypeId_ = 0;
                this.bitField0_ = i3 & (-97);
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= -129;
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -257;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public TypeAlias build() {
                TypeAlias buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public TypeAlias buildPartial() {
                TypeAlias typeAlias = new TypeAlias(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                typeAlias.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                typeAlias.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -5;
                }
                typeAlias.typeParameter_ = this.typeParameter_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                typeAlias.underlyingType_ = this.underlyingType_;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                typeAlias.underlyingTypeId_ = this.underlyingTypeId_;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                typeAlias.expandedType_ = this.expandedType_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                typeAlias.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -129;
                }
                typeAlias.annotation_ = this.annotation_;
                if ((this.bitField0_ & 256) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -257;
                }
                typeAlias.versionRequirement_ = this.versionRequirement_;
                typeAlias.bitField0_ = i2;
                return typeAlias;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    setFlags(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    setName(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = typeAlias.typeParameter_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    mergeUnderlyingType(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    setUnderlyingTypeId(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    mergeExpandedType(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    setExpandedTypeId(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = typeAlias.annotation_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureAnnotationIsMutable();
                        this.annotation_.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = typeAlias.versionRequirement_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(typeAlias.versionRequirement_);
                    }
                }
                mergeExtensionFields(typeAlias);
                setUnknownFields(getUnknownFields().concat(typeAlias.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName()) {
                    for (int i = 0; i < getTypeParameterCount(); i++) {
                        if (!getTypeParameter(i).isInitialized()) {
                            return false;
                        }
                    }
                    if (!hasUnderlyingType() || getUnderlyingType().isInitialized()) {
                        if (!hasExpandedType() || getExpandedType().isInitialized()) {
                            for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
                                if (!getAnnotation(i2).isInitialized()) {
                                    return false;
                                }
                            }
                            return extensionsAreInitialized();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TypeAlias typeAlias = null;
                try {
                    try {
                        TypeAlias parsePartialFrom = TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        TypeAlias typeAlias2 = (TypeAlias) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            typeAlias = typeAlias2;
                            if (typeAlias != null) {
                                mergeFrom(typeAlias);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (typeAlias != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 6;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getName() {
                return this.name_;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -3;
                this.name_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public TypeParameter getTypeParameter(int i) {
                return this.typeParameter_.get(i);
            }

            public Builder setTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, typeParameter);
                return this;
            }

            public Builder setTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.set(i, builder.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(typeParameter);
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter typeParameter) {
                typeParameter.getClass();
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, typeParameter);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(builder.build());
                return this;
            }

            public Builder addTypeParameter(int i, TypeParameter.Builder builder) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.add(i, builder.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> iterable) {
                ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder removeTypeParameter(int i) {
                ensureTypeParameterIsMutable();
                this.typeParameter_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public boolean hasUnderlyingType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public Builder setUnderlyingType(Type type) {
                type.getClass();
                this.underlyingType_ = type;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setUnderlyingType(Type.Builder builder) {
                this.underlyingType_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeUnderlyingType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.underlyingType_ != Type.getDefaultInstance()) {
                    this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(type).buildPartial();
                } else {
                    this.underlyingType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearUnderlyingType() {
                this.underlyingType_ = Type.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public boolean hasUnderlyingTypeId() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getUnderlyingTypeId() {
                return this.underlyingTypeId_;
            }

            public Builder setUnderlyingTypeId(int i) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = i;
                return this;
            }

            public Builder clearUnderlyingTypeId() {
                this.bitField0_ &= -17;
                this.underlyingTypeId_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public boolean hasExpandedType() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public Type getExpandedType() {
                return this.expandedType_;
            }

            public Builder setExpandedType(Type type) {
                type.getClass();
                this.expandedType_ = type;
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setExpandedType(Type.Builder builder) {
                this.expandedType_ = builder.build();
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeExpandedType(Type type) {
                if ((this.bitField0_ & 32) == 32 && this.expandedType_ != Type.getDefaultInstance()) {
                    this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(type).buildPartial();
                } else {
                    this.expandedType_ = type;
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder clearExpandedType() {
                this.expandedType_ = Type.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public boolean hasExpandedTypeId() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getExpandedTypeId() {
                return this.expandedTypeId_;
            }

            public Builder setExpandedTypeId(int i) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = i;
                return this;
            }

            public Builder clearExpandedTypeId() {
                this.bitField0_ &= -65;
                this.expandedTypeId_ = 0;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) != 128) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(this.annotation_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public Annotation getAnnotation(int i) {
                return this.annotation_.get(i);
            }

            public Builder setAnnotation(int i, Annotation annotation) {
                annotation.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.set(i, annotation);
                return this;
            }

            public Builder setAnnotation(int i, Annotation.Builder builder) {
                ensureAnnotationIsMutable();
                this.annotation_.set(i, builder.build());
                return this;
            }

            public Builder addAnnotation(Annotation annotation) {
                annotation.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.add(annotation);
                return this;
            }

            public Builder addAnnotation(int i, Annotation annotation) {
                annotation.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.add(i, annotation);
                return this;
            }

            public Builder addAnnotation(Annotation.Builder builder) {
                ensureAnnotationIsMutable();
                this.annotation_.add(builder.build());
                return this;
            }

            public Builder addAnnotation(int i, Annotation.Builder builder) {
                ensureAnnotationIsMutable();
                this.annotation_.add(i, builder.build());
                return this;
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> iterable) {
                ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.annotation_);
                return this;
            }

            public Builder clearAnnotation() {
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= -129;
                return this;
            }

            public Builder removeAnnotation(int i) {
                ensureAnnotationIsMutable();
                this.annotation_.remove(i);
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public List<Integer> getVersionRequirementList() {
                return Collections.unmodifiableList(this.versionRequirement_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getVersionRequirementCount() {
                return this.versionRequirement_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.TypeAliasOrBuilder
            public int getVersionRequirement(int i) {
                return this.versionRequirement_.get(i).intValue();
            }

            public Builder setVersionRequirement(int i, int i2) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder addVersionRequirement(int i) {
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllVersionRequirement(Iterable<? extends Integer> iterable) {
                ensureVersionRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.versionRequirement_);
                return this;
            }

            public Builder clearVersionRequirement() {
                this.versionRequirement_ = Collections.emptyList();
                this.bitField0_ &= -257;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static Parser<EnumEntry> PARSER = new AbstractParser<EnumEntry>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.EnumEntry.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public EnumEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumEntry(codedInputStream, extensionRegistryLite);
            }
        };
        private static final EnumEntry defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private EnumEntry(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        private EnumEntry(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag != 8) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
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
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EnumEntryOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EnumEntryOrBuilder
        public int getName() {
            return this.name_;
        }

        private void initFields() {
            this.name_ = 0;
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
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = ((this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.name_) : 0) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnumEntry parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static EnumEntry parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static EnumEntry parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static EnumEntry parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static EnumEntry parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static EnumEntry parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static EnumEntry parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static EnumEntry parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static EnumEntry parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static EnumEntry parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$20400();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumEntry enumEntry) {
            return newBuilder().mergeFrom(enumEntry);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$20400() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.name_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public EnumEntry buildPartial() {
                EnumEntry enumEntry = new EnumEntry(this);
                int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
                enumEntry.name_ = this.name_;
                enumEntry.bitField0_ = i;
                return enumEntry;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    setName(enumEntry.getName());
                }
                mergeExtensionFields(enumEntry);
                setUnknownFields(getUnknownFields().concat(enumEntry.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return extensionsAreInitialized();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                EnumEntry enumEntry = null;
                try {
                    try {
                        EnumEntry parsePartialFrom = EnumEntry.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        EnumEntry enumEntry2 = (EnumEntry) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            enumEntry = enumEntry2;
                            if (enumEntry != null) {
                                mergeFrom(enumEntry);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (enumEntry != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EnumEntryOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EnumEntryOrBuilder
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
        }
    }

    /* loaded from: classes5.dex */
    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static final int ERROR_CODE_FIELD_NUMBER = 4;
        public static final int LEVEL_FIELD_NUMBER = 3;
        public static final int MESSAGE_FIELD_NUMBER = 5;
        public static Parser<VersionRequirement> PARSER = new AbstractParser<VersionRequirement>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirement.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public VersionRequirement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirement(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int VERSION_FIELD_NUMBER = 1;
        public static final int VERSION_FULL_FIELD_NUMBER = 2;
        public static final int VERSION_KIND_FIELD_NUMBER = 6;
        private static final VersionRequirement defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final ByteString unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        private VersionRequirement(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirement(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        private VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.version_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.versionFull_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    int readEnum = codedInputStream.readEnum();
                                    Level valueOf = Level.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.level_ = valueOf;
                                    }
                                } else if (readTag == 32) {
                                    this.bitField0_ |= 8;
                                    this.errorCode_ = codedInputStream.readInt32();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 16;
                                    this.message_ = codedInputStream.readInt32();
                                } else if (readTag != 48) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int readEnum2 = codedInputStream.readEnum();
                                    VersionKind valueOf2 = VersionKind.valueOf(readEnum2);
                                    if (valueOf2 == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum2);
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.versionKind_ = valueOf2;
                                    }
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
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public enum Level implements Internal.EnumLite {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);
            
            public static final int ERROR_VALUE = 1;
            public static final int HIDDEN_VALUE = 2;
            public static final int WARNING_VALUE = 0;
            private static Internal.EnumLiteMap<Level> internalValueMap = new Internal.EnumLiteMap<Level>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirement.Level.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public Level findValueByNumber(int i) {
                    return Level.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return HIDDEN;
                    }
                    return ERROR;
                }
                return WARNING;
            }

            public static Internal.EnumLiteMap<Level> internalGetValueMap() {
                return internalValueMap;
            }

            Level(int i, int i2) {
                this.value = i2;
            }
        }

        /* loaded from: classes5.dex */
        public enum VersionKind implements Internal.EnumLite {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);
            
            public static final int API_VERSION_VALUE = 2;
            public static final int COMPILER_VERSION_VALUE = 1;
            public static final int LANGUAGE_VERSION_VALUE = 0;
            private static Internal.EnumLiteMap<VersionKind> internalValueMap = new Internal.EnumLiteMap<VersionKind>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirement.VersionKind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public VersionKind findValueByNumber(int i) {
                    return VersionKind.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return API_VERSION;
                    }
                    return COMPILER_VERSION;
                }
                return LANGUAGE_VERSION;
            }

            public static Internal.EnumLiteMap<VersionKind> internalGetValueMap() {
                return internalValueMap;
            }

            VersionKind(int i, int i2) {
                this.value = i2;
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public int getVersionFull() {
            return this.versionFull_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public Level getLevel() {
            return this.level_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public int getErrorCode() {
            return this.errorCode_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public int getMessage() {
            return this.message_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
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
                codedOutputStream.writeInt32(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.version_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static VersionRequirement parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static VersionRequirement parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static VersionRequirement parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static VersionRequirement parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static VersionRequirement parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static VersionRequirement parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static VersionRequirement parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static VersionRequirement parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static VersionRequirement parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static VersionRequirement parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$21000();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().mergeFrom(versionRequirement);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private int message_;
            private int versionFull_;
            private int version_;
            private Level level_ = Level.ERROR;
            private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$21000() {
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
                this.version_ = 0;
                int i = this.bitField0_;
                this.versionFull_ = 0;
                this.bitField0_ = i & (-4);
                this.level_ = Level.ERROR;
                int i2 = this.bitField0_;
                this.errorCode_ = 0;
                this.message_ = 0;
                this.bitField0_ = i2 & (-29);
                this.versionKind_ = VersionKind.LANGUAGE_VERSION;
                this.bitField0_ &= -33;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public VersionRequirement buildPartial() {
                VersionRequirement versionRequirement = new VersionRequirement(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                versionRequirement.version_ = this.version_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                versionRequirement.versionFull_ = this.versionFull_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                versionRequirement.level_ = this.level_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                versionRequirement.errorCode_ = this.errorCode_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                versionRequirement.message_ = this.message_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                versionRequirement.versionKind_ = this.versionKind_;
                versionRequirement.bitField0_ = i2;
                return versionRequirement;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    setVersion(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    setVersionFull(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    setLevel(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    setErrorCode(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    setMessage(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    setVersionKind(versionRequirement.getVersionKind());
                }
                setUnknownFields(getUnknownFields().concat(versionRequirement.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirement versionRequirement = null;
                try {
                    try {
                        VersionRequirement parsePartialFrom = VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        VersionRequirement versionRequirement2 = (VersionRequirement) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            versionRequirement = versionRequirement2;
                            if (versionRequirement != null) {
                                mergeFrom(versionRequirement);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (versionRequirement != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public boolean hasVersion() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public int getVersion() {
                return this.version_;
            }

            public Builder setVersion(int i) {
                this.bitField0_ |= 1;
                this.version_ = i;
                return this;
            }

            public Builder clearVersion() {
                this.bitField0_ &= -2;
                this.version_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public boolean hasVersionFull() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public int getVersionFull() {
                return this.versionFull_;
            }

            public Builder setVersionFull(int i) {
                this.bitField0_ |= 2;
                this.versionFull_ = i;
                return this;
            }

            public Builder clearVersionFull() {
                this.bitField0_ &= -3;
                this.versionFull_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public boolean hasLevel() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public Level getLevel() {
                return this.level_;
            }

            public Builder setLevel(Level level) {
                level.getClass();
                this.bitField0_ |= 4;
                this.level_ = level;
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= -5;
                this.level_ = Level.ERROR;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public boolean hasErrorCode() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public int getErrorCode() {
                return this.errorCode_;
            }

            public Builder setErrorCode(int i) {
                this.bitField0_ |= 8;
                this.errorCode_ = i;
                return this;
            }

            public Builder clearErrorCode() {
                this.bitField0_ &= -9;
                this.errorCode_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public boolean hasMessage() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public int getMessage() {
                return this.message_;
            }

            public Builder setMessage(int i) {
                this.bitField0_ |= 16;
                this.message_ = i;
                return this;
            }

            public Builder clearMessage() {
                this.bitField0_ &= -17;
                this.message_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public boolean hasVersionKind() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementOrBuilder
            public VersionKind getVersionKind() {
                return this.versionKind_;
            }

            public Builder setVersionKind(VersionKind versionKind) {
                versionKind.getClass();
                this.bitField0_ |= 32;
                this.versionKind_ = versionKind;
                return this;
            }

            public Builder clearVersionKind() {
                this.bitField0_ &= -33;
                this.versionKind_ = VersionKind.LANGUAGE_VERSION;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER = new AbstractParser<VersionRequirementTable>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTable.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public VersionRequirementTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUIREMENT_FIELD_NUMBER = 1;
        private static final VersionRequirementTable defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final ByteString unknownFields;

        private VersionRequirementTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirementTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!z2) {
                                        this.requirement_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.requirement_.add(codedInputStream.readMessage(VersionRequirement.PARSER, extensionRegistryLite));
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
                    if (z2) {
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            if (z2) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTableOrBuilder
        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        public List<? extends VersionRequirementOrBuilder> getRequirementOrBuilderList() {
            return this.requirement_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTableOrBuilder
        public int getRequirementCount() {
            return this.requirement_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTableOrBuilder
        public VersionRequirement getRequirement(int i) {
            return this.requirement_.get(i);
        }

        public VersionRequirementOrBuilder getRequirementOrBuilder(int i) {
            return this.requirement_.get(i);
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
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
            for (int i = 0; i < this.requirement_.size(); i++) {
                codedOutputStream.writeMessage(1, this.requirement_.get(i));
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
            for (int i3 = 0; i3 < this.requirement_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i3));
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static VersionRequirementTable parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static VersionRequirementTable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static VersionRequirementTable parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static VersionRequirementTable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static VersionRequirementTable parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static VersionRequirementTable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static VersionRequirementTable parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static VersionRequirementTable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static VersionRequirementTable parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static VersionRequirementTable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$22100();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().mergeFrom(versionRequirementTable);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            static /* synthetic */ Builder access$22100() {
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
                this.requirement_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public VersionRequirementTable build() {
                VersionRequirementTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public VersionRequirementTable buildPartial() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    this.bitField0_ &= -2;
                }
                versionRequirementTable.requirement_ = this.requirement_;
                return versionRequirementTable;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.requirement_.isEmpty()) {
                        this.requirement_ = versionRequirementTable.requirement_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRequirementIsMutable();
                        this.requirement_.addAll(versionRequirementTable.requirement_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(versionRequirementTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                VersionRequirementTable versionRequirementTable = null;
                try {
                    try {
                        VersionRequirementTable parsePartialFrom = VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        VersionRequirementTable versionRequirementTable2 = (VersionRequirementTable) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            versionRequirementTable = versionRequirementTable2;
                            if (versionRequirementTable != null) {
                                mergeFrom(versionRequirementTable);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (versionRequirementTable != null) {
                    }
                    throw th;
                }
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.requirement_ = new ArrayList(this.requirement_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTableOrBuilder
            public List<VersionRequirement> getRequirementList() {
                return Collections.unmodifiableList(this.requirement_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTableOrBuilder
            public int getRequirementCount() {
                return this.requirement_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.VersionRequirementTableOrBuilder
            public VersionRequirement getRequirement(int i) {
                return this.requirement_.get(i);
            }

            public Builder setRequirement(int i, VersionRequirement versionRequirement) {
                versionRequirement.getClass();
                ensureRequirementIsMutable();
                this.requirement_.set(i, versionRequirement);
                return this;
            }

            public Builder setRequirement(int i, VersionRequirement.Builder builder) {
                ensureRequirementIsMutable();
                this.requirement_.set(i, builder.build());
                return this;
            }

            public Builder addRequirement(VersionRequirement versionRequirement) {
                versionRequirement.getClass();
                ensureRequirementIsMutable();
                this.requirement_.add(versionRequirement);
                return this;
            }

            public Builder addRequirement(int i, VersionRequirement versionRequirement) {
                versionRequirement.getClass();
                ensureRequirementIsMutable();
                this.requirement_.add(i, versionRequirement);
                return this;
            }

            public Builder addRequirement(VersionRequirement.Builder builder) {
                ensureRequirementIsMutable();
                this.requirement_.add(builder.build());
                return this;
            }

            public Builder addRequirement(int i, VersionRequirement.Builder builder) {
                ensureRequirementIsMutable();
                this.requirement_.add(i, builder.build());
                return this;
            }

            public Builder addAllRequirement(Iterable<? extends VersionRequirement> iterable) {
                ensureRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.requirement_);
                return this;
            }

            public Builder clearRequirement() {
                this.requirement_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeRequirement(int i) {
                ensureRequirementIsMutable();
                this.requirement_.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static final int CLASS_FIELD_NUMBER = 4;
        public static final int PACKAGE_FIELD_NUMBER = 3;
        public static Parser<PackageFragment> PARSER = new AbstractParser<PackageFragment>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragment.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public PackageFragment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageFragment(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int QUALIFIED_NAMES_FIELD_NUMBER = 2;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private static final PackageFragment defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final ByteString unknownFields;

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private PackageFragment(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PackageFragment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                StringTable.Builder builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                StringTable stringTable = (StringTable) codedInputStream.readMessage(StringTable.PARSER, extensionRegistryLite);
                                this.strings_ = stringTable;
                                if (builder != null) {
                                    builder.mergeFrom(stringTable);
                                    this.strings_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (readTag == 18) {
                                QualifiedNameTable.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                QualifiedNameTable qualifiedNameTable = (QualifiedNameTable) codedInputStream.readMessage(QualifiedNameTable.PARSER, extensionRegistryLite);
                                this.qualifiedNames_ = qualifiedNameTable;
                                if (builder2 != null) {
                                    builder2.mergeFrom(qualifiedNameTable);
                                    this.qualifiedNames_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag == 26) {
                                Package.Builder builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                Package r6 = (Package) codedInputStream.readMessage(Package.PARSER, extensionRegistryLite);
                                this.package_ = r6;
                                if (builder3 != null) {
                                    builder3.mergeFrom(r6);
                                    this.package_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (readTag != 34) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                boolean z3 = (z2 ? 1 : 0) & true;
                                z2 = z2;
                                if (!z3) {
                                    this.class__ = new ArrayList();
                                    z2 = true;
                                }
                                this.class__.add(codedInputStream.readMessage(Class.PARSER, extensionRegistryLite));
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((z2 ? 1 : 0) & true) {
                        this.class__ = Collections.unmodifiableList(this.class__);
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
            if ((z2 ? 1 : 0) & true) {
                this.class__ = Collections.unmodifiableList(this.class__);
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
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public boolean hasStrings() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public StringTable getStrings() {
            return this.strings_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public List<Class> getClass_List() {
            return this.class__;
        }

        public List<? extends ClassOrBuilder> getClass_OrBuilderList() {
            return this.class__;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public int getClass_Count() {
            return this.class__.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
        public Class getClass_(int i) {
            return this.class__.get(i);
        }

        public ClassOrBuilder getClass_OrBuilder(int i) {
            return this.class__.get(i);
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
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
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasPackage() && !getPackage().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i = 0; i < getClass_Count(); i++) {
                    if (!getClass_(i).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.package_);
            }
            for (int i = 0; i < this.class__.size(); i++) {
                codedOutputStream.writeMessage(4, this.class__.get(i));
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
            }
            for (int i2 = 0; i2 < this.class__.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
            }
            int extensionsSerializedSize = computeMessageSize + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PackageFragment parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PackageFragment parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PackageFragment parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PackageFragment parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PackageFragment parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static PackageFragment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PackageFragment parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PackageFragment parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PackageFragment parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PackageFragment parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$22600();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PackageFragment packageFragment) {
            return newBuilder().mergeFrom(packageFragment);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private StringTable strings_ = StringTable.getDefaultInstance();
            private QualifiedNameTable qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            private Package package_ = Package.getDefaultInstance();
            private List<Class> class__ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$22600() {
                return create();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.strings_ = StringTable.getDefaultInstance();
                this.bitField0_ &= -2;
                this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= -3;
                this.package_ = Package.getDefaultInstance();
                this.bitField0_ &= -5;
                this.class__ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public PackageFragment build() {
                PackageFragment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public PackageFragment buildPartial() {
                PackageFragment packageFragment = new PackageFragment(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                packageFragment.strings_ = this.strings_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                packageFragment.qualifiedNames_ = this.qualifiedNames_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                packageFragment.package_ = this.package_;
                if ((this.bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                    this.bitField0_ &= -9;
                }
                packageFragment.class__ = this.class__;
                packageFragment.bitField0_ = i2;
                return packageFragment;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    mergeStrings(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    mergeQualifiedNames(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    mergePackage(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.class__.isEmpty()) {
                        this.class__ = packageFragment.class__;
                        this.bitField0_ &= -9;
                    } else {
                        ensureClass_IsMutable();
                        this.class__.addAll(packageFragment.class__);
                    }
                }
                mergeExtensionFields(packageFragment);
                setUnknownFields(getUnknownFields().concat(packageFragment.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasQualifiedNames() || getQualifiedNames().isInitialized()) {
                    if (!hasPackage() || getPackage().isInitialized()) {
                        for (int i = 0; i < getClass_Count(); i++) {
                            if (!getClass_(i).isInitialized()) {
                                return false;
                            }
                        }
                        return extensionsAreInitialized();
                    }
                    return false;
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PackageFragment packageFragment = null;
                try {
                    try {
                        PackageFragment parsePartialFrom = PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        PackageFragment packageFragment2 = (PackageFragment) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            packageFragment = packageFragment2;
                            if (packageFragment != null) {
                                mergeFrom(packageFragment);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (packageFragment != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public boolean hasStrings() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public StringTable getStrings() {
                return this.strings_;
            }

            public Builder setStrings(StringTable stringTable) {
                stringTable.getClass();
                this.strings_ = stringTable;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setStrings(StringTable.Builder builder) {
                this.strings_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeStrings(StringTable stringTable) {
                if ((this.bitField0_ & 1) == 1 && this.strings_ != StringTable.getDefaultInstance()) {
                    this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(stringTable).buildPartial();
                } else {
                    this.strings_ = stringTable;
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder clearStrings() {
                this.strings_ = StringTable.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public boolean hasQualifiedNames() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public Builder setQualifiedNames(QualifiedNameTable qualifiedNameTable) {
                qualifiedNameTable.getClass();
                this.qualifiedNames_ = qualifiedNameTable;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setQualifiedNames(QualifiedNameTable.Builder builder) {
                this.qualifiedNames_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable qualifiedNameTable) {
                if ((this.bitField0_ & 2) == 2 && this.qualifiedNames_ != QualifiedNameTable.getDefaultInstance()) {
                    this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(qualifiedNameTable).buildPartial();
                } else {
                    this.qualifiedNames_ = qualifiedNameTable;
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearQualifiedNames() {
                this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public boolean hasPackage() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public Package getPackage() {
                return this.package_;
            }

            public Builder setPackage(Package r1) {
                r1.getClass();
                this.package_ = r1;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setPackage(Package.Builder builder) {
                this.package_ = builder.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergePackage(Package r4) {
                if ((this.bitField0_ & 4) == 4 && this.package_ != Package.getDefaultInstance()) {
                    this.package_ = Package.newBuilder(this.package_).mergeFrom(r4).buildPartial();
                } else {
                    this.package_ = r4;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearPackage() {
                this.package_ = Package.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.class__ = new ArrayList(this.class__);
                    this.bitField0_ |= 8;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public List<Class> getClass_List() {
                return Collections.unmodifiableList(this.class__);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public int getClass_Count() {
                return this.class__.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.PackageFragmentOrBuilder
            public Class getClass_(int i) {
                return this.class__.get(i);
            }

            public Builder setClass_(int i, Class r3) {
                r3.getClass();
                ensureClass_IsMutable();
                this.class__.set(i, r3);
                return this;
            }

            public Builder setClass_(int i, Class.Builder builder) {
                ensureClass_IsMutable();
                this.class__.set(i, builder.build());
                return this;
            }

            public Builder addClass_(Class r2) {
                r2.getClass();
                ensureClass_IsMutable();
                this.class__.add(r2);
                return this;
            }

            public Builder addClass_(int i, Class r3) {
                r3.getClass();
                ensureClass_IsMutable();
                this.class__.add(i, r3);
                return this;
            }

            public Builder addClass_(Class.Builder builder) {
                ensureClass_IsMutable();
                this.class__.add(builder.build());
                return this;
            }

            public Builder addClass_(int i, Class.Builder builder) {
                ensureClass_IsMutable();
                this.class__.add(i, builder.build());
                return this;
            }

            public Builder addAllClass_(Iterable<? extends Class> iterable) {
                ensureClass_IsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.class__);
                return this;
            }

            public Builder clearClass_() {
                this.class__ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder removeClass_(int i) {
                ensureClass_IsMutable();
                this.class__.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static final int EFFECT_FIELD_NUMBER = 1;
        public static Parser<Contract> PARSER = new AbstractParser<Contract>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Contract.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Contract parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Contract(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Contract defaultInstance;
        private static final long serialVersionUID = 0;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        private Contract(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Contract(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!z2) {
                                        this.effect_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.effect_.add(codedInputStream.readMessage(Effect.PARSER, extensionRegistryLite));
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
                    if (z2) {
                        this.effect_ = Collections.unmodifiableList(this.effect_);
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
            if (z2) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
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
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ContractOrBuilder
        public List<Effect> getEffectList() {
            return this.effect_;
        }

        public List<? extends EffectOrBuilder> getEffectOrBuilderList() {
            return this.effect_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ContractOrBuilder
        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ContractOrBuilder
        public Effect getEffect(int i) {
            return this.effect_.get(i);
        }

        public EffectOrBuilder getEffectOrBuilder(int i) {
            return this.effect_.get(i);
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
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
            for (int i = 0; i < getEffectCount(); i++) {
                if (!getEffect(i).isInitialized()) {
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
            for (int i = 0; i < this.effect_.size(); i++) {
                codedOutputStream.writeMessage(1, this.effect_.get(i));
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
            for (int i3 = 0; i3 < this.effect_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.effect_.get(i3));
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Contract parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Contract parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Contract parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Contract parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Contract parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Contract parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Contract parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Contract parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Contract parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Contract parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$23500();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Contract contract) {
            return newBuilder().mergeFrom(contract);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$23500() {
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
                this.effect_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Contract build() {
                Contract buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Contract buildPartial() {
                Contract contract = new Contract(this);
                if ((this.bitField0_ & 1) == 1) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                    this.bitField0_ &= -2;
                }
                contract.effect_ = this.effect_;
                return contract;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.effect_.isEmpty()) {
                        this.effect_ = contract.effect_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEffectIsMutable();
                        this.effect_.addAll(contract.effect_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(contract.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getEffectCount(); i++) {
                    if (!getEffect(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Contract contract = null;
                try {
                    try {
                        Contract parsePartialFrom = Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Contract contract2 = (Contract) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            contract = contract2;
                            if (contract != null) {
                                mergeFrom(contract);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (contract != null) {
                    }
                    throw th;
                }
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.effect_ = new ArrayList(this.effect_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ContractOrBuilder
            public List<Effect> getEffectList() {
                return Collections.unmodifiableList(this.effect_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ContractOrBuilder
            public int getEffectCount() {
                return this.effect_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ContractOrBuilder
            public Effect getEffect(int i) {
                return this.effect_.get(i);
            }

            public Builder setEffect(int i, Effect effect) {
                effect.getClass();
                ensureEffectIsMutable();
                this.effect_.set(i, effect);
                return this;
            }

            public Builder setEffect(int i, Effect.Builder builder) {
                ensureEffectIsMutable();
                this.effect_.set(i, builder.build());
                return this;
            }

            public Builder addEffect(Effect effect) {
                effect.getClass();
                ensureEffectIsMutable();
                this.effect_.add(effect);
                return this;
            }

            public Builder addEffect(int i, Effect effect) {
                effect.getClass();
                ensureEffectIsMutable();
                this.effect_.add(i, effect);
                return this;
            }

            public Builder addEffect(Effect.Builder builder) {
                ensureEffectIsMutable();
                this.effect_.add(builder.build());
                return this;
            }

            public Builder addEffect(int i, Effect.Builder builder) {
                ensureEffectIsMutable();
                this.effect_.add(i, builder.build());
                return this;
            }

            public Builder addAllEffect(Iterable<? extends Effect> iterable) {
                ensureEffectIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.effect_);
                return this;
            }

            public Builder clearEffect() {
                this.effect_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder removeEffect(int i) {
                ensureEffectIsMutable();
                this.effect_.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static final int CONCLUSION_OF_CONDITIONAL_EFFECT_FIELD_NUMBER = 3;
        public static final int EFFECT_CONSTRUCTOR_ARGUMENT_FIELD_NUMBER = 2;
        public static final int EFFECT_TYPE_FIELD_NUMBER = 1;
        public static final int KIND_FIELD_NUMBER = 4;
        public static Parser<Effect> PARSER = new AbstractParser<Effect>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Effect.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Effect parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Effect(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Effect defaultInstance;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        private Effect(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Effect(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                int readEnum = codedInputStream.readEnum();
                                EffectType valueOf = EffectType.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.effectType_ = valueOf;
                                }
                            } else if (readTag == 18) {
                                if (!(z2 & true)) {
                                    this.effectConstructorArgument_ = new ArrayList();
                                    z2 = true;
                                }
                                this.effectConstructorArgument_.add(codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite));
                            } else if (readTag == 26) {
                                Expression.Builder builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                                Expression expression = (Expression) codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite);
                                this.conclusionOfConditionalEffect_ = expression;
                                if (builder != null) {
                                    builder.mergeFrom(expression);
                                    this.conclusionOfConditionalEffect_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (readTag != 32) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                int readEnum2 = codedInputStream.readEnum();
                                InvocationKind valueOf2 = InvocationKind.valueOf(readEnum2);
                                if (valueOf2 == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum2);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf2;
                                }
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public enum EffectType implements Internal.EnumLite {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);
            
            public static final int CALLS_VALUE = 1;
            public static final int RETURNS_CONSTANT_VALUE = 0;
            public static final int RETURNS_NOT_NULL_VALUE = 2;
            private static Internal.EnumLiteMap<EffectType> internalValueMap = new Internal.EnumLiteMap<EffectType>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Effect.EffectType.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public EffectType findValueByNumber(int i) {
                    return EffectType.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return RETURNS_NOT_NULL;
                    }
                    return CALLS;
                }
                return RETURNS_CONSTANT;
            }

            public static Internal.EnumLiteMap<EffectType> internalGetValueMap() {
                return internalValueMap;
            }

            EffectType(int i, int i2) {
                this.value = i2;
            }
        }

        /* loaded from: classes5.dex */
        public enum InvocationKind implements Internal.EnumLite {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);
            
            public static final int AT_LEAST_ONCE_VALUE = 2;
            public static final int AT_MOST_ONCE_VALUE = 0;
            public static final int EXACTLY_ONCE_VALUE = 1;
            private static Internal.EnumLiteMap<InvocationKind> internalValueMap = new Internal.EnumLiteMap<InvocationKind>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Effect.InvocationKind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public InvocationKind findValueByNumber(int i) {
                    return InvocationKind.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return AT_LEAST_ONCE;
                    }
                    return EXACTLY_ONCE;
                }
                return AT_MOST_ONCE;
            }

            public static Internal.EnumLiteMap<InvocationKind> internalGetValueMap() {
                return internalValueMap;
            }

            InvocationKind(int i, int i2) {
                this.value = i2;
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public EffectType getEffectType() {
            return this.effectType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public List<Expression> getEffectConstructorArgumentList() {
            return this.effectConstructorArgument_;
        }

        public List<? extends ExpressionOrBuilder> getEffectConstructorArgumentOrBuilderList() {
            return this.effectConstructorArgument_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public Expression getEffectConstructorArgument(int i) {
            return this.effectConstructorArgument_.get(i);
        }

        public ExpressionOrBuilder getEffectConstructorArgumentOrBuilder(int i) {
            return this.effectConstructorArgument_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
        public InvocationKind getKind() {
            return this.kind_;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
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
            for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
                if (!getEffectConstructorArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasConclusionOfConditionalEffect() && !getConclusionOfConditionalEffect().isInitialized()) {
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
                codedOutputStream.writeEnum(1, this.effectType_.getNumber());
            }
            for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
                codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) : 0;
            for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
            }
            int size = computeEnumSize + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Effect parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Effect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Effect parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Effect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Effect parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Effect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Effect parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Effect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Effect parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Effect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$24000();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Effect effect) {
            return newBuilder().mergeFrom(effect);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
            private List<Expression> effectConstructorArgument_ = Collections.emptyList();
            private Expression conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$24000() {
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
                this.effectType_ = EffectType.RETURNS_CONSTANT;
                this.bitField0_ &= -2;
                this.effectConstructorArgument_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
                this.bitField0_ &= -5;
                this.kind_ = InvocationKind.AT_MOST_ONCE;
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Effect build() {
                Effect buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Effect buildPartial() {
                Effect effect = new Effect(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                effect.effectType_ = this.effectType_;
                if ((this.bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    this.bitField0_ &= -3;
                }
                effect.effectConstructorArgument_ = this.effectConstructorArgument_;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                effect.kind_ = this.kind_;
                effect.bitField0_ = i2;
                return effect;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    setEffectType(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.effectConstructorArgument_.isEmpty()) {
                        this.effectConstructorArgument_ = effect.effectConstructorArgument_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEffectConstructorArgumentIsMutable();
                        this.effectConstructorArgument_.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    mergeConclusionOfConditionalEffect(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    setKind(effect.getKind());
                }
                setUnknownFields(getUnknownFields().concat(effect.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
                    if (!getEffectConstructorArgument(i).isInitialized()) {
                        return false;
                    }
                }
                return !hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Effect effect = null;
                try {
                    try {
                        Effect parsePartialFrom = Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Effect effect2 = (Effect) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            effect = effect2;
                            if (effect != null) {
                                mergeFrom(effect);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (effect != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public boolean hasEffectType() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public EffectType getEffectType() {
                return this.effectType_;
            }

            public Builder setEffectType(EffectType effectType) {
                effectType.getClass();
                this.bitField0_ |= 1;
                this.effectType_ = effectType;
                return this;
            }

            public Builder clearEffectType() {
                this.bitField0_ &= -2;
                this.effectType_ = EffectType.RETURNS_CONSTANT;
                return this;
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public List<Expression> getEffectConstructorArgumentList() {
                return Collections.unmodifiableList(this.effectConstructorArgument_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public Expression getEffectConstructorArgument(int i) {
                return this.effectConstructorArgument_.get(i);
            }

            public Builder setEffectConstructorArgument(int i, Expression expression) {
                expression.getClass();
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.set(i, expression);
                return this;
            }

            public Builder setEffectConstructorArgument(int i, Expression.Builder builder) {
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.set(i, builder.build());
                return this;
            }

            public Builder addEffectConstructorArgument(Expression expression) {
                expression.getClass();
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.add(expression);
                return this;
            }

            public Builder addEffectConstructorArgument(int i, Expression expression) {
                expression.getClass();
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.add(i, expression);
                return this;
            }

            public Builder addEffectConstructorArgument(Expression.Builder builder) {
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.add(builder.build());
                return this;
            }

            public Builder addEffectConstructorArgument(int i, Expression.Builder builder) {
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.add(i, builder.build());
                return this;
            }

            public Builder addAllEffectConstructorArgument(Iterable<? extends Expression> iterable) {
                ensureEffectConstructorArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.effectConstructorArgument_);
                return this;
            }

            public Builder clearEffectConstructorArgument() {
                this.effectConstructorArgument_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder removeEffectConstructorArgument(int i) {
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.remove(i);
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public boolean hasConclusionOfConditionalEffect() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            public Builder setConclusionOfConditionalEffect(Expression expression) {
                expression.getClass();
                this.conclusionOfConditionalEffect_ = expression;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setConclusionOfConditionalEffect(Expression.Builder builder) {
                this.conclusionOfConditionalEffect_ = builder.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression expression) {
                if ((this.bitField0_ & 4) == 4 && this.conclusionOfConditionalEffect_ != Expression.getDefaultInstance()) {
                    this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(expression).buildPartial();
                } else {
                    this.conclusionOfConditionalEffect_ = expression;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearConclusionOfConditionalEffect() {
                this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public boolean hasKind() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.EffectOrBuilder
            public InvocationKind getKind() {
                return this.kind_;
            }

            public Builder setKind(InvocationKind invocationKind) {
                invocationKind.getClass();
                this.bitField0_ |= 8;
                this.kind_ = invocationKind;
                return this;
            }

            public Builder clearKind() {
                this.bitField0_ &= -9;
                this.kind_ = InvocationKind.AT_MOST_ONCE;
                return this;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static final int AND_ARGUMENT_FIELD_NUMBER = 6;
        public static final int CONSTANT_VALUE_FIELD_NUMBER = 3;
        public static final int FLAGS_FIELD_NUMBER = 1;
        public static final int IS_INSTANCE_TYPE_FIELD_NUMBER = 4;
        public static final int IS_INSTANCE_TYPE_ID_FIELD_NUMBER = 5;
        public static final int OR_ARGUMENT_FIELD_NUMBER = 7;
        public static Parser<Expression> PARSER = new AbstractParser<Expression>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Expression.1
            @Override // kotlinx.metadata.internal.protobuf.Parser
            public Expression parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Expression(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int VALUE_PARAMETER_REFERENCE_FIELD_NUMBER = 2;
        private static final Expression defaultInstance;
        private static final long serialVersionUID = 0;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final ByteString unknownFields;
        private int valueParameterReference_;

        private Expression(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Expression(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.flags_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.valueParameterReference_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                ConstantValue valueOf = ConstantValue.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.constantValue_ = valueOf;
                                }
                            } else if (readTag == 34) {
                                Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.isInstanceType_ = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.isInstanceType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.isInstanceTypeId_ = codedInputStream.readInt32();
                            } else if (readTag == 50) {
                                if (!(z2 & true)) {
                                    this.andArgument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.andArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                            } else if (readTag != 58) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.orArgument_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.orArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                        }
                        if (z2 & true) {
                            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if (z2 & true) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes5.dex */
        public enum ConstantValue implements Internal.EnumLite {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);
            
            public static final int FALSE_VALUE = 1;
            public static final int NULL_VALUE = 2;
            public static final int TRUE_VALUE = 0;
            private static Internal.EnumLiteMap<ConstantValue> internalValueMap = new Internal.EnumLiteMap<ConstantValue>() { // from class: kotlinx.metadata.internal.metadata.ProtoBuf.Expression.ConstantValue.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLiteMap
                public ConstantValue findValueByNumber(int i) {
                    return ConstantValue.valueOf(i);
                }
            };
            private final int value;

            @Override // kotlinx.metadata.internal.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return NULL;
                    }
                    return FALSE;
                }
                return TRUE;
            }

            public static Internal.EnumLiteMap<ConstantValue> internalGetValueMap() {
                return internalValueMap;
            }

            ConstantValue(int i, int i2) {
                this.value = i2;
            }
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public boolean hasValueParameterReference() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public List<Expression> getAndArgumentList() {
            return this.andArgument_;
        }

        public List<? extends ExpressionOrBuilder> getAndArgumentOrBuilderList() {
            return this.andArgument_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public Expression getAndArgument(int i) {
            return this.andArgument_.get(i);
        }

        public ExpressionOrBuilder getAndArgumentOrBuilder(int i) {
            return this.andArgument_.get(i);
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public List<Expression> getOrArgumentList() {
            return this.orArgument_;
        }

        public List<? extends ExpressionOrBuilder> getOrArgumentOrBuilderList() {
            return this.orArgument_;
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
        public Expression getOrArgument(int i) {
            return this.orArgument_.get(i);
        }

        public ExpressionOrBuilder getOrArgumentOrBuilder(int i) {
            return this.orArgument_.get(i);
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
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
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i = 0; i < getAndArgumentCount(); i++) {
                if (!getAndArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
                if (!getOrArgument(i2).isInitialized()) {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
            }
            for (int i = 0; i < this.andArgument_.size(); i++) {
                codedOutputStream.writeMessage(6, this.andArgument_.get(i));
            }
            for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
                codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
            }
            for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
            }
            for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Expression parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Expression parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Expression parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Expression parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Expression parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Expression parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Expression parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Expression parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Expression parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Expression parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.access$24900();
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Expression expression) {
            return newBuilder().mergeFrom(expression);
        }

        @Override // kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private int bitField0_;
            private int flags_;
            private int isInstanceTypeId_;
            private int valueParameterReference_;
            private ConstantValue constantValue_ = ConstantValue.TRUE;
            private Type isInstanceType_ = Type.getDefaultInstance();
            private List<Expression> andArgument_ = Collections.emptyList();
            private List<Expression> orArgument_ = Collections.emptyList();

            private void maybeForceBuilderInitialization() {
            }

            static /* synthetic */ Builder access$24900() {
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
                this.flags_ = 0;
                int i = this.bitField0_;
                this.valueParameterReference_ = 0;
                this.bitField0_ = i & (-4);
                this.constantValue_ = ConstantValue.TRUE;
                this.bitField0_ &= -5;
                this.isInstanceType_ = Type.getDefaultInstance();
                int i2 = this.bitField0_;
                this.isInstanceTypeId_ = 0;
                this.bitField0_ = i2 & (-25);
                this.andArgument_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.orArgument_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Expression build() {
                Expression buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Expression buildPartial() {
                Expression expression = new Expression(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                expression.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                expression.valueParameterReference_ = this.valueParameterReference_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                expression.constantValue_ = this.constantValue_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                expression.isInstanceType_ = this.isInstanceType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                expression.isInstanceTypeId_ = this.isInstanceTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    this.bitField0_ &= -33;
                }
                expression.andArgument_ = this.andArgument_;
                if ((this.bitField0_ & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    this.bitField0_ &= -65;
                }
                expression.orArgument_ = this.orArgument_;
                expression.bitField0_ = i2;
                return expression;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    setFlags(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    setValueParameterReference(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    setConstantValue(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    mergeIsInstanceType(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    setIsInstanceTypeId(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.andArgument_.isEmpty()) {
                        this.andArgument_ = expression.andArgument_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureAndArgumentIsMutable();
                        this.andArgument_.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.orArgument_.isEmpty()) {
                        this.orArgument_ = expression.orArgument_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureOrArgumentIsMutable();
                        this.orArgument_.addAll(expression.orArgument_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(expression.unknownFields));
                return this;
            }

            @Override // kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasIsInstanceType() || getIsInstanceType().isInitialized()) {
                    for (int i = 0; i < getAndArgumentCount(); i++) {
                        if (!getAndArgument(i).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
                        if (!getOrArgument(i2).isInitialized()) {
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
                Expression expression = null;
                try {
                    try {
                        Expression parsePartialFrom = Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Expression expression2 = (Expression) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            expression = expression2;
                            if (expression != null) {
                                mergeFrom(expression);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (expression != null) {
                    }
                    throw th;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= -2;
                this.flags_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public boolean hasValueParameterReference() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public int getValueParameterReference() {
                return this.valueParameterReference_;
            }

            public Builder setValueParameterReference(int i) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = i;
                return this;
            }

            public Builder clearValueParameterReference() {
                this.bitField0_ &= -3;
                this.valueParameterReference_ = 0;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public boolean hasConstantValue() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public ConstantValue getConstantValue() {
                return this.constantValue_;
            }

            public Builder setConstantValue(ConstantValue constantValue) {
                constantValue.getClass();
                this.bitField0_ |= 4;
                this.constantValue_ = constantValue;
                return this;
            }

            public Builder clearConstantValue() {
                this.bitField0_ &= -5;
                this.constantValue_ = ConstantValue.TRUE;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public boolean hasIsInstanceType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Builder setIsInstanceType(Type type) {
                type.getClass();
                this.isInstanceType_ = type;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setIsInstanceType(Type.Builder builder) {
                this.isInstanceType_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeIsInstanceType(Type type) {
                if ((this.bitField0_ & 8) == 8 && this.isInstanceType_ != Type.getDefaultInstance()) {
                    this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(type).buildPartial();
                } else {
                    this.isInstanceType_ = type;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearIsInstanceType() {
                this.isInstanceType_ = Type.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public boolean hasIsInstanceTypeId() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public int getIsInstanceTypeId() {
                return this.isInstanceTypeId_;
            }

            public Builder setIsInstanceTypeId(int i) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = i;
                return this;
            }

            public Builder clearIsInstanceTypeId() {
                this.bitField0_ &= -17;
                this.isInstanceTypeId_ = 0;
                return this;
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.andArgument_ = new ArrayList(this.andArgument_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public List<Expression> getAndArgumentList() {
                return Collections.unmodifiableList(this.andArgument_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public Expression getAndArgument(int i) {
                return this.andArgument_.get(i);
            }

            public Builder setAndArgument(int i, Expression expression) {
                expression.getClass();
                ensureAndArgumentIsMutable();
                this.andArgument_.set(i, expression);
                return this;
            }

            public Builder setAndArgument(int i, Builder builder) {
                ensureAndArgumentIsMutable();
                this.andArgument_.set(i, builder.build());
                return this;
            }

            public Builder addAndArgument(Expression expression) {
                expression.getClass();
                ensureAndArgumentIsMutable();
                this.andArgument_.add(expression);
                return this;
            }

            public Builder addAndArgument(int i, Expression expression) {
                expression.getClass();
                ensureAndArgumentIsMutable();
                this.andArgument_.add(i, expression);
                return this;
            }

            public Builder addAndArgument(Builder builder) {
                ensureAndArgumentIsMutable();
                this.andArgument_.add(builder.build());
                return this;
            }

            public Builder addAndArgument(int i, Builder builder) {
                ensureAndArgumentIsMutable();
                this.andArgument_.add(i, builder.build());
                return this;
            }

            public Builder addAllAndArgument(Iterable<? extends Expression> iterable) {
                ensureAndArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.andArgument_);
                return this;
            }

            public Builder clearAndArgument() {
                this.andArgument_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder removeAndArgument(int i) {
                ensureAndArgumentIsMutable();
                this.andArgument_.remove(i);
                return this;
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.orArgument_ = new ArrayList(this.orArgument_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public List<Expression> getOrArgumentList() {
                return Collections.unmodifiableList(this.orArgument_);
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            @Override // kotlinx.metadata.internal.metadata.ProtoBuf.ExpressionOrBuilder
            public Expression getOrArgument(int i) {
                return this.orArgument_.get(i);
            }

            public Builder setOrArgument(int i, Expression expression) {
                expression.getClass();
                ensureOrArgumentIsMutable();
                this.orArgument_.set(i, expression);
                return this;
            }

            public Builder setOrArgument(int i, Builder builder) {
                ensureOrArgumentIsMutable();
                this.orArgument_.set(i, builder.build());
                return this;
            }

            public Builder addOrArgument(Expression expression) {
                expression.getClass();
                ensureOrArgumentIsMutable();
                this.orArgument_.add(expression);
                return this;
            }

            public Builder addOrArgument(int i, Expression expression) {
                expression.getClass();
                ensureOrArgumentIsMutable();
                this.orArgument_.add(i, expression);
                return this;
            }

            public Builder addOrArgument(Builder builder) {
                ensureOrArgumentIsMutable();
                this.orArgument_.add(builder.build());
                return this;
            }

            public Builder addOrArgument(int i, Builder builder) {
                ensureOrArgumentIsMutable();
                this.orArgument_.add(i, builder.build());
                return this;
            }

            public Builder addAllOrArgument(Iterable<? extends Expression> iterable) {
                ensureOrArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.orArgument_);
                return this;
            }

            public Builder clearOrArgument() {
                this.orArgument_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder removeOrArgument(int i) {
                ensureOrArgumentIsMutable();
                this.orArgument_.remove(i);
                return this;
            }
        }
    }
}
