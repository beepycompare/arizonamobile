package io.appmetrica.analytics.idsync.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.idsync.internal.model.Preconditions;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.network.internal.NetworkClientBuilder;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import io.appmetrica.analytics.networkapi.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f431a;
    public final G b;
    public SdkIdentifiers c;
    public final SystemTimeProvider d = new SystemTimeProvider();
    public final o e;
    public final x f;
    public final q g;

    public n(ServiceContext serviceContext, G g, SdkIdentifiers sdkIdentifiers) {
        this.f431a = serviceContext;
        this.b = g;
        this.c = sdkIdentifiers;
        this.e = new o(serviceContext.getNetworkContext().getSslSocketFactoryProvider(), this);
        this.f = new x(serviceContext);
        this.g = new q(serviceContext);
    }

    public static final void a(D d, n nVar, RequestConfig requestConfig) {
        if (d.b) {
            G g = nVar.b;
            String str = d.f415a;
            g.d.put(str, new E(str, nVar.d.currentTimeMillis(), d.d ? A.d : A.e));
            g.f418a.putString(g.c, g.b.fromModel(CollectionsKt.toList(g.d.values())));
            q qVar = nVar.g;
            SdkIdentifiers sdkIdentifiers = nVar.c;
            qVar.f434a.getClass();
            String a2 = v.a(d);
            t tVar = qVar.b;
            tVar.getClass();
            ArrayList arrayList = new ArrayList();
            if (requestConfig.getReportEventEnabled()) {
                arrayList.add(new p(tVar.f436a));
            }
            String reportUrl = requestConfig.getReportUrl();
            if (reportUrl != null && !StringsKt.isBlank(reportUrl)) {
                arrayList.add(new r(tVar.f436a, requestConfig.getReportUrl()));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((s) it.next()).a(a2, sdkIdentifiers);
            }
        }
    }

    public final SdkIdentifiers a() {
        return this.c;
    }

    public final void a(SdkIdentifiers sdkIdentifiers) {
        this.c = sdkIdentifiers;
    }

    public static final void a(n nVar, RequestConfig requestConfig) {
        y c0099a;
        x xVar = nVar.f;
        Preconditions preconditions = requestConfig.getPreconditions();
        xVar.getClass();
        if (w.f438a[preconditions.getNetworkType().ordinal()] == 1) {
            c0099a = new C0100b(xVar.f439a);
        } else {
            c0099a = new C0099a();
        }
        if (c0099a.a()) {
            o oVar = nVar.e;
            oVar.getClass();
            Request.Builder builder = new Request.Builder(requestConfig.getUrl());
            for (Map.Entry<String, List<String>> entry : requestConfig.getHeaders().entrySet()) {
                builder.addHeader(entry.getKey(), CollectionsKt.joinToString$default(entry.getValue(), ", ", null, null, 0, null, null, 62, null));
            }
            Response execute = new NetworkClientBuilder().withSettings(new NetworkClientSettings.Builder().withSslSocketFactory(oVar.f432a.getSslSocketFactory()).withUseCaches(false).withInstanceFollowRedirects(true).withMaxResponseSize(102400).build()).build().newCall(builder.build()).execute();
            oVar.b.a(new D(requestConfig.getType(), execute.isCompleted(), execute.getUrl(), requestConfig.getValidResponseCodes().contains(Integer.valueOf(execute.getCode())), execute.getCode(), execute.getResponseData(), execute.getHeaders()), requestConfig);
        }
    }

    public final void a(final D d, final RequestConfig requestConfig) {
        this.f431a.getExecutorProvider().getModuleExecutor().execute(new Runnable() { // from class: io.appmetrica.analytics.idsync.impl.n$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                n.a(D.this, this, requestConfig);
            }
        });
    }

    public final void a(final RequestConfig requestConfig) {
        long resendIntervalForValidResponse;
        if (TextUtils.isEmpty(requestConfig.getType()) || TextUtils.isEmpty(requestConfig.getUrl()) || requestConfig.getValidResponseCodes().isEmpty()) {
            return;
        }
        E e = (E) this.b.d.get(requestConfig.getType());
        if (e != null) {
            long currentTimeMillis = this.d.currentTimeMillis();
            int ordinal = e.c.ordinal();
            if (ordinal != 1) {
                resendIntervalForValidResponse = ordinal != 3 ? 0L : requestConfig.getResendIntervalForInvalidResponse();
            } else {
                resendIntervalForValidResponse = requestConfig.getResendIntervalForValidResponse();
            }
            if (currentTimeMillis - e.b < resendIntervalForValidResponse) {
                return;
            }
        }
        this.f431a.getExecutorProvider().getSupportIOExecutor().execute(new Runnable() { // from class: io.appmetrica.analytics.idsync.impl.n$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                n.a(n.this, requestConfig);
            }
        });
    }
}
