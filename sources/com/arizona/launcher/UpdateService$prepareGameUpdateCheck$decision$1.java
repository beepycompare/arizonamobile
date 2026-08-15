package com.arizona.launcher;

import android.os.Handler;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.UpdateService$prepareGameUpdateCheck$decision$1;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckCoordinator;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$prepareGameUpdateCheck$decision$1", f = "UpdateService.kt", i = {}, l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend", n = {}, nl = {427}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$prepareGameUpdateCheck$decision$1 extends SuspendLambda implements Function1<Continuation<? super ArchiveUpdateCheckDecision>, Object> {
    final /* synthetic */ UpdateOperationKind $kind;
    final /* synthetic */ long $operationToken;
    final /* synthetic */ String $response;
    final /* synthetic */ String $server;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$prepareGameUpdateCheck$decision$1(UpdateService updateService, String str, String str2, UpdateOperationKind updateOperationKind, long j, Continuation<? super UpdateService$prepareGameUpdateCheck$decision$1> continuation) {
        super(1, continuation);
        this.this$0 = updateService;
        this.$response = str;
        this.$server = str2;
        this.$kind = updateOperationKind;
        this.$operationToken = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UpdateService$prepareGameUpdateCheck$decision$1(this.this$0, this.$response, this.$server, this.$kind, this.$operationToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        return ((UpdateService$prepareGameUpdateCheck$decision$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DurableArchiveStateStore durableArchiveStateStore;
        DurableArchiveStateStore durableArchiveStateStore2;
        boolean isGameDownloadRetryEnabled;
        ArchiveGpu selectedArchiveGpu;
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
        File externalFilesDir = this.this$0.getExternalFilesDir(null);
        File externalCacheDir = this.this$0.getExternalCacheDir();
        File file = externalCacheDir != null ? new File(externalCacheDir, "archive-updater/downloads") : null;
        durableArchiveStateStore = this.this$0.archiveStateStore;
        if (durableArchiveStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveStateStore");
            durableArchiveStateStore2 = null;
        } else {
            durableArchiveStateStore2 = durableArchiveStateStore;
        }
        ArchiveManifestResolver.Companion companion = ArchiveManifestResolver.Companion;
        UpdateService updateService = this.this$0;
        UpdateService updateService2 = updateService;
        isGameDownloadRetryEnabled = updateService.isGameDownloadRetryEnabled();
        ArchiveUpdateCheckCoordinator archiveUpdateCheckCoordinator = new ArchiveUpdateCheckCoordinator(externalFilesDir, durableArchiveStateStore2, file, null, companion.create(updateService2, isGameDownloadRetryEnabled, new AnonymousClass2(this.this$0, this.$kind, this.$operationToken, this.$server)), null, null, 104, null);
        String str = this.$response;
        selectedArchiveGpu = this.this$0.selectedArchiveGpu();
        this.label = 1;
        Object prepare = archiveUpdateCheckCoordinator.prepare(str, selectedArchiveGpu, this.$server, this);
        return prepare == coroutine_suspended ? coroutine_suspended : prepare;
    }

    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/arizona/launcher/UpdateService$prepareGameUpdateCheck$decision$1$2", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "onRetry", "", "packageId", "", "retryAttempt", "", "delayMs", "", "failure", "Lcom/arizona/launcher/DownloadFailureDetails;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.UpdateService$prepareGameUpdateCheck$decision$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 implements ArchiveRangeRetryListener {
        final /* synthetic */ UpdateOperationKind $kind;
        final /* synthetic */ long $operationToken;
        final /* synthetic */ String $server;
        final /* synthetic */ UpdateService this$0;

        AnonymousClass2(UpdateService updateService, UpdateOperationKind updateOperationKind, long j, String str) {
            this.this$0 = updateService;
            this.$kind = updateOperationKind;
            this.$operationToken = j;
            this.$server = str;
        }

        @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener
        public void onRetry(final String packageId, final int i, final long j, final DownloadFailureDetails failure) {
            Intrinsics.checkNotNullParameter(packageId, "packageId");
            Intrinsics.checkNotNullParameter(failure, "failure");
            Handler handler = this.this$0.mainHandler;
            final UpdateService updateService = this.this$0;
            final UpdateOperationKind updateOperationKind = this.$kind;
            final long j2 = this.$operationToken;
            final String str = this.$server;
            handler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$prepareGameUpdateCheck$decision$1$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateService$prepareGameUpdateCheck$decision$1.AnonymousClass2.onRetry$lambda$0(UpdateService.this, updateOperationKind, j2, packageId, i, j, failure, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onRetry$lambda$0(UpdateService updateService, UpdateOperationKind updateOperationKind, long j, String str, int i, long j2, DownloadFailureDetails downloadFailureDetails, String str2) {
            boolean isCurrentUpdateOperation;
            UpdateAnalyticsReporter updateAnalyticsReporter;
            isCurrentUpdateOperation = updateService.isCurrentUpdateOperation(updateOperationKind, j);
            if (isCurrentUpdateOperation) {
                Log.w("UPDATE_SERVICE", "Archive index retry package=" + str + " attempt=" + i + " delayMs=" + j2 + " subtype=" + downloadFailureDetails.getSubtypeSuffix());
                updateAnalyticsReporter = updateService.analyticsReporter;
                if (updateAnalyticsReporter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                    updateAnalyticsReporter = null;
                }
                updateAnalyticsReporter.reportArchiveIndexRetry(str, i, j2, downloadFailureDetails, str2);
            }
        }
    }
}
