package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkPreparation;", "", "Ready", "ServerEmpty", "ExternalStorageUnavailable", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$ExternalStorageUnavailable;", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$Ready;", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$ServerEmpty;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkPreparation {

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$Ready;", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation;", "request", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;)V", "getRequest", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Ready implements LauncherApkPreparation {
        public static final int $stable = LauncherApkDownloadRequest.$stable;
        private final LauncherApkDownloadRequest request;

        public static /* synthetic */ Ready copy$default(Ready ready, LauncherApkDownloadRequest launcherApkDownloadRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                launcherApkDownloadRequest = ready.request;
            }
            return ready.copy(launcherApkDownloadRequest);
        }

        public final LauncherApkDownloadRequest component1() {
            return this.request;
        }

        public final Ready copy(LauncherApkDownloadRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return new Ready(request);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ready) && Intrinsics.areEqual(this.request, ((Ready) obj).request);
        }

        public int hashCode() {
            return this.request.hashCode();
        }

        public String toString() {
            return "Ready(request=" + this.request + ")";
        }

        public Ready(LauncherApkDownloadRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
        }

        public final LauncherApkDownloadRequest getRequest() {
            return this.request;
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$ServerEmpty;", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ServerEmpty implements LauncherApkPreparation {
        public static final int $stable = 0;
        public static final ServerEmpty INSTANCE = new ServerEmpty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServerEmpty) {
                ServerEmpty serverEmpty = (ServerEmpty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1084465023;
        }

        public String toString() {
            return "ServerEmpty";
        }

        private ServerEmpty() {
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$ExternalStorageUnavailable;", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ExternalStorageUnavailable implements LauncherApkPreparation {
        public static final int $stable = 0;
        public static final ExternalStorageUnavailable INSTANCE = new ExternalStorageUnavailable();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ExternalStorageUnavailable) {
                ExternalStorageUnavailable externalStorageUnavailable = (ExternalStorageUnavailable) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 633735273;
        }

        public String toString() {
            return "ExternalStorageUnavailable";
        }

        private ExternalStorageUnavailable() {
        }
    }
}
