package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rÊ\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeMetadata;", "", "packageId", "", "expectedSize", "", "expectedCrc32", "committedOffset", "strongEtag", "lastModified", "<init>", "(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;)V", "getPackageId", "()Ljava/lang/String;", "getExpectedSize", "()J", "getExpectedCrc32", "getCommittedOffset", "getStrongEtag", "getLastModified", "matchesIdentity", "", "isResumeCompatible", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadResumeMetadata {
    public static final int $stable = 0;
    private final long committedOffset;
    private final long expectedCrc32;
    private final long expectedSize;
    private final String lastModified;
    private final String packageId;
    private final String strongEtag;

    public static /* synthetic */ ArchiveDownloadResumeMetadata copy$default(ArchiveDownloadResumeMetadata archiveDownloadResumeMetadata, String str, long j, long j2, long j3, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveDownloadResumeMetadata.packageId;
        }
        if ((i & 2) != 0) {
            j = archiveDownloadResumeMetadata.expectedSize;
        }
        if ((i & 4) != 0) {
            j2 = archiveDownloadResumeMetadata.expectedCrc32;
        }
        if ((i & 8) != 0) {
            j3 = archiveDownloadResumeMetadata.committedOffset;
        }
        if ((i & 16) != 0) {
            str2 = archiveDownloadResumeMetadata.strongEtag;
        }
        if ((i & 32) != 0) {
            str3 = archiveDownloadResumeMetadata.lastModified;
        }
        long j4 = j3;
        long j5 = j2;
        return archiveDownloadResumeMetadata.copy(str, j, j5, j4, str2, str3);
    }

    public final String component1() {
        return this.packageId;
    }

    public final long component2() {
        return this.expectedSize;
    }

    public final long component3() {
        return this.expectedCrc32;
    }

    public final long component4() {
        return this.committedOffset;
    }

    public final String component5() {
        return this.strongEtag;
    }

    public final String component6() {
        return this.lastModified;
    }

    public final ArchiveDownloadResumeMetadata copy(String packageId, long j, long j2, long j3, String str, String str2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        return new ArchiveDownloadResumeMetadata(packageId, j, j2, j3, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveDownloadResumeMetadata) {
            ArchiveDownloadResumeMetadata archiveDownloadResumeMetadata = (ArchiveDownloadResumeMetadata) obj;
            return Intrinsics.areEqual(this.packageId, archiveDownloadResumeMetadata.packageId) && this.expectedSize == archiveDownloadResumeMetadata.expectedSize && this.expectedCrc32 == archiveDownloadResumeMetadata.expectedCrc32 && this.committedOffset == archiveDownloadResumeMetadata.committedOffset && Intrinsics.areEqual(this.strongEtag, archiveDownloadResumeMetadata.strongEtag) && Intrinsics.areEqual(this.lastModified, archiveDownloadResumeMetadata.lastModified);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.packageId.hashCode() * 31) + Long.hashCode(this.expectedSize)) * 31) + Long.hashCode(this.expectedCrc32)) * 31) + Long.hashCode(this.committedOffset)) * 31;
        String str = this.strongEtag;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastModified;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.packageId;
        long j = this.expectedSize;
        long j2 = this.expectedCrc32;
        long j3 = this.committedOffset;
        String str2 = this.strongEtag;
        return "ArchiveDownloadResumeMetadata(packageId=" + str + ", expectedSize=" + j + ", expectedCrc32=" + j2 + ", committedOffset=" + j3 + ", strongEtag=" + str2 + ", lastModified=" + this.lastModified + ")";
    }

    public ArchiveDownloadResumeMetadata(String packageId, long j, long j2, long j3, String str, String str2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        this.packageId = packageId;
        this.expectedSize = j;
        this.expectedCrc32 = j2;
        this.committedOffset = j3;
        this.strongEtag = str;
        this.lastModified = str2;
    }

    public /* synthetic */ ArchiveDownloadResumeMetadata(String str, long j, long j2, long j3, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, j3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final long getExpectedSize() {
        return this.expectedSize;
    }

    public final long getExpectedCrc32() {
        return this.expectedCrc32;
    }

    public final long getCommittedOffset() {
        return this.committedOffset;
    }

    public final String getStrongEtag() {
        return this.strongEtag;
    }

    public final String getLastModified() {
        return this.lastModified;
    }

    public final boolean matchesIdentity(String packageId, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        return Intrinsics.areEqual(this.packageId, packageId) && this.expectedSize == j && this.expectedCrc32 == j2;
    }

    public final boolean isResumeCompatible(String packageId, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        if (matchesIdentity(packageId, j, j2)) {
            long j3 = this.committedOffset;
            return 1 <= j3 && j3 <= j;
        }
        return false;
    }
}
