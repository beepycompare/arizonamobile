package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0354jh extends AbstractC0303hh {
    public final IReporter b;

    public C0354jh(C0446n5 c0446n5, IReporter iReporter) {
        super(c0446n5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        C0299hd c0299hd = (C0299hd) C0299hd.c.get(c0240f6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0299hd.f1015a);
        hashMap.put("delivery_method", c0299hd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
