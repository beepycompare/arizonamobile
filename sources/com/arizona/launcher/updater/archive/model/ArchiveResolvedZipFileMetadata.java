package com.arizona.launcher.updater.archive.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fÊ\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0002¨\u0006 "}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipFileMetadata;", "", "entryPath", "", "size", "", "crc32", "compressedSize", "localHeaderOffset", "<init>", "(Ljava/lang/String;JJJJ)V", "getEntryPath", "()Ljava/lang/String;", "getSize", "()J", "getCrc32", "getCompressedSize", "getLocalHeaderOffset", "targetRelativePath", "getTargetRelativePath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveResolvedZipFileMetadata {
    public static final int $stable = 0;
    private final long compressedSize;
    private final long crc32;
    private final String entryPath;
    private final long localHeaderOffset;
    private final long size;
    private final String targetRelativePath;

    public static /* synthetic */ ArchiveResolvedZipFileMetadata copy$default(ArchiveResolvedZipFileMetadata archiveResolvedZipFileMetadata, String str, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveResolvedZipFileMetadata.entryPath;
        }
        if ((i & 2) != 0) {
            j = archiveResolvedZipFileMetadata.size;
        }
        if ((i & 4) != 0) {
            j2 = archiveResolvedZipFileMetadata.crc32;
        }
        if ((i & 8) != 0) {
            j3 = archiveResolvedZipFileMetadata.compressedSize;
        }
        if ((i & 16) != 0) {
            j4 = archiveResolvedZipFileMetadata.localHeaderOffset;
        }
        long j5 = j4;
        long j6 = j3;
        return archiveResolvedZipFileMetadata.copy(str, j, j2, j6, j5);
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

    public final long component4() {
        return this.compressedSize;
    }

    public final long component5() {
        return this.localHeaderOffset;
    }

    public final ArchiveResolvedZipFileMetadata copy(String entryPath, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(entryPath, "entryPath");
        return new ArchiveResolvedZipFileMetadata(entryPath, j, j2, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveResolvedZipFileMetadata) {
            ArchiveResolvedZipFileMetadata archiveResolvedZipFileMetadata = (ArchiveResolvedZipFileMetadata) obj;
            return Intrinsics.areEqual(this.entryPath, archiveResolvedZipFileMetadata.entryPath) && this.size == archiveResolvedZipFileMetadata.size && this.crc32 == archiveResolvedZipFileMetadata.crc32 && this.compressedSize == archiveResolvedZipFileMetadata.compressedSize && this.localHeaderOffset == archiveResolvedZipFileMetadata.localHeaderOffset;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.entryPath.hashCode() * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.crc32)) * 31) + Long.hashCode(this.compressedSize)) * 31) + Long.hashCode(this.localHeaderOffset);
    }

    public String toString() {
        String str = this.entryPath;
        long j = this.size;
        long j2 = this.crc32;
        long j3 = this.compressedSize;
        return "ArchiveResolvedZipFileMetadata(entryPath=" + str + ", size=" + j + ", crc32=" + j2 + ", compressedSize=" + j3 + ", localHeaderOffset=" + this.localHeaderOffset + ")";
    }

    public ArchiveResolvedZipFileMetadata(String entryPath, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(entryPath, "entryPath");
        this.entryPath = entryPath;
        this.size = j;
        this.crc32 = j2;
        this.compressedSize = j3;
        this.localHeaderOffset = j4;
        this.targetRelativePath = ArchiveModelRules.INSTANCE.entryTarget(entryPath);
        ArchiveModelRules.INSTANCE.requireNonNegativeSize(j, "entry size");
        ArchiveModelRules.INSTANCE.requireUnsignedCrc32(j2);
        ArchiveModelRules.INSTANCE.requireNonNegativeSize(j3, "compressed entry size");
        if (j4 < 0) {
            throw new IllegalArgumentException("ZIP local header offset must be nonnegative".toString());
        }
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

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final long getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    public final String getTargetRelativePath() {
        return this.targetRelativePath;
    }
}
