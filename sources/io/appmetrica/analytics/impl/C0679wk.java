package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0679wk implements ServiceModuleReporterComponentContext {

    /* renamed from: a  reason: collision with root package name */
    public final C0147bk f1269a;
    public final C0121ak b;

    public C0679wk(Y4 y4, C0489p4 c0489p4) {
        this.f1269a = new C0147bk(y4, null, 2, null);
        this.b = new C0121ak(c0489p4);
    }

    public final C0121ak a() {
        return this.b;
    }

    public final C0147bk b() {
        return this.f1269a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleConfig getConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleReporter getReporter() {
        return this.f1269a;
    }
}
