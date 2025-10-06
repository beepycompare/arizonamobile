package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;
/* renamed from: io.appmetrica.analytics.impl.vd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0660vd implements ModuleEventServiceHandlerReporter {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1125a;
    public final K9 b;
    public final C0478o6 c;

    public C0660vd(boolean z, K9 k9, C0478o6 c0478o6) {
        this.f1125a = z;
        this.b = k9;
        this.c = c0478o6;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final boolean isMain() {
        return this.f1125a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        C0478o6 d = C0478o6.d(this.c);
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
        K9 k9 = this.b;
        k9.a(d, C0157bl.a(k9.c.b(d), d.i));
    }
}
