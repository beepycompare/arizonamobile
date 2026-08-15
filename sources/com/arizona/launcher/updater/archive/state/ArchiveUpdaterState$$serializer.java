package com.arizona.launcher.updater.archive.state;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: ArchiveStateModels.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/arizona/launcher/updater/archive/state/ArchiveUpdaterState.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes3.dex */
public final /* synthetic */ class ArchiveUpdaterState$$serializer implements GeneratedSerializer<ArchiveUpdaterState> {
    public static final int $stable = 0;
    public static final ArchiveUpdaterState$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ArchiveUpdaterState$$serializer archiveUpdaterState$$serializer = new ArchiveUpdaterState$$serializer();
        INSTANCE = archiveUpdaterState$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arizona.launcher.updater.archive.state.ArchiveUpdaterState", archiveUpdaterState$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("schemaVersion", true);
        pluginGeneratedSerialDescriptor.addElement("manifestId", false);
        pluginGeneratedSerialDescriptor.addElement("manifestVersion", false);
        pluginGeneratedSerialDescriptor.addElement("manifestSchemaVersion", false);
        pluginGeneratedSerialDescriptor.addElement("selectedGpu", false);
        pluginGeneratedSerialDescriptor.addElement("packages", true);
        pluginGeneratedSerialDescriptor.addElement("pendingRetirements", true);
        pluginGeneratedSerialDescriptor.addElement("legacyMetadataReconciled", true);
        pluginGeneratedSerialDescriptor.addElement("updatedAtEpochMs", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ArchiveUpdaterState$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ArchiveUpdaterState.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, lazyArr[5].getValue(), lazyArr[6].getValue(), BooleanSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ArchiveUpdaterState deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        int i2;
        int i3;
        String str;
        List list;
        List list2;
        String str2;
        boolean z;
        String str3;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ArchiveUpdaterState.$childSerializers;
        int i4 = 7;
        if (beginStructure.decodeSequentially()) {
            i = beginStructure.decodeIntElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            z = decodeBooleanElement;
            i2 = decodeIntElement;
            str = decodeStringElement3;
            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            j = beginStructure.decodeLongElement(serialDescriptor, 8);
            i3 = 511;
            str3 = decodeStringElement2;
            str2 = decodeStringElement;
        } else {
            boolean z2 = true;
            i = 0;
            List list3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            long j2 = 0;
            boolean z3 = false;
            i2 = 0;
            int i5 = 0;
            List list4 = null;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        i5 |= 1;
                        i = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i4 = 7;
                        break;
                    case 1:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        i4 = 7;
                        break;
                    case 2:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        i2 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i5 |= 16;
                        break;
                    case 5:
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list4);
                        i5 |= 32;
                        break;
                    case 6:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list3);
                        i5 |= 64;
                        break;
                    case 7:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i5 |= 128;
                        break;
                    case 8:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 8);
                        i5 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i3 = i5;
            str = str6;
            long j3 = j2;
            list = list3;
            list2 = list4;
            str2 = str4;
            z = z3;
            str3 = str5;
            j = j3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ArchiveUpdaterState(i3, i, str2, str3, i2, str, list2, list, z, j, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ArchiveUpdaterState value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ArchiveUpdaterState.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
