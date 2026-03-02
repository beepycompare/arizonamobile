package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0125ak implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f907a;
    public final C0607tk b;

    public C0125ak(X4 x4, C0607tk c0607tk) {
        this.f907a = x4;
        this.b = c0607tk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f907a.a(C0607tk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ C0125ak(X4 x4, C0607tk c0607tk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(x4, (i & 2) != 0 ? new C0607tk() : c0607tk);
    }
}
