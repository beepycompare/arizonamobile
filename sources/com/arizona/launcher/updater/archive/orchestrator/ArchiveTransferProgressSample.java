package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
/* compiled from: ArchiveTransferProgressTracker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveTransferProgressSample;", "", "downloadedBytes", "", "totalBytes", "speedDeltaBytes", "<init>", "(JJJ)V", "getDownloadedBytes", "()J", "getTotalBytes", "getSpeedDeltaBytes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveTransferProgressSample {
    public static final int $stable = 0;
    private final long downloadedBytes;
    private final long speedDeltaBytes;
    private final long totalBytes;

    public static /* synthetic */ ArchiveTransferProgressSample copy$default(ArchiveTransferProgressSample archiveTransferProgressSample, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = archiveTransferProgressSample.downloadedBytes;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = archiveTransferProgressSample.totalBytes;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = archiveTransferProgressSample.speedDeltaBytes;
        }
        return archiveTransferProgressSample.copy(j4, j5, j3);
    }

    public final long component1() {
        return this.downloadedBytes;
    }

    public final long component2() {
        return this.totalBytes;
    }

    public final long component3() {
        return this.speedDeltaBytes;
    }

    public final ArchiveTransferProgressSample copy(long j, long j2, long j3) {
        return new ArchiveTransferProgressSample(j, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveTransferProgressSample) {
            ArchiveTransferProgressSample archiveTransferProgressSample = (ArchiveTransferProgressSample) obj;
            return this.downloadedBytes == archiveTransferProgressSample.downloadedBytes && this.totalBytes == archiveTransferProgressSample.totalBytes && this.speedDeltaBytes == archiveTransferProgressSample.speedDeltaBytes;
        }
        return false;
    }

    public int hashCode() {
        return (((Long.hashCode(this.downloadedBytes) * 31) + Long.hashCode(this.totalBytes)) * 31) + Long.hashCode(this.speedDeltaBytes);
    }

    public String toString() {
        long j = this.downloadedBytes;
        long j2 = this.totalBytes;
        return "ArchiveTransferProgressSample(downloadedBytes=" + j + ", totalBytes=" + j2 + ", speedDeltaBytes=" + this.speedDeltaBytes + ")";
    }

    public ArchiveTransferProgressSample(long j, long j2, long j3) {
        this.downloadedBytes = j;
        this.totalBytes = j2;
        this.speedDeltaBytes = j3;
    }

    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final long getSpeedDeltaBytes() {
        return this.speedDeltaBytes;
    }
}
