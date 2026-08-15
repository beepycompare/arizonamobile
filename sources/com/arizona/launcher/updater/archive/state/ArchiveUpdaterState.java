package com.arizona.launcher.updater.archive.state;

import java.util.Collection;
import java.util.Iterator;
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
/* compiled from: ArchiveStateModels.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0002OPBe\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013By\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u0010\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u00020\u0005J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u0011HÆ\u0003Jo\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0014\u0010B\u001a\u00020\u000f2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010D\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010E\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0001b\u0002\bN¢\u0006\u0002\bMR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010 R*\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR*\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010 R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\t¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010)R0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\f¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010)R*\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010.R*\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0010¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b2\u0010.R\u0011\u00103\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b3\u0010.R\u0011\u00104\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b5\u0010.Ê\u0001\u0002\bRÊ\u0001\f\bS\u0012\b\bT\u0012\u0004\b\u0003\u0010\u0002¨\u0006Q"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "", "schemaVersion", "", "manifestId", "", "manifestVersion", "manifestSchemaVersion", "selectedGpu", "packages", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "pendingRetirements", "Lcom/arizona/launcher/updater/archive/state/ArchiveFileRetirementRecord;", "legacyMetadataReconciled", "", "updatedAtEpochMs", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;ZJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;ZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSchemaVersion$annotations", "()V", "getSchemaVersion", "()I", "Lkotlinx/serialization/SerialName;", "value", "getManifestId$annotations", "getManifestId", "()Ljava/lang/String;", "getManifestVersion$annotations", "getManifestVersion", "getManifestSchemaVersion$annotations", "getManifestSchemaVersion", "getSelectedGpu$annotations", "getSelectedGpu", "getPackages$annotations", "getPackages", "()Ljava/util/List;", "getPendingRetirements$annotations", "getPendingRetirements", "getLegacyMetadataReconciled$annotations", "getLegacyMetadataReconciled", "()Z", "getUpdatedAtEpochMs$annotations", "getUpdatedAtEpochMs", "()J", "isPayloadCommitted", "isInstallReady", "payloadMetadataReconciled", "getPayloadMetadataReconciled", "packageById", "packageId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class ArchiveUpdaterState {
    public static final int $stable = 0;
    private final boolean legacyMetadataReconciled;
    private final String manifestId;
    private final int manifestSchemaVersion;
    private final String manifestVersion;
    private final List<ArchivePackageJournalEntry> packages;
    private final List<ArchiveFileRetirementRecord> pendingRetirements;
    private final int schemaVersion;
    private final String selectedGpu;
    private final long updatedAtEpochMs;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchiveUpdaterState$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ArchiveUpdaterState._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.updater.archive.state.ArchiveUpdaterState$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ArchiveUpdaterState._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ArchivePackageJournalEntry$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ArchiveFileRetirementRecord$$serializer.INSTANCE);
    }

    public static /* synthetic */ ArchiveUpdaterState copy$default(ArchiveUpdaterState archiveUpdaterState, int i, String str, String str2, int i2, String str3, List list, List list2, boolean z, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = archiveUpdaterState.schemaVersion;
        }
        if ((i3 & 2) != 0) {
            str = archiveUpdaterState.manifestId;
        }
        if ((i3 & 4) != 0) {
            str2 = archiveUpdaterState.manifestVersion;
        }
        if ((i3 & 8) != 0) {
            i2 = archiveUpdaterState.manifestSchemaVersion;
        }
        if ((i3 & 16) != 0) {
            str3 = archiveUpdaterState.selectedGpu;
        }
        List<ArchivePackageJournalEntry> list3 = list;
        if ((i3 & 32) != 0) {
            list3 = archiveUpdaterState.packages;
        }
        List<ArchiveFileRetirementRecord> list4 = list2;
        if ((i3 & 64) != 0) {
            list4 = archiveUpdaterState.pendingRetirements;
        }
        if ((i3 & 128) != 0) {
            z = archiveUpdaterState.legacyMetadataReconciled;
        }
        if ((i3 & 256) != 0) {
            j = archiveUpdaterState.updatedAtEpochMs;
        }
        long j2 = j;
        List list5 = list4;
        boolean z2 = z;
        String str4 = str3;
        List list6 = list3;
        return archiveUpdaterState.copy(i, str, str2, i2, str4, list6, list5, z2, j2);
    }

    @SerialName("legacyMetadataReconciled")
    public static /* synthetic */ void getLegacyMetadataReconciled$annotations() {
    }

    @SerialName("manifestId")
    public static /* synthetic */ void getManifestId$annotations() {
    }

    @SerialName("manifestSchemaVersion")
    public static /* synthetic */ void getManifestSchemaVersion$annotations() {
    }

    @SerialName("manifestVersion")
    public static /* synthetic */ void getManifestVersion$annotations() {
    }

    @SerialName("packages")
    public static /* synthetic */ void getPackages$annotations() {
    }

    @SerialName("pendingRetirements")
    public static /* synthetic */ void getPendingRetirements$annotations() {
    }

    @SerialName("schemaVersion")
    public static /* synthetic */ void getSchemaVersion$annotations() {
    }

    @SerialName("selectedGpu")
    public static /* synthetic */ void getSelectedGpu$annotations() {
    }

    @SerialName("updatedAtEpochMs")
    public static /* synthetic */ void getUpdatedAtEpochMs$annotations() {
    }

    public final int component1() {
        return this.schemaVersion;
    }

    public final String component2() {
        return this.manifestId;
    }

    public final String component3() {
        return this.manifestVersion;
    }

    public final int component4() {
        return this.manifestSchemaVersion;
    }

    public final String component5() {
        return this.selectedGpu;
    }

    public final List<ArchivePackageJournalEntry> component6() {
        return this.packages;
    }

    public final List<ArchiveFileRetirementRecord> component7() {
        return this.pendingRetirements;
    }

    public final boolean component8() {
        return this.legacyMetadataReconciled;
    }

    public final long component9() {
        return this.updatedAtEpochMs;
    }

    public final ArchiveUpdaterState copy(int i, String manifestId, String manifestVersion, int i2, String selectedGpu, List<ArchivePackageJournalEntry> packages, List<ArchiveFileRetirementRecord> pendingRetirements, boolean z, long j) {
        Intrinsics.checkNotNullParameter(manifestId, "manifestId");
        Intrinsics.checkNotNullParameter(manifestVersion, "manifestVersion");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(pendingRetirements, "pendingRetirements");
        return new ArchiveUpdaterState(i, manifestId, manifestVersion, i2, selectedGpu, packages, pendingRetirements, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveUpdaterState) {
            ArchiveUpdaterState archiveUpdaterState = (ArchiveUpdaterState) obj;
            return this.schemaVersion == archiveUpdaterState.schemaVersion && Intrinsics.areEqual(this.manifestId, archiveUpdaterState.manifestId) && Intrinsics.areEqual(this.manifestVersion, archiveUpdaterState.manifestVersion) && this.manifestSchemaVersion == archiveUpdaterState.manifestSchemaVersion && Intrinsics.areEqual(this.selectedGpu, archiveUpdaterState.selectedGpu) && Intrinsics.areEqual(this.packages, archiveUpdaterState.packages) && Intrinsics.areEqual(this.pendingRetirements, archiveUpdaterState.pendingRetirements) && this.legacyMetadataReconciled == archiveUpdaterState.legacyMetadataReconciled && this.updatedAtEpochMs == archiveUpdaterState.updatedAtEpochMs;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.schemaVersion) * 31) + this.manifestId.hashCode()) * 31) + this.manifestVersion.hashCode()) * 31) + Integer.hashCode(this.manifestSchemaVersion)) * 31) + this.selectedGpu.hashCode()) * 31) + this.packages.hashCode()) * 31) + this.pendingRetirements.hashCode()) * 31) + Boolean.hashCode(this.legacyMetadataReconciled)) * 31) + Long.hashCode(this.updatedAtEpochMs);
    }

    public String toString() {
        int i = this.schemaVersion;
        String str = this.manifestId;
        String str2 = this.manifestVersion;
        int i2 = this.manifestSchemaVersion;
        String str3 = this.selectedGpu;
        List<ArchivePackageJournalEntry> list = this.packages;
        List<ArchiveFileRetirementRecord> list2 = this.pendingRetirements;
        boolean z = this.legacyMetadataReconciled;
        return "ArchiveUpdaterState(schemaVersion=" + i + ", manifestId=" + str + ", manifestVersion=" + str2 + ", manifestSchemaVersion=" + i2 + ", selectedGpu=" + str3 + ", packages=" + list + ", pendingRetirements=" + list2 + ", legacyMetadataReconciled=" + z + ", updatedAtEpochMs=" + this.updatedAtEpochMs + ")";
    }

    /* compiled from: ArchiveStateModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchiveUpdaterState> serializer() {
            return ArchiveUpdaterState$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ArchiveUpdaterState(int i, int i2, String str, String str2, int i3, String str3, List list, List list2, boolean z, long j, SerializationConstructorMarker serializationConstructorMarker) {
        if (30 != (i & 30)) {
            PluginExceptionsKt.throwMissingFieldException(i, 30, ArchiveUpdaterState$$serializer.INSTANCE.getDescriptor());
        }
        this.schemaVersion = (i & 1) == 0 ? 1 : i2;
        this.manifestId = str;
        this.manifestVersion = str2;
        this.manifestSchemaVersion = i3;
        this.selectedGpu = str3;
        if ((i & 32) == 0) {
            this.packages = CollectionsKt.emptyList();
        } else {
            this.packages = list;
        }
        if ((i & 64) == 0) {
            this.pendingRetirements = CollectionsKt.emptyList();
        } else {
            this.pendingRetirements = list2;
        }
        if ((i & 128) == 0) {
            this.legacyMetadataReconciled = false;
        } else {
            this.legacyMetadataReconciled = z;
        }
        if ((i & 256) == 0) {
            this.updatedAtEpochMs = 0L;
        } else {
            this.updatedAtEpochMs = j;
        }
    }

    public ArchiveUpdaterState(int i, String manifestId, String manifestVersion, int i2, String selectedGpu, List<ArchivePackageJournalEntry> packages, List<ArchiveFileRetirementRecord> pendingRetirements, boolean z, long j) {
        Intrinsics.checkNotNullParameter(manifestId, "manifestId");
        Intrinsics.checkNotNullParameter(manifestVersion, "manifestVersion");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(pendingRetirements, "pendingRetirements");
        this.schemaVersion = i;
        this.manifestId = manifestId;
        this.manifestVersion = manifestVersion;
        this.manifestSchemaVersion = i2;
        this.selectedGpu = selectedGpu;
        this.packages = packages;
        this.pendingRetirements = pendingRetirements;
        this.legacyMetadataReconciled = z;
        this.updatedAtEpochMs = j;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ArchiveUpdaterState archiveUpdaterState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || archiveUpdaterState.schemaVersion != 1) {
            compositeEncoder.encodeIntElement(serialDescriptor, 0, archiveUpdaterState.schemaVersion);
        }
        compositeEncoder.encodeStringElement(serialDescriptor, 1, archiveUpdaterState.manifestId);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, archiveUpdaterState.manifestVersion);
        compositeEncoder.encodeIntElement(serialDescriptor, 3, archiveUpdaterState.manifestSchemaVersion);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, archiveUpdaterState.selectedGpu);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || !Intrinsics.areEqual(archiveUpdaterState.packages, CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 5, lazyArr[5].getValue(), archiveUpdaterState.packages);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || !Intrinsics.areEqual(archiveUpdaterState.pendingRetirements, CollectionsKt.emptyList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, lazyArr[6].getValue(), archiveUpdaterState.pendingRetirements);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || archiveUpdaterState.legacyMetadataReconciled) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 7, archiveUpdaterState.legacyMetadataReconciled);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) && archiveUpdaterState.updatedAtEpochMs == 0) {
            return;
        }
        compositeEncoder.encodeLongElement(serialDescriptor, 8, archiveUpdaterState.updatedAtEpochMs);
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getManifestId() {
        return this.manifestId;
    }

    public final String getManifestVersion() {
        return this.manifestVersion;
    }

    public final int getManifestSchemaVersion() {
        return this.manifestSchemaVersion;
    }

    public final String getSelectedGpu() {
        return this.selectedGpu;
    }

    public /* synthetic */ ArchiveUpdaterState(int i, String str, String str2, int i2, String str3, List list, List list2, boolean z, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, str, str2, i2, str3, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? 0L : j);
    }

    public final List<ArchivePackageJournalEntry> getPackages() {
        return this.packages;
    }

    public final List<ArchiveFileRetirementRecord> getPendingRetirements() {
        return this.pendingRetirements;
    }

    public final boolean getLegacyMetadataReconciled() {
        return this.legacyMetadataReconciled;
    }

    public final long getUpdatedAtEpochMs() {
        return this.updatedAtEpochMs;
    }

    public final boolean isPayloadCommitted() {
        if (this.packages.isEmpty()) {
            return false;
        }
        List<ArchivePackageJournalEntry> list = this.packages;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (ArchivePackageJournalEntry archivePackageJournalEntry : list) {
                if (!archivePackageJournalEntry.isReady()) {
                    return false;
                }
            }
        }
        return this.pendingRetirements.isEmpty();
    }

    public final boolean isInstallReady() {
        return isPayloadCommitted() && this.legacyMetadataReconciled;
    }

    public final boolean getPayloadMetadataReconciled() {
        return this.legacyMetadataReconciled;
    }

    public final ArchivePackageJournalEntry packageById(String packageId) {
        Object obj;
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Iterator<T> it = this.packages.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ArchivePackageJournalEntry) obj).getPackageId(), packageId)) {
                break;
            }
        }
        return (ArchivePackageJournalEntry) obj;
    }
}
