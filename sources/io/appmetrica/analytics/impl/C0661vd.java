package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* renamed from: io.appmetrica.analytics.impl.vd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0661vd implements ModuleEventServiceHandlerReporter {

    /* renamed from: a  reason: collision with root package name */
    public final String f1250a;
    public final boolean b;
    public final E9 c;
    public final C0240f6 d;

    public C0661vd(String str, boolean z, E9 e9, C0240f6 c0240f6) {
        this.f1250a = str;
        this.b = z;
        this.c = e9;
        this.d = c0240f6;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final String getApiKey() {
        return this.f1250a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final boolean isMain() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        C0240f6 d = C0240f6.d(this.d);
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
        E9 e9 = this.c;
        e9.a(d, C0669vl.a(e9.c.b(d), d.i));
    }
}
