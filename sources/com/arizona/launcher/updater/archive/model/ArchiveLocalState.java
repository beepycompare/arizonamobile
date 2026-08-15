package com.arizona.launcher.updater.archive.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveLocalState.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveLocalState;", "", "schemaVersion", "", "manifestVersion", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "bootstrapComplete", "", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackageIdentity;", "<init>", "(ILjava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;ZLjava/util/List;)V", "getSchemaVersion", "()I", "getManifestVersion", "()Ljava/lang/String;", "getSelectedGpu", "()Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "getBootstrapComplete", "()Z", "getPackages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveLocalState {
    public static final int $stable = 8;
    private final boolean bootstrapComplete;
    private final String manifestVersion;
    private final List<ArchivePackageIdentity> packages;
    private final int schemaVersion;
    private final ArchiveGpu selectedGpu;

    public static /* synthetic */ ArchiveLocalState copy$default(ArchiveLocalState archiveLocalState, int i, String str, ArchiveGpu archiveGpu, boolean z, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = archiveLocalState.schemaVersion;
        }
        if ((i2 & 2) != 0) {
            str = archiveLocalState.manifestVersion;
        }
        if ((i2 & 4) != 0) {
            archiveGpu = archiveLocalState.selectedGpu;
        }
        if ((i2 & 8) != 0) {
            z = archiveLocalState.bootstrapComplete;
        }
        List<ArchivePackageIdentity> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = archiveLocalState.packages;
        }
        List list3 = list2;
        ArchiveGpu archiveGpu2 = archiveGpu;
        return archiveLocalState.copy(i, str, archiveGpu2, z, list3);
    }

    public final int component1() {
        return this.schemaVersion;
    }

    public final String component2() {
        return this.manifestVersion;
    }

    public final ArchiveGpu component3() {
        return this.selectedGpu;
    }

    public final boolean component4() {
        return this.bootstrapComplete;
    }

    public final List<ArchivePackageIdentity> component5() {
        return this.packages;
    }

    public final ArchiveLocalState copy(int i, String str, ArchiveGpu archiveGpu, boolean z, List<ArchivePackageIdentity> packages) {
        Intrinsics.checkNotNullParameter(packages, "packages");
        return new ArchiveLocalState(i, str, archiveGpu, z, packages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveLocalState) {
            ArchiveLocalState archiveLocalState = (ArchiveLocalState) obj;
            return this.schemaVersion == archiveLocalState.schemaVersion && Intrinsics.areEqual(this.manifestVersion, archiveLocalState.manifestVersion) && this.selectedGpu == archiveLocalState.selectedGpu && this.bootstrapComplete == archiveLocalState.bootstrapComplete && Intrinsics.areEqual(this.packages, archiveLocalState.packages);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.schemaVersion) * 31;
        String str = this.manifestVersion;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ArchiveGpu archiveGpu = this.selectedGpu;
        return ((((hashCode2 + (archiveGpu != null ? archiveGpu.hashCode() : 0)) * 31) + Boolean.hashCode(this.bootstrapComplete)) * 31) + this.packages.hashCode();
    }

    public String toString() {
        int i = this.schemaVersion;
        String str = this.manifestVersion;
        ArchiveGpu archiveGpu = this.selectedGpu;
        boolean z = this.bootstrapComplete;
        return "ArchiveLocalState(schemaVersion=" + i + ", manifestVersion=" + str + ", selectedGpu=" + archiveGpu + ", bootstrapComplete=" + z + ", packages=" + this.packages + ")";
    }

    public ArchiveLocalState(int i, String str, ArchiveGpu archiveGpu, boolean z, List<ArchivePackageIdentity> packages) {
        Intrinsics.checkNotNullParameter(packages, "packages");
        this.schemaVersion = i;
        this.manifestVersion = str;
        this.selectedGpu = archiveGpu;
        this.bootstrapComplete = z;
        this.packages = packages;
        if (i < 1) {
            throw new IllegalArgumentException("local schemaVersion must be positive".toString());
        }
        if (str != null) {
            ArchiveModelRules.INSTANCE.requireManifestVersion(str);
        }
        List<ArchivePackageIdentity> list = packages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ArchivePackageIdentity archivePackageIdentity : list) {
            arrayList.add(archivePackageIdentity.getId());
        }
        if (CollectionsKt.toSet(arrayList).size() != this.packages.size()) {
            throw new IllegalArgumentException("local package ids must be unique".toString());
        }
        if (this.bootstrapComplete && this.packages.isEmpty()) {
            throw new IllegalArgumentException("a completed bootstrap must contain package identities".toString());
        }
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getManifestVersion() {
        return this.manifestVersion;
    }

    public final ArchiveGpu getSelectedGpu() {
        return this.selectedGpu;
    }

    public final boolean getBootstrapComplete() {
        return this.bootstrapComplete;
    }

    public final List<ArchivePackageIdentity> getPackages() {
        return this.packages;
    }
}
