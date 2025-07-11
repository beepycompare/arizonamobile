package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.eh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0236eh extends AbstractC0185ch {
    public final IReporter b;

    public C0236eh(C0572s5 c0572s5, IReporter iReporter) {
        super(c0572s5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        Zc zc = (Zc) Zc.c.get(c0325i6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", zc.f736a);
        hashMap.put("delivery_method", zc.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
