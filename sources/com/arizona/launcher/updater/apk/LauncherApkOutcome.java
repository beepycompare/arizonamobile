package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherApkDownloadResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome$Failure;", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkOutcome {

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkOutcome$Success;", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "result", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Success;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Success;)V", "getResult", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Success;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements LauncherApkOutcome {
        public static final int $stable = LauncherApkDownloadResult.Success.$stable;
        private final LauncherApkDownloadResult.Success result;

        public static /* synthetic */ Success copy$default(Success success, LauncherApkDownloadResult.Success success2, int i, Object obj) {
            if ((i & 1) != 0) {
                success2 = success.result;
            }
            return success.copy(success2);
        }

        public final LauncherApkDownloadResult.Success component1() {
            return this.result;
        }

        public final Success copy(LauncherApkDownloadResult.Success result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new Success(result);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.result, ((Success) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "Success(result=" + this.result + ")";
        }

        public Success(LauncherApkDownloadResult.Success result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        public final LauncherApkDownloadResult.Success getResult() {
            return this.result;
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkOutcome$Failure;", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "result", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Failure;", "classification", "Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Failure;Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;)V", "getResult", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult$Failure;", "getClassification", "()Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements LauncherApkOutcome {
        public static final int $stable = LauncherApkFailureClassification.$stable | LauncherApkDownloadResult.Failure.$stable;
        private final LauncherApkFailureClassification classification;
        private final LauncherApkDownloadResult.Failure result;

        public static /* synthetic */ Failure copy$default(Failure failure, LauncherApkDownloadResult.Failure failure2, LauncherApkFailureClassification launcherApkFailureClassification, int i, Object obj) {
            if ((i & 1) != 0) {
                failure2 = failure.result;
            }
            if ((i & 2) != 0) {
                launcherApkFailureClassification = failure.classification;
            }
            return failure.copy(failure2, launcherApkFailureClassification);
        }

        public final LauncherApkDownloadResult.Failure component1() {
            return this.result;
        }

        public final LauncherApkFailureClassification component2() {
            return this.classification;
        }

        public final Failure copy(LauncherApkDownloadResult.Failure result, LauncherApkFailureClassification classification) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(classification, "classification");
            return new Failure(result, classification);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return Intrinsics.areEqual(this.result, failure.result) && Intrinsics.areEqual(this.classification, failure.classification);
            }
            return false;
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.classification.hashCode();
        }

        public String toString() {
            LauncherApkDownloadResult.Failure failure = this.result;
            return "Failure(result=" + failure + ", classification=" + this.classification + ")";
        }

        public Failure(LauncherApkDownloadResult.Failure result, LauncherApkFailureClassification classification) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(classification, "classification");
            this.result = result;
            this.classification = classification;
        }

        public final LauncherApkDownloadResult.Failure getResult() {
            return this.result;
        }

        public final LauncherApkFailureClassification getClassification() {
            return this.classification;
        }
    }
}
