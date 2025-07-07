package com.miami.game.core.foreground.service;

import android.app.Notification;
import android.app.NotificationManager;
import com.miami.game.core.files.updater.domain.model.FilesUpdaterState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "filesUpdaterState", "Lcom/miami/game/core/files/updater/domain/model/FilesUpdaterState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.foreground.service.DownloadService$updateNotification$1", f = "DownloadService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DownloadService$updateNotification$1 extends SuspendLambda implements Function2<FilesUpdaterState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadService$updateNotification$1(DownloadService downloadService, Continuation<? super DownloadService$updateNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadService$updateNotification$1 downloadService$updateNotification$1 = new DownloadService$updateNotification$1(this.this$0, continuation);
        downloadService$updateNotification$1.L$0 = obj;
        return downloadService$updateNotification$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FilesUpdaterState filesUpdaterState, Continuation<? super Unit> continuation) {
        return ((DownloadService$updateNotification$1) create(filesUpdaterState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Notification createNotification;
        NotificationManager notificationManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FilesUpdaterState filesUpdaterState = (FilesUpdaterState) this.L$0;
        int percentageProgress = (int) (filesUpdaterState.getPercentageProgress() * 100);
        if (filesUpdaterState.isComplete()) {
            this.this$0.stopSelf();
        }
        createNotification = this.this$0.createNotification(percentageProgress, filesUpdaterState.getTimeRemainingString());
        notificationManager = this.this$0.notificationManager;
        if (notificationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            notificationManager = null;
        }
        notificationManager.notify(1, createNotification);
        return Unit.INSTANCE;
    }
}
