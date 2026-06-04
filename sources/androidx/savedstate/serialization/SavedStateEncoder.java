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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u001eH\u0016J)\u00103\u001a\u00020\u001e\"\u0004\b\u0000\u001042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H4062\u0006\u0010\f\u001a\u0002H4H\u0016¢\u0006\u0002\u00107R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00068"}, d2 = {"Landroidx/savedstate/serialization/SavedStateEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "shouldEncodeElementDefault", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", FirebaseAnalytics.Param.INDEX, "", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "putClassDiscriminatorIfRequired", "", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlinx/serialization/descriptors/SerialDescriptor;Landroid/os/Bundle;)V", "encodeElement", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "encodeNull", "encodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SavedStateEncoder extends AbstractEncoder {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;

    public final Bundle getSavedState$savedstate() {
        return this.savedState;
    }

    public SavedStateEncoder(Bundle savedState, SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
    }

    public final String getKey$savedstate() {
        return this.key;
    }

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return this.configuration.getSerializersModule();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
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
        SavedStateWriter.m9161constructorimpl(bundleOf);
        SavedStateWriter.m9188putSavedStateimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, bundleOf);
        putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleOf);
        return new SavedStateEncoder(bundleOf, this.configuration);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration savedStateConfiguration, SerialDescriptor serialDescriptor, Bundle bundle) {
        if (savedStateConfiguration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m9076containsimpl(SavedStateReader.m9075constructorimpl(bundle), "type")) {
            if (Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE) || Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.OBJECT.INSTANCE)) {
                SavedStateWriter.m9194putStringimpl(SavedStateWriter.m9161constructorimpl(bundle), "type", serialDescriptor.getSerialName());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.key = descriptor.getElementName(i);
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean m9076containsimpl = SavedStateReader.m9076containsimpl(SavedStateReader.m9075constructorimpl(this.savedState), "type");
            boolean areEqual = Intrinsics.areEqual(this.key, "type");
            if (m9076containsimpl && areEqual) {
                throw new IllegalArgumentException("SavedStateEncoder for " + SavedStateReader.m9146getStringimpl(SavedStateReader.m9075constructorimpl(this.savedState), "type") + " has property '" + this.key + "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        SavedStateWriter.m9167putBooleanimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, z);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        SavedStateWriter.m9178putIntimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, b);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        SavedStateWriter.m9178putIntimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, s);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        SavedStateWriter.m9178putIntimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, i);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        SavedStateWriter.m9182putLongimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, j);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        SavedStateWriter.m9176putFloatimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, f);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        SavedStateWriter.m9174putDoubleimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, d);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        SavedStateWriter.m9169putCharimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, c);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SavedStateWriter.m9194putStringimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        SavedStateWriter.m9178putIntimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key, i);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        SavedStateWriter.m9184putNullimpl(SavedStateWriter.m9161constructorimpl(this.savedState), this.key);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, serializer, t)) {
            return;
        }
        SerialDescriptor descriptor = serializer.getDescriptor();
        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
                    if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
                            if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
                                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
                                    if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
                                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
                                            super.encodeSerializableValue(serializer, t);
                                            return;
                                        }
                                        Bundle m9161constructorimpl = SavedStateWriter.m9161constructorimpl(this.savedState);
                                        String str = this.key;
                                        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                                        SavedStateWriter.m9195putStringArrayimpl(m9161constructorimpl, str, (String[]) t);
                                        return;
                                    }
                                    Bundle m9161constructorimpl2 = SavedStateWriter.m9161constructorimpl(this.savedState);
                                    String str2 = this.key;
                                    Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.LongArray");
                                    SavedStateWriter.m9183putLongArrayimpl(m9161constructorimpl2, str2, (long[]) t);
                                    return;
                                }
                                Bundle m9161constructorimpl3 = SavedStateWriter.m9161constructorimpl(this.savedState);
                                String str3 = this.key;
                                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.IntArray");
                                SavedStateWriter.m9179putIntArrayimpl(m9161constructorimpl3, str3, (int[]) t);
                                return;
                            }
                            Bundle m9161constructorimpl4 = SavedStateWriter.m9161constructorimpl(this.savedState);
                            String str4 = this.key;
                            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.FloatArray");
                            SavedStateWriter.m9177putFloatArrayimpl(m9161constructorimpl4, str4, (float[]) t);
                            return;
                        }
                        Bundle m9161constructorimpl5 = SavedStateWriter.m9161constructorimpl(this.savedState);
                        String str5 = this.key;
                        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.DoubleArray");
                        SavedStateWriter.m9175putDoubleArrayimpl(m9161constructorimpl5, str5, (double[]) t);
                        return;
                    }
                    Bundle m9161constructorimpl6 = SavedStateWriter.m9161constructorimpl(this.savedState);
                    String str6 = this.key;
                    Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.CharArray");
                    SavedStateWriter.m9170putCharArrayimpl(m9161constructorimpl6, str6, (char[]) t);
                    return;
                }
                Bundle m9161constructorimpl7 = SavedStateWriter.m9161constructorimpl(this.savedState);
                String str7 = this.key;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.BooleanArray");
                SavedStateWriter.m9168putBooleanArrayimpl(m9161constructorimpl7, str7, (boolean[]) t);
                return;
            }
            Bundle m9161constructorimpl8 = SavedStateWriter.m9161constructorimpl(this.savedState);
            String str8 = this.key;
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            SavedStateWriter.m9196putStringListimpl(m9161constructorimpl8, str8, (List) t);
            return;
        }
        Bundle m9161constructorimpl9 = SavedStateWriter.m9161constructorimpl(this.savedState);
        String str9 = this.key;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
        SavedStateWriter.m9180putIntListimpl(m9161constructorimpl9, str9, (List) t);
    }
}
