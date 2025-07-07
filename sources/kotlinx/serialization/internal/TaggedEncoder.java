package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
/* compiled from: Tagged.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00028\u0000*\u00020\b2\u0006\u0010\t\u001a\u00020\nH$¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\nH\u0014¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u001eH\u0014¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020!H\u0014¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020$H\u0014¢\u0006\u0002\u0010%J\u001d\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020'H\u0014¢\u0006\u0002\u0010(J\u001d\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020*H\u0014¢\u0006\u0002\u0010+J\u001d\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020-H\u0014¢\u0006\u0002\u0010.J\u001d\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u000200H\u0014¢\u0006\u0002\u00101J%\u00102\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\nH\u0014¢\u0006\u0002\u00105J\u001d\u00106\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u00107\u001a\u00020\bH\u0014¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\bH\u0016J\u0018\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\u0011H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\u000e\u0010?\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020*J\u000e\u0010@\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u001bJ\u000e\u0010A\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u001eJ\u000e\u0010B\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020!J\u000e\u0010D\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020$J\u000e\u0010E\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020'J\u000e\u0010F\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020-J\u000e\u0010G\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u000200J\u0016\u0010H\u001a\u00020\u00112\u0006\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010I\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\bH\u0016J\u000e\u0010J\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\bJ\u0010\u0010K\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\bH\u0014J\u001e\u0010L\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020*J\u001e\u0010M\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u001bJ\u001e\u0010N\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u001eJ\u001e\u0010O\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u001e\u0010P\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020!J\u001e\u0010Q\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020$J\u001e\u0010R\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020'J\u001e\u0010S\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020-J\u001e\u0010T\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u000200J\u0016\u0010U\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ?\u0010V\u001a\u00020\u0011\"\n\b\u0001\u0010W*\u0004\u0018\u00010\u00022\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0Y2\u0006\u0010\u0013\u001a\u0002HWH\u0016¢\u0006\u0002\u0010ZJ?\u0010[\u001a\u00020\u0011\"\b\b\u0001\u0010W*\u00020\u00022\u0006\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0Y2\b\u0010\u0013\u001a\u0004\u0018\u0001HWH\u0016¢\u0006\u0002\u0010ZJ\u0015\u0010d\u001a\u00020\u00112\u0006\u0010e\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\r\u0010f\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010aR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\\\u001a\u0012\u0012\u0004\u0012\u00028\u00000]j\b\u0012\u0004\u0012\u00028\u0000`^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0016\u0010b\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bc\u0010a¨\u0006g"}, d2 = {"Lkotlinx/serialization/internal/TaggedEncoder;", "Tag", "", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", FirebaseAnalytics.Param.INDEX, "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeTaggedValue", "", "tag", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "encodeTaggedNonNullMark", "(Ljava/lang/Object;)V", "encodeTaggedNull", "encodeTaggedInt", "(Ljava/lang/Object;I)V", "encodeTaggedByte", "", "(Ljava/lang/Object;B)V", "encodeTaggedShort", "", "(Ljava/lang/Object;S)V", "encodeTaggedLong", "", "(Ljava/lang/Object;J)V", "encodeTaggedFloat", "", "(Ljava/lang/Object;F)V", "encodeTaggedDouble", "", "(Ljava/lang/Object;D)V", "encodeTaggedBoolean", "", "(Ljava/lang/Object;Z)V", "encodeTaggedChar", "", "(Ljava/lang/Object;C)V", "encodeTaggedString", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "encodeTaggedEnum", "enumDescriptor", "ordinal", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "encodeTaggedInline", "inlineDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeInline", "descriptor", "encodeElement", "desc", "encodeNotNullMark", "encodeNull", "encodeBoolean", "encodeByte", "encodeShort", "encodeInt", "encodeLong", "encodeFloat", "encodeDouble", "encodeChar", "encodeString", "encodeEnum", "beginStructure", "endStructure", "endEncode", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "encodeSerializableElement", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "pushTag", "name", "popTag", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
/* loaded from: classes5.dex */
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    protected void encodeTaggedNonNullMark(Tag tag) {
    }

    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    protected abstract Tag getTag(SerialDescriptor serialDescriptor, int i);

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, t);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializationStrategy, t);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return SerializersModuleBuildersKt.EmptySerializersModule();
    }

    protected void encodeTaggedValue(Tag tag, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(value.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    protected void encodeTaggedNull(Tag tag) {
        throw new SerializationException("null is not supported");
    }

    protected void encodeTaggedInt(Tag tag, int i) {
        encodeTaggedValue(tag, Integer.valueOf(i));
    }

    protected void encodeTaggedByte(Tag tag, byte b) {
        encodeTaggedValue(tag, Byte.valueOf(b));
    }

    protected void encodeTaggedShort(Tag tag, short s) {
        encodeTaggedValue(tag, Short.valueOf(s));
    }

    protected void encodeTaggedLong(Tag tag, long j) {
        encodeTaggedValue(tag, Long.valueOf(j));
    }

    protected void encodeTaggedFloat(Tag tag, float f) {
        encodeTaggedValue(tag, Float.valueOf(f));
    }

    protected void encodeTaggedDouble(Tag tag, double d) {
        encodeTaggedValue(tag, Double.valueOf(d));
    }

    protected void encodeTaggedBoolean(Tag tag, boolean z) {
        encodeTaggedValue(tag, Boolean.valueOf(z));
    }

    protected void encodeTaggedChar(Tag tag, char c) {
        encodeTaggedValue(tag, Character.valueOf(c));
    }

    protected void encodeTaggedString(Tag tag, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedValue(tag, value);
    }

    protected void encodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedValue(tag, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Encoder encodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        pushTag(tag);
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(popTag(), descriptor);
    }

    private final boolean encodeElement(SerialDescriptor serialDescriptor, int i) {
        pushTag(getTag(serialDescriptor, i));
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
        encodeTaggedNonNullMark(getCurrentTag());
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        encodeTaggedNull(popTag());
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        encodeTaggedBoolean(popTag(), z);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        encodeTaggedByte(popTag(), b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        encodeTaggedShort(popTag(), s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
        encodeTaggedInt(popTag(), i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        encodeTaggedLong(popTag(), j);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        encodeTaggedFloat(popTag(), f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        encodeTaggedDouble(popTag(), d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        encodeTaggedChar(popTag(), c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedEnum(popTag(), enumDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            popTag();
        }
        endEncode(descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedBoolean(getTag(descriptor, i), z);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor descriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedByte(getTag(descriptor, i), b);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor descriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedShort(getTag(descriptor, i), s);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor descriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedInt(getTag(descriptor, i), i2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor descriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedLong(getTag(descriptor, i), j);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedFloat(getTag(descriptor, i), f);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedDouble(getTag(descriptor, i), d);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor descriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedChar(getTag(descriptor, i), c);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor descriptor, int i, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(getTag(descriptor, i), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(getTag(descriptor, i), descriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeSerializableValue(serializer, t);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeNullableSerializableValue(serializer, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Tag getCurrentTag() {
        return (Tag) CollectionsKt.last((List<? extends Object>) this.tagStack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Tag getCurrentTagOrNull() {
        return (Tag) CollectionsKt.lastOrNull((List<? extends Object>) this.tagStack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pushTag(Tag tag) {
        this.tagStack.add(tag);
    }

    protected final Tag popTag() {
        if (!this.tagStack.isEmpty()) {
            ArrayList<Tag> arrayList = this.tagStack;
            return arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }
}
