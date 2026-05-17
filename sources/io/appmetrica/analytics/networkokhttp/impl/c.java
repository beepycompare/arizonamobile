package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.coreutils.internal.io.InputStreamUtils;
import io.appmetrica.analytics.networkapi.Call;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import io.appmetrica.analytics.networkapi.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes5.dex */
public final class c extends Call {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f1398a;
    public final Request b;
    public final NetworkClientSettings c;

    public c(OkHttpClient okHttpClient, Request request, NetworkClientSettings networkClientSettings) {
        this.f1398a = okHttpClient;
        this.b = request;
        this.c = networkClientSettings;
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

    @Override // io.appmetrica.analytics.networkapi.Call
    public final Response execute() {
        try {
            okhttp3.Response execute = this.f1398a.newCall(a(this.b)).execute();
            return new Response.Builder(true, execute.code(), InputStreamUtils.INSTANCE.readSafelyApprox(this.c.getMaxResponseSize(), new b(execute))).withHeaders(a(execute.headers())).withUrl(execute.request().url().toString()).build();
        } catch (Throwable th) {
            return new Response.Builder(th).build();
        }
    }

    public static okhttp3.Request a(Request request) {
        Request.Builder url = new Request.Builder().url(request.getUrl());
        int i = a.f1396a[request.getMethod().ordinal()];
        if (i == 1) {
            url.get();
        } else if (i == 2) {
            url.method(request.getMethod().getMethodName(), RequestBody.Companion.create$default(RequestBody.Companion, request.getBody(), (MediaType) null, 0, 0, 7, (Object) null));
        }
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            url.addHeader(entry.getKey(), entry.getValue());
        }
        return url.build();
    }
}
