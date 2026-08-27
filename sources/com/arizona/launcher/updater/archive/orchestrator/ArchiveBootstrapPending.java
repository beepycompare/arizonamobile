package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPending;", "", "downloadBytes", "", "<init>", "(J)V", "getDownloadBytes", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveBootstrapPending {
    public static final int $stable = 0;
    private final long downloadBytes;

    public static /* synthetic */ ArchiveBootstrapPending copy$default(ArchiveBootstrapPending archiveBootstrapPending, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = archiveBootstrapPending.downloadBytes;
        }
        return archiveBootstrapPending.copy(j);
    }

    public final long component1() {
        return this.downloadBytes;
    }

    public final ArchiveBootstrapPending copy(long j) {
        return new ArchiveBootstrapPending(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ArchiveBootstrapPending) && this.downloadBytes == ((ArchiveBootstrapPending) obj).downloadBytes;
    }

    public int hashCode() {
        return Long.hashCode(this.downloadBytes);
    }

    public String toString() {
        return "ArchiveBootstrapPending(downloadBytes=" + this.downloadBytes + ")";
    }

    public ArchiveBootstrapPending(long j) {
        this.downloadBytes = j;
        if (j <= 0) {
            throw new IllegalArgumentException("bootstrap download bytes must be positive".toString());
        }
    }

    public final long getDownloadBytes() {
        return this.downloadBytes;
    }
}
