package com.arizona.launcher;

import com.arizona.launcher.updater.archive.adoption.ArchiveInstallAdopter;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveBootstrapPrefetcher;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageArtifactCleaner;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectiveDownloadEstimator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$prepareGameUpdateCheck$decision$2", f = "UpdateService.kt", i = {0, 0, 0}, l = {473}, m = "invokeSuspend", n = {"gameRoot", "rangeRetryListener", "retryEnabled"}, nl = {488}, s = {"L$0", "L$1", "Z$0"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$prepareGameUpdateCheck$decision$2 extends SuspendLambda implements Function1<Continuation<? super ArchiveUpdateCheckDecision>, Object> {
    final /* synthetic */ UpdateOperationKind $kind;
    final /* synthetic */ Ref.BooleanRef $metadataAuditValidatedForFinalization;
    final /* synthetic */ long $operationToken;
    final /* synthetic */ String $response;
    final /* synthetic */ String $server;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$prepareGameUpdateCheck$decision$2(UpdateService updateService, String str, String str2, UpdateOperationKind updateOperationKind, Ref.BooleanRef booleanRef, long j, Continuation<? super UpdateService$prepareGameUpdateCheck$decision$2> continuation) {
        super(1, continuation);
        this.this$0 = updateService;
        this.$response = str;
        this.$server = str2;
        this.$kind = updateOperationKind;
        this.$metadataAuditValidatedForFinalization = booleanRef;
        this.$operationToken = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UpdateService$prepareGameUpdateCheck$decision$2(this.this$0, this.$response, this.$server, this.$kind, this.$metadataAuditValidatedForFinalization, this.$operationToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        return ((UpdateService$prepareGameUpdateCheck$decision$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean isGameDownloadRetryEnabled;
        DurableArchiveStateStore durableArchiveStateStore;
        DurableArchiveStateStore durableArchiveStateStore2;
        ArchiveSelectiveDownloadEstimator archiveSelectiveDownloadEstimator;
        ArchiveGpu selectedArchiveGpu;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1 updateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1 = (UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1) this.L$1;
                File file = (File) this.L$0;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        File externalFilesDir = this.this$0.getExternalFilesDir(null);
        isGameDownloadRetryEnabled = this.this$0.isGameDownloadRetryEnabled();
        UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1 updateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$12 = new UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1(this.this$0, this.$kind, this.$operationToken, this.$server);
        ArchiveInstallAdopter forAndroid = ArchiveInstallAdopter.Companion.forAndroid();
        ArchivePackageArtifactCleaner forAndroid2 = ArchivePackageArtifactCleaner.Companion.forAndroid();
        File externalCacheDir = this.this$0.getExternalCacheDir();
        File file2 = externalCacheDir != null ? new File(externalCacheDir, "archive-updater/downloads") : null;
        durableArchiveStateStore = this.this$0.archiveStateStore;
        if (durableArchiveStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore2 = null;
        } else {
            durableArchiveStateStore2 = durableArchiveStateStore;
        }
        ArchiveManifestResolver create = ArchiveManifestResolver.Companion.create(this.this$0, isGameDownloadRetryEnabled, updateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$12);
        try {
            archiveSelectiveDownloadEstimator = new ArchiveSelectiveDownloadEstimator();
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
            archiveSelectiveDownloadEstimator = null;
        }
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator = new ArchiveUpdateCheckCoordinator(externalFilesDir, durableArchiveStateStore2, forAndroid, forAndroid2, file2, null, create, null, archiveSelectiveDownloadEstimator, 160, null);
        String str = this.$response;
        selectedArchiveGpu = this.this$0.selectedArchiveGpu();
        String str2 = this.$server;
        boolean z = this.$kind == UpdateOperationKind.CHECK_UPDATE;
        ArchiveBootstrapPrefetcher forAndroid3 = this.$kind == UpdateOperationKind.CHECK_AND_DOWNLOAD ? ArchiveBootstrapPrefetcher.Companion.forAndroid(this.this$0, isGameDownloadRetryEnabled) : null;
        this.L$0 = SpillingKt.nullOutSpilledVariable(externalFilesDir);
        this.L$1 = SpillingKt.nullOutSpilledVariable(updateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$12);
        this.Z$0 = isGameDownloadRetryEnabled;
        this.label = 1;
        Object prepare = archiveUpdateCheckCoordinator.prepare(str, selectedArchiveGpu, str2, z, forAndroid3, this.$metadataAuditValidatedForFinalization.element, this);
        return prepare == coroutine_suspended ? coroutine_suspended : prepare;
    }
}
