package com.miami.game.core.firebase.notification;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* compiled from: NotificationStatsSender.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.firebase.notification.HttpNotificationStatsSender$send$2", f = "NotificationStatsSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
final class HttpNotificationStatsSender$send$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends String>>, Object> {
    final /* synthetic */ List<NotificationInteractionEvent> $events;
    int label;
    final /* synthetic */ HttpNotificationStatsSender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpNotificationStatsSender$send$2(List<NotificationInteractionEvent> list, HttpNotificationStatsSender httpNotificationStatsSender, Continuation<? super HttpNotificationStatsSender$send$2> continuation) {
        super(2, continuation);
        this.$events = list;
        this.this$0 = httpNotificationStatsSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpNotificationStatsSender$send$2(this.$events, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Set<String>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<String>> continuation) {
        return ((HttpNotificationStatsSender$send$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9919constructorimpl;
        NotificationStatsPayloadFactory notificationStatsPayloadFactory;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<NotificationInteractionEvent> list = this.$events;
        HttpNotificationStatsSender httpNotificationStatsSender = this.this$0;
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (NotificationInteractionEvent notificationInteractionEvent : list) {
            try {
                Result.Companion companion = Result.Companion;
                notificationStatsPayloadFactory = httpNotificationStatsSender.payloadFactory;
                String jSONObject = notificationStatsPayloadFactory.create(notificationInteractionEvent).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                httpNotificationStatsSender.post(jSONObject);
                m9919constructorimpl = Result.m9919constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9926isSuccessimpl(m9919constructorimpl)) {
                Unit unit = (Unit) m9919constructorimpl;
                createSetBuilder.add(notificationInteractionEvent.getEventId());
                Timber.Forest forest = Timber.Forest;
                NotificationInteractionType type = notificationInteractionEvent.getType();
                forest.d("Notification stats event sent: type=" + type + ", notifRef=" + notificationInteractionEvent.getNotifRef(), new Object[0]);
            }
            Throwable m9922exceptionOrNullimpl = Result.m9922exceptionOrNullimpl(m9919constructorimpl);
            if (m9922exceptionOrNullimpl != null) {
                Timber.Forest forest2 = Timber.Forest;
                NotificationInteractionType type2 = notificationInteractionEvent.getType();
                forest2.w(m9922exceptionOrNullimpl, "Failed to send notification stats event: type=" + type2 + ", notifRef=" + notificationInteractionEvent.getNotifRef(), new Object[0]);
            }
        }
        return SetsKt.build(createSetBuilder);
    }
}
