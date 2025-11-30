package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleConfig;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0680wk implements ServiceModuleReporterComponentContext {

    /* renamed from: a  reason: collision with root package name */
    public final C0148bk f1186a;
    public final C0122ak b;

    public C0680wk(Y4 y4, C0490p4 c0490p4) {
        this.f1186a = new C0148bk(y4, null, 2, null);
        this.b = new C0122ak(c0490p4);
    }

    public final C0122ak a() {
        return this.b;
    }

    public final C0148bk b() {
        return this.f1186a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleConfig getConfig() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext
    public final ServiceComponentModuleReporter getReporter() {
        return this.f1186a;
    }
}
