package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* loaded from: classes5.dex */
public final class Vc implements ModuleEventServiceHandlerReporter {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f827a;
    public final C0373k9 b;
    public final P5 c;

    public Vc(boolean z, C0373k9 c0373k9, P5 p5) {
        this.f827a = z;
        this.b = c0373k9;
        this.c = p5;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final boolean isMain() {
        return this.f827a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        P5 d = P5.d(this.c);
        d.d = counterReportApi.getType();
        d.e = counterReportApi.getCustomType();
        d.setName(counterReportApi.getName());
        String value = counterReportApi.getValue();
        if (value != null) {
            d.setValue(value);
        }
        byte[] valueBytes = counterReportApi.getValueBytes();
        if (valueBytes != null) {
            d.setValueBytes(valueBytes);
        }
        d.g = counterReportApi.getBytesTruncated();
        C0373k9 c0373k9 = this.b;
        c0373k9.a(d, Rk.a(c0373k9.c.b(d), d.i));
    }
}
