package com.arizona.launcher.updater.apk;

import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Failure;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkDownloadResult {

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Success;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "totalBytes", "", "resumedFromBytes", "attempts", "", "<init>", "(Ljava/io/File;JJI)V", "getFile", "()Ljava/io/File;", "getTotalBytes", "()J", "getResumedFromBytes", "getAttempts", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements LauncherApkDownloadResult {
        public static final int $stable = 8;
        private final int attempts;
        private final File file;
        private final long resumedFromBytes;
        private final long totalBytes;

        public static /* synthetic */ Success copy$default(Success success, File file, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                file = success.file;
            }
            if ((i2 & 2) != 0) {
                j = success.totalBytes;
            }
            if ((i2 & 4) != 0) {
                j2 = success.resumedFromBytes;
            }
            if ((i2 & 8) != 0) {
                i = success.attempts;
            }
            int i3 = i;
            return success.copy(file, j, j2, i3);
        }

        public final File component1() {
            return this.file;
        }

        public final long component2() {
            return this.totalBytes;
        }

        public final long component3() {
            return this.resumedFromBytes;
        }

        public final int component4() {
            return this.attempts;
        }

        public final Success copy(File file, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Success(file, j, j2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.file, success.file) && this.totalBytes == success.totalBytes && this.resumedFromBytes == success.resumedFromBytes && this.attempts == success.attempts;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.file.hashCode() * 31) + Long.hashCode(this.totalBytes)) * 31) + Long.hashCode(this.resumedFromBytes)) * 31) + Integer.hashCode(this.attempts);
        }

        public String toString() {
            File file = this.file;
            long j = this.totalBytes;
            long j2 = this.resumedFromBytes;
            return "Success(file=" + file + ", totalBytes=" + j + ", resumedFromBytes=" + j2 + ", attempts=" + this.attempts + ")";
        }

        public Success(File file, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.totalBytes = j;
            this.resumedFromBytes = j2;
            this.attempts = i;
        }

        public final File getFile() {
            return this.file;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final long getResumedFromBytes() {
            return this.resumedFromBytes;
        }

        public final int getAttempts() {
            return this.attempts;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Failure;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "error", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "attempts", "", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;I)V", "getError", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "getAttempts", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements LauncherApkDownloadResult {
        public static final int $stable = 8;
        private final int attempts;
        private final LauncherApkDownloadError error;

        public static /* synthetic */ Failure copy$default(Failure failure, LauncherApkDownloadError launcherApkDownloadError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                launcherApkDownloadError = failure.error;
            }
            if ((i2 & 2) != 0) {
                i = failure.attempts;
            }
            return failure.copy(launcherApkDownloadError, i);
        }

        public final LauncherApkDownloadError component1() {
            return this.error;
        }

        public final int component2() {
            return this.attempts;
        }

        public final Failure copy(LauncherApkDownloadError error, int i) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failure(error, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return Intrinsics.areEqual(this.error, failure.error) && this.attempts == failure.attempts;
            }
            return false;
        }

        public int hashCode() {
            return (this.error.hashCode() * 31) + Integer.hashCode(this.attempts);
        }

        public String toString() {
            LauncherApkDownloadError launcherApkDownloadError = this.error;
            return "Failure(error=" + launcherApkDownloadError + ", attempts=" + this.attempts + ")";
        }

        public Failure(LauncherApkDownloadError error, int i) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
            this.attempts = i;
        }

        public final LauncherApkDownloadError getError() {
            return this.error;
        }

        public final int getAttempts() {
            return this.attempts;
        }
    }
}
