package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "", "onProgress", "", "progress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "onRetry", "retry", "Lcom/arizona/launcher/updater/apk/LauncherApkRetry;", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkDownloadObserver {
    public static final Companion Companion = Companion.$$INSTANCE;

    default void onProgress(LauncherApkProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
    }

    default void onRetry(LauncherApkRetry retry) {
        Intrinsics.checkNotNullParameter(retry, "retry");
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onProgress(LauncherApkDownloadObserver launcherApkDownloadObserver, LauncherApkProgress progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            LauncherApkDownloadObserver.super.onProgress(progress);
        }

        @Deprecated
        public static void onRetry(LauncherApkDownloadObserver launcherApkDownloadObserver, LauncherApkRetry retry) {
            Intrinsics.checkNotNullParameter(retry, "retry");
            LauncherApkDownloadObserver.super.onRetry(retry);
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver$Companion;", "", "<init>", "()V", "None", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "getNone", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final LauncherApkDownloadObserver None = new LauncherApkDownloadObserver() { // from class: com.arizona.launcher.updater.apk.LauncherApkDownloadObserver$Companion$None$1
            @Override // com.arizona.launcher.updater.apk.LauncherApkDownloadObserver
            public /* bridge */ void onProgress(LauncherApkProgress launcherApkProgress) {
                super.onProgress(launcherApkProgress);
            }

            @Override // com.arizona.launcher.updater.apk.LauncherApkDownloadObserver
            public /* bridge */ void onRetry(LauncherApkRetry launcherApkRetry) {
                super.onRetry(launcherApkRetry);
            }
        };

        private Companion() {
        }

        public final LauncherApkDownloadObserver getNone() {
            return None;
        }
    }
}
