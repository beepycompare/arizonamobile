package com.arizona.launcher.ui.notifications;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationsViewModel.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ui.notifications.NotificationsViewModel", f = "NotificationsViewModel.kt", i = {1, 2, 3}, l = {LockFreeTaskQueueCore.CLOSED_SHIFT, 62, 68, TsExtractor.TS_SYNC_BYTE}, m = "loadNotifications", n = {"fromApi", "mergedList", "mergedList"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes3.dex */
public final class NotificationsViewModel$loadNotifications$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsViewModel$loadNotifications$1(NotificationsViewModel notificationsViewModel, Continuation<? super NotificationsViewModel$loadNotifications$1> continuation) {
        super(continuation);
        this.this$0 = notificationsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadNotifications;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadNotifications = this.this$0.loadNotifications(this);
        return loadNotifications;
    }
}
