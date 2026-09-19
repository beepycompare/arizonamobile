package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Ck implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0446n5 f503a;
    public final Vk b;

    public Ck(C0446n5 c0446n5, Vk vk) {
        this.f503a = c0446n5;
        this.b = vk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f503a.a(Vk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ Ck(C0446n5 c0446n5, Vk vk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c0446n5, (i & 2) != 0 ? new Vk() : vk);
    }
}
