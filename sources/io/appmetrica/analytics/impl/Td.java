package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider;
import io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext;
/* loaded from: classes5.dex */
public final class Td implements ServiceNetworkContext {

    /* renamed from: a  reason: collision with root package name */
    public final C0261g5 f776a;
    public final String b = new Cdo().a();
    public final C0605tl c = new C0605tl();

    public Td(Context context) {
        this.f776a = new C0261g5(new C0515q5(context), new C0528qi(C0470oa.k().h()));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final IExecutionPolicy getExecutionPolicy() {
        return this.f776a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final SimpleNetworkApi getNetworkApi() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final SslSocketFactoryProvider getSslSocketFactoryProvider() {
        return C0470oa.I.z();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final String getUserAgent() {
        return this.b;
    }
}
