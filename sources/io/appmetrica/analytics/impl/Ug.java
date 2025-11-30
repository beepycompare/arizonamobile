package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Ug extends Sg {
    public final IReporter b;

    public Ug(Y4 y4, IReporter iReporter) {
        super(y4);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Hc hc = (Hc) Hc.c.get(q5.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", hc.f505a);
        hashMap.put("delivery_method", hc.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
