package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* renamed from: io.appmetrica.analytics.impl.od  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0489od implements ModuleEventServiceHandlerReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C9 f971a;
    public final C0333i6 b;

    public C0489od(C9 c9, C0333i6 c0333i6) {
        this.f971a = c9;
        this.b = c0333i6;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        C0333i6 d = C0333i6.d(this.b);
        d.d = counterReportApi.getType();
        d.e = counterReportApi.getCustomType();
        d.setName(counterReportApi.getName());
        d.setValue(counterReportApi.getValue());
        d.setValueBytes(counterReportApi.getValueBytes());
        d.g = counterReportApi.getBytesTruncated();
        C9 c9 = this.f971a;
        c9.a(d, Pk.a(c9.c.b(d), d.i));
    }
}
