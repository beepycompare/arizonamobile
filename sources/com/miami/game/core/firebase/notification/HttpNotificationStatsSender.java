package com.miami.game.core.firebase.notification;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;
/* compiled from: NotificationStatsSender.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0014\u0010\u0013\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/firebase/notification/HttpNotificationStatsSender;", "Lcom/miami/game/core/firebase/notification/NotificationStatsSender;", "context", "Landroid/content/Context;", "endpointUrl", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "payloadFactory", "Lcom/miami/game/core/firebase/notification/NotificationStatsPayloadFactory;", "send", "", NotificationStatsStore.KEY_EVENTS, "", "Lcom/miami/game/core/firebase/notification/NotificationInteractionEvent;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "", "payload", "readTextWithLimit", "Ljava/io/InputStream;", "maxBytes", "", "Companion", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HttpNotificationStatsSender implements NotificationStatsSender {
    private static final int CONNECT_TIMEOUT_MS = 2000;
    public static final String DEFAULT_ENDPOINT_URL = "https://promo.shinoa.tech/api/notifications/track";
    private static final int MAX_RESPONSE_BYTES = 16384;
    private static final int READ_TIMEOUT_MS = 3000;
    private final String endpointUrl;
    private final NotificationStatsPayloadFactory payloadFactory;
    public static final Companion Companion = new Companion(null);
    private static final IntRange HTTP_OK_RANGE = new IntRange(200, 299);

    public HttpNotificationStatsSender(Context context, String endpointUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(endpointUrl, "endpointUrl");
        this.endpointUrl = endpointUrl;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.payloadFactory = new NotificationStatsPayloadFactory(applicationContext);
    }

    public /* synthetic */ HttpNotificationStatsSender(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? DEFAULT_ENDPOINT_URL : str);
    }

    @Override // com.miami.game.core.firebase.notification.NotificationStatsSender
    public Object send(List<NotificationInteractionEvent> list, Continuation<? super Set<String>> continuation) {
        if (list.isEmpty()) {
            return SetsKt.emptySet();
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new HttpNotificationStatsSender$send$2(list, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void post(String str) {
        InputStream errorStream;
        URLConnection openConnection = new URL(this.endpointUrl).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        try {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            String str2 = null;
            CloseableKt.closeFinally(outputStream, null);
            int responseCode = httpURLConnection.getResponseCode();
            IntRange intRange = HTTP_OK_RANGE;
            int first = intRange.getFirst();
            if (responseCode <= intRange.getLast() && first <= responseCode) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            if (errorStream != null) {
                InputStream inputStream = errorStream;
                String readTextWithLimit = readTextWithLimit(inputStream, 16384);
                CloseableKt.closeFinally(inputStream, null);
                str2 = readTextWithLimit;
            }
            if (str2 == null) {
                str2 = "";
            }
            int first2 = intRange.getFirst();
            if (responseCode > intRange.getLast() || first2 > responseCode) {
                throw new IOException("Notification stats request failed: " + responseCode + " " + str2);
            }
            if (!StringsKt.isBlank(str2)) {
                Timber.Forest.d("Notification stats response: " + str2, new Object[0]);
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private final String readTextWithLimit(InputStream inputStream, int i) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            int i2 = 0;
            while (true) {
                int read = bufferedInputStream2.read(bArr);
                if (read == -1) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString(Charsets.UTF_8.name());
                    Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream2, "toString(...)");
                    CloseableKt.closeFinally(bufferedInputStream, null);
                    return byteArrayOutputStream2;
                }
                i2 += read;
                if (i2 > i) {
                    String byteArrayOutputStream3 = byteArrayOutputStream.toString(Charsets.UTF_8.name());
                    Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream3, "toString(...)");
                    CloseableKt.closeFinally(bufferedInputStream, null);
                    return byteArrayOutputStream3;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedInputStream, th);
                throw th2;
            }
        }
    }

    /* compiled from: NotificationStatsSender.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/miami/game/core/firebase/notification/HttpNotificationStatsSender$Companion;", "", "<init>", "()V", "DEFAULT_ENDPOINT_URL", "", "CONNECT_TIMEOUT_MS", "", "READ_TIMEOUT_MS", "MAX_RESPONSE_BYTES", "HTTP_OK_RANGE", "Lkotlin/ranges/IntRange;", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
