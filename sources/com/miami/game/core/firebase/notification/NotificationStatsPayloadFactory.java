package com.miami.game.core.firebase.notification;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
/* compiled from: NotificationStatsPayloadFactory.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\t*\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsPayloadFactory;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "deviceInfo", "Lcom/miami/game/core/firebase/notification/NotificationStatsDeviceInfo;", "create", "Lorg/json/JSONObject;", "event", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "toApiEventName", "", "Lcom/miami/game/core/firebase/notification/NotificationInteractionType;", "putMetadataValue", "", "key", "value", "toIso8601Utc", "", "putIfNotBlank", "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationStatsPayloadFactory {
    @Deprecated
    public static final String API_EVENT_ENTERED = "entered";
    @Deprecated
    public static final String API_EVENT_OPENED = "opened";
    @Deprecated
    public static final String API_EVENT_RECEIVED = "received";
    private static final Companion Companion = new Companion(null);
    private static final ThreadLocal<SimpleDateFormat> ISO_8601_UTC_FORMAT;
    @Deprecated
    public static final String KEY_ANDROID_SDK = "android_sdk";
    @Deprecated
    public static final String KEY_ANDROID_VERSION = "android_version";
    @Deprecated
    public static final String KEY_APP_BUILD = "app_build";
    @Deprecated
    public static final String KEY_APP_VERSION = "app_version";
    @Deprecated
    public static final String KEY_DEVICE_ID = "device_id";
    @Deprecated
    public static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    @Deprecated
    public static final String KEY_DEVICE_MODEL = "device_model";
    @Deprecated
    public static final String KEY_EVENT = "event";
    @Deprecated
    public static final String KEY_LOCALE = "locale";
    @Deprecated
    public static final String KEY_NOTIF_REF = "notif_ref";
    @Deprecated
    public static final String KEY_PACKAGE_NAME = "package_name";
    @Deprecated
    public static final String KEY_PLATFORM = "platform";
    @Deprecated
    public static final String KEY_RECEIVED_AT = "received_at";
    @Deprecated
    public static final String KEY_SERVER_CODE = "server_code";
    @Deprecated
    public static final String KEY_SERVER_IS_MOBILE = "server_is_mobile";
    @Deprecated
    public static final String KEY_SERVER_IS_TEST = "server_is_test";
    @Deprecated
    public static final String KEY_SERVER_NUMBER = "server_number";
    @Deprecated
    public static final String KEY_TS = "ts";
    private final NotificationStatsDeviceInfo deviceInfo;

    /* compiled from: NotificationStatsPayloadFactory.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationInteractionType.values().length];
            try {
                iArr[NotificationInteractionType.RECEIVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationInteractionType.DISPLAYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotificationInteractionType.OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NotificationInteractionType.GAME_LAUNCHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NotificationStatsPayloadFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.deviceInfo = new NotificationStatsDeviceInfo(applicationContext);
    }

    public final JSONObject create(NotificationInteractionEvent event) {
        String sentAt;
        Intrinsics.checkNotNullParameter(event, "event");
        String iso8601Utc = toIso8601Utc(event.getOccurredAtMillis());
        JSONObject put = new JSONObject().put("notif_ref", event.getNotifRef()).put(KEY_DEVICE_ID, this.deviceInfo.getDeviceId()).put("event", toApiEventName(event.getType()));
        if (iso8601Utc == null) {
            iso8601Utc = event.getSentAt();
        }
        JSONObject put2 = put.put(KEY_TS, iso8601Utc).put(KEY_PLATFORM, this.deviceInfo.getPlatform());
        Intrinsics.checkNotNullExpressionValue(put2, "put(...)");
        JSONObject put3 = putIfNotBlank(putIfNotBlank(putIfNotBlank(put2, KEY_APP_VERSION, this.deviceInfo.getAppVersionName()), "locale", this.deviceInfo.getLocale()), KEY_ANDROID_VERSION, this.deviceInfo.getAndroidVersion()).put(KEY_ANDROID_SDK, this.deviceInfo.getAndroidSdk());
        Intrinsics.checkNotNullExpressionValue(put3, "put(...)");
        JSONObject putIfNotBlank = putIfNotBlank(putIfNotBlank(putIfNotBlank(put3, KEY_DEVICE_MANUFACTURER, this.deviceInfo.getDeviceManufacturer()), KEY_DEVICE_MODEL, this.deviceInfo.getDeviceModel()), KEY_PACKAGE_NAME, this.deviceInfo.getPackageName());
        Long appVersionCode = this.deviceInfo.getAppVersionCode();
        if (appVersionCode != null) {
            putIfNotBlank.put(KEY_APP_BUILD, appVersionCode.longValue());
        }
        if (event.getType() == NotificationInteractionType.GAME_LAUNCHED) {
            Long receivedAtMillis = event.getReceivedAtMillis();
            if (receivedAtMillis == null || (sentAt = toIso8601Utc(receivedAtMillis.longValue())) == null) {
                sentAt = event.getSentAt();
            }
            putIfNotBlank(putIfNotBlank, KEY_RECEIVED_AT, sentAt);
        }
        for (Map.Entry<String, String> entry : event.getMetadata().entrySet()) {
            putMetadataValue(putIfNotBlank, entry.getKey(), entry.getValue());
        }
        return putIfNotBlank;
    }

    private final String toApiEventName(NotificationInteractionType notificationInteractionType) {
        int i = WhenMappings.$EnumSwitchMapping$0[notificationInteractionType.ordinal()];
        if (i == 1 || i == 2) {
            return API_EVENT_RECEIVED;
        }
        if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return API_EVENT_ENTERED;
        }
        return API_EVENT_OPENED;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r2.equals(com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory.KEY_SERVER_NUMBER) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
        if (r2.equals(com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory.KEY_SERVER_CODE) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
        r0 = kotlin.text.StringsKt.toIntOrNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
        if (r0 != 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0059, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005a, code lost:
        r1.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void putMetadataValue(JSONObject jSONObject, String str, String str2) {
        if (StringsKt.isBlank(str2)) {
            str2 = null;
        }
        if (str2 == null) {
            return;
        }
        switch (str.hashCode()) {
            case -759084695:
                break;
            case 251166091:
                if (str.equals(KEY_SERVER_IS_TEST)) {
                    ?? booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str2);
                    if (booleanStrictOrNull != 0) {
                        str2 = booleanStrictOrNull;
                    }
                    jSONObject.put(str, str2);
                    return;
                }
                jSONObject.put(str, str2);
                return;
            case 660762459:
                if (str.equals(KEY_SERVER_IS_MOBILE)) {
                    ?? booleanStrictOrNull2 = StringsKt.toBooleanStrictOrNull(str2);
                    if (booleanStrictOrNull2 != 0) {
                        str2 = booleanStrictOrNull2;
                    }
                    jSONObject.put(str, str2);
                    return;
                }
                jSONObject.put(str, str2);
                return;
            case 984778693:
                break;
            default:
                jSONObject.put(str, str2);
                return;
        }
    }

    private final String toIso8601Utc(long j) {
        if (j <= 0) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = ISO_8601_UTC_FORMAT.get();
        Intrinsics.checkNotNull(simpleDateFormat);
        return simpleDateFormat.format(new Date(j));
    }

    private final JSONObject putIfNotBlank(JSONObject jSONObject, String str, String str2) {
        String str3 = str2;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            jSONObject.put(str, str2);
        }
        return jSONObject;
    }

    /* compiled from: NotificationStatsPayloadFactory.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R5\u0010\u001a\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010\u001b0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationStatsPayloadFactory$Companion;", "", "<init>", "()V", "KEY_NOTIF_REF", "", "KEY_DEVICE_ID", "KEY_EVENT", "KEY_TS", "KEY_RECEIVED_AT", "KEY_PLATFORM", "KEY_APP_VERSION", "KEY_APP_BUILD", "KEY_LOCALE", "KEY_ANDROID_VERSION", "KEY_ANDROID_SDK", "KEY_DEVICE_MANUFACTURER", "KEY_DEVICE_MODEL", "KEY_PACKAGE_NAME", "KEY_SERVER_CODE", "KEY_SERVER_NUMBER", "KEY_SERVER_IS_MOBILE", "KEY_SERVER_IS_TEST", "API_EVENT_RECEIVED", "API_EVENT_OPENED", "API_EVENT_ENTERED", "ISO_8601_UTC_FORMAT", "Ljava/lang/ThreadLocal;", "Ljava/text/SimpleDateFormat;", "kotlin.jvm.PlatformType", "getISO_8601_UTC_FORMAT", "()Ljava/lang/ThreadLocal;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThreadLocal<SimpleDateFormat> getISO_8601_UTC_FORMAT() {
            return NotificationStatsPayloadFactory.ISO_8601_UTC_FORMAT;
        }
    }

    static {
        final Supplier supplier = new Supplier() { // from class: com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return NotificationStatsPayloadFactory.ISO_8601_UTC_FORMAT$lambda$0();
            }
        };
        ISO_8601_UTC_FORMAT = new ThreadLocal() { // from class: com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory$$ExternalSyntheticThreadLocal1
            @Override // java.lang.ThreadLocal
            protected /* synthetic */ Object initialValue() {
                return supplier.get();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SimpleDateFormat ISO_8601_UTC_FORMAT$lambda$0() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }
}
