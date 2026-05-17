package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
/* renamed from: io.appmetrica.analytics.impl.vk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0657vk implements ServiceModuleReporterComponentContext {

    /* renamed from: a  reason: collision with root package name */
    public final C0125ak f1279a;
    public final Zj b;

    public C0657vk(X4 x4, C0467o4 c0467o4) {
        this.f1279a = new C0125ak(x4, null, 2, null);
        this.b = new Zj(c0467o4);
    }

    public final Zj a() {
        return this.b;
    }

    public final C0125ak b() {
        return this.f1279a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleConfig getConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleReporter getReporter() {
        return this.f1279a;
    }
}
