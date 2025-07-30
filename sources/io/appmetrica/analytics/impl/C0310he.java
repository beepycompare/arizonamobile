package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider;
import io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext;
/* renamed from: io.appmetrica.analytics.impl.he  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0310he implements ServiceNetworkContext {

    /* renamed from: a  reason: collision with root package name */
    public final A5 f885a;
    public final String b = new Zn().a();
    public final C0590sl c = new C0590sl();

    public C0310he(Context context) {
        this.f885a = new A5(new K5(context), new Ci(Ia.j().g()));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final IExecutionPolicy getExecutionPolicy() {
        return this.f885a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final SimpleNetworkApi getNetworkApi() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final SslSocketFactoryProvider getSslSocketFactoryProvider() {
        return Ia.F.y();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext
    public final String getUserAgent() {
        return this.b;
    }
}
