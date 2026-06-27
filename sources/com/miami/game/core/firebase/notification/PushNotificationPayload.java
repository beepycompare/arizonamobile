package com.miami.game.core.firebase.notification;

import android.net.Uri;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: PushNotificationPayload.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/miami/game/core/firebase/notification/PushNotificationPayload;", "", "title", "", TtmlNode.TAG_BODY, "imageUrl", "notifRef", "sentAt", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getBody", "getImageUrl", "getNotifRef", "getSentAt", "getMessageId", "canReportInteraction", "", "getCanReportInteraction", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PushNotificationPayload {
    public static final Companion Companion = new Companion(null);
    private final String body;
    private final boolean canReportInteraction;
    private final String imageUrl;
    private final String messageId;
    private final String notifRef;
    private final String sentAt;
    private final String title;

    public static /* synthetic */ PushNotificationPayload copy$default(PushNotificationPayload pushNotificationPayload, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushNotificationPayload.title;
        }
        if ((i & 2) != 0) {
            str2 = pushNotificationPayload.body;
        }
        if ((i & 4) != 0) {
            str3 = pushNotificationPayload.imageUrl;
        }
        if ((i & 8) != 0) {
            str4 = pushNotificationPayload.notifRef;
        }
        if ((i & 16) != 0) {
            str5 = pushNotificationPayload.sentAt;
        }
        if ((i & 32) != 0) {
            str6 = pushNotificationPayload.messageId;
        }
        String str7 = str5;
        String str8 = str6;
        return pushNotificationPayload.copy(str, str2, str3, str4, str7, str8);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.body;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final String component4() {
        return this.notifRef;
    }

    public final String component5() {
        return this.sentAt;
    }

    public final String component6() {
        return this.messageId;
    }

    public final PushNotificationPayload copy(String title, String body, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        return new PushNotificationPayload(title, body, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PushNotificationPayload) {
            PushNotificationPayload pushNotificationPayload = (PushNotificationPayload) obj;
            return Intrinsics.areEqual(this.title, pushNotificationPayload.title) && Intrinsics.areEqual(this.body, pushNotificationPayload.body) && Intrinsics.areEqual(this.imageUrl, pushNotificationPayload.imageUrl) && Intrinsics.areEqual(this.notifRef, pushNotificationPayload.notifRef) && Intrinsics.areEqual(this.sentAt, pushNotificationPayload.sentAt) && Intrinsics.areEqual(this.messageId, pushNotificationPayload.messageId);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.body.hashCode()) * 31;
        String str = this.imageUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.notifRef;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sentAt;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.messageId;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.body;
        String str3 = this.imageUrl;
        String str4 = this.notifRef;
        String str5 = this.sentAt;
        return "PushNotificationPayload(title=" + str + ", body=" + str2 + ", imageUrl=" + str3 + ", notifRef=" + str4 + ", sentAt=" + str5 + ", messageId=" + this.messageId + ")";
    }

    public PushNotificationPayload(String title, String body, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        this.title = title;
        this.body = body;
        this.imageUrl = str;
        this.notifRef = str2;
        this.sentAt = str3;
        this.messageId = str4;
        String str5 = str2;
        this.canReportInteraction = true ^ (str5 == null || StringsKt.isBlank(str5));
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getNotifRef() {
        return this.notifRef;
    }

    public final String getSentAt() {
        return this.sentAt;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final boolean getCanReportInteraction() {
        return this.canReportInteraction;
    }

    /* compiled from: PushNotificationPayload.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007JL\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ3\u0010\u0010\u001a\u0004\u0018\u00010\u000b*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0012\"\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/firebase/notification/PushNotificationPayload$Companion;", "", "<init>", "()V", "fromRemoteMessage", "Lcom/miami/game/core/firebase/notification/PushNotificationPayload;", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "fromData", "data", "", "", "fallbackTitle", "fallbackBody", "fallbackImageUrl", "messageId", "firstValue", UserMetadata.KEYDATA_FILENAME, "", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/String;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PushNotificationPayload fromRemoteMessage(RemoteMessage message) {
            Uri imageUrl;
            Intrinsics.checkNotNullParameter(message, "message");
            Map<String, String> data = message.getData();
            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
            RemoteMessage.Notification notification = message.getNotification();
            String str = null;
            String title = notification != null ? notification.getTitle() : null;
            RemoteMessage.Notification notification2 = message.getNotification();
            String body = notification2 != null ? notification2.getBody() : null;
            RemoteMessage.Notification notification3 = message.getNotification();
            if (notification3 != null && (imageUrl = notification3.getImageUrl()) != null) {
                str = imageUrl.toString();
            }
            return fromData(data, title, body, str, message.getMessageId());
        }

        public static /* synthetic */ PushNotificationPayload fromData$default(Companion companion, Map map, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            return companion.fromData(map, str, str2, str3, str4);
        }

        public final PushNotificationPayload fromData(Map<String, String> data, String str, String str2, String str3, String str4) {
            String str5;
            Intrinsics.checkNotNullParameter(data, "data");
            String firstValue = firstValue(data, "title");
            String str6 = firstValue == null ? str : firstValue;
            String firstValue2 = firstValue(data, TtmlNode.TAG_BODY, "text", "message");
            String str7 = firstValue2 == null ? str2 : firstValue2;
            String str8 = str6;
            if (str8 == null || StringsKt.isBlank(str8) || (str5 = str7) == null || StringsKt.isBlank(str5)) {
                return null;
            }
            String firstValue3 = firstValue(data, "image_url", "imageUrl", "image", "picture");
            return new PushNotificationPayload(str6, str7, firstValue3 == null ? str3 : firstValue3, firstValue(data, "notif_ref"), firstValue(data, NotificationIntentExtras.SENT_AT), str4);
        }

        private final String firstValue(Map<String, String> map, String... strArr) {
            Object obj;
            String str;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str2 = map.get(strArr[i]);
                    if (str2 != null) {
                        String str3 = StringsKt.isBlank(str2) ? null : str2;
                        if (str3 != null) {
                            return str3;
                        }
                    }
                    i++;
                } else {
                    Iterator<T> it = map.entrySet().iterator();
                    loop1: while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        Map.Entry entry = (Map.Entry) obj;
                        for (String str4 : strArr) {
                            if (StringsKt.equals(str4, (String) entry.getKey(), true)) {
                                break loop1;
                            }
                        }
                    }
                    Map.Entry entry2 = (Map.Entry) obj;
                    if (entry2 == null || (str = (String) entry2.getValue()) == null || StringsKt.isBlank(str)) {
                        return null;
                    }
                    return str;
                }
            }
        }
    }
}
