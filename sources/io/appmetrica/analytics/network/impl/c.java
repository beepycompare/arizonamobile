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
/* loaded from: classes4.dex */
public final class c implements Call {

    /* renamed from: a  reason: collision with root package name */
    public final NetworkClient f1219a;
    public final Request b;
    public final d c;

    public c(NetworkClient networkClient, Request request, d dVar) {
        this.f1219a = networkClient;
        this.b = request;
        this.c = dVar;
    }

    public final void a(HttpsURLConnection httpsURLConnection) {
        Iterator<T> it = this.b.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Integer readTimeout = this.f1219a.getReadTimeout();
        if (readTimeout != null) {
            httpsURLConnection.setReadTimeout(readTimeout.intValue());
        }
        Integer connectTimeout = this.f1219a.getConnectTimeout();
        if (connectTimeout != null) {
            httpsURLConnection.setConnectTimeout(connectTimeout.intValue());
        }
        Boolean useCaches = this.f1219a.getUseCaches();
        if (useCaches != null) {
            httpsURLConnection.setUseCaches(useCaches.booleanValue());
        }
        Boolean instanceFollowRedirects = this.f1219a.getInstanceFollowRedirects();
        if (instanceFollowRedirects != null) {
            httpsURLConnection.setInstanceFollowRedirects(instanceFollowRedirects.booleanValue());
        }
        httpsURLConnection.setRequestMethod(this.b.getMethod());
        SSLSocketFactory sslSocketFactory = this.f1219a.getSslSocketFactory();
        if (sslSocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(7:12|13|14|(3:37|38|(2:40|41))|16|17|18)|(3:20|21|22)|23|24|25|26|27) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Throwable] */
    @Override // io.appmetrica.analytics.network.internal.Call
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response execute() {
        int i;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        boolean z;
        Map<String, List<String>> headerFields;
        try {
            d dVar = this.c;
            String url = this.b.getUrl();
            dVar.getClass();
            URLConnection openConnection = new URL(url).openConnection();
            Map<String, List<String>> map3 = null;
            HttpsURLConnection httpsURLConnection = openConnection instanceof HttpsURLConnection ? (HttpsURLConnection) openConnection : null;
            if (httpsURLConnection == null) {
                return new Response(new IllegalArgumentException("Connection created for " + this.b.getUrl() + " does not represent https connection"));
            }
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            try {
                a(httpsURLConnection);
                if (Intrinsics.areEqual(this.b.getMethod(), "POST")) {
                    try {
                        httpsURLConnection.setDoOutput(true);
                        OutputStream outputStream = httpsURLConnection.getOutputStream();
                        if (outputStream != null) {
                            outputStream.write(this.b.getBody());
                            outputStream.flush();
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(outputStream, null);
                        }
                    } catch (Throwable th) {
                        map3 = th;
                        map = null;
                        i = 0;
                        map2 = map;
                        z = false;
                        ?? r15 = map3;
                        byte[] bArr3 = bArr;
                        byte[] bArr4 = bArr2;
                        int i2 = i;
                        httpsURLConnection.disconnect();
                        return new Response(z, i2, bArr3, bArr4, map2, r15);
                    }
                }
                i = httpsURLConnection.getResponseCode();
                try {
                    headerFields = httpsURLConnection.getHeaderFields();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                i = 0;
            }
            try {
                bArr = e.a(this.f1219a.getMaxResponseSize(), new a(httpsURLConnection));
                bArr2 = e.a(this.f1219a.getMaxResponseSize(), new b(httpsURLConnection));
                z = true;
                map2 = headerFields;
            } catch (Throwable th4) {
                th = th4;
                map3 = headerFields;
                Map<String, List<String>> map4 = map3;
                map3 = th;
                map = map4;
                map2 = map;
                z = false;
                ?? r152 = map3;
                byte[] bArr32 = bArr;
                byte[] bArr42 = bArr2;
                int i22 = i;
                httpsURLConnection.disconnect();
                return new Response(z, i22, bArr32, bArr42, map2, r152);
            }
            ?? r1522 = map3;
            byte[] bArr322 = bArr;
            byte[] bArr422 = bArr2;
            int i222 = i;
            httpsURLConnection.disconnect();
            return new Response(z, i222, bArr322, bArr422, map2, r1522);
        } catch (Throwable th5) {
            return new Response(th5);
        }
    }

    public c(NetworkClient networkClient, Request request) {
        this(networkClient, request, new d());
    }
}
