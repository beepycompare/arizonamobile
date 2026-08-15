package com.arizona.launcher.updater.archive.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveEntryMetadata.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "", "entryPath", "", "size", "", "crc32", "<init>", "(Ljava/lang/String;JJ)V", "getEntryPath", "()Ljava/lang/String;", "getSize", "()J", "getCrc32", "targetRelativePath", "getTargetRelativePath", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveEntryMetadata {
    public static final int $stable = 0;
    private final long crc32;
    private final String entryPath;
    private final long size;
    private final String targetRelativePath;

    public static /* synthetic */ ArchiveEntryMetadata copy$default(ArchiveEntryMetadata archiveEntryMetadata, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveEntryMetadata.entryPath;
        }
        if ((i & 2) != 0) {
            j = archiveEntryMetadata.size;
        }
        if ((i & 4) != 0) {
            j2 = archiveEntryMetadata.crc32;
        }
        return archiveEntryMetadata.copy(str, j, j2);
    }

    public final String component1() {
        return this.entryPath;
    }

    public final long component2() {
        return this.size;
    }

    public final long component3() {
        return this.crc32;
    }

    public final ArchiveEntryMetadata copy(String entryPath, long j, long j2) {
        Intrinsics.checkNotNullParameter(entryPath, "entryPath");
        return new ArchiveEntryMetadata(entryPath, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveEntryMetadata) {
            ArchiveEntryMetadata archiveEntryMetadata = (ArchiveEntryMetadata) obj;
            return Intrinsics.areEqual(this.entryPath, archiveEntryMetadata.entryPath) && this.size == archiveEntryMetadata.size && this.crc32 == archiveEntryMetadata.crc32;
        }
        return false;
    }

    public int hashCode() {
        return (((this.entryPath.hashCode() * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.crc32);
    }

    public String toString() {
        String str = this.entryPath;
        long j = this.size;
        return "ArchiveEntryMetadata(entryPath=" + str + ", size=" + j + ", crc32=" + this.crc32 + ")";
    }

    public ArchiveEntryMetadata(String entryPath, long j, long j2) {
        Intrinsics.checkNotNullParameter(entryPath, "entryPath");
        this.entryPath = entryPath;
        this.size = j;
        this.crc32 = j2;
        this.targetRelativePath = ArchiveModelRules.INSTANCE.entryTarget(entryPath);
        ArchiveModelRules.INSTANCE.requireNonNegativeSize(j, "entry size");
        ArchiveModelRules.INSTANCE.requireUnsignedCrc32(j2);
    }

    public final String getEntryPath() {
        return this.entryPath;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final String getTargetRelativePath() {
        return this.targetRelativePath;
    }
}
