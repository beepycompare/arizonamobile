package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneOwnershipHandoff.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\u0003\u0010\u0002¨\u0006)"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveCrossLaneTransfer;", "", "fromScope", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "toScope", "fromPackageId", "", "toPackageId", "relativePath", "size", "", "crc32", "md5", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "getFromScope", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "getToScope", "getFromPackageId", "()Ljava/lang/String;", "getToPackageId", "getRelativePath", "getSize", "()J", "getCrc32", "getMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveCrossLaneTransfer {
    public static final int $stable = 0;
    private final long crc32;
    private final String fromPackageId;
    private final ArchiveUpdaterStorageScope fromScope;
    private final String md5;
    private final String relativePath;
    private final long size;
    private final String toPackageId;
    private final ArchiveUpdaterStorageScope toScope;

    public static /* synthetic */ ArchiveCrossLaneTransfer copy$default(ArchiveCrossLaneTransfer archiveCrossLaneTransfer, ArchiveUpdaterStorageScope archiveUpdaterStorageScope, ArchiveUpdaterStorageScope archiveUpdaterStorageScope2, String str, String str2, String str3, long j, long j2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveUpdaterStorageScope = archiveCrossLaneTransfer.fromScope;
        }
        if ((i & 2) != 0) {
            archiveUpdaterStorageScope2 = archiveCrossLaneTransfer.toScope;
        }
        if ((i & 4) != 0) {
            str = archiveCrossLaneTransfer.fromPackageId;
        }
        if ((i & 8) != 0) {
            str2 = archiveCrossLaneTransfer.toPackageId;
        }
        if ((i & 16) != 0) {
            str3 = archiveCrossLaneTransfer.relativePath;
        }
        if ((i & 32) != 0) {
            j = archiveCrossLaneTransfer.size;
        }
        if ((i & 64) != 0) {
            j2 = archiveCrossLaneTransfer.crc32;
        }
        if ((i & 128) != 0) {
            str4 = archiveCrossLaneTransfer.md5;
        }
        String str5 = str4;
        long j3 = j2;
        long j4 = j;
        String str6 = str3;
        String str7 = str;
        return archiveCrossLaneTransfer.copy(archiveUpdaterStorageScope, archiveUpdaterStorageScope2, str7, str2, str6, j4, j3, str5);
    }

    public final ArchiveUpdaterStorageScope component1() {
        return this.fromScope;
    }

    public final ArchiveUpdaterStorageScope component2() {
        return this.toScope;
    }

    public final String component3() {
        return this.fromPackageId;
    }

    public final String component4() {
        return this.toPackageId;
    }

    public final String component5() {
        return this.relativePath;
    }

    public final long component6() {
        return this.size;
    }

    public final long component7() {
        return this.crc32;
    }

    public final String component8() {
        return this.md5;
    }

    public final ArchiveCrossLaneTransfer copy(ArchiveUpdaterStorageScope fromScope, ArchiveUpdaterStorageScope toScope, String fromPackageId, String toPackageId, String relativePath, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(fromScope, "fromScope");
        Intrinsics.checkNotNullParameter(toScope, "toScope");
        Intrinsics.checkNotNullParameter(fromPackageId, "fromPackageId");
        Intrinsics.checkNotNullParameter(toPackageId, "toPackageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new ArchiveCrossLaneTransfer(fromScope, toScope, fromPackageId, toPackageId, relativePath, j, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveCrossLaneTransfer) {
            ArchiveCrossLaneTransfer archiveCrossLaneTransfer = (ArchiveCrossLaneTransfer) obj;
            return this.fromScope == archiveCrossLaneTransfer.fromScope && this.toScope == archiveCrossLaneTransfer.toScope && Intrinsics.areEqual(this.fromPackageId, archiveCrossLaneTransfer.fromPackageId) && Intrinsics.areEqual(this.toPackageId, archiveCrossLaneTransfer.toPackageId) && Intrinsics.areEqual(this.relativePath, archiveCrossLaneTransfer.relativePath) && this.size == archiveCrossLaneTransfer.size && this.crc32 == archiveCrossLaneTransfer.crc32 && Intrinsics.areEqual(this.md5, archiveCrossLaneTransfer.md5);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.fromScope.hashCode() * 31) + this.toScope.hashCode()) * 31) + this.fromPackageId.hashCode()) * 31) + this.toPackageId.hashCode()) * 31) + this.relativePath.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.crc32)) * 31;
        String str = this.md5;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        ArchiveUpdaterStorageScope archiveUpdaterStorageScope = this.fromScope;
        ArchiveUpdaterStorageScope archiveUpdaterStorageScope2 = this.toScope;
        String str = this.fromPackageId;
        String str2 = this.toPackageId;
        String str3 = this.relativePath;
        long j = this.size;
        long j2 = this.crc32;
        return "ArchiveCrossLaneTransfer(fromScope=" + archiveUpdaterStorageScope + ", toScope=" + archiveUpdaterStorageScope2 + ", fromPackageId=" + str + ", toPackageId=" + str2 + ", relativePath=" + str3 + ", size=" + j + ", crc32=" + j2 + ", md5=" + this.md5 + ")";
    }

    public ArchiveCrossLaneTransfer(ArchiveUpdaterStorageScope fromScope, ArchiveUpdaterStorageScope toScope, String fromPackageId, String toPackageId, String relativePath, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(fromScope, "fromScope");
        Intrinsics.checkNotNullParameter(toScope, "toScope");
        Intrinsics.checkNotNullParameter(fromPackageId, "fromPackageId");
        Intrinsics.checkNotNullParameter(toPackageId, "toPackageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        this.fromScope = fromScope;
        this.toScope = toScope;
        this.fromPackageId = fromPackageId;
        this.toPackageId = toPackageId;
        this.relativePath = relativePath;
        this.size = j;
        this.crc32 = j2;
        this.md5 = str;
    }

    public /* synthetic */ ArchiveCrossLaneTransfer(ArchiveUpdaterStorageScope archiveUpdaterStorageScope, ArchiveUpdaterStorageScope archiveUpdaterStorageScope2, String str, String str2, String str3, long j, long j2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveUpdaterStorageScope, archiveUpdaterStorageScope2, str, str2, str3, j, j2, (i & 128) != 0 ? null : str4);
    }

    public final ArchiveUpdaterStorageScope getFromScope() {
        return this.fromScope;
    }

    public final ArchiveUpdaterStorageScope getToScope() {
        return this.toScope;
    }

    public final String getFromPackageId() {
        return this.fromPackageId;
    }

    public final String getToPackageId() {
        return this.toPackageId;
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
}
