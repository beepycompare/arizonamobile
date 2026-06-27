package com.miami.game.core.firebase.notification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationStatsTracker.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.firebase.notification.NotificationStatsTracker", f = "NotificationStatsTracker.kt", i = {0, 0}, l = {30}, m = "flushPending", n = {"pendingEvents", "$this$flushPending_u24lambda_u240"}, nl = {29}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes5.dex */
public final class NotificationStatsTracker$flushPending$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationStatsTracker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationStatsTracker$flushPending$1(NotificationStatsTracker notificationStatsTracker, Continuation<? super NotificationStatsTracker$flushPending$1> continuation) {
        super(continuation);
        this.this$0 = notificationStatsTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.flushPending(this);
    }
}
