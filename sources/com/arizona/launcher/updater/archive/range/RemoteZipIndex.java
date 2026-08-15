package com.arizona.launcher.updater.archive.range;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fÊ\u0001\f\b&\u0012\b\b'\u0012\u0004\b\u0003\u0010\u0000¨\u0006%"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndex;", "", "archiveSize", "", "centralDirectoryOffset", "centralDirectorySize", "centralDirectorySha256", "Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;", "totalUncompressedBytes", "<init>", "(JJJLcom/arizona/launcher/updater/archive/range/Sha256Digest;Ljava/util/List;J)V", "getArchiveSize", "()J", "getCentralDirectoryOffset", "getCentralDirectorySize", "getCentralDirectorySha256", "()Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "getEntries", "()Ljava/util/List;", "getTotalUncompressedBytes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipIndex {
    public static final int $stable = Sha256Digest.$stable;
    private final long archiveSize;
    private final long centralDirectoryOffset;
    private final Sha256Digest centralDirectorySha256;
    private final long centralDirectorySize;
    private final List<RemoteZipEntry> entries;
    private final long totalUncompressedBytes;

    public static /* synthetic */ RemoteZipIndex copy$default(RemoteZipIndex remoteZipIndex, long j, long j2, long j3, Sha256Digest sha256Digest, List list, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = remoteZipIndex.archiveSize;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = remoteZipIndex.centralDirectoryOffset;
        }
        return remoteZipIndex.copy(j5, j2, (i & 4) != 0 ? remoteZipIndex.centralDirectorySize : j3, (i & 8) != 0 ? remoteZipIndex.centralDirectorySha256 : sha256Digest, (i & 16) != 0 ? remoteZipIndex.entries : list, (i & 32) != 0 ? remoteZipIndex.totalUncompressedBytes : j4);
    }

    public final long component1() {
        return this.archiveSize;
    }

    public final long component2() {
        return this.centralDirectoryOffset;
    }

    public final long component3() {
        return this.centralDirectorySize;
    }

    public final Sha256Digest component4() {
        return this.centralDirectorySha256;
    }

    public final List<RemoteZipEntry> component5() {
        return this.entries;
    }

    public final long component6() {
        return this.totalUncompressedBytes;
    }

    public final RemoteZipIndex copy(long j, long j2, long j3, Sha256Digest centralDirectorySha256, List<RemoteZipEntry> entries, long j4) {
        Intrinsics.checkNotNullParameter(centralDirectorySha256, "centralDirectorySha256");
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new RemoteZipIndex(j, j2, j3, centralDirectorySha256, entries, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipIndex) {
            RemoteZipIndex remoteZipIndex = (RemoteZipIndex) obj;
            return this.archiveSize == remoteZipIndex.archiveSize && this.centralDirectoryOffset == remoteZipIndex.centralDirectoryOffset && this.centralDirectorySize == remoteZipIndex.centralDirectorySize && Intrinsics.areEqual(this.centralDirectorySha256, remoteZipIndex.centralDirectorySha256) && Intrinsics.areEqual(this.entries, remoteZipIndex.entries) && this.totalUncompressedBytes == remoteZipIndex.totalUncompressedBytes;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.archiveSize) * 31) + Long.hashCode(this.centralDirectoryOffset)) * 31) + Long.hashCode(this.centralDirectorySize)) * 31) + this.centralDirectorySha256.hashCode()) * 31) + this.entries.hashCode()) * 31) + Long.hashCode(this.totalUncompressedBytes);
    }

    public String toString() {
        long j = this.archiveSize;
        long j2 = this.centralDirectoryOffset;
        long j3 = this.centralDirectorySize;
        Sha256Digest sha256Digest = this.centralDirectorySha256;
        List<RemoteZipEntry> list = this.entries;
        return "RemoteZipIndex(archiveSize=" + j + ", centralDirectoryOffset=" + j2 + ", centralDirectorySize=" + j3 + ", centralDirectorySha256=" + sha256Digest + ", entries=" + list + ", totalUncompressedBytes=" + this.totalUncompressedBytes + ")";
    }

    public RemoteZipIndex(long j, long j2, long j3, Sha256Digest centralDirectorySha256, List<RemoteZipEntry> entries, long j4) {
        Intrinsics.checkNotNullParameter(centralDirectorySha256, "centralDirectorySha256");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.archiveSize = j;
        this.centralDirectoryOffset = j2;
        this.centralDirectorySize = j3;
        this.centralDirectorySha256 = centralDirectorySha256;
        this.entries = entries;
        this.totalUncompressedBytes = j4;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final long getCentralDirectorySize() {
        return this.centralDirectorySize;
    }

    public final Sha256Digest getCentralDirectorySha256() {
        return this.centralDirectorySha256;
    }

    public final List<RemoteZipEntry> getEntries() {
        return this.entries;
    }

    public final long getTotalUncompressedBytes() {
        return this.totalUncompressedBytes;
    }
}
