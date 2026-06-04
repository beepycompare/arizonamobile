package com.arizona.launcher.ui.notifications;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationsViewModel.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ui.notifications.NotificationsViewModel", f = "NotificationsViewModel.kt", i = {1, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {69, 70, 76, 79}, m = "loadNotifications", n = {"fromApi", "fromApi", "fromDb", "mergedList", "fromApi", "fromDb", "mergedList", "$this$forEach$iv", "element$iv", "it"}, nl = {70, 72, 77, 80}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6"}, v = 2)
/* loaded from: classes3.dex */
public final class NotificationsViewModel$loadNotifications$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
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
