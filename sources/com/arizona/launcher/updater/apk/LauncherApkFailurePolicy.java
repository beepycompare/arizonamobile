package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherApkDownloadError;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdatePolicies.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkFailurePolicy;", "", "<init>", "()V", "classify", "Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;", "error", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", ImagesContract.LOCAL, Constants.ScionAnalytics.PARAM_LABEL, "", "remote", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkFailurePolicy {
    public static final int $stable = 0;
    public static final LauncherApkFailurePolicy INSTANCE = new LauncherApkFailurePolicy();

    private LauncherApkFailurePolicy() {
    }

    public final LauncherApkFailureClassification classify(LauncherApkDownloadError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof LauncherApkDownloadError.HttpStatus) {
            return new LauncherApkFailureClassification("HTTP_" + ((LauncherApkDownloadError.HttpStatus) error).getStatusCode(), true);
        } else if (error instanceof LauncherApkDownloadError.InvalidRequest) {
            return local("INVALID_REQUEST");
        } else {
            if (error instanceof LauncherApkDownloadError.Integrity) {
                return remote("INTEGRITY");
            }
            if (error instanceof LauncherApkDownloadError.Network) {
                return remote("NETWORK");
            }
            if (error instanceof LauncherApkDownloadError.RedirectRejected) {
                return remote("REDIRECT_REJECTED");
            }
            if (error instanceof LauncherApkDownloadError.Storage) {
                return local("STORAGE");
            }
            if (error instanceof LauncherApkDownloadError.Timeout) {
                return remote("TIMEOUT");
            }
            if (error instanceof LauncherApkDownloadError.UnsafeUrl) {
                return remote(CodePackage.SECURITY);
            }
            if (Intrinsics.areEqual(error, LauncherApkDownloadError.DestinationBusy.INSTANCE)) {
                return local("DESTINATION_BUSY");
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final LauncherApkFailureClassification local(String str) {
        return new LauncherApkFailureClassification(str, false);
    }

    private final LauncherApkFailureClassification remote(String str) {
        return new LauncherApkFailureClassification(str, true);
    }
}
