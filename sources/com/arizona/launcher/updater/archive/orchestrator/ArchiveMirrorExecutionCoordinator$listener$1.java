package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"com/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator$listener$1", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;", "onPhase", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveInstallerPhase;", "packageId", "", "onDownloadProgress", "downloadedBytes", "", "totalBytes", "onRuntimeRequirementsChanged", "downloadBytes", "requiredFreeSpaceBytes", "(JLjava/lang/Long;)V", "onRetry", "retryAttempt", "", "delayMs", "failureSubtype", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveMirrorExecutionCoordinator$listener$1 implements ArchiveUpdaterListener {
    final /* synthetic */ long $progressToken;
    final /* synthetic */ ArchiveMirrorExecutionCoordinator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchiveMirrorExecutionCoordinator$listener$1(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, long j) {
        this.this$0 = archiveMirrorExecutionCoordinator;
        this.$progressToken = j;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
    public void onPhase(final ArchiveInstallerPhase phase, final String str) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(phase, "phase");
        function1 = this.this$0.postToMain;
        final ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$listener$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchiveMirrorExecutionCoordinator$listener$1.onPhase$lambda$0(ArchiveMirrorExecutionCoordinator.this, phase, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onPhase$lambda$0(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, ArchiveInstallerPhase archiveInstallerPhase, String str) {
        Function0 function0;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks;
        function0 = archiveMirrorExecutionCoordinator.isCurrentOperation;
        if (((Boolean) function0.invoke()).booleanValue()) {
            archiveMirrorExecutionCallbacks = archiveMirrorExecutionCoordinator.callbacks;
            archiveMirrorExecutionCallbacks.onPhase(archiveInstallerPhase, str);
        }
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
    public void onDownloadProgress(long j, long j2) {
        ArchiveProgressPublicationCoalescer archiveProgressPublicationCoalescer;
        Function2 function2;
        ArchiveProgressSample archiveProgressSample = new ArchiveProgressSample(RangesKt.coerceAtLeast(j, 0L), RangesKt.coerceAtLeast(j2, 0L));
        archiveProgressPublicationCoalescer = this.this$0.progressPublication;
        Long offer = archiveProgressPublicationCoalescer.offer(this.$progressToken, archiveProgressSample);
        if (offer != null) {
            long longValue = offer.longValue();
            function2 = this.this$0.postToMainDelayed;
            Long valueOf = Long.valueOf(longValue);
            final ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator = this.this$0;
            final long j3 = this.$progressToken;
            function2.invoke(valueOf, new Function0() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$listener$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ArchiveMirrorExecutionCoordinator$listener$1.onDownloadProgress$lambda$1(ArchiveMirrorExecutionCoordinator.this, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onDownloadProgress$lambda$1(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, long j) {
        ArchiveProgressPublicationCoalescer archiveProgressPublicationCoalescer;
        Function0 function0;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks;
        archiveProgressPublicationCoalescer = archiveMirrorExecutionCoordinator.progressPublication;
        ArchiveProgressSample consumeScheduled = archiveProgressPublicationCoalescer.consumeScheduled(j);
        if (consumeScheduled != null) {
            function0 = archiveMirrorExecutionCoordinator.isCurrentOperation;
            if (((Boolean) function0.invoke()).booleanValue()) {
                archiveMirrorExecutionCallbacks = archiveMirrorExecutionCoordinator.callbacks;
                archiveMirrorExecutionCallbacks.onDownloadProgress(consumeScheduled.getDownloadedBytes(), consumeScheduled.getTotalBytes());
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
    public void onRuntimeRequirementsChanged(final long j, final Long l) {
        Function1 function1;
        function1 = this.this$0.postToMain;
        final ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$listener$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchiveMirrorExecutionCoordinator$listener$1.onRuntimeRequirementsChanged$lambda$2(ArchiveMirrorExecutionCoordinator.this, j, l);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onRuntimeRequirementsChanged$lambda$2(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, long j, Long l) {
        Function0 function0;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks;
        ArchiveUpdateSessionState archiveUpdateSessionState2;
        function0 = archiveMirrorExecutionCoordinator.isCurrentOperation;
        if (((Boolean) function0.invoke()).booleanValue()) {
            archiveUpdateSessionState = archiveMirrorExecutionCoordinator.sessionState;
            archiveUpdateSessionState.recordRuntimeRequirements(j, l);
            archiveMirrorExecutionCallbacks = archiveMirrorExecutionCoordinator.callbacks;
            archiveUpdateSessionState2 = archiveMirrorExecutionCoordinator.sessionState;
            archiveMirrorExecutionCallbacks.onRuntimeRequirementsChanged(archiveUpdateSessionState2.snapshot().getStorageRequirements());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener
    public void onRetry(final String packageId, final int i, final long j, final String failureSubtype) {
        ArchiveUpdateSessionState archiveUpdateSessionState;
        Function1 function1;
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(failureSubtype, "failureSubtype");
        archiveUpdateSessionState = this.this$0.sessionState;
        final String server = archiveUpdateSessionState.snapshot().getServer();
        function1 = this.this$0.postToMain;
        final ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator = this.this$0;
        function1.invoke(new Function0() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$listener$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchiveMirrorExecutionCoordinator$listener$1.onRetry$lambda$3(ArchiveMirrorExecutionCoordinator.this, packageId, i, j, failureSubtype, server);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onRetry$lambda$3(ArchiveMirrorExecutionCoordinator archiveMirrorExecutionCoordinator, String str, int i, long j, String str2, String str3) {
        Function0 function0;
        ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks;
        function0 = archiveMirrorExecutionCoordinator.isCurrentOperation;
        if (((Boolean) function0.invoke()).booleanValue()) {
            archiveMirrorExecutionCallbacks = archiveMirrorExecutionCoordinator.callbacks;
            archiveMirrorExecutionCallbacks.onRetry(str, i, j, str2, str3);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
