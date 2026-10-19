package com.arizona.launcher;

import com.arizona.launcher.UpdateService;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveCrossLaneUpdateCheck;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveCrossLaneUpdateCheck$prepare$2;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveCrossLaneUpdateCheckResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveGenerationMigration;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStateMaintenance;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterStorageScope;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceCleanupRequest;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationController;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$prepareGameUpdateCheck$2", f = "UpdateService.kt", i = {1, 2, 2}, l = {624, 634, 644}, m = "invokeSuspend", n = {"baseAudit", "baseAudit", "viceAudit"}, nl = {621, 640, 686}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$prepareGameUpdateCheck$2 extends SuspendLambda implements Function1<Continuation<? super ArchiveUpdateCheckDecision>, Object> {
    final /* synthetic */ boolean $generationIncomplete;
    final /* synthetic */ UpdateOperationKind $kind;
    final /* synthetic */ boolean $migrationPending;
    final /* synthetic */ long $operationToken;
    final /* synthetic */ String $response;
    final /* synthetic */ String $server;
    final /* synthetic */ boolean $viceEnabled;
    final /* synthetic */ String $viceResponse;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$prepareGameUpdateCheck$2(boolean z, UpdateService updateService, boolean z2, String str, UpdateOperationKind updateOperationKind, long j, String str2, String str3, boolean z3, Continuation<? super UpdateService$prepareGameUpdateCheck$2> continuation) {
        super(1, continuation);
        this.$migrationPending = z;
        this.this$0 = updateService;
        this.$viceEnabled = z2;
        this.$viceResponse = str;
        this.$kind = updateOperationKind;
        this.$operationToken = j;
        this.$server = str2;
        this.$response = str3;
        this.$generationIncomplete = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UpdateService$prepareGameUpdateCheck$2(this.$migrationPending, this.this$0, this.$viceEnabled, this.$viceResponse, this.$kind, this.$operationToken, this.$server, this.$response, this.$generationIncomplete, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        return ((UpdateService$prepareGameUpdateCheck$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r2 == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c2, code lost:
        if (r6 == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0188, code lost:
        if (r2 == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x018a, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DurableArchiveStateStore durableArchiveStateStore;
        ArchiveStateMaintenance archiveStateMaintenance;
        Object auditFinalizationMetadataIfNeeded;
        UpdateService.ArchiveFinalizationAudit archiveFinalizationAudit;
        ArchiveUpdateCheckDecision.Block block;
        UpdateService.ArchiveFinalizationAudit archiveFinalizationAudit2;
        DurableArchiveStateStore durableArchiveStateStore2;
        ArchiveStateMaintenance archiveStateMaintenance2;
        Object auditFinalizationMetadataIfNeeded2;
        ArchiveUpdateCheckDecision.Block block2;
        ArchiveUpdateCheckCoordinator archiveCheckCoordinator;
        ArchiveUpdateCheckCoordinator archiveCheckCoordinator2;
        DurableArchiveStateStore durableArchiveStateStore3;
        DurableArchiveStateStore durableArchiveStateStore4;
        DurableArchiveStateStore durableArchiveStateStore5;
        DurableArchiveStateStore durableArchiveStateStore6;
        ArchiveGpu selectedArchiveGpu;
        EngineResourceGenerationController engineResourceGenerationController;
        Object prepare;
        EngineResourceGenerationController engineResourceGenerationController2;
        EngineResourceGenerationController engineResourceGenerationController3;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        ArchiveUpdateSessionState archiveUpdateSessionState2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$migrationPending) {
                archiveFinalizationAudit = new UpdateService.ArchiveFinalizationAudit(false, null, 3, null);
                block = archiveFinalizationAudit.getBlock();
                if (block == null) {
                    return block;
                }
                if (this.$migrationPending) {
                    archiveFinalizationAudit2 = new UpdateService.ArchiveFinalizationAudit(false, null, 3, null);
                } else if (this.$viceEnabled && this.$viceResponse != null) {
                    UpdateService updateService = this.this$0;
                    ArchiveUpdaterStorageScope archiveUpdaterStorageScope = ArchiveUpdaterStorageScope.VICE;
                    durableArchiveStateStore2 = this.this$0.viceArchiveStateStore;
                    if (durableArchiveStateStore2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
                        durableArchiveStateStore2 = null;
                    }
                    archiveStateMaintenance2 = this.this$0.viceArchiveStateMaintenance;
                    if (archiveStateMaintenance2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateMaintenance");
                        archiveStateMaintenance2 = null;
                    }
                    this.L$0 = archiveFinalizationAudit;
                    this.label = 2;
                    auditFinalizationMetadataIfNeeded2 = updateService.auditFinalizationMetadataIfNeeded(archiveUpdaterStorageScope, durableArchiveStateStore2, archiveStateMaintenance2, this);
                } else {
                    archiveFinalizationAudit2 = new UpdateService.ArchiveFinalizationAudit(false, null, 3, null);
                }
                block2 = archiveFinalizationAudit2.getBlock();
                if (block2 == null) {
                }
            } else {
                UpdateService updateService2 = this.this$0;
                ArchiveUpdaterStorageScope archiveUpdaterStorageScope2 = ArchiveUpdaterStorageScope.BASE;
                durableArchiveStateStore = this.this$0.archiveStateStore;
                if (durableArchiveStateStore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
                    durableArchiveStateStore = null;
                }
                archiveStateMaintenance = this.this$0.archiveStateMaintenance;
                if (archiveStateMaintenance == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("archiveStateMaintenance");
                    archiveStateMaintenance = null;
                }
                this.label = 1;
                auditFinalizationMetadataIfNeeded = updateService2.auditFinalizationMetadataIfNeeded(archiveUpdaterStorageScope2, durableArchiveStateStore, archiveStateMaintenance, this);
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            auditFinalizationMetadataIfNeeded = obj;
        } else if (i != 2) {
            if (i == 3) {
                UpdateService.ArchiveFinalizationAudit archiveFinalizationAudit3 = (UpdateService.ArchiveFinalizationAudit) this.L$1;
                UpdateService.ArchiveFinalizationAudit archiveFinalizationAudit4 = (UpdateService.ArchiveFinalizationAudit) this.L$0;
                ResultKt.throwOnFailure(obj);
                prepare = obj;
                ArchiveCrossLaneUpdateCheckResult archiveCrossLaneUpdateCheckResult = (ArchiveCrossLaneUpdateCheckResult) prepare;
                Boolean viceContentAvailable = archiveCrossLaneUpdateCheckResult.getViceContentAvailable();
                if (viceContentAvailable != null) {
                    this.this$0.viceContentAvailable = viceContentAvailable.booleanValue();
                }
                if (archiveCrossLaneUpdateCheckResult.getMarkViceCommitted()) {
                    archiveUpdateSessionState2 = this.this$0.viceArchiveSession;
                    archiveUpdateSessionState2.markCommitted();
                }
                ArchiveUpdateCheckDecision viceDecision = archiveCrossLaneUpdateCheckResult.getViceDecision();
                if (viceDecision != null) {
                    UpdateService updateService3 = this.this$0;
                    String str = this.$server;
                    archiveUpdateSessionState = updateService3.viceArchiveSession;
                    archiveUpdateSessionState.applyDecision(viceDecision, str);
                }
                ArchiveUpdateCheckDecision decision = archiveCrossLaneUpdateCheckResult.getDecision();
                if (!(decision instanceof ArchiveUpdateCheckDecision.Block)) {
                    engineResourceGenerationController2 = this.this$0.resourceGeneration;
                    if (engineResourceGenerationController2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resourceGeneration");
                        engineResourceGenerationController3 = null;
                    } else {
                        engineResourceGenerationController3 = engineResourceGenerationController2;
                    }
                    ArchiveUpdateCheckDecision.Block markCompletedIfInstallReady = engineResourceGenerationController3.markCompletedIfInstallReady(new AnonymousClass5(this.this$0));
                    if (markCompletedIfInstallReady != null) {
                        return markCompletedIfInstallReady;
                    }
                }
                return decision;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            archiveFinalizationAudit = (UpdateService.ArchiveFinalizationAudit) this.L$0;
            ResultKt.throwOnFailure(obj);
            auditFinalizationMetadataIfNeeded2 = obj;
            archiveFinalizationAudit2 = (UpdateService.ArchiveFinalizationAudit) auditFinalizationMetadataIfNeeded2;
            block2 = archiveFinalizationAudit2.getBlock();
            if (block2 == null) {
                return block2;
            }
            ArchiveCrossLaneUpdateCheck archiveCrossLaneUpdateCheck = ArchiveCrossLaneUpdateCheck.INSTANCE;
            archiveCheckCoordinator = this.this$0.archiveCheckCoordinator(ArchiveUpdaterStorageScope.BASE, this.$kind, this.$operationToken, this.$server);
            archiveCheckCoordinator2 = this.this$0.archiveCheckCoordinator(ArchiveUpdaterStorageScope.VICE, this.$kind, this.$operationToken, this.$server);
            durableArchiveStateStore3 = this.this$0.archiveStateStore;
            if (durableArchiveStateStore3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
                durableArchiveStateStore4 = null;
            } else {
                durableArchiveStateStore4 = durableArchiveStateStore3;
            }
            durableArchiveStateStore5 = this.this$0.viceArchiveStateStore;
            if (durableArchiveStateStore5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viceArchiveStateStore");
                durableArchiveStateStore6 = null;
            } else {
                durableArchiveStateStore6 = durableArchiveStateStore5;
            }
            selectedArchiveGpu = this.this$0.selectedArchiveGpu();
            boolean z = this.$kind == UpdateOperationKind.CHECK_UPDATE;
            boolean validated = archiveFinalizationAudit.getValidated();
            boolean validated2 = archiveFinalizationAudit2.getValidated();
            engineResourceGenerationController = this.this$0.resourceGeneration;
            if (engineResourceGenerationController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resourceGeneration");
                engineResourceGenerationController = null;
            }
            long j = this.$operationToken;
            final UpdateService updateService4 = this.this$0;
            Function2<? super ArchiveManifest, ? super ArchiveManifest, EngineResourceCleanupRequest> function2 = new Function2() { // from class: com.arizona.launcher.UpdateService$prepareGameUpdateCheck$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return UpdateService$prepareGameUpdateCheck$2.invokeSuspend$lambda$2(UpdateService.this, (ArchiveManifest) obj2, (ArchiveManifest) obj3);
                }
            };
            final UpdateService updateService5 = this.this$0;
            ArchiveGenerationMigration migrationHook = engineResourceGenerationController.migrationHook(j, function2, new Function0() { // from class: com.arizona.launcher.UpdateService$prepareGameUpdateCheck$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UpdateService$prepareGameUpdateCheck$2.invokeSuspend$lambda$3(UpdateService.this);
                }
            });
            String str2 = this.$response;
            String str3 = this.$viceResponse;
            boolean z2 = this.$viceEnabled;
            String str4 = this.$server;
            boolean z3 = this.$generationIncomplete;
            this.L$0 = SpillingKt.nullOutSpilledVariable(archiveFinalizationAudit);
            this.L$1 = SpillingKt.nullOutSpilledVariable(archiveFinalizationAudit2);
            this.label = 3;
            prepare = archiveCrossLaneUpdateCheck.prepare(archiveCheckCoordinator, archiveCheckCoordinator2, durableArchiveStateStore4, durableArchiveStateStore6, str2, str3, z2, selectedArchiveGpu, str4, z, null, (r39 & 2048) != 0 ? false : validated, (r39 & 4096) != 0 ? false : validated2, (r39 & 8192) != 0 ? ArchiveCrossLaneUpdateCheck$prepare$2.INSTANCE : null, (r39 & 16384) != 0 ? null : migrationHook, (r39 & 32768) != 0 ? false : z3, this);
        }
        archiveFinalizationAudit = (UpdateService.ArchiveFinalizationAudit) auditFinalizationMetadataIfNeeded;
        block = archiveFinalizationAudit.getBlock();
        if (block == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final EngineResourceCleanupRequest invokeSuspend$lambda$2(UpdateService updateService, ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2) {
        EngineResourceCleanupRequest resourceCleanupRequest;
        resourceCleanupRequest = updateService.resourceCleanupRequest(archiveManifest, archiveManifest2);
        if (resourceCleanupRequest != null) {
            return resourceCleanupRequest;
        }
        throw new IOException("Archive storage roots are unavailable for resource generation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$3(UpdateService updateService) {
        ArchiveUpdateSessionState archiveUpdateSessionState;
        ArchiveUpdateSessionState archiveUpdateSessionState2;
        archiveUpdateSessionState = updateService.archiveSession;
        archiveUpdateSessionState.invalidateForManifestRefresh();
        archiveUpdateSessionState2 = updateService.viceArchiveSession;
        archiveUpdateSessionState2.invalidateForManifestRefresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpdateService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.UpdateService$prepareGameUpdateCheck$2$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Boolean> {
        AnonymousClass5(Object obj) {
            super(0, obj, UpdateService.class, "resourceLanesReady", "resourceLanesReady()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            boolean resourceLanesReady;
            resourceLanesReady = ((UpdateService) this.receiver).resourceLanesReady();
            return Boolean.valueOf(resourceLanesReady);
        }
    }
}
