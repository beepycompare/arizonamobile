package com.miami.game.core.firebase.notification;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: NotificationInteractionEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationInteractionReporter;", "", "report", "", "event", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "(Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NotificationInteractionReporter {
    Object report(NotificationInteractionEvent notificationInteractionEvent, Continuation<? super Unit> continuation);
}
