package com.arizona.launcher.updater.archive.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: ArchiveStateModels.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", "message", "This synthesized declaration should not be used directly", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes3.dex */
public final /* synthetic */ class ArchivePackageJournalEntry$$serializer implements GeneratedSerializer<ArchivePackageJournalEntry> {
    public static final int $stable = 0;
    public static final ArchivePackageJournalEntry$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ArchivePackageJournalEntry$$serializer archivePackageJournalEntry$$serializer = new ArchivePackageJournalEntry$$serializer();
        INSTANCE = archivePackageJournalEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry", archivePackageJournalEntry$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("identity", false);
        pluginGeneratedSerialDescriptor.addElement(TypedValues.CycleType.S_WAVE_PHASE, false);
        pluginGeneratedSerialDescriptor.addElement("bytesDownloaded", true);
        pluginGeneratedSerialDescriptor.addElement("previousCommitted", true);
        pluginGeneratedSerialDescriptor.addElement(OriginalTzArchiveManifestParser.FILES_ROOT, true);
        pluginGeneratedSerialDescriptor.addElement("desiredFiles", true);
        pluginGeneratedSerialDescriptor.addElement("previousFiles", true);
        pluginGeneratedSerialDescriptor.addElement("phaseUpdatedAtEpochMs", true);
        pluginGeneratedSerialDescriptor.addElement("lastError", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ArchivePackageJournalEntry$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = ArchivePackageJournalEntry.$childSerializers;
        return new KSerializer[]{ArchivePackageIdentity$$serializer.INSTANCE, lazyArr[1].getValue(), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(ArchivePackageIdentity$$serializer.INSTANCE), lazyArr[4].getValue(), lazyArr[5].getValue(), lazyArr[6].getValue(), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ArchivePackageJournalEntry deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        ArchivePackageIdentity archivePackageIdentity;
        String str;
        ArchivePackageIdentity archivePackageIdentity2;
        ArchivePackagePhase archivePackagePhase;
        long j;
        long j2;
        int i;
        List list;
        List list2;
        List list3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = ArchivePackageJournalEntry.$childSerializers;
        int i2 = 7;
        int i3 = 8;
        int i4 = 4;
        String str2 = null;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 2);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 7);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            archivePackageIdentity2 = (ArchivePackageIdentity) beginStructure.decodeSerializableElement(serialDescriptor, 0, ArchivePackageIdentity$$serializer.INSTANCE, null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            i = 511;
            list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            j2 = decodeLongElement2;
            archivePackageIdentity = (ArchivePackageIdentity) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ArchivePackageIdentity$$serializer.INSTANCE, null);
            j = decodeLongElement;
            archivePackagePhase = (ArchivePackagePhase) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
        } else {
            int i5 = 1;
            boolean z = true;
            int i6 = 0;
            List list4 = null;
            List list5 = null;
            List list6 = null;
            ArchivePackageIdentity archivePackageIdentity3 = null;
            long j3 = 0;
            long j4 = 0;
            ArchivePackageIdentity archivePackageIdentity4 = null;
            ArchivePackagePhase archivePackagePhase2 = null;
            while (z) {
                int i7 = i4;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i5 = 1;
                        i3 = 8;
                        i4 = 4;
                    case 0:
                        archivePackageIdentity4 = (ArchivePackageIdentity) beginStructure.decodeSerializableElement(serialDescriptor, 0, ArchivePackageIdentity$$serializer.INSTANCE, archivePackageIdentity4);
                        i6 |= 1;
                        i5 = 1;
                        i2 = 7;
                        i3 = 8;
                        i4 = 4;
                    case 1:
                        archivePackagePhase2 = (ArchivePackagePhase) beginStructure.decodeSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), archivePackagePhase2);
                        i6 |= 2;
                        i2 = 7;
                        i3 = 8;
                        i4 = 4;
                    case 2:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 2);
                        i6 |= 4;
                        i2 = 7;
                        i4 = 4;
                    case 3:
                        archivePackageIdentity3 = (ArchivePackageIdentity) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ArchivePackageIdentity$$serializer.INSTANCE, archivePackageIdentity3);
                        i6 |= 8;
                        i2 = 7;
                        i4 = 4;
                    case 4:
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i7, (DeserializationStrategy) lazyArr[i7].getValue(), list6);
                        i6 |= 16;
                        i4 = i7;
                        i2 = 7;
                        continue;
                    case 5:
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list5);
                        i6 |= 32;
                        break;
                    case 6:
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list4);
                        i6 |= 64;
                        break;
                    case 7:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, i2);
                        i6 |= 128;
                        break;
                    case 8:
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str2);
                        i6 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                i4 = i7;
            }
            archivePackageIdentity = archivePackageIdentity3;
            str = str2;
            archivePackageIdentity2 = archivePackageIdentity4;
            archivePackagePhase = archivePackagePhase2;
            j = j3;
            j2 = j4;
            i = i6;
            list = list4;
            list2 = list5;
            list3 = list6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ArchivePackageJournalEntry(i, archivePackageIdentity2, archivePackagePhase, j, archivePackageIdentity, list3, list2, list, j2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ArchivePackageJournalEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ArchivePackageJournalEntry.write$Self$app(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
