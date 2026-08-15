package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMetadataFinalizationResult;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$finalizePublishedMetadata$2", f = "ArchiveStateMaintenance.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, nl = {73}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveStateMaintenance$finalizePublishedMetadata$2 extends SuspendLambda implements Function1<Continuation<? super ArchiveMetadataFinalizationResult>, Object> {
    final /* synthetic */ ArchiveManifest $manifest;
    int label;
    final /* synthetic */ ArchiveStateMaintenance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveStateMaintenance$finalizePublishedMetadata$2(ArchiveStateMaintenance archiveStateMaintenance, ArchiveManifest archiveManifest, Continuation<? super ArchiveStateMaintenance$finalizePublishedMetadata$2> continuation) {
        super(1, continuation);
        this.this$0 = archiveStateMaintenance;
        this.$manifest = archiveManifest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ArchiveStateMaintenance$finalizePublishedMetadata$2(this.this$0, this.$manifest, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchiveMetadataFinalizationResult> continuation) {
        return ((ArchiveStateMaintenance$finalizePublishedMetadata$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$finalizePublishedMetadata$2$1", f = "ArchiveStateMaintenance.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance$finalizePublishedMetadata$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveMetadataFinalizationResult>, Object> {
        final /* synthetic */ ArchiveManifest $manifest;
        int label;
        final /* synthetic */ ArchiveStateMaintenance this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArchiveStateMaintenance archiveStateMaintenance, ArchiveManifest archiveManifest, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = archiveStateMaintenance;
            this.$manifest = archiveManifest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$manifest, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveMetadataFinalizationResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DurableArchiveStateStore durableArchiveStateStore;
            List<ArchivePackage> packages;
            Function0 function0;
            DurableArchiveStateStore durableArchiveStateStore2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                durableArchiveStateStore = this.this$0.stateStore;
                ArchiveStateLoadResult load = durableArchiveStateStore.load();
                ArchiveStateLoadResult.Loaded loaded = load instanceof ArchiveStateLoadResult.Loaded ? (ArchiveStateLoadResult.Loaded) load : null;
                if (loaded == null) {
                    return new ArchiveMetadataFinalizationResult.Blocked(ArchiveMetadataFinalizationBlockReason.STATE_MISSING, "archive state missing during finalization");
                }
                ArchiveUpdaterState state = loaded.getState();
                if (!state.isPayloadCommitted()) {
                    return new ArchiveMetadataFinalizationResult.Blocked(ArchiveMetadataFinalizationBlockReason.PAYLOAD_NOT_COMMITTED, "archive state is not fully committed during finalization");
                }
                ArchiveManifest archiveManifest = this.$manifest;
                if (archiveManifest == null || (packages = archiveManifest.getPackages()) == null) {
                    return new ArchiveMetadataFinalizationResult.Blocked(ArchiveMetadataFinalizationBlockReason.PUBLISHED_METADATA_MISSING, "archive entry metadata is missing during finalization");
                }
                List<ArchivePackage> list = packages;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (ArchivePackage archivePackage : list) {
                        if (archivePackage.getEntries() == null) {
                            return new ArchiveMetadataFinalizationResult.Blocked(ArchiveMetadataFinalizationBlockReason.PUBLISHED_METADATA_MISSING, "archive entry metadata is missing during finalization");
                        }
                    }
                }
                if (!ArchivePublishedPayloadReconciler.INSTANCE.matches(this.$manifest, state)) {
                    return new ArchiveMetadataFinalizationResult.Blocked(ArchiveMetadataFinalizationBlockReason.PUBLISHED_PAYLOAD_MISMATCH, "archive payload does not match published entry metadata");
                }
                ArchiveStateAdapter archiveStateAdapter = ArchiveStateAdapter.INSTANCE;
                function0 = this.this$0.nowEpochMs;
                ArchiveUpdaterState markPayloadMetadataReconciled = archiveStateAdapter.markPayloadMetadataReconciled(state, ((Number) function0.invoke()).longValue());
                durableArchiveStateStore2 = this.this$0.stateStore;
                durableArchiveStateStore2.save(markPayloadMetadataReconciled);
                return ArchiveMetadataFinalizationResult.Success.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, this.$manifest, null), this);
        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
    }
}
