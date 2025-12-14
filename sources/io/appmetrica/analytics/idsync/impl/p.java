package io.appmetrica.analytics.idsync.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.idsync.internal.model.Preconditions;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f472a;
    public final B b;
    public final SystemTimeProvider c = new SystemTimeProvider();
    public final q d;
    public final s e;
    public final i f;

    public p(ServiceContext serviceContext, B b) {
        this.f472a = serviceContext;
        this.b = b;
        this.d = new q(serviceContext.getNetworkContext().getSslSocketFactoryProvider(), this);
        this.e = new s(serviceContext);
        this.f = new i(serviceContext);
    }

    public static final void a(y yVar, p pVar) {
        if (yVar.b) {
            B b = pVar.b;
            String str = yVar.f478a;
            b.d.put(str, new z(str, pVar.c.currentTimeMillis(), yVar.d ? 2 : 4));
            b.f458a.putString(b.c, b.b.fromModel(CollectionsKt.toList(b.d.values())));
            i iVar = pVar.f;
            ModuleSelfReporter selfReporter = iVar.f466a.getSelfReporter();
            iVar.b.getClass();
            selfReporter.reportEvent("id_sync", j.a(yVar));
        }
    }

    public static final void a(p pVar, RequestConfig requestConfig) {
        t c0098a;
        s sVar = pVar.e;
        Preconditions preconditions = requestConfig.getPreconditions();
        sVar.getClass();
        if (r.f474a[preconditions.getNetworkType().ordinal()] == 1) {
            c0098a = new C0099b(sVar.f475a);
        } else {
            c0098a = new C0098a();
        }
        if (c0098a.a()) {
            q qVar = pVar.d;
            qVar.getClass();
            Request.Builder builder = new Request.Builder(requestConfig.getUrl());
            for (Map.Entry<String, List<String>> entry : requestConfig.getHeaders().entrySet()) {
                builder.addHeader(entry.getKey(), CollectionsKt.joinToString$default(entry.getValue(), ", ", null, null, 0, null, null, 62, null));
            }
            Response execute = new NetworkClient.Builder().withSslSocketFactory(qVar.f473a.getSslSocketFactory()).withUseCaches(false).withInstanceFollowRedirects(true).withMaxResponseSize(102400).build().newCall(builder.build()).execute();
            qVar.b.a(new y(requestConfig.getType(), execute.isCompleted(), execute.getUrl(), requestConfig.getValidResponseCodes().contains(Integer.valueOf(execute.getCode())), execute.getCode(), !(execute.getResponseData().length == 0) ? execute.getResponseData() : execute.getErrorData(), execute.getHeaders()));
        }
    }

    public final void a(final y yVar) {
        this.f472a.getExecutorProvider().getModuleExecutor().execute(new Runnable() { // from class: io.appmetrica.analytics.idsync.impl.p$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                p.a(y.this, this);
            }
        });
    }

    public final void a(final RequestConfig requestConfig) {
        long resendIntervalForValidResponse;
        if (TextUtils.isEmpty(requestConfig.getType()) || TextUtils.isEmpty(requestConfig.getUrl()) || requestConfig.getValidResponseCodes().isEmpty()) {
            return;
        }
        z zVar = (z) this.b.d.get(requestConfig.getType());
        if (zVar != null) {
            long currentTimeMillis = this.c.currentTimeMillis();
            int a2 = v.a(zVar.c);
            if (a2 != 1) {
                resendIntervalForValidResponse = a2 != 3 ? 0L : requestConfig.getResendIntervalForInvalidResponse();
            } else {
                resendIntervalForValidResponse = requestConfig.getResendIntervalForValidResponse();
            }
            if (currentTimeMillis - zVar.b < resendIntervalForValidResponse) {
                return;
            }
        }
        this.f472a.getExecutorProvider().getSupportIOExecutor().execute(new Runnable() { // from class: io.appmetrica.analytics.idsync.impl.p$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                p.a(p.this, requestConfig);
            }
        });
    }
}
