package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.modules.SerializersModule;
/* compiled from: SavedStateEncoder.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J!\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\u0016\u00102\u001a\u00020\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001a03H\u0002J\u0016\u00104\u001a\u00020\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r03H\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010\f\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\f\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020@H\u0002J\u001b\u0010A\u001a\u00020\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0BH\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J)\u0010F\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0002\u0010GJ)\u0010H\u001a\u00020\u001d\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0K2\u0006\u0010\f\u001a\u0002HIH\u0016¢\u0006\u0002\u0010LJ)\u0010M\u001a\u00020\u0016\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0K2\u0006\u0010\f\u001a\u0002HIH\u0002¢\u0006\u0002\u0010NR\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006O"}, d2 = {"Landroidx/savedstate/serialization/SavedStateEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate_release", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate_release", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "shouldEncodeElementDefault", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", FirebaseAnalytics.Param.INDEX, "", "encodeElement", "checkDiscriminatorCollisions", "", "elementName", "(Landroid/os/Bundle;Ljava/lang/String;)V", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "encodeNull", "encodeIntList", "", "encodeStringList", "encodeBooleanArray", "", "encodeCharArray", "", "encodeDoubleArray", "", "encodeFloatArray", "", "encodeIntArray", "", "encodeLongArray", "", "encodeStringArray", "", "([Ljava/lang/String;)V", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "putClassDiscriminatorIfRequired", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlinx/serialization/descriptors/SerialDescriptor;Landroid/os/Bundle;)V", "encodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeFormatSpecificTypes", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Z", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SavedStateEncoder extends AbstractEncoder {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;
    private final SerializersModule serializersModule;

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    public SavedStateEncoder(Bundle savedState, SavedStateConfiguration configuration) {
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

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String elementName = descriptor.getElementName(i);
        this.key = elementName;
        checkDiscriminatorCollisions(this.savedState, elementName);
        return true;
    }

    private final void checkDiscriminatorCollisions(Bundle bundle, String str) {
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean m7581containsimpl = SavedStateReader.m7581containsimpl(SavedStateReader.m7580constructorimpl(bundle), "type");
            boolean areEqual = Intrinsics.areEqual(str, "type");
            if (m7581containsimpl && areEqual) {
                throw new IllegalArgumentException("SavedStateEncoder for " + SavedStateReader.m7651getStringimpl(SavedStateReader.m7580constructorimpl(bundle), "type") + " has property '" + str + "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        SavedStateWriter.m7672putBooleanimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, z);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        SavedStateWriter.m7683putIntimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, b);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        SavedStateWriter.m7683putIntimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, s);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        SavedStateWriter.m7683putIntimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, i);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        SavedStateWriter.m7687putLongimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, j);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        SavedStateWriter.m7681putFloatimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, f);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        SavedStateWriter.m7679putDoubleimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, d);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        SavedStateWriter.m7674putCharimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, c);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SavedStateWriter.m7699putStringimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        SavedStateWriter.m7683putIntimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, i);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        SavedStateWriter.m7689putNullimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key);
    }

    private final void encodeIntList(List<Integer> list) {
        SavedStateWriter.m7685putIntListimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, list);
    }

    private final void encodeStringList(List<String> list) {
        SavedStateWriter.m7701putStringListimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, list);
    }

    private final void encodeBooleanArray(boolean[] zArr) {
        SavedStateWriter.m7673putBooleanArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, zArr);
    }

    private final void encodeCharArray(char[] cArr) {
        SavedStateWriter.m7675putCharArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, cArr);
    }

    private final void encodeDoubleArray(double[] dArr) {
        SavedStateWriter.m7680putDoubleArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, dArr);
    }

    private final void encodeFloatArray(float[] fArr) {
        SavedStateWriter.m7682putFloatArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, fArr);
    }

    private final void encodeIntArray(int[] iArr) {
        SavedStateWriter.m7684putIntArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, iArr);
    }

    private final void encodeLongArray(long[] jArr) {
        SavedStateWriter.m7688putLongArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, jArr);
    }

    private final void encodeStringArray(String[] strArr) {
        SavedStateWriter.m7700putStringArrayimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, strArr);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, descriptor, this.savedState);
            return this;
        }
        Map emptyMap = MapsKt.emptyMap();
        if (emptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(emptyMap.size());
            for (Map.Entry entry : emptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7666constructorimpl(bundleOf);
        SavedStateWriter.m7693putSavedStateimpl(SavedStateWriter.m7666constructorimpl(this.savedState), this.key, bundleOf);
        putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleOf);
        return new SavedStateEncoder(bundleOf, this.configuration);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration savedStateConfiguration, SerialDescriptor serialDescriptor, Bundle bundle) {
        if (savedStateConfiguration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m7581containsimpl(SavedStateReader.m7580constructorimpl(bundle), "type")) {
            if (Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE) || Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.OBJECT.INSTANCE)) {
                SavedStateWriter.m7699putStringimpl(SavedStateWriter.m7666constructorimpl(bundle), "type", serialDescriptor.getSerialName());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeFormatSpecificTypes(serializer, t)) {
            return;
        }
        super.encodeSerializableValue(serializer, t);
    }

    private final <T> boolean encodeFormatSpecificTypes(SerializationStrategy<? super T> serializationStrategy, T t) {
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, serializationStrategy, t)) {
            return true;
        }
        SerialDescriptor descriptor = serializationStrategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            encodeIntList((List) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            encodeStringList((List) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.BooleanArray");
            encodeBooleanArray((boolean[]) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.CharArray");
            encodeCharArray((char[]) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.DoubleArray");
            encodeDoubleArray((double[]) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.FloatArray");
            encodeFloatArray((float[]) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.IntArray");
            encodeIntArray((int[]) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.LongArray");
            encodeLongArray((long[]) t);
            return true;
        } else if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            encodeStringArray((String[]) t);
            return true;
        } else {
            return false;
        }
    }
}
