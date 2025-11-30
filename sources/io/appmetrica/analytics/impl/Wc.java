package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* loaded from: classes5.dex */
public final class Wc implements ModuleEventServiceHandlerReporter {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f738a;
    public final C0395l9 b;
    public final Q5 c;

    public Wc(boolean z, C0395l9 c0395l9, Q5 q5) {
        this.f738a = z;
        this.b = c0395l9;
        this.c = q5;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final boolean isMain() {
        return this.f738a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        Q5 d = Q5.d(this.c);
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
        C0395l9 c0395l9 = this.b;
        c0395l9.a(d, Sk.a(c0395l9.c.b(d), d.i));
    }
}
