package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0356jh extends AbstractC0305hh {
    public final IReporter b;

    public C0356jh(C0448n5 c0448n5, IReporter iReporter) {
        super(c0448n5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        C0301hd c0301hd = (C0301hd) C0301hd.c.get(c0242f6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0301hd.f1012a);
        hashMap.put("delivery_method", c0301hd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
