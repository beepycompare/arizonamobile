package com.miami.game.core.firebase.notification;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
/* compiled from: NotificationInteractionEvent.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JZ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006/"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "", "type", "Lcom/miami/game/core/firebase/notification/NotificationInteractionType;", "notifRef", "", "sentAt", "occurredAtMillis", "", "receivedAtMillis", "metadata", "", "<init>", "(Lcom/miami/game/core/firebase/notification/NotificationInteractionType;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/util/Map;)V", "getType", "()Lcom/miami/game/core/firebase/notification/NotificationInteractionType;", "getNotifRef", "()Ljava/lang/String;", "getSentAt", "getOccurredAtMillis", "()J", "getReceivedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMetadata", "()Ljava/util/Map;", "eventId", "getEventId", "attributionKey", "getAttributionKey", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/miami/game/core/firebase/notification/NotificationInteractionType;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/util/Map;)Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "equals", "", "other", "hashCode", "", "toString", "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationInteractionEvent {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_METADATA = "metadata";
    private static final String KEY_NOTIF_REF = "notif_ref";
    private static final String KEY_OCCURRED_AT_MILLIS = "occurred_at_millis";
    private static final String KEY_RECEIVED_AT_MILLIS = "received_at_millis";
    private static final String KEY_SENT_AT = "sent_at";
    private static final String KEY_TYPE = "type";
    private final String attributionKey;
    private final String eventId;
    private final Map<String, String> metadata;
    private final String notifRef;
    private final long occurredAtMillis;
    private final Long receivedAtMillis;
    private final String sentAt;
    private final NotificationInteractionType type;

    public static /* synthetic */ NotificationInteractionEvent copy$default(NotificationInteractionEvent notificationInteractionEvent, NotificationInteractionType notificationInteractionType, String str, String str2, long j, Long l, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            notificationInteractionType = notificationInteractionEvent.type;
        }
        if ((i & 2) != 0) {
            str = notificationInteractionEvent.notifRef;
        }
        if ((i & 4) != 0) {
            str2 = notificationInteractionEvent.sentAt;
        }
        if ((i & 8) != 0) {
            j = notificationInteractionEvent.occurredAtMillis;
        }
        if ((i & 16) != 0) {
            l = notificationInteractionEvent.receivedAtMillis;
        }
        Map<String, String> map2 = map;
        if ((i & 32) != 0) {
            map2 = notificationInteractionEvent.metadata;
        }
        long j2 = j;
        String str3 = str2;
        return notificationInteractionEvent.copy(notificationInteractionType, str, str3, j2, l, map2);
    }

    public final NotificationInteractionType component1() {
        return this.type;
    }

    public final String component2() {
        return this.notifRef;
    }

    public final String component3() {
        return this.sentAt;
    }

    public final long component4() {
        return this.occurredAtMillis;
    }

    public final Long component5() {
        return this.receivedAtMillis;
    }

    public final Map<String, String> component6() {
        return this.metadata;
    }

    public final NotificationInteractionEvent copy(NotificationInteractionType type, String notifRef, String str, long j, Long l, Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(notifRef, "notifRef");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new NotificationInteractionEvent(type, notifRef, str, j, l, metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationInteractionEvent) {
            NotificationInteractionEvent notificationInteractionEvent = (NotificationInteractionEvent) obj;
            return this.type == notificationInteractionEvent.type && Intrinsics.areEqual(this.notifRef, notificationInteractionEvent.notifRef) && Intrinsics.areEqual(this.sentAt, notificationInteractionEvent.sentAt) && this.occurredAtMillis == notificationInteractionEvent.occurredAtMillis && Intrinsics.areEqual(this.receivedAtMillis, notificationInteractionEvent.receivedAtMillis) && Intrinsics.areEqual(this.metadata, notificationInteractionEvent.metadata);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.notifRef.hashCode()) * 31;
        String str = this.sentAt;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.occurredAtMillis)) * 31;
        Long l = this.receivedAtMillis;
        return ((hashCode2 + (l != null ? l.hashCode() : 0)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        NotificationInteractionType notificationInteractionType = this.type;
        String str = this.notifRef;
        String str2 = this.sentAt;
        long j = this.occurredAtMillis;
        Long l = this.receivedAtMillis;
        return "NotificationInteractionEvent(type=" + notificationInteractionType + ", notifRef=" + str + ", sentAt=" + str2 + ", occurredAtMillis=" + j + ", receivedAtMillis=" + l + ", metadata=" + this.metadata + ")";
    }

    public NotificationInteractionEvent(NotificationInteractionType type, String notifRef, String str, long j, Long l, Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(notifRef, "notifRef");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.type = type;
        this.notifRef = notifRef;
        this.sentAt = str;
        this.occurredAtMillis = j;
        this.receivedAtMillis = l;
        this.metadata = metadata;
        this.eventId = type.name() + StringUtils.PROCESS_POSTFIX_DELIMITER + notifRef + StringUtils.PROCESS_POSTFIX_DELIMITER + (str == null ? "" : str) + StringUtils.PROCESS_POSTFIX_DELIMITER + j;
        this.attributionKey = type.name() + StringUtils.PROCESS_POSTFIX_DELIMITER + notifRef + StringUtils.PROCESS_POSTFIX_DELIMITER + (str == null ? "" : str);
    }

    public final NotificationInteractionType getType() {
        return this.type;
    }

    public final String getNotifRef() {
        return this.notifRef;
    }

    public final String getSentAt() {
        return this.sentAt;
    }

    public /* synthetic */ NotificationInteractionEvent(NotificationInteractionType notificationInteractionType, String str, String str2, long j, Long l, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(notificationInteractionType, str, str2, (i & 8) != 0 ? System.currentTimeMillis() : j, (i & 16) != 0 ? null : l, (i & 32) != 0 ? MapsKt.emptyMap() : map);
    }

    public final long getOccurredAtMillis() {
        return this.occurredAtMillis;
    }

    public final Long getReceivedAtMillis() {
        return this.receivedAtMillis;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getAttributionKey() {
        return this.attributionKey;
    }

    public final JSONObject toJson() {
        JSONObject put = new JSONObject().put(KEY_EVENT_ID, this.eventId).put("type", this.type.name()).put("notif_ref", this.notifRef).put("sent_at", this.sentAt).put(KEY_OCCURRED_AT_MILLIS, this.occurredAtMillis);
        Long l = this.receivedAtMillis;
        if (l != null) {
            put.put(KEY_RECEIVED_AT_MILLIS, l.longValue());
        }
        JSONObject put2 = put.put("metadata", new JSONObject(this.metadata));
        Intrinsics.checkNotNullExpressionValue(put2, "put(...)");
        return put2;
    }

    /* compiled from: NotificationInteractionEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent$Companion;", "", "<init>", "()V", "KEY_EVENT_ID", "", "KEY_TYPE", "KEY_NOTIF_REF", "KEY_SENT_AT", "KEY_OCCURRED_AT_MILLIS", "KEY_RECEIVED_AT_MILLIS", "KEY_METADATA", "fromJson", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "json", "Lorg/json/JSONObject;", "optNullableString", "key", "toStringMap", "", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationInteractionEvent fromJson(JSONObject json) {
            Object m9920constructorimpl;
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                String optString = json.optString("type");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                m9920constructorimpl = Result.m9920constructorimpl(NotificationInteractionType.valueOf(optString));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9926isFailureimpl(m9920constructorimpl)) {
                m9920constructorimpl = null;
            }
            NotificationInteractionType notificationInteractionType = (NotificationInteractionType) m9920constructorimpl;
            if (notificationInteractionType == null) {
                return null;
            }
            String optString2 = json.optString("notif_ref");
            Intrinsics.checkNotNull(optString2);
            String str = !StringsKt.isBlank(optString2) ? optString2 : null;
            if (str == null) {
                return null;
            }
            String optNullableString = optNullableString(json, "sent_at");
            Long valueOf = Long.valueOf(json.optLong(NotificationInteractionEvent.KEY_OCCURRED_AT_MILLIS, 0L));
            if (valueOf.longValue() <= 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                long longValue = valueOf.longValue();
                Long valueOf2 = Long.valueOf(json.optLong(NotificationInteractionEvent.KEY_RECEIVED_AT_MILLIS, 0L));
                Long l = valueOf2.longValue() > 0 ? valueOf2 : null;
                JSONObject optJSONObject = json.optJSONObject("metadata");
                Map<String, String> stringMap = optJSONObject != null ? toStringMap(optJSONObject) : null;
                if (stringMap == null) {
                    stringMap = MapsKt.emptyMap();
                }
                return new NotificationInteractionEvent(notificationInteractionType, str, optNullableString, longValue, l, stringMap);
            }
            return null;
        }

        private final String optNullableString(JSONObject jSONObject, String str) {
            if (jSONObject.has(str) && !jSONObject.isNull(str)) {
                String optString = jSONObject.optString(str);
                Intrinsics.checkNotNull(optString);
                if (!StringsKt.isBlank(optString)) {
                    return optString;
                }
            }
            return null;
        }

        private final Map<String, String> toStringMap(JSONObject jSONObject) {
            Map createMapBuilder = MapsKt.createMapBuilder();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                Intrinsics.checkNotNull(optString);
                if (StringsKt.isBlank(optString)) {
                    optString = null;
                }
                if (optString != null) {
                    Intrinsics.checkNotNull(next);
                    createMapBuilder.put(next, optString);
                }
            }
            return MapsKt.build(createMapBuilder);
        }
    }
}
