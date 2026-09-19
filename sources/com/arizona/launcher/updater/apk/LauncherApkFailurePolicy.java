package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherApkDownloadError;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
/* compiled from: LauncherUpdatePolicies.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkFailurePolicy;", "", "<init>", "()V", "MAX_CAUSE_DEPTH", "", "NO_SPACE_MARKERS", "", "", "classify", "Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;", "error", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "localStorageFailure", "Lcom/arizona/launcher/updater/apk/LauncherApkLocalStorageFailure;", "redactForLog", "value", "isInsufficientStorage", "", "", ImagesContract.LOCAL, Constants.ScionAnalytics.PARAM_LABEL, "remote", "URL_IN_TEXT", "Lkotlin/text/Regex;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkFailurePolicy {
    public static final int $stable = 0;
    private static final int MAX_CAUSE_DEPTH = 16;
    public static final LauncherApkFailurePolicy INSTANCE = new LauncherApkFailurePolicy();
    private static final List<String> NO_SPACE_MARKERS = CollectionsKt.listOf((Object[]) new String[]{"enospc", "errno 28", "errno: 28", "errno=28", "no space left on device", "not enough space on the disk", "insufficient storage space", "disk is full", "edquot", "errno 122", "errno: 122", "errno=122", "disk quota exceeded"});
    private static final Regex URL_IN_TEXT = new Regex("https?://\\S+", RegexOption.IGNORE_CASE);

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

    public final LauncherApkLocalStorageFailure localStorageFailure(LauncherApkDownloadError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        LauncherApkDownloadError.Storage storage = error instanceof LauncherApkDownloadError.Storage ? (LauncherApkDownloadError.Storage) error : null;
        if (storage == null) {
            return null;
        }
        if (isInsufficientStorage(storage.getCause())) {
            return LauncherApkLocalStorageFailure.INSUFFICIENT;
        }
        return LauncherApkLocalStorageFailure.UNAVAILABLE;
    }

    public final String redactForLog(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        return URL_IN_TEXT.replace(str2, "<url>");
    }

    private final boolean isInsufficientStorage(Throwable th) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 16 && th != null; i++) {
            ArrayList<Throwable> arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                for (Throwable th2 : arrayList2) {
                    if (th2 == th) {
                        return false;
                    }
                }
            }
            arrayList.add(th);
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            String lowerCase = message.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<String> list = NO_SPACE_MARKERS;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (CharSequence charSequence : list) {
                    if (StringsKt.contains$default((CharSequence) lowerCase, charSequence, false, 2, (Object) null)) {
                        return true;
                    }
                }
                continue;
            }
            th = th.getCause();
        }
        return false;
    }

    private final LauncherApkFailureClassification local(String str) {
        return new LauncherApkFailureClassification(str, false);
    }

    private final LauncherApkFailureClassification remote(String str) {
        return new LauncherApkFailureClassification(str, true);
    }
}
