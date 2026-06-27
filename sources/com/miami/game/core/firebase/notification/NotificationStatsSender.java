package com.miami.game.core.firebase.notification;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: NotificationStatsSender.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsSender;", "", "send", "", "", NotificationStatsStore.KEY_EVENTS, "", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NotificationStatsSender {
    Object send(List<NotificationInteractionEvent> list, Continuation<? super Set<String>> continuation);
}
