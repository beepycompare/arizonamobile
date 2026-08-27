package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveEntryTransfer;", "", "desired", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "prepared", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;)V", "getDesired", "()Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "getPrepared", "()Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveSelectiveEntryTransfer {
    public static final int $stable = RemoteZipPreparedEntry.$stable | ArchivePackageFileRecord.$stable;
    private final ArchivePackageFileRecord desired;
    private final RemoteZipPreparedEntry prepared;

    public static /* synthetic */ ArchiveSelectiveEntryTransfer copy$default(ArchiveSelectiveEntryTransfer archiveSelectiveEntryTransfer, ArchivePackageFileRecord archivePackageFileRecord, RemoteZipPreparedEntry remoteZipPreparedEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            archivePackageFileRecord = archiveSelectiveEntryTransfer.desired;
        }
        if ((i & 2) != 0) {
            remoteZipPreparedEntry = archiveSelectiveEntryTransfer.prepared;
        }
        return archiveSelectiveEntryTransfer.copy(archivePackageFileRecord, remoteZipPreparedEntry);
    }

    public final ArchivePackageFileRecord component1() {
        return this.desired;
    }

    public final RemoteZipPreparedEntry component2() {
        return this.prepared;
    }

    public final ArchiveSelectiveEntryTransfer copy(ArchivePackageFileRecord desired, RemoteZipPreparedEntry prepared) {
        Intrinsics.checkNotNullParameter(desired, "desired");
        Intrinsics.checkNotNullParameter(prepared, "prepared");
        return new ArchiveSelectiveEntryTransfer(desired, prepared);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveSelectiveEntryTransfer) {
            ArchiveSelectiveEntryTransfer archiveSelectiveEntryTransfer = (ArchiveSelectiveEntryTransfer) obj;
            return Intrinsics.areEqual(this.desired, archiveSelectiveEntryTransfer.desired) && Intrinsics.areEqual(this.prepared, archiveSelectiveEntryTransfer.prepared);
        }
        return false;
    }

    public int hashCode() {
        return (this.desired.hashCode() * 31) + this.prepared.hashCode();
    }

    public String toString() {
        ArchivePackageFileRecord archivePackageFileRecord = this.desired;
        return "ArchiveSelectiveEntryTransfer(desired=" + archivePackageFileRecord + ", prepared=" + this.prepared + ")";
    }

    public ArchiveSelectiveEntryTransfer(ArchivePackageFileRecord desired, RemoteZipPreparedEntry prepared) {
        Intrinsics.checkNotNullParameter(desired, "desired");
        Intrinsics.checkNotNullParameter(prepared, "prepared");
        this.desired = desired;
        this.prepared = prepared;
    }

    public final ArchivePackageFileRecord getDesired() {
        return this.desired;
    }

    public final RemoteZipPreparedEntry getPrepared() {
        return this.prepared;
    }
}
