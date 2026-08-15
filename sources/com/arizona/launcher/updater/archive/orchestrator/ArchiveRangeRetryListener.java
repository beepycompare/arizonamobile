package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.DownloadFailureDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\fJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "", "onRetry", "", "packageId", "", "retryAttempt", "", "delayMs", "", "failure", "Lcom/arizona/launcher/DownloadFailureDetails;", "None", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveRangeRetryListener {
    void onRetry(String str, int i, long j, DownloadFailureDetails downloadFailureDetails);

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0007HÖ\u0081\u0004Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener$None;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "<init>", "()V", "onRetry", "", "packageId", "", "retryAttempt", "", "delayMs", "", "failure", "Lcom/arizona/launcher/DownloadFailureDetails;", "equals", "", "other", "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class None implements ArchiveRangeRetryListener {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof None) {
                None none = (None) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1670461157;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener
        public void onRetry(String packageId, int i, long j, DownloadFailureDetails failure) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            Intrinsics.checkNotNullParameter(failure, "failure");
        }

        public String toString() {
            return "None";
        }

        private None() {
        }
    }
}
