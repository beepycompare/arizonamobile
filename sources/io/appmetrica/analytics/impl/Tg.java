package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Tg extends Rg {
    public final IReporter b;

    public Tg(X4 x4, IReporter iReporter) {
        super(x4);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        Gc gc = (Gc) Gc.c.get(p5.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", gc.f595a);
        hashMap.put("delivery_method", gc.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
