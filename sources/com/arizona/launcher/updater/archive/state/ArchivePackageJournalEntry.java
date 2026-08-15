package com.arizona.launcher.updater.archive.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: ArchiveStateModels.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002RSBs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012B\u0083\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jy\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0014\u0010E\u001a\u0002092\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010G\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010H\u001a\u00020\u0010HÖ\u0081\u0004J)\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001b\u0002\bQ¢\u0006\u0002\bPR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R,\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\t¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\f¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010(R0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\r¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010(R*\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010#R,\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000f¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b3\u00101R\u0011\u00104\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b5\u0010#R\u0011\u00106\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010#R\u0011\u00108\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b8\u0010:Ê\u0001\u0002\bUÊ\u0001\f\bV\u0012\b\bW\u0012\u0004\b\u0003\u0010\u0002¨\u0006T"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "", "identity", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "bytesDownloaded", "", "previousCommitted", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "desiredFiles", "previousFiles", "phaseUpdatedAtEpochMs", "lastError", "", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;JLcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;Ljava/util/List;Ljava/util/List;Ljava/util/List;JLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;JLcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;Ljava/util/List;Ljava/util/List;Ljava/util/List;JLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIdentity$annotations", "()V", "getIdentity", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "Lkotlinx/serialization/SerialName;", "value", "getPhase$annotations", "getPhase", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackagePhase;", "getBytesDownloaded$annotations", "getBytesDownloaded", "()J", "getPreviousCommitted$annotations", "getPreviousCommitted", "getFiles$annotations", "getFiles", "()Ljava/util/List;", "getDesiredFiles$annotations", "getDesiredFiles", "getPreviousFiles$annotations", "getPreviousFiles", "getPhaseUpdatedAtEpochMs$annotations", "getPhaseUpdatedAtEpochMs", "getLastError$annotations", "getLastError", "()Ljava/lang/String;", "packageId", "getPackageId", "archiveSize", "getArchiveSize", "archiveCrc32", "getArchiveCrc32", "isReady", "", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class ArchivePackageJournalEntry {
    public static final int $stable = 0;
    private final long bytesDownloaded;
    private final List<ArchivePackageFileRecord> desiredFiles;
    private final List<ArchivePackageFileRecord> files;
    private final ArchivePackageIdentity identity;
    private final String lastError;
    private final ArchivePackagePhase phase;
    private final long phaseUpdatedAtEpochMs;
    private final ArchivePackageIdentity previousCommitted;
    private final List<ArchivePackageFileRecord> previousFiles;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ArchivePackageJournalEntry._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ArchivePackageJournalEntry._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = ArchivePackageJournalEntry._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = ArchivePackageJournalEntry._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return ArchivePackagePhase.Companion.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ArchivePackageFileRecord$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(ArchivePackageFileRecord$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(ArchivePackageFileRecord$$serializer.INSTANCE);
    }

    public static /* synthetic */ ArchivePackageJournalEntry copy$default(ArchivePackageJournalEntry archivePackageJournalEntry, ArchivePackageIdentity archivePackageIdentity, ArchivePackagePhase archivePackagePhase, long j, ArchivePackageIdentity archivePackageIdentity2, List list, List list2, List list3, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            archivePackageIdentity = archivePackageJournalEntry.identity;
        }
        if ((i & 2) != 0) {
            archivePackagePhase = archivePackageJournalEntry.phase;
        }
        if ((i & 4) != 0) {
            j = archivePackageJournalEntry.bytesDownloaded;
        }
        if ((i & 8) != 0) {
            archivePackageIdentity2 = archivePackageJournalEntry.previousCommitted;
        }
        List<ArchivePackageFileRecord> list4 = list;
        if ((i & 16) != 0) {
            list4 = archivePackageJournalEntry.files;
        }
        List<ArchivePackageFileRecord> list5 = list2;
        if ((i & 32) != 0) {
            list5 = archivePackageJournalEntry.desiredFiles;
        }
        List<ArchivePackageFileRecord> list6 = list3;
        if ((i & 64) != 0) {
            list6 = archivePackageJournalEntry.previousFiles;
        }
        if ((i & 128) != 0) {
            j2 = archivePackageJournalEntry.phaseUpdatedAtEpochMs;
        }
        if ((i & 256) != 0) {
            str = archivePackageJournalEntry.lastError;
        }
        String str2 = str;
        long j3 = j2;
        long j4 = j;
        return archivePackageJournalEntry.copy(archivePackageIdentity, archivePackagePhase, j4, archivePackageIdentity2, list4, list5, list6, j3, str2);
    }

    @SerialName("bytesDownloaded")
    public static /* synthetic */ void getBytesDownloaded$annotations() {
    }

    @SerialName("desiredFiles")
    public static /* synthetic */ void getDesiredFiles$annotations() {
    }

    @SerialName(OriginalTzArchiveManifestParser.FILES_ROOT)
    public static /* synthetic */ void getFiles$annotations() {
    }

    @SerialName("identity")
    public static /* synthetic */ void getIdentity$annotations() {
    }

    @SerialName("lastError")
    public static /* synthetic */ void getLastError$annotations() {
    }

    @SerialName(TypedValues.CycleType.S_WAVE_PHASE)
    public static /* synthetic */ void getPhase$annotations() {
    }

    @SerialName("phaseUpdatedAtEpochMs")
    public static /* synthetic */ void getPhaseUpdatedAtEpochMs$annotations() {
    }

    @SerialName("previousCommitted")
    public static /* synthetic */ void getPreviousCommitted$annotations() {
    }

    @SerialName("previousFiles")
    public static /* synthetic */ void getPreviousFiles$annotations() {
    }

    public final ArchivePackageIdentity component1() {
        return this.identity;
    }

    public final ArchivePackagePhase component2() {
        return this.phase;
    }

    public final long component3() {
        return this.bytesDownloaded;
    }

    public final ArchivePackageIdentity component4() {
        return this.previousCommitted;
    }

    public final List<ArchivePackageFileRecord> component5() {
        return this.files;
    }

    public final List<ArchivePackageFileRecord> component6() {
        return this.desiredFiles;
    }

    public final List<ArchivePackageFileRecord> component7() {
        return this.previousFiles;
    }

    public final long component8() {
        return this.phaseUpdatedAtEpochMs;
    }

    public final String component9() {
        return this.lastError;
    }

    public final ArchivePackageJournalEntry copy(ArchivePackageIdentity identity, ArchivePackagePhase phase, long j, ArchivePackageIdentity archivePackageIdentity, List<ArchivePackageFileRecord> files, List<ArchivePackageFileRecord> desiredFiles, List<ArchivePackageFileRecord> previousFiles, long j2, String str) {
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(desiredFiles, "desiredFiles");
        Intrinsics.checkNotNullParameter(previousFiles, "previousFiles");
        return new ArchivePackageJournalEntry(identity, phase, j, archivePackageIdentity, files, desiredFiles, previousFiles, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePackageJournalEntry) {
            ArchivePackageJournalEntry archivePackageJournalEntry = (ArchivePackageJournalEntry) obj;
            return Intrinsics.areEqual(this.identity, archivePackageJournalEntry.identity) && this.phase == archivePackageJournalEntry.phase && this.bytesDownloaded == archivePackageJournalEntry.bytesDownloaded && Intrinsics.areEqual(this.previousCommitted, archivePackageJournalEntry.previousCommitted) && Intrinsics.areEqual(this.files, archivePackageJournalEntry.files) && Intrinsics.areEqual(this.desiredFiles, archivePackageJournalEntry.desiredFiles) && Intrinsics.areEqual(this.previousFiles, archivePackageJournalEntry.previousFiles) && this.phaseUpdatedAtEpochMs == archivePackageJournalEntry.phaseUpdatedAtEpochMs && Intrinsics.areEqual(this.lastError, archivePackageJournalEntry.lastError);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.identity.hashCode() * 31) + this.phase.hashCode()) * 31) + Long.hashCode(this.bytesDownloaded)) * 31;
        ArchivePackageIdentity archivePackageIdentity = this.previousCommitted;
        int hashCode2 = (((((((((hashCode + (archivePackageIdentity == null ? 0 : archivePackageIdentity.hashCode())) * 31) + this.files.hashCode()) * 31) + this.desiredFiles.hashCode()) * 31) + this.previousFiles.hashCode()) * 31) + Long.hashCode(this.phaseUpdatedAtEpochMs)) * 31;
        String str = this.lastError;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        ArchivePackageIdentity archivePackageIdentity = this.identity;
        ArchivePackagePhase archivePackagePhase = this.phase;
        long j = this.bytesDownloaded;
        ArchivePackageIdentity archivePackageIdentity2 = this.previousCommitted;
        List<ArchivePackageFileRecord> list = this.files;
        List<ArchivePackageFileRecord> list2 = this.desiredFiles;
        List<ArchivePackageFileRecord> list3 = this.previousFiles;
        long j2 = this.phaseUpdatedAtEpochMs;
        return "ArchivePackageJournalEntry(identity=" + archivePackageIdentity + ", phase=" + archivePackagePhase + ", bytesDownloaded=" + j + ", previousCommitted=" + archivePackageIdentity2 + ", files=" + list + ", desiredFiles=" + list2 + ", previousFiles=" + list3 + ", phaseUpdatedAtEpochMs=" + j2 + ", lastError=" + this.lastError + ")";
    }

    /* compiled from: ArchiveStateModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchivePackageJournalEntry> serializer() {
            return ArchivePackageJournalEntry$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ArchivePackageJournalEntry(int i, ArchivePackageIdentity archivePackageIdentity, ArchivePackagePhase archivePackagePhase, long j, ArchivePackageIdentity archivePackageIdentity2, List list, List list2, List list3, long j2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ArchivePackageJournalEntry$$serializer.INSTANCE.getDescriptor());
        }
        this.identity = archivePackageIdentity;
        this.phase = archivePackagePhase;
        if ((i & 4) == 0) {
            this.bytesDownloaded = 0L;
        } else {
            this.bytesDownloaded = j;
        }
        if ((i & 8) == 0) {
            this.previousCommitted = null;
        } else {
            this.previousCommitted = archivePackageIdentity2;
        }
        if ((i & 16) == 0) {
            this.files = CollectionsKt.emptyList();
        } else {
            this.files = list;
        }
        if ((i & 32) == 0) {
            this.desiredFiles = CollectionsKt.emptyList();
        } else {
            this.desiredFiles = list2;
        }
        if ((i & 64) == 0) {
            this.previousFiles = CollectionsKt.emptyList();
        } else {
            this.previousFiles = list3;
        }
        if ((i & 128) == 0) {
            this.phaseUpdatedAtEpochMs = 0L;
        } else {
            this.phaseUpdatedAtEpochMs = j2;
        }
        if ((i & 256) == 0) {
            this.lastError = null;
        } else {
            this.lastError = str;
        }
    }

    public ArchivePackageJournalEntry(ArchivePackageIdentity identity, ArchivePackagePhase phase, long j, ArchivePackageIdentity archivePackageIdentity, List<ArchivePackageFileRecord> files, List<ArchivePackageFileRecord> desiredFiles, List<ArchivePackageFileRecord> previousFiles, long j2, String str) {
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(desiredFiles, "desiredFiles");
        Intrinsics.checkNotNullParameter(previousFiles, "previousFiles");
        this.identity = identity;
        this.phase = phase;
        this.bytesDownloaded = j;
        this.previousCommitted = archivePackageIdentity;
        this.files = files;
        this.desiredFiles = desiredFiles;
        this.previousFiles = previousFiles;
        this.phaseUpdatedAtEpochMs = j2;
        this.lastError = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ArchivePackageJournalEntry archivePackageJournalEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, ArchivePackageIdentity$$serializer.INSTANCE, archivePackageJournalEntry.identity);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), archivePackageJournalEntry.phase);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || archivePackageJournalEntry.bytesDownloaded != 0) {
            compositeEncoder.encodeLongElement(serialDescriptor, 2, archivePackageJournalEntry.bytesDownloaded);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || archivePackageJournalEntry.previousCommitted != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, ArchivePackageIdentity$$serializer.INSTANCE, archivePackageJournalEntry.previousCommitted);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(archivePackageJournalEntry.files, CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 4, lazyArr[4].getValue(), archivePackageJournalEntry.files);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || !Intrinsics.areEqual(archivePackageJournalEntry.desiredFiles, CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 5, lazyArr[5].getValue(), archivePackageJournalEntry.desiredFiles);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || !Intrinsics.areEqual(archivePackageJournalEntry.previousFiles, CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, lazyArr[6].getValue(), archivePackageJournalEntry.previousFiles);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || archivePackageJournalEntry.phaseUpdatedAtEpochMs != 0) {
            compositeEncoder.encodeLongElement(serialDescriptor, 7, archivePackageJournalEntry.phaseUpdatedAtEpochMs);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) && archivePackageJournalEntry.lastError == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, archivePackageJournalEntry.lastError);
    }

    public final ArchivePackageIdentity getIdentity() {
        return this.identity;
    }

    public final ArchivePackagePhase getPhase() {
        return this.phase;
    }

    public final long getBytesDownloaded() {
        return this.bytesDownloaded;
    }

    public final ArchivePackageIdentity getPreviousCommitted() {
        return this.previousCommitted;
    }

    public /* synthetic */ ArchivePackageJournalEntry(ArchivePackageIdentity archivePackageIdentity, ArchivePackagePhase archivePackagePhase, long j, ArchivePackageIdentity archivePackageIdentity2, List list, List list2, List list3, long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        ArchivePackageJournalEntry archivePackageJournalEntry;
        ArchivePackageIdentity archivePackageIdentity3;
        ArchivePackagePhase archivePackagePhase2;
        long j3 = (i & 4) != 0 ? 0L : j;
        ArchivePackageIdentity archivePackageIdentity4 = (i & 8) != 0 ? null : archivePackageIdentity2;
        List emptyList = (i & 16) != 0 ? CollectionsKt.emptyList() : list;
        List emptyList2 = (i & 32) != 0 ? CollectionsKt.emptyList() : list2;
        List emptyList3 = (i & 64) != 0 ? CollectionsKt.emptyList() : list3;
        long j4 = (i & 128) != 0 ? 0L : j2;
        if ((i & 256) != 0) {
            str2 = null;
            archivePackageIdentity3 = archivePackageIdentity;
            archivePackagePhase2 = archivePackagePhase;
            archivePackageJournalEntry = this;
        } else {
            str2 = str;
            archivePackageJournalEntry = this;
            archivePackageIdentity3 = archivePackageIdentity;
            archivePackagePhase2 = archivePackagePhase;
        }
        new ArchivePackageJournalEntry(archivePackageIdentity3, archivePackagePhase2, j3, archivePackageIdentity4, emptyList, emptyList2, emptyList3, j4, str2);
    }

    public final List<ArchivePackageFileRecord> getFiles() {
        return this.files;
    }

    public final List<ArchivePackageFileRecord> getDesiredFiles() {
        return this.desiredFiles;
    }

    public final List<ArchivePackageFileRecord> getPreviousFiles() {
        return this.previousFiles;
    }

    public final long getPhaseUpdatedAtEpochMs() {
        return this.phaseUpdatedAtEpochMs;
    }

    public final String getLastError() {
        return this.lastError;
    }

    public final String getPackageId() {
        return this.identity.getPackageId();
    }

    public final long getArchiveSize() {
        return this.identity.getArchiveSize();
    }

    public final long getArchiveCrc32() {
        return this.identity.getArchiveCrc32();
    }

    public final boolean isReady() {
        return this.phase == ArchivePackagePhase.COMMITTED;
    }
}
