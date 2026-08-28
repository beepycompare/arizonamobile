package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
/* compiled from: ArchiveProgressPublicationCoalescer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveProgressSample;", "", "downloadedBytes", "", "totalBytes", "<init>", "(JJ)V", "getDownloadedBytes", "()J", "getTotalBytes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveProgressSample {
    public static final int $stable = 0;
    private final long downloadedBytes;
    private final long totalBytes;

    public static /* synthetic */ ArchiveProgressSample copy$default(ArchiveProgressSample archiveProgressSample, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = archiveProgressSample.downloadedBytes;
        }
        if ((i & 2) != 0) {
            j2 = archiveProgressSample.totalBytes;
        }
        return archiveProgressSample.copy(j, j2);
    }

    public final long component1() {
        return this.downloadedBytes;
    }

    public final long component2() {
        return this.totalBytes;
    }

    public final ArchiveProgressSample copy(long j, long j2) {
        return new ArchiveProgressSample(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveProgressSample) {
            ArchiveProgressSample archiveProgressSample = (ArchiveProgressSample) obj;
            return this.downloadedBytes == archiveProgressSample.downloadedBytes && this.totalBytes == archiveProgressSample.totalBytes;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.downloadedBytes) * 31) + Long.hashCode(this.totalBytes);
    }

    public String toString() {
        long j = this.downloadedBytes;
        return "ArchiveProgressSample(downloadedBytes=" + j + ", totalBytes=" + this.totalBytes + ")";
    }

    public ArchiveProgressSample(long j, long j2) {
        this.downloadedBytes = j;
        this.totalBytes = j2;
        if (j < 0) {
            throw new IllegalArgumentException("downloadedBytes must be non-negative".toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("totalBytes must be non-negative".toString());
        }
    }

    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }
}
