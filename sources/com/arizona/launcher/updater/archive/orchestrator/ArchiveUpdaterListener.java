package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u0015J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0007H&¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;", "", "onPhase", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "packageId", "", "onDownloadProgress", "downloadedBytes", "", "totalBytes", "onRuntimeRequirementsChanged", "downloadBytes", "requiredFreeSpaceBytes", "(JLjava/lang/Long;)V", "onRetry", "retryAttempt", "", "delayMs", "failureSubtype", "None", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveUpdaterListener {
    void onDownloadProgress(long j, long j2);

    void onPhase(ArchiveInstallerPhase archiveInstallerPhase, String str);

    void onRetry(String str, int i, long j, String str2);

    default void onRuntimeRequirementsChanged(long j, Long l) {
    }

    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onRuntimeRequirementsChanged(ArchiveUpdaterListener archiveUpdaterListener, long j, Long l) {
            ArchiveUpdaterListener.super.onRuntimeRequirementsChanged(j, l);
        }
    }

    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\tHÖ\u0081\u0004Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener$None;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;", "<init>", "()V", "onPhase", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "packageId", "", "onDownloadProgress", "downloadedBytes", "", "totalBytes", "onRetry", "retryAttempt", "", "delayMs", "failureSubtype", "equals", "", "other", "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class None implements ArchiveUpdaterListener {
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
            return -1398739317;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
        public void onDownloadProgress(long j, long j2) {
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
        public void onPhase(ArchiveInstallerPhase phase, String str) {
            Intrinsics.checkNotNullParameter(phase, "phase");
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
        public void onRetry(String packageId, int i, long j, String failureSubtype) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            Intrinsics.checkNotNullParameter(failureSubtype, "failureSubtype");
        }

        public String toString() {
            return "None";
        }

        private None() {
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
        public /* bridge */ void onRuntimeRequirementsChanged(long j, Long l) {
            super.onRuntimeRequirementsChanged(j, l);
        }
    }
}
