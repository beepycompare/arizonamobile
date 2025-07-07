package ru.rustore.sdk.appupdate.model;

import android.os.Bundle;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lru/rustore/sdk/appupdate/model/InstallState;", "", "installStatus", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "bytesDownloaded", "", "totalBytesToDownload", "installErrorCode", "(ILjava/lang/String;JJI)V", "getBytesDownloaded", "()J", "getInstallErrorCode", "()I", "getInstallStatus", "getPackageName", "()Ljava/lang/String;", "getTotalBytesToDownload", "Companion", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InstallState {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_BYTES_DOWNLOADED = "BYTES_DOWNLOADED";
    private static final String KEY_INSTALL_ERROR_CODE = "INSTALL_ERROR_CODE";
    private static final String KEY_INSTALL_STATUS = "INSTALL_STATUS";
    private static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    private static final String KEY_TOTAL_BYTES_TO_DOWNLOAD = "TOTAL_BYTES_TO_DOWNLOAD";
    private final long bytesDownloaded;
    private final int installErrorCode;
    private final int installStatus;
    private final String packageName;
    private final long totalBytesToDownload;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/appupdate/model/InstallState$Companion;", "", "()V", "KEY_BYTES_DOWNLOADED", "", "KEY_INSTALL_ERROR_CODE", "KEY_INSTALL_STATUS", "KEY_PACKAGE_NAME", "KEY_TOTAL_BYTES_TO_DOWNLOAD", "empty", "Lru/rustore/sdk/appupdate/model/InstallState;", "empty$sdk_public_appupdate_release", "of", "bundle", "Landroid/os/Bundle;", "of$sdk_public_appupdate_release", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InstallState empty$sdk_public_appupdate_release() {
            return new InstallState(0, "", 0L, 0L, 0, null);
        }

        public final InstallState of$sdk_public_appupdate_release(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            int i = bundle.getInt(InstallState.KEY_INSTALL_STATUS, 0);
            String string = bundle.getString(InstallState.KEY_PACKAGE_NAME);
            if (string == null) {
                string = "";
            }
            return new InstallState(i, string, bundle.getLong(InstallState.KEY_BYTES_DOWNLOADED, 0L), bundle.getLong(InstallState.KEY_TOTAL_BYTES_TO_DOWNLOAD, 0L), bundle.getInt(InstallState.KEY_INSTALL_ERROR_CODE, 0), null);
        }
    }

    private InstallState(int i, String str, long j, long j2, int i2) {
        this.installStatus = i;
        this.packageName = str;
        this.bytesDownloaded = j;
        this.totalBytesToDownload = j2;
        this.installErrorCode = i2;
    }

    public final long getBytesDownloaded() {
        return this.bytesDownloaded;
    }

    public final int getInstallErrorCode() {
        return this.installErrorCode;
    }

    public final int getInstallStatus() {
        return this.installStatus;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getTotalBytesToDownload() {
        return this.totalBytesToDownload;
    }

    public /* synthetic */ InstallState(int i, String str, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, j, j2, i2);
    }
}
