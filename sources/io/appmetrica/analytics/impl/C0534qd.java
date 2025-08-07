package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0534qd implements ModuleEventServiceHandlerReporter {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1017a;
    public final F9 b;
    public final C0402l6 c;

    public C0534qd(boolean z, F9 f9, C0402l6 c0402l6) {
        this.f1017a = z;
        this.b = f9;
        this.c = c0402l6;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final boolean isMain() {
        return this.f1017a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        C0402l6 d = C0402l6.d(this.c);
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
        F9 f9 = this.b;
        f9.a(d, Sk.a(f9.c.b(d), d.i));
    }
}
