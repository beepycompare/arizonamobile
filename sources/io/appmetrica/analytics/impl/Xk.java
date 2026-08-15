package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
/* loaded from: classes5.dex */
public final class Xk implements ServiceModuleReporterComponentContext {

    /* renamed from: a  reason: collision with root package name */
    public final Ck f843a;
    public final Bk b;

    public Xk(C0447n5 c0447n5, F4 f4) {
        this.f843a = new Ck(c0447n5, null, 2, null);
        this.b = new Bk(f4);
    }

    public final Bk a() {
        return this.b;
    }

    public final Ck b() {
        return this.f843a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleConfig getConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleReporter getReporter() {
        return this.f843a;
    }
}
