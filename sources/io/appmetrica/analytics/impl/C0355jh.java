package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0355jh extends AbstractC0304hh {
    public final IReporter b;

    public C0355jh(C0447n5 c0447n5, IReporter iReporter) {
        super(c0447n5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0300hd c0300hd = (C0300hd) C0300hd.c.get(c0241f6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0300hd.f1015a);
        hashMap.put("delivery_method", c0300hd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
