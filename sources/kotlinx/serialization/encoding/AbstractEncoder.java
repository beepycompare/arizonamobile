package kotlinx.serialization.encoding;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NoOpEncoder;
/* compiled from: AbstractEncoder.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010%\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bJ\u001e\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0014J\u001e\u0010'\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0016J\u001e\u0010(\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u001e\u0010)\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0019J\u001e\u0010*\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001bJ\u001e\u0010+\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001dJ\u001e\u0010,\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001fJ\u001e\u0010-\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020!J\u0016\u0010.\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ?\u0010/\u001a\u00020\t\"\n\b\u0000\u00100*\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0006\u0010\u000f\u001a\u0002H0H\u0016¢\u0006\u0002\u00103J?\u00104\u001a\u00020\t\"\b\b\u0000\u00100*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\b\u0010\u000f\u001a\u0004\u0018\u0001H0H\u0016¢\u0006\u0002\u00103¨\u00065"}, d2 = {"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "endStructure", "", "encodeElement", "", FirebaseAnalytics.Param.INDEX, "", "encodeValue", "value", "", "encodeNull", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "", "encodeEnum", "enumDescriptor", "encodeInline", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "encodeSerializableElement", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes5.dex */
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    public boolean encodeElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
        Encoder.DefaultImpls.encodeNotNullMark(this);
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

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    public void encodeValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(value.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        encodeValue(Boolean.valueOf(z));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        encodeValue(Byte.valueOf(b));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        encodeValue(Short.valueOf(s));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        encodeValue(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        encodeValue(Long.valueOf(j));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        encodeValue(Float.valueOf(f));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        encodeValue(Double.valueOf(d));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        encodeValue(Character.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue(value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeBoolean(z);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor descriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeByte(b);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor descriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeShort(s);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor descriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeInt(i2);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor descriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeLong(j);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeFloat(f);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeDouble(d);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor descriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeChar(c);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor descriptor, int i, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        if (encodeElement(descriptor, i)) {
            encodeString(value);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeElement(descriptor, i) ? encodeInline(descriptor.getElementDescriptor(i)) : NoOpEncoder.INSTANCE;
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
}
