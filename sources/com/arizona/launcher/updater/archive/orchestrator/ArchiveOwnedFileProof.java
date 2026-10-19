package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneOwnershipHandoff.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fÊ\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0002¨\u0006 "}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveOwnedFileProof;", "", "packageId", "", "relativePath", "size", "", "crc32", "md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "getPackageId", "()Ljava/lang/String;", "getRelativePath", "getSize", "()J", "getCrc32", "getMd5", "toOwnedPath", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnedFileProof {
    public static final int $stable = 0;
    private final long crc32;
    private final String md5;
    private final String packageId;
    private final String relativePath;
    private final long size;

    public static /* synthetic */ ArchiveOwnedFileProof copy$default(ArchiveOwnedFileProof archiveOwnedFileProof, String str, String str2, long j, long j2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveOwnedFileProof.packageId;
        }
        if ((i & 2) != 0) {
            str2 = archiveOwnedFileProof.relativePath;
        }
        if ((i & 4) != 0) {
            j = archiveOwnedFileProof.size;
        }
        if ((i & 8) != 0) {
            j2 = archiveOwnedFileProof.crc32;
        }
        if ((i & 16) != 0) {
            str3 = archiveOwnedFileProof.md5;
        }
        String str4 = str3;
        long j3 = j2;
        return archiveOwnedFileProof.copy(str, str2, j, j3, str4);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.relativePath;
    }

    public final long component3() {
        return this.size;
    }

    public final long component4() {
        return this.crc32;
    }

    public final String component5() {
        return this.md5;
    }

    public final ArchiveOwnedFileProof copy(String packageId, String relativePath, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new ArchiveOwnedFileProof(packageId, relativePath, j, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveOwnedFileProof) {
            ArchiveOwnedFileProof archiveOwnedFileProof = (ArchiveOwnedFileProof) obj;
            return Intrinsics.areEqual(this.packageId, archiveOwnedFileProof.packageId) && Intrinsics.areEqual(this.relativePath, archiveOwnedFileProof.relativePath) && this.size == archiveOwnedFileProof.size && this.crc32 == archiveOwnedFileProof.crc32 && Intrinsics.areEqual(this.md5, archiveOwnedFileProof.md5);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.packageId.hashCode() * 31) + this.relativePath.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.crc32)) * 31;
        String str = this.md5;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.packageId;
        String str2 = this.relativePath;
        long j = this.size;
        long j2 = this.crc32;
        return "ArchiveOwnedFileProof(packageId=" + str + ", relativePath=" + str2 + ", size=" + j + ", crc32=" + j2 + ", md5=" + this.md5 + ")";
    }

    public ArchiveOwnedFileProof(String packageId, String relativePath, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        this.packageId = packageId;
        this.relativePath = relativePath;
        this.size = j;
        this.crc32 = j2;
        this.md5 = str;
    }

    public /* synthetic */ ArchiveOwnedFileProof(String str, String str2, long j, long j2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, j2, (i & 16) != 0 ? null : str3);
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final ArchiveOwnedPath toOwnedPath() {
        return new ArchiveOwnedPath(this.packageId, this.relativePath);
    }
}
