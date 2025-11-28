package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.fk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0251fk implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f880a;
    public final C0730yk b;

    public C0251fk(C0210e5 c0210e5, C0730yk c0730yk) {
        this.f880a = c0210e5;
        this.b = c0730yk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f880a.a(C0730yk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ C0251fk(C0210e5 c0210e5, C0730yk c0730yk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c0210e5, (i & 2) != 0 ? new C0730yk() : c0730yk);
    }
}
