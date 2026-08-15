package com.arizona.launcher.updater.apk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkModels.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult;", "", "Success", "Failure", "DestinationBusy", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult$DestinationBusy;", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult$Failure;", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkCleanupResult {

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult$Success;", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult;", "removedPartialFile", "", "removedSidecar", "<init>", "(ZZ)V", "getRemovedPartialFile", "()Z", "getRemovedSidecar", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements LauncherApkCleanupResult {
        public static final int $stable = 0;
        private final boolean removedPartialFile;
        private final boolean removedSidecar;

        public static /* synthetic */ Success copy$default(Success success, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = success.removedPartialFile;
            }
            if ((i & 2) != 0) {
                z2 = success.removedSidecar;
            }
            return success.copy(z, z2);
        }

        public final boolean component1() {
            return this.removedPartialFile;
        }

        public final boolean component2() {
            return this.removedSidecar;
        }

        public final Success copy(boolean z, boolean z2) {
            return new Success(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return this.removedPartialFile == success.removedPartialFile && this.removedSidecar == success.removedSidecar;
            }
            return false;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.removedPartialFile) * 31) + Boolean.hashCode(this.removedSidecar);
        }

        public String toString() {
            boolean z = this.removedPartialFile;
            return "Success(removedPartialFile=" + z + ", removedSidecar=" + this.removedSidecar + ")";
        }

        public Success(boolean z, boolean z2) {
            this.removedPartialFile = z;
            this.removedSidecar = z2;
        }

        public final boolean getRemovedPartialFile() {
            return this.removedPartialFile;
        }

        public final boolean getRemovedSidecar() {
            return this.removedSidecar;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult$Failure;", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult;", "cause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getCause", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements LauncherApkCleanupResult {
        public static final int $stable = 8;
        private final IOException cause;

        public static /* synthetic */ Failure copy$default(Failure failure, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = failure.cause;
            }
            return failure.copy(iOException);
        }

        public final IOException component1() {
            return this.cause;
        }

        public final Failure copy(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return new Failure(cause);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual(this.cause, ((Failure) obj).cause);
        }

        public int hashCode() {
            return this.cause.hashCode();
        }

        public String toString() {
            return "Failure(cause=" + this.cause + ")";
        }

        public Failure(IOException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.cause = cause;
        }

        public final IOException getCause() {
            return this.cause;
        }
    }

    /* compiled from: LauncherApkModels.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult$DestinationBusy;", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult;", "<init>", "()V", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DestinationBusy implements LauncherApkCleanupResult {
        public static final int $stable = 0;
        public static final DestinationBusy INSTANCE = new DestinationBusy();

        private DestinationBusy() {
        }
    }
}
