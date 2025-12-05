package ru.rustore.sdk.metrics.internal;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.rustore.sdk.metrics.MetricsException;
import ru.rustore.sdk.metrics.internal.X;
/* renamed from: ru.rustore.sdk.metrics.internal.s  reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C0827s {

    /* renamed from: a  reason: collision with root package name */
    public final C0811b f1602a;
    public final Q b;
    public final InterfaceC0816g c;
    public final Lazy d;

    public C0827s(C0811b endpointProvider, Q remoteMetricsEventDtoSerializer, X.b logger) {
        Intrinsics.checkNotNullParameter(endpointProvider, "endpointProvider");
        Intrinsics.checkNotNullParameter(remoteMetricsEventDtoSerializer, "remoteMetricsEventDtoSerializer");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1602a = endpointProvider;
        this.b = remoteMetricsEventDtoSerializer;
        this.c = logger;
        this.d = LazyKt.lazy(new C0825p(this));
    }

    public final String a(ArrayList arrayList) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            P remoteMetricsEventDto = (P) it.next();
            this.b.getClass();
            Intrinsics.checkNotNullParameter(remoteMetricsEventDto, "remoteMetricsEventDto");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event_name", remoteMetricsEventDto.e.getEventName());
            jSONObject2.put("user_id", remoteMetricsEventDto.c);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("package_name", remoteMetricsEventDto.f1566a);
            String str = remoteMetricsEventDto.d;
            if (str == null) {
                str = null;
            }
            jSONObject3.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str);
            jSONObject3.put("userIdSdk", remoteMetricsEventDto.c);
            jSONObject3.put("time", String.valueOf(remoteMetricsEventDto.e.getEventTime$sdk_public_metrics_release()));
            for (Map.Entry<String, String> entry : remoteMetricsEventDto.e.getEventData().entrySet()) {
                jSONObject3.put(entry.getKey(), entry.getValue());
            }
            jSONObject2.put("params", jSONObject3);
            String jSONObject4 = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonObject.toString()");
            jSONArray.put(new JSONObject(jSONObject4));
        }
        jSONObject.put("events", jSONArray);
        String jSONObject5 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject5, "jsonObject.toString()");
        return jSONObject5;
    }

    public final void b(ArrayList values) {
        String a2;
        HttpsURLConnection a3;
        Intrinsics.checkNotNullParameter(values, "values");
        HttpsURLConnection httpsURLConnection = null;
        try {
            a2 = a(values);
            a3 = a();
            OutputStream outputStream = a3.getOutputStream();
            byte[] bytes = a2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            outputStream.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.c.a(new C0826q(a3.getURL(), a3.getResponseCode(), a2));
            a3.disconnect();
        } catch (Throwable th2) {
            th = th2;
            httpsURLConnection = a3;
            try {
                this.c.a(new r(th));
                throw new MetricsException.NetworkError("Http request was failed", th);
            } catch (Throwable th3) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                throw th3;
            }
        }
    }

    public static HostnameVerifier a(final URL url) {
        return new HostnameVerifier() { // from class: ru.rustore.sdk.metrics.internal.s$$ExternalSyntheticLambda0
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return C0827s.a(url, str, sSLSession);
            }
        };
    }

    public static final boolean a(URL this_createHostnameVerifier, String str, SSLSession sSLSession) {
        Intrinsics.checkNotNullParameter(this_createHostnameVerifier, "$this_createHostnameVerifier");
        return str.equals(this_createHostnameVerifier.getHost());
    }

    public final HttpsURLConnection a() {
        URLConnection openConnection = ((URL) this.d.getValue()).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        URL backendUrl = (URL) this.d.getValue();
        Intrinsics.checkNotNullExpressionValue(backendUrl, "backendUrl");
        httpsURLConnection.setHostnameVerifier(a(backendUrl));
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("content-type", "application/json");
        httpsURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpsURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpsURLConnection.setDoOutput(true);
        return httpsURLConnection;
    }
}
