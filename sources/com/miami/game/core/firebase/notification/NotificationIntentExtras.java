package com.miami.game.core.firebase.notification;

import android.content.Intent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: NotificationIntentExtras.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationIntentExtras;", "", "<init>", "()V", "NOTIF_REF", "", "SENT_AT", "RECEIVED_AT_MILLIS", "putInto", "Landroid/content/Intent;", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "payload", "Lcom/miami/game/core/firebase/notification/PushNotificationPayload;", "receivedAtMillis", "", "(Landroid/content/Intent;Lcom/miami/game/core/firebase/notification/PushNotificationPayload;Ljava/lang/Long;)Landroid/content/Intent;", "openedEventFrom", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationIntentExtras {
    public static final NotificationIntentExtras INSTANCE = new NotificationIntentExtras();
    public static final String NOTIF_REF = "notif_ref";
    public static final String RECEIVED_AT_MILLIS = "notification_received_at_millis";
    public static final String SENT_AT = "sent_at";

    private NotificationIntentExtras() {
    }

    public static /* synthetic */ Intent putInto$default(NotificationIntentExtras notificationIntentExtras, Intent intent, PushNotificationPayload pushNotificationPayload, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        return notificationIntentExtras.putInto(intent, pushNotificationPayload, l);
    }

    public final Intent putInto(Intent intent, PushNotificationPayload payload, Long l) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(payload, "payload");
        String notifRef = payload.getNotifRef();
        if (notifRef != null) {
            intent.putExtra("notif_ref", notifRef);
        }
        String sentAt = payload.getSentAt();
        if (sentAt != null) {
            intent.putExtra(SENT_AT, sentAt);
        }
        if (l != null) {
            intent.putExtra(RECEIVED_AT_MILLIS, l.longValue());
        }
        return intent;
    }

    public final NotificationInteractionEvent openedEventFrom(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("notif_ref")) != null) {
            String str = !StringsKt.isBlank(stringExtra) ? stringExtra : null;
            if (str != null) {
                NotificationInteractionType notificationInteractionType = NotificationInteractionType.OPENED;
                String stringExtra2 = intent.getStringExtra(SENT_AT);
                Long valueOf = Long.valueOf(intent.getLongExtra(RECEIVED_AT_MILLIS, 0L));
                return new NotificationInteractionEvent(notificationInteractionType, str, stringExtra2, 0L, valueOf.longValue() > 0 ? valueOf : null, null, 40, null);
            }
        }
        return null;
    }
}
