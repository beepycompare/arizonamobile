package com.arizona.launcher.updater.apk;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fÊ\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "", "url", "", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "expectedSizeBytes", "", "expectedSha256", "<init>", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/Long;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getDestination", "()Ljava/io/File;", "getExpectedSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpectedSha256", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/Long;Ljava/lang/String;)Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkDownloadRequest {
    public static final int $stable = 8;
    private final File destination;
    private final String expectedSha256;
    private final Long expectedSizeBytes;
    private final String url;

    public static /* synthetic */ LauncherApkDownloadRequest copy$default(LauncherApkDownloadRequest launcherApkDownloadRequest, String str, File file, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = launcherApkDownloadRequest.url;
        }
        if ((i & 2) != 0) {
            file = launcherApkDownloadRequest.destination;
        }
        if ((i & 4) != 0) {
            l = launcherApkDownloadRequest.expectedSizeBytes;
        }
        if ((i & 8) != 0) {
            str2 = launcherApkDownloadRequest.expectedSha256;
        }
        return launcherApkDownloadRequest.copy(str, file, l, str2);
    }

    public final String component1() {
        return this.url;
    }

    public final File component2() {
        return this.destination;
    }

    public final Long component3() {
        return this.expectedSizeBytes;
    }

    public final String component4() {
        return this.expectedSha256;
    }

    public final LauncherApkDownloadRequest copy(String url, File destination, Long l, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return new LauncherApkDownloadRequest(url, destination, l, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherApkDownloadRequest) {
            LauncherApkDownloadRequest launcherApkDownloadRequest = (LauncherApkDownloadRequest) obj;
            return Intrinsics.areEqual(this.url, launcherApkDownloadRequest.url) && Intrinsics.areEqual(this.destination, launcherApkDownloadRequest.destination) && Intrinsics.areEqual(this.expectedSizeBytes, launcherApkDownloadRequest.expectedSizeBytes) && Intrinsics.areEqual(this.expectedSha256, launcherApkDownloadRequest.expectedSha256);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.url.hashCode() * 31) + this.destination.hashCode()) * 31;
        Long l = this.expectedSizeBytes;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.expectedSha256;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.url;
        File file = this.destination;
        Long l = this.expectedSizeBytes;
        return "LauncherApkDownloadRequest(url=" + str + ", destination=" + file + ", expectedSizeBytes=" + l + ", expectedSha256=" + this.expectedSha256 + ")";
    }

    public LauncherApkDownloadRequest(String url, File destination, Long l, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.url = url;
        this.destination = destination;
        this.expectedSizeBytes = l;
        this.expectedSha256 = str;
    }

    public /* synthetic */ LauncherApkDownloadRequest(String str, File file, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, file, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2);
    }

    public final String getUrl() {
        return this.url;
    }

    public final File getDestination() {
        return this.destination;
    }

    public final Long getExpectedSizeBytes() {
        return this.expectedSizeBytes;
    }

    public final String getExpectedSha256() {
        return this.expectedSha256;
    }
}
