package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateReader;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.modules.SerializersModule;
/* compiled from: SavedStateDecoder.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0019H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120-H\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0-H\u0002J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020:H\u0002J\u0013\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0<H\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020?2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J!\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0DH\u0016¢\u0006\u0002\u0010EJ#\u0010F\u001a\u0004\u0018\u0001HB\"\u0004\b\u0000\u0010B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0DH\u0002¢\u0006\u0002\u0010ER\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006G"}, d2 = {"Landroidx/savedstate/serialization/SavedStateDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate_release", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate_release", "()Ljava/lang/String;", FirebaseAnalytics.Param.INDEX, "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeBoolean", "", "decodeByte", "", "decodeShort", "", "decodeInt", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeChar", "", "decodeString", "decodeEnum", "enumDescriptor", "decodeIntList", "", "decodeStringList", "decodeBooleanArray", "", "decodeCharArray", "", "decodeDoubleArray", "", "decodeFloatArray", "", "decodeIntArray", "", "decodeLongArray", "", "decodeStringArray", "", "()[Ljava/lang/String;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeNotNullMark", "decodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeFormatSpecificTypes", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SavedStateDecoder extends AbstractDecoder {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;
    private final SerializersModule serializersModule;

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    public SavedStateDecoder(Bundle savedState, SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
        this.serializersModule = configuration.getSerializersModule();
    }

    public final String getKey$savedstate_release() {
        return this.key;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        int m7659sizeimpl;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(descriptor.getKind(), StructureKind.LIST.INSTANCE) || Intrinsics.areEqual(descriptor.getKind(), StructureKind.MAP.INSTANCE)) {
            m7659sizeimpl = SavedStateReader.m7659sizeimpl(SavedStateReader.m7579constructorimpl(this.savedState));
        } else {
            m7659sizeimpl = descriptor.getElementsCount();
        }
        while (true) {
            int i = this.index;
            if (i >= m7659sizeimpl || !descriptor.isElementOptional(i) || decodeElementIndex$presentInEncoding(this, descriptor, this.index)) {
                break;
            }
            this.index++;
        }
        int i2 = this.index;
        if (i2 < m7659sizeimpl) {
            this.key = descriptor.getElementName(i2);
            int i3 = this.index;
            this.index = i3 + 1;
            return i3;
        }
        return -1;
    }

    private static final boolean decodeElementIndex$presentInEncoding(SavedStateDecoder savedStateDecoder, SerialDescriptor serialDescriptor, int i) {
        return SavedStateReader.m7580containsimpl(SavedStateReader.m7579constructorimpl(savedStateDecoder.savedState), serialDescriptor.getElementName(i));
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return SavedStateReader.m7588getBooleanimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return (byte) SavedStateReader.m7610getIntimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return (short) SavedStateReader.m7610getIntimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return SavedStateReader.m7610getIntimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return SavedStateReader.m7620getLongimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return SavedStateReader.m7606getFloatimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return SavedStateReader.m7602getDoubleimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return SavedStateReader.m7592getCharimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        return SavedStateReader.m7650getStringimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return SavedStateReader.m7610getIntimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        return SavedStateReader.m7613getIntListimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        return SavedStateReader.m7653getStringListimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final boolean[] decodeBooleanArray() {
        return SavedStateReader.m7589getBooleanArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        return SavedStateReader.m7593getCharArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        return SavedStateReader.m7603getDoubleArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final float[] decodeFloatArray() {
        return SavedStateReader.m7607getFloatArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final int[] decodeIntArray() {
        return SavedStateReader.m7611getIntArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        return SavedStateReader.m7621getLongArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        return SavedStateReader.m7651getStringArrayimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.key, "")) {
            return this;
        }
        return new SavedStateDecoder(SavedStateReader.m7636getSavedStateimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key), this.configuration);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !SavedStateReader.m7658isNullimpl(SavedStateReader.m7579constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        T t = (T) decodeFormatSpecificTypes(deserializer);
        return t == null ? (T) super.decodeSerializableValue(deserializer) : t;
    }

    private final <T> T decodeFormatSpecificTypes(DeserializationStrategy<? extends T> deserializationStrategy) {
        T t = (T) SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, deserializationStrategy);
        if (t == null) {
            SerialDescriptor descriptor = deserializationStrategy.getDescriptor();
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
                return (T) decodeIntList();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
                return (T) decodeStringList();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
                return (T) decodeBooleanArray();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
                return (T) decodeCharArray();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
                return (T) decodeDoubleArray();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
                return (T) decodeFloatArray();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
                return (T) decodeIntArray();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
                return (T) decodeLongArray();
            }
            if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
                return (T) decodeStringArray();
            }
            return null;
        }
        return t;
    }
}
