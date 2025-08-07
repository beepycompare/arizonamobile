package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0289gh extends AbstractC0237eh {
    public final IReporter b;

    public C0289gh(C0575s5 c0575s5, IReporter iReporter) {
        super(c0575s5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        C0156bd c0156bd = (C0156bd) C0156bd.c.get(c0402l6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0156bd.f782a);
        hashMap.put("delivery_method", c0156bd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
