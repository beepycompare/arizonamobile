package androidx.datastore.preferences.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class WireFormat {
    static final int FIXED32_SIZE = 4;
    static final int FIXED64_SIZE = 8;
    static final int MAX_VARINT32_SIZE = 5;
    static final int MAX_VARINT64_SIZE = 10;
    static final int MAX_VARINT_SIZE = 10;
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);

    public static int getTagFieldNumber(final int tag) {
        return tag >>> 3;
    }

    public static int getTagWireType(final int tag) {
        return tag & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int makeTag(final int fieldNumber, final int wireType) {
        return (fieldNumber << 3) | wireType;
    }

    private WireFormat() {
    }

    /* loaded from: classes2.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        JavaType(final Object defaultDefault) {
            this.defaultDefault = defaultDefault;
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    /* loaded from: classes2.dex */
    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(JavaType.LONG, 0),
        UINT64(JavaType.LONG, 0),
        INT32(JavaType.INT, 0),
        FIXED64(JavaType.LONG, 1),
        FIXED32(JavaType.INT, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.1
            @Override // androidx.datastore.preferences.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(JavaType.MESSAGE, 3) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.2
            @Override // androidx.datastore.preferences.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(JavaType.MESSAGE, 2) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.3
            @Override // androidx.datastore.preferences.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.4
            @Override // androidx.datastore.preferences.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(JavaType.INT, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(JavaType.INT, 5),
        SFIXED64(JavaType.LONG, 1),
        SINT32(JavaType.INT, 0),
        SINT64(JavaType.LONG, 0);
        
        private final JavaType javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        /* synthetic */ FieldType(JavaType javaType, int i, AnonymousClass1 anonymousClass1) {
            this(javaType, i);
        }

        FieldType(final JavaType javaType, final int wireType) {
            this.javaType = javaType;
            this.wireType = wireType;
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Utf8Validation {
        LOOSE { // from class: androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation.1
            @Override // androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream input) throws IOException {
                return input.readString();
            }
        },
        STRICT { // from class: androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation.2
            @Override // androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream input) throws IOException {
                return input.readStringRequireUtf8();
            }
        },
        LAZY { // from class: androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation.3
            @Override // androidx.datastore.preferences.protobuf.WireFormat.Utf8Validation
            Object readString(CodedInputStream input) throws IOException {
                return input.readBytes();
            }
        };

        abstract Object readString(CodedInputStream input) throws IOException;

        /* synthetic */ Utf8Validation(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.datastore.preferences.protobuf.WireFormat$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object readPrimitiveField(CodedInputStream input, FieldType type, Utf8Validation utf8Validation) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case 1:
                return Double.valueOf(input.readDouble());
            case 2:
                return Float.valueOf(input.readFloat());
            case 3:
                return Long.valueOf(input.readInt64());
            case 4:
                return Long.valueOf(input.readUInt64());
            case 5:
                return Integer.valueOf(input.readInt32());
            case 6:
                return Long.valueOf(input.readFixed64());
            case 7:
                return Integer.valueOf(input.readFixed32());
            case 8:
                return Boolean.valueOf(input.readBool());
            case 9:
                return input.readBytes();
            case 10:
                return Integer.valueOf(input.readUInt32());
            case 11:
                return Integer.valueOf(input.readSFixed32());
            case 12:
                return Long.valueOf(input.readSFixed64());
            case 13:
                return Integer.valueOf(input.readSInt32());
            case 14:
                return Long.valueOf(input.readSInt64());
            case 15:
                return utf8Validation.readString(input);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
