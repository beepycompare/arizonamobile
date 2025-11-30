package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0148bk implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f820a;
    public final C0630uk b;

    public C0148bk(Y4 y4, C0630uk c0630uk) {
        this.f820a = y4;
        this.b = c0630uk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f820a.a(C0630uk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ C0148bk(Y4 y4, C0630uk c0630uk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(y4, (i & 2) != 0 ? new C0630uk() : c0630uk);
    }
}
