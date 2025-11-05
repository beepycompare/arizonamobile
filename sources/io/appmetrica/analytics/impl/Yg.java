package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class Yg extends Wg {
    public final IReporter b;

    public Yg(C0210e5 c0210e5, IReporter iReporter) {
        super(c0210e5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        Nc nc = (Nc) Nc.c.get(w5.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", nc.f605a);
        hashMap.put("delivery_method", nc.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
