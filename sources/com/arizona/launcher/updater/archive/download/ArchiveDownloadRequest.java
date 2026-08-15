package com.arizona.launcher.updater.archive.download;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0000¨\u0006 "}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;", "", "packageId", "", "url", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "expectedSize", "", "expectedCrc32", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;JJ)V", "getPackageId", "()Ljava/lang/String;", "getUrl", "getDestination", "()Ljava/io/File;", "getExpectedSize", "()J", "getExpectedCrc32", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadRequest {
    public static final int $stable = 8;
    private final File destination;
    private final long expectedCrc32;
    private final long expectedSize;
    private final String packageId;
    private final String url;

    public static /* synthetic */ ArchiveDownloadRequest copy$default(ArchiveDownloadRequest archiveDownloadRequest, String str, String str2, File file, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveDownloadRequest.packageId;
        }
        if ((i & 2) != 0) {
            str2 = archiveDownloadRequest.url;
        }
        if ((i & 4) != 0) {
            file = archiveDownloadRequest.destination;
        }
        if ((i & 8) != 0) {
            j = archiveDownloadRequest.expectedSize;
        }
        if ((i & 16) != 0) {
            j2 = archiveDownloadRequest.expectedCrc32;
        }
        long j3 = j2;
        File file2 = file;
        return archiveDownloadRequest.copy(str, str2, file2, j, j3);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.url;
    }

    public final File component3() {
        return this.destination;
    }

    public final long component4() {
        return this.expectedSize;
    }

    public final long component5() {
        return this.expectedCrc32;
    }

    public final ArchiveDownloadRequest copy(String packageId, String url, File destination, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return new ArchiveDownloadRequest(packageId, url, destination, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveDownloadRequest) {
            ArchiveDownloadRequest archiveDownloadRequest = (ArchiveDownloadRequest) obj;
            return Intrinsics.areEqual(this.packageId, archiveDownloadRequest.packageId) && Intrinsics.areEqual(this.url, archiveDownloadRequest.url) && Intrinsics.areEqual(this.destination, archiveDownloadRequest.destination) && this.expectedSize == archiveDownloadRequest.expectedSize && this.expectedCrc32 == archiveDownloadRequest.expectedCrc32;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.packageId.hashCode() * 31) + this.url.hashCode()) * 31) + this.destination.hashCode()) * 31) + Long.hashCode(this.expectedSize)) * 31) + Long.hashCode(this.expectedCrc32);
    }

    public String toString() {
        String str = this.packageId;
        String str2 = this.url;
        File file = this.destination;
        long j = this.expectedSize;
        return "ArchiveDownloadRequest(packageId=" + str + ", url=" + str2 + ", destination=" + file + ", expectedSize=" + j + ", expectedCrc32=" + this.expectedCrc32 + ")";
    }

    public ArchiveDownloadRequest(String packageId, String url, File destination, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.packageId = packageId;
        this.url = url;
        this.destination = destination;
        this.expectedSize = j;
        this.expectedCrc32 = j2;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final File getDestination() {
        return this.destination;
    }

    public final long getExpectedSize() {
        return this.expectedSize;
    }

    public final long getExpectedCrc32() {
        return this.expectedCrc32;
    }
}
