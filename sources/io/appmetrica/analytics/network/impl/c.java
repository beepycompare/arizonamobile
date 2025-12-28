package io.appmetrica.analytics.network.impl;

import io.appmetrica.analytics.network.internal.Call;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c implements Call {

    /* renamed from: a  reason: collision with root package name */
    public final NetworkClient f1381a;
    public final Request b;
    public final d c;

    public c(NetworkClient networkClient, Request request, d dVar) {
        this.f1381a = networkClient;
        this.b = request;
        this.c = dVar;
    }

    public final void a(HttpsURLConnection httpsURLConnection) {
        Iterator<T> it = this.b.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Integer readTimeout = this.f1381a.getReadTimeout();
        if (readTimeout != null) {
            httpsURLConnection.setReadTimeout(readTimeout.intValue());
        }
        Integer connectTimeout = this.f1381a.getConnectTimeout();
        if (connectTimeout != null) {
            httpsURLConnection.setConnectTimeout(connectTimeout.intValue());
        }
        Boolean useCaches = this.f1381a.getUseCaches();
        if (useCaches != null) {
            httpsURLConnection.setUseCaches(useCaches.booleanValue());
        }
        Boolean instanceFollowRedirects = this.f1381a.getInstanceFollowRedirects();
        if (instanceFollowRedirects != null) {
            httpsURLConnection.setInstanceFollowRedirects(instanceFollowRedirects.booleanValue());
        }
        httpsURLConnection.setRequestMethod(this.b.getMethod());
        SSLSocketFactory sslSocketFactory = this.f1381a.getSslSocketFactory();
        if (sslSocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
        }
    }

    @Override // io.appmetrica.analytics.network.internal.Call
    public final Response execute() {
        Map<String, List<String>> map;
        int i;
        Throwable th;
        String str;
        boolean z;
        try {
            d dVar = this.c;
            String url = this.b.getUrl();
            dVar.getClass();
            URLConnection openConnection = new URL(url).openConnection();
            HttpsURLConnection httpsURLConnection = openConnection instanceof HttpsURLConnection ? (HttpsURLConnection) openConnection : null;
            if (httpsURLConnection == null) {
                return new Response(new IllegalArgumentException("Connection created for " + this.b.getUrl() + " does not represent https connection"));
            }
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            try {
                a(httpsURLConnection);
                if (Intrinsics.areEqual(this.b.getMethod(), "POST")) {
                    httpsURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpsURLConnection.getOutputStream();
                    if (outputStream != null) {
                        outputStream.write(this.b.getBody());
                        outputStream.flush();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                    }
                }
                i = httpsURLConnection.getResponseCode();
                try {
                    map = httpsURLConnection.getHeaderFields();
                    try {
                        bArr = e.a(this.f1381a.getMaxResponseSize(), new a(httpsURLConnection));
                        bArr2 = e.a(this.f1381a.getMaxResponseSize(), new b(httpsURLConnection));
                        str = httpsURLConnection.getURL().toString();
                        th = null;
                        z = true;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        str = null;
                        z = false;
                        byte[] bArr3 = bArr;
                        byte[] bArr4 = bArr2;
                        int i2 = i;
                        Map<String, List<String>> map2 = map;
                        httpsURLConnection.disconnect();
                        return new Response(z, i2, bArr3, bArr4, map2, th, str);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    map = null;
                }
            } catch (Throwable th4) {
                th = th4;
                map = null;
                i = 0;
            }
            byte[] bArr32 = bArr;
            byte[] bArr42 = bArr2;
            int i22 = i;
            Map<String, List<String>> map22 = map;
            try {
                httpsURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            return new Response(z, i22, bArr32, bArr42, map22, th, str);
        } catch (Throwable th5) {
            return new Response(th5);
        }
    }

    public c(NetworkClient networkClient, Request request) {
        this(networkClient, request, new d());
    }
}
