package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.lh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0410lh extends AbstractC0358jh {
    public final IReporter b;

    public C0410lh(C0572s5 c0572s5, IReporter iReporter) {
        super(c0572s5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        C0200dd c0200dd = (C0200dd) C0200dd.c.get(c0399l6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0200dd.f829a);
        hashMap.put("delivery_method", c0200dd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
