package com.arizona.launcher;

import android.os.Handler;
import android.util.Log;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/arizona/launcher/UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "onRetry", "", "packageId", "", "retryAttempt", "", "delayMs", "", "failure", "Lcom/arizona/launcher/DownloadFailureDetails;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1 implements ArchiveRangeRetryListener {
    final /* synthetic */ UpdateOperationKind $kind;
    final /* synthetic */ long $operationToken;
    final /* synthetic */ String $server;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1(UpdateService updateService, UpdateOperationKind updateOperationKind, long j, String str) {
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
        handler.post(new Runnable() { // from class: com.arizona.launcher.UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UpdateService$prepareGameUpdateCheck$decision$2$rangeRetryListener$1.onRetry$lambda$0(UpdateService.this, updateOperationKind, j2, packageId, i, j, failure, str);
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
