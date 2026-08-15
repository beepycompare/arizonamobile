package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndex;", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "installedSize", "", "<init>", "(Ljava/util/List;J)V", "getEntries", "()Ljava/util/List;", "getInstalledSize", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTzArchivePackageIndex {
    public static final int $stable = 8;
    private final List<ArchiveEntryMetadata> entries;
    private final long installedSize;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OriginalTzArchivePackageIndex copy$default(OriginalTzArchivePackageIndex originalTzArchivePackageIndex, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = originalTzArchivePackageIndex.entries;
        }
        if ((i & 2) != 0) {
            j = originalTzArchivePackageIndex.installedSize;
        }
        return originalTzArchivePackageIndex.copy(list, j);
    }

    public final List<ArchiveEntryMetadata> component1() {
        return this.entries;
    }

    public final long component2() {
        return this.installedSize;
    }

    public final OriginalTzArchivePackageIndex copy(List<ArchiveEntryMetadata> entries, long j) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new OriginalTzArchivePackageIndex(entries, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OriginalTzArchivePackageIndex) {
            OriginalTzArchivePackageIndex originalTzArchivePackageIndex = (OriginalTzArchivePackageIndex) obj;
            return Intrinsics.areEqual(this.entries, originalTzArchivePackageIndex.entries) && this.installedSize == originalTzArchivePackageIndex.installedSize;
        }
        return false;
    }

    public int hashCode() {
        return (this.entries.hashCode() * 31) + Long.hashCode(this.installedSize);
    }

    public String toString() {
        List<ArchiveEntryMetadata> list = this.entries;
        return "OriginalTzArchivePackageIndex(entries=" + list + ", installedSize=" + this.installedSize + ")";
    }

    public OriginalTzArchivePackageIndex(List<ArchiveEntryMetadata> entries, long j) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.installedSize = j;
    }

    public final List<ArchiveEntryMetadata> getEntries() {
        return this.entries;
    }

    public final long getInstalledSize() {
        return this.installedSize;
    }
}
