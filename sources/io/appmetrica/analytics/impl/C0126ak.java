package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0126ak implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f908a;
    public final C0608tk b;

    public C0126ak(X4 x4, C0608tk c0608tk) {
        this.f908a = x4;
        this.b = c0608tk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f908a.a(C0608tk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ C0126ak(X4 x4, C0608tk c0608tk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(x4, (i & 2) != 0 ? new C0608tk() : c0608tk);
    }
}
