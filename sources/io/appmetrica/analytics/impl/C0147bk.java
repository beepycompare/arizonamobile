package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0147bk implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f918a;
    public final C0629uk b;

    public C0147bk(Y4 y4, C0629uk c0629uk) {
        this.f918a = y4;
        this.b = c0629uk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f918a.a(C0629uk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ C0147bk(Y4 y4, C0629uk c0629uk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(y4, (i & 2) != 0 ? new C0629uk() : c0629uk);
    }
}
