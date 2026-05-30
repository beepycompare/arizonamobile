package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleCounterReport;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Ck implements ServiceComponentModuleReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f501a;
    public final Vk b;

    public Ck(C0448n5 c0448n5, Vk vk) {
        this.f501a = c0448n5;
        this.b = vk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentModuleReporter
    public final void handleReport(ServiceModuleCounterReport serviceModuleCounterReport) {
        this.b.getClass();
        this.f501a.a(Vk.a(serviceModuleCounterReport));
    }

    public /* synthetic */ Ck(C0448n5 c0448n5, Vk vk, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c0448n5, (i & 2) != 0 ? new Vk() : vk);
    }
}
