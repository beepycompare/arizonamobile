package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import com.arizona.launcher.UpdateActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.internal.PolymorphicKt;
import kotlinx.serialization.modules.SerializersModule;
/* compiled from: StreamingJsonEncoder.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB1\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000b\u0010\u000fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J)\u0010'\u001a\u00020\u001f\"\u0004\b\u0000\u0010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0*2\u0006\u0010+\u001a\u0002H(H\u0016¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u00103\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J?\u00104\u001a\u00020\u001f\"\b\b\u0000\u0010(*\u0002052\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0*2\b\u0010+\u001a\u0004\u0018\u0001H(H\u0016¢\u0006\u0002\u00106J\u0010\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020$H\u0016JR\u00109\u001a\u0002H(\"\n\b\u0000\u0010(\u0018\u0001*\u00020\u000426\u0010:\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H(0;H\u0082\b¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\u001fH\u0016J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001aH\u0016J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0016J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001cH\u0016J\u0018\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "composer", "Lkotlinx/serialization/json/internal/Composer;", "json", "Lkotlinx/serialization/json/Json;", UpdateActivity.UPDATE_MODE, "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "<init>", "(Lkotlinx/serialization/json/internal/Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "output", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonEncoder;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "forceQuoting", "", "polymorphicDiscriminator", "", "polymorphicSerialName", "encodeJsonElement", "", "element", "Lkotlinx/serialization/json/JsonElement;", "shouldEncodeElementDefault", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", FirebaseAnalytics.Param.INDEX, "", "encodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTypeInfo", "discriminator", "serialName", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "endStructure", "encodeElement", "encodeNullableSerializableElement", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeInline", "Lkotlinx/serialization/encoding/Encoder;", "composerAs", "composerCreator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "writer", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/serialization/json/internal/Composer;", "encodeNull", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {
    private final Composer composer;
    private final JsonConfiguration configuration;
    private boolean forceQuoting;
    private final Json json;
    private final WriteMode mode;
    private final JsonEncoder[] modeReuseCache;
    private String polymorphicDiscriminator;
    private String polymorphicSerialName;
    private final SerializersModule serializersModule;

    /* compiled from: StreamingJsonEncoder.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public Json getJson() {
        return this.json;
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode mode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.composer = composer;
        this.json = json;
        this.mode = mode;
        this.modeReuseCache = jsonEncoderArr;
        this.serializersModule = getJson().getSerializersModule();
        this.configuration = getJson().getConfiguration();
        int ordinal = mode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[ordinal];
            if (jsonEncoder == null && jsonEncoder == this) {
                return;
            }
            jsonEncoderArr[ordinal] = this;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamingJsonEncoder(InternalJsonWriter output, Json json, WriteMode mode, JsonEncoder[] modeReuseCache) {
        this(ComposersKt.Composer(output, json), json, mode, modeReuseCache);
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(modeReuseCache, "modeReuseCache");
    }

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public void encodeJsonElement(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (this.polymorphicDiscriminator != null && !(element instanceof JsonObject)) {
            PolymorphicKt.throwJsonElementPolymorphicException(this.polymorphicSerialName, element);
            throw new KotlinNothingValueException();
        } else {
            encodeSerializableValue(JsonElementSerializer.INSTANCE, element);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, kotlinx.serialization.descriptors.StructureKind.OBJECT.INSTANCE) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r0.getJson().getConfiguration().getClassDiscriminatorMode() != kotlinx.serialization.json.ClassDiscriminatorMode.NONE) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        String classDiscriminator;
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        StreamingJsonEncoder streamingJsonEncoder = this;
        if (streamingJsonEncoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializer.serialize(streamingJsonEncoder, t);
            return;
        }
        boolean z = serializer instanceof AbstractPolymorphicSerializer;
        if (!z) {
            int i = PolymorphicKt.WhenMappings.$EnumSwitchMapping$0[streamingJsonEncoder.getJson().getConfiguration().getClassDiscriminatorMode().ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                SerialKind kind = serializer.getDescriptor().getKind();
                if (!Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE)) {
                }
                classDiscriminator = PolymorphicKt.classDiscriminator(serializer.getDescriptor(), streamingJsonEncoder.getJson());
            }
            classDiscriminator = null;
        }
        if (z) {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializer;
            if (t == 0) {
                throw new IllegalArgumentException(("Value for serializer " + abstractPolymorphicSerializer.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
            }
            SerializationStrategy<? super T> findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(abstractPolymorphicSerializer, streamingJsonEncoder, t);
            if (classDiscriminator != null) {
                PolymorphicKt.validateIfSealed(serializer, findPolymorphicSerializer, classDiscriminator);
            }
            PolymorphicKt.checkKind(findPolymorphicSerializer.getDescriptor().getKind());
            Intrinsics.checkNotNull(findPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
            serializer = findPolymorphicSerializer;
        }
        if (classDiscriminator != null) {
            String serialName = serializer.getDescriptor().getSerialName();
            this.polymorphicDiscriminator = classDiscriminator;
            this.polymorphicSerialName = serialName;
        }
        serializer.serialize(streamingJsonEncoder, t);
    }

    private final void encodeTypeInfo(String str, String str2) {
        this.composer.nextItem();
        encodeString(str);
        this.composer.print(AbstractJsonLexerKt.COLON);
        this.composer.space();
        encodeString(str2);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        JsonEncoder jsonEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode switchMode = WriteModeKt.switchMode(getJson(), descriptor);
        if (switchMode.begin != 0) {
            this.composer.print(switchMode.begin);
            this.composer.indent();
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            String str2 = this.polymorphicSerialName;
            if (str2 == null) {
                str2 = descriptor.getSerialName();
            }
            encodeTypeInfo(str, str2);
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if (this.mode == switchMode) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.modeReuseCache;
        return (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[switchMode.ordinal()]) == null) ? new StreamingJsonEncoder(this.composer, getJson(), switchMode, this.modeReuseCache) : jsonEncoder;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.mode.end != 0) {
            this.composer.unIndent();
            this.composer.nextItemIfNotFirst();
            this.composer.print(this.mode.end);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i2 != 1) {
            boolean z = false;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (!this.composer.getWritingFirst()) {
                        this.composer.print(AbstractJsonLexerKt.COMMA);
                    }
                    this.composer.nextItem();
                    encodeString(JsonNamesMapKt.getJsonElementName(descriptor, getJson(), i));
                    this.composer.print(AbstractJsonLexerKt.COLON);
                    this.composer.space();
                } else {
                    if (i == 0) {
                        this.forceQuoting = true;
                    }
                    if (i == 1) {
                        this.composer.print(AbstractJsonLexerKt.COMMA);
                        this.composer.space();
                        this.forceQuoting = false;
                    }
                }
            } else if (!this.composer.getWritingFirst()) {
                if (i % 2 == 0) {
                    this.composer.print(AbstractJsonLexerKt.COMMA);
                    this.composer.nextItem();
                    z = true;
                } else {
                    this.composer.print(AbstractJsonLexerKt.COLON);
                    this.composer.space();
                }
                this.forceQuoting = z;
            } else {
                this.forceQuoting = true;
                this.composer.nextItem();
            }
        } else {
            if (!this.composer.getWritingFirst()) {
                this.composer.print(AbstractJsonLexerKt.COMMA);
            }
            this.composer.nextItem();
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (t != null || this.configuration.getExplicitNulls()) {
            super.encodeNullableSerializableElement(descriptor, i, serializer, t);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!StreamingJsonEncoderKt.isUnsignedNumber(descriptor)) {
            if (!StreamingJsonEncoderKt.isUnquotedLiteral(descriptor)) {
                if (this.polymorphicDiscriminator != null) {
                    this.polymorphicSerialName = descriptor.getSerialName();
                    return this;
                }
                return super.encodeInline(descriptor);
            }
            ComposerForUnquotedLiterals composerForUnquotedLiterals = this.composer;
            if (!(composerForUnquotedLiterals instanceof ComposerForUnquotedLiterals)) {
                composerForUnquotedLiterals = new ComposerForUnquotedLiterals(composerForUnquotedLiterals.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, getJson(), this.mode, (JsonEncoder[]) null);
        }
        ComposerForUnsignedNumbers composerForUnsignedNumbers = this.composer;
        if (!(composerForUnsignedNumbers instanceof ComposerForUnsignedNumbers)) {
            composerForUnsignedNumbers = new ComposerForUnsignedNumbers(composerForUnsignedNumbers.writer, this.forceQuoting);
        }
        return new StreamingJsonEncoder(composerForUnsignedNumbers, getJson(), this.mode, (JsonEncoder[]) null);
    }

    private final /* synthetic */ <T extends Composer> T composerAs(Function2<? super InternalJsonWriter, ? super Boolean, ? extends T> function2) {
        Composer composer = this.composer;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return composer instanceof Composer ? (T) this.composer : function2.invoke(this.composer.writer, Boolean.valueOf(this.forceQuoting));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        this.composer.print(AbstractJsonLexerKt.NULL);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(z));
        } else {
            this.composer.print(z);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) b));
        } else {
            this.composer.print(b);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) s));
        } else {
            this.composer.print(s);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(i));
        } else {
            this.composer.print(i);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(j));
        } else {
            this.composer.print(j);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(f));
        } else {
            this.composer.print(f);
        }
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(f), this.composer.writer.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(d));
        } else {
            this.composer.print(d);
        }
        if (this.configuration.getAllowSpecialFloatingPointValues()) {
            return;
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(d), this.composer.writer.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        encodeString(String.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.composer.printQuoted(value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeString(enumDescriptor.getElementName(i));
    }
}
