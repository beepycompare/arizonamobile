package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
/* loaded from: classes3.dex */
public final class Ak implements ServiceModuleReporterComponentContext {

    /* renamed from: a  reason: collision with root package name */
    public final C0251fk f399a;
    public final C0225ek b;

    public Ak(C0210e5 c0210e5, C0639v4 c0639v4) {
        this.f399a = new C0251fk(c0210e5, null, 2, null);
        this.b = new C0225ek(c0639v4);
    }

    public final C0225ek a() {
        return this.b;
    }

    public final C0251fk b() {
        return this.f399a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleConfig getConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleReporter getReporter() {
        return this.f399a;
    }
}
