package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.coreutils.internal.io.InputStreamUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.networkapi.Call;
import io.appmetrica.analytics.networkapi.NetworkCallMetrics;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import io.appmetrica.analytics.networkapi.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes5.dex */
public final class c extends Call {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f1379a;
    public final Request b;
    public final NetworkClientSettings c;

    public c(OkHttpClient okHttpClient, Request request, NetworkClientSettings networkClientSettings) {
        this.f1379a = okHttpClient;
        this.b = request;
        this.c = networkClientSettings;
    }

    public static final EventListener a(d dVar, okhttp3.Call call) {
        return dVar;
    }

    @Override // io.appmetrica.analytics.networkapi.Call
    public final Response execute() {
        NetworkCallMetrics networkCallMetrics;
        NetworkCallMetrics networkCallMetrics2 = null;
        final d dVar = Intrinsics.areEqual(this.c.getCollectMetrics(), Boolean.TRUE) ? new d(new SystemTimeProvider()) : null;
        OkHttpClient okHttpClient = this.f1379a;
        if (dVar != null) {
            okHttpClient = okHttpClient.newBuilder().eventListenerFactory(new EventListener.Factory() { // from class: io.appmetrica.analytics.networkokhttp.impl.c$$ExternalSyntheticLambda0
                @Override // okhttp3.EventListener.Factory
                public final EventListener create(okhttp3.Call call) {
                    return c.a(d.this, call);
                }
            }).build();
        }
        try {
            okhttp3.Response execute = okHttpClient.newCall(a(this.b)).execute();
            Response.Builder withUrl = new Response.Builder(true, execute.code(), InputStreamUtils.INSTANCE.readSafelyApprox(this.c.getMaxResponseSize(), new b(execute))).withHeaders(a(execute.headers())).withUrl(execute.request().url().toString());
            if (dVar != null) {
                Long a2 = d.a(dVar.b, dVar.c);
                Long a3 = d.a(dVar.d, dVar.e);
                networkCallMetrics = new NetworkCallMetrics.Builder().withDnsLookup(a2).withTcpConnect(a3).withTlsHandshake(d.a(dVar.f, dVar.g)).withTimeToFirstByte(d.a(dVar.h, dVar.i)).withResponse(d.a(dVar.i, dVar.j)).withConnectionReused(dVar.l).withProtocol(dVar.k).build();
            } else {
                networkCallMetrics = null;
            }
            return withUrl.withMetrics(networkCallMetrics).build();
        } catch (Throwable th) {
            Response.Builder builder = new Response.Builder(th);
            if (dVar != null) {
                Long a4 = d.a(dVar.b, dVar.c);
                Long a5 = d.a(dVar.d, dVar.e);
                networkCallMetrics2 = new NetworkCallMetrics.Builder().withDnsLookup(a4).withTcpConnect(a5).withTlsHandshake(d.a(dVar.f, dVar.g)).withTimeToFirstByte(d.a(dVar.h, dVar.i)).withResponse(d.a(dVar.i, dVar.j)).withConnectionReused(dVar.l).withProtocol(dVar.k).build();
            }
            return builder.withMetrics(networkCallMetrics2).build();
        }
    }

    public static LinkedHashMap a(Headers headers) {
        IntRange until = RangesKt.until(0, headers.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            String name = headers.name(nextInt);
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add(headers.value(nextInt));
        }
        return linkedHashMap;
    }

    public static okhttp3.Request a(Request request) {
        Request.Builder url = new Request.Builder().url(request.getUrl());
        switch (a.f1377a[request.getMethod().ordinal()]) {
            case 1:
                url.get();
                break;
            case 2:
                url.head();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                url.method(request.getMethod().getMethodName(), RequestBody.Companion.create$default(RequestBody.Companion, request.getBody(), (MediaType) null, 0, 0, 7, (Object) null));
                break;
        }
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        return url.build();
    }
}
