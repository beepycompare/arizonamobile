package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.network.internal.NetworkClientBuilder;
import io.appmetrica.analytics.networkapi.NetworkClientSettings;
import io.appmetrica.analytics.networkapi.Request;
import io.appmetrica.analytics.networkapi.Response;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f437a;

    public u(ServiceContext serviceContext) {
        this.f437a = serviceContext;
    }

    public final boolean a(String str, String str2) {
        try {
            Response execute = new NetworkClientBuilder().withSettings(new NetworkClientSettings.Builder().withSslSocketFactory(this.f437a.getNetworkContext().getSslSocketFactoryProvider().getSslSocketFactory()).withUseCaches(false).withInstanceFollowRedirects(true).withMaxResponseSize(10240).build()).build().newCall(new Request.Builder(str).withMethod(Request.Method.POST).withBody(str2.getBytes(Charsets.UTF_8)).addHeader("Content-Type", "application/json").build()).execute();
            if (execute.isCompleted()) {
                if (execute.getCode() != 200) {
                    int code = execute.getCode();
                    if (400 > code || code >= 500) {
                    }
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
