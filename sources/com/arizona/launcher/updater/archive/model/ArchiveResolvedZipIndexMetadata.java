package com.arizona.launcher.updater.archive.model;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fÊ\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipIndexMetadata;", "", "indexFetchBytes", "", "centralDirectoryOffset", "localHeaderOffsets", "", OriginalTzArchiveManifestParser.FILES_ROOT, "Lcom/arizona/launcher/updater/archive/model/ArchiveResolvedZipFileMetadata;", "<init>", "(JJLjava/util/List;Ljava/util/List;)V", "getIndexFetchBytes", "()J", "getCentralDirectoryOffset", "getLocalHeaderOffsets", "()Ljava/util/List;", "getFiles", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveResolvedZipIndexMetadata {
    public static final int $stable = 0;
    private final long centralDirectoryOffset;
    private final List<ArchiveResolvedZipFileMetadata> files;
    private final long indexFetchBytes;
    private final List<Long> localHeaderOffsets;

    public static /* synthetic */ ArchiveResolvedZipIndexMetadata copy$default(ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata, long j, long j2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = archiveResolvedZipIndexMetadata.indexFetchBytes;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = archiveResolvedZipIndexMetadata.centralDirectoryOffset;
        }
        long j4 = j2;
        List<Long> list3 = list;
        if ((i & 4) != 0) {
            list3 = archiveResolvedZipIndexMetadata.localHeaderOffsets;
        }
        List list4 = list3;
        List<ArchiveResolvedZipFileMetadata> list5 = list2;
        if ((i & 8) != 0) {
            list5 = archiveResolvedZipIndexMetadata.files;
        }
        return archiveResolvedZipIndexMetadata.copy(j3, j4, list4, list5);
    }

    public final long component1() {
        return this.indexFetchBytes;
    }

    public final long component2() {
        return this.centralDirectoryOffset;
    }

    public final List<Long> component3() {
        return this.localHeaderOffsets;
    }

    public final List<ArchiveResolvedZipFileMetadata> component4() {
        return this.files;
    }

    public final ArchiveResolvedZipIndexMetadata copy(long j, long j2, List<Long> localHeaderOffsets, List<ArchiveResolvedZipFileMetadata> files) {
        Intrinsics.checkNotNullParameter(localHeaderOffsets, "localHeaderOffsets");
        Intrinsics.checkNotNullParameter(files, "files");
        return new ArchiveResolvedZipIndexMetadata(j, j2, localHeaderOffsets, files);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveResolvedZipIndexMetadata) {
            ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata = (ArchiveResolvedZipIndexMetadata) obj;
            return this.indexFetchBytes == archiveResolvedZipIndexMetadata.indexFetchBytes && this.centralDirectoryOffset == archiveResolvedZipIndexMetadata.centralDirectoryOffset && Intrinsics.areEqual(this.localHeaderOffsets, archiveResolvedZipIndexMetadata.localHeaderOffsets) && Intrinsics.areEqual(this.files, archiveResolvedZipIndexMetadata.files);
        }
        return false;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.indexFetchBytes) * 31) + Long.hashCode(this.centralDirectoryOffset)) * 31) + this.localHeaderOffsets.hashCode()) * 31) + this.files.hashCode();
    }

    public String toString() {
        long j = this.indexFetchBytes;
        long j2 = this.centralDirectoryOffset;
        List<Long> list = this.localHeaderOffsets;
        return "ArchiveResolvedZipIndexMetadata(indexFetchBytes=" + j + ", centralDirectoryOffset=" + j2 + ", localHeaderOffsets=" + list + ", files=" + this.files + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArchiveResolvedZipIndexMetadata(long j, long j2, List<Long> localHeaderOffsets, List<ArchiveResolvedZipFileMetadata> files) {
        Intrinsics.checkNotNullParameter(localHeaderOffsets, "localHeaderOffsets");
        Intrinsics.checkNotNullParameter(files, "files");
        this.indexFetchBytes = j;
        this.centralDirectoryOffset = j2;
        this.localHeaderOffsets = localHeaderOffsets;
        this.files = files;
        if (j <= 0) {
            throw new IllegalArgumentException("ZIP index fetch bytes must be positive".toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException("ZIP central directory offset must be positive".toString());
        }
        if (localHeaderOffsets.isEmpty()) {
            throw new IllegalArgumentException("ZIP local header offsets must not be empty".toString());
        }
        List<Long> list = localHeaderOffsets;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Number number : list) {
                long longValue = number.longValue();
                if (longValue < 0 || longValue >= this.centralDirectoryOffset) {
                    throw new IllegalArgumentException("ZIP local header offsets must precede the central directory".toString());
                }
                while (r3.hasNext()) {
                }
            }
        }
        if (this.files.isEmpty()) {
            throw new IllegalArgumentException("ZIP file layout must not be empty".toString());
        }
        List<ArchiveResolvedZipFileMetadata> list2 = this.files;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        for (ArchiveResolvedZipFileMetadata archiveResolvedZipFileMetadata : list2) {
            if (!this.localHeaderOffsets.contains(Long.valueOf(archiveResolvedZipFileMetadata.getLocalHeaderOffset()))) {
                throw new IllegalArgumentException("ZIP file layout must reference an observed local header".toString());
            }
        }
    }

    public final long getIndexFetchBytes() {
        return this.indexFetchBytes;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final List<Long> getLocalHeaderOffsets() {
        return this.localHeaderOffsets;
    }

    public final List<ArchiveResolvedZipFileMetadata> getFiles() {
        return this.files;
    }
}
