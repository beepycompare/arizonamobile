package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorExecutionCoordinator$Companion$create$2", f = "ArchiveMirrorExecutionCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class ArchiveMirrorExecutionCoordinator$Companion$create$2 extends SuspendLambda implements Function2<ArchiveUpdatePlan, Continuation<? super Long>, Object> {
    final /* synthetic */ ArchiveUpdateSessionState $sessionState;
    final /* synthetic */ DurableArchiveStateStore $stateStore;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveMirrorExecutionCoordinator$Companion$create$2(DurableArchiveStateStore durableArchiveStateStore, ArchiveUpdateSessionState archiveUpdateSessionState, Continuation<? super ArchiveMirrorExecutionCoordinator$Companion$create$2> continuation) {
        super(2, continuation);
        this.$stateStore = durableArchiveStateStore;
        this.$sessionState = archiveUpdateSessionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ArchiveMirrorExecutionCoordinator$Companion$create$2 archiveMirrorExecutionCoordinator$Companion$create$2 = new ArchiveMirrorExecutionCoordinator$Companion$create$2(this.$stateStore, this.$sessionState, continuation);
        archiveMirrorExecutionCoordinator$Companion$create$2.L$0 = obj;
        return archiveMirrorExecutionCoordinator$Companion$create$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ArchiveUpdatePlan archiveUpdatePlan, Continuation<? super Long> continuation) {
        return ((ArchiveMirrorExecutionCoordinator$Companion$create$2) create(archiveUpdatePlan, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map<String, Long> plannedArchiveDownloadBytesByPackage;
        ArchiveUpdatePlan archiveUpdatePlan = (ArchiveUpdatePlan) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArchiveStateLoadResult load = this.$stateStore.load();
        ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
        ArchiveUpdaterState state = loaded != null ? loaded.getState() : null;
        ArchiveStorageEstimator archiveStorageEstimator = ArchiveStorageEstimator.INSTANCE;
        if (state == null) {
            plannedArchiveDownloadBytesByPackage = MapsKt.emptyMap();
        } else {
            plannedArchiveDownloadBytesByPackage = this.$sessionState.snapshot().getPlannedArchiveDownloadBytesByPackage();
        }
        return Boxing.boxLong(archiveStorageEstimator.downloadBytes(archiveUpdatePlan, state, plannedArchiveDownloadBytesByPackage));
    }
}
