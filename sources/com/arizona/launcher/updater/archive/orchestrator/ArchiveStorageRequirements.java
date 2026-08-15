package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
/* compiled from: ArchiveStorageEstimator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirements;", "", "gameBytes", "", "downloadBytes", "<init>", "(JJ)V", "getGameBytes", "()J", "getDownloadBytes", "combinedBytes", "getCombinedBytes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageRequirements {
    public static final int $stable = 0;
    private final long combinedBytes;
    private final long downloadBytes;
    private final long gameBytes;

    public static /* synthetic */ ArchiveStorageRequirements copy$default(ArchiveStorageRequirements archiveStorageRequirements, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = archiveStorageRequirements.gameBytes;
        }
        if ((i & 2) != 0) {
            j2 = archiveStorageRequirements.downloadBytes;
        }
        return archiveStorageRequirements.copy(j, j2);
    }

    public final long component1() {
        return this.gameBytes;
    }

    public final long component2() {
        return this.downloadBytes;
    }

    public final ArchiveStorageRequirements copy(long j, long j2) {
        return new ArchiveStorageRequirements(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveStorageRequirements) {
            ArchiveStorageRequirements archiveStorageRequirements = (ArchiveStorageRequirements) obj;
            return this.gameBytes == archiveStorageRequirements.gameBytes && this.downloadBytes == archiveStorageRequirements.downloadBytes;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.gameBytes) * 31) + Long.hashCode(this.downloadBytes);
    }

    public String toString() {
        long j = this.gameBytes;
        return "ArchiveStorageRequirements(gameBytes=" + j + ", downloadBytes=" + this.downloadBytes + ")";
    }

    public ArchiveStorageRequirements(long j, long j2) {
        this.gameBytes = j;
        this.downloadBytes = j2;
        try {
            this.combinedBytes = Math.addExact(j, j2);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("archive storage estimate overflows Long", e);
        }
    }

    public final long getGameBytes() {
        return this.gameBytes;
    }

    public final long getDownloadBytes() {
        return this.downloadBytes;
    }

    public final long getCombinedBytes() {
        return this.combinedBytes;
    }
}
