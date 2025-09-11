package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ph  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0514ph extends AbstractC0462nh {
    public final IReporter b;

    public C0514ph(C0651v5 c0651v5, IReporter iReporter) {
        super(c0651v5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        C0277gd c0277gd = (C0277gd) C0277gd.c.get(c0477o6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0277gd.f894a);
        hashMap.put("delivery_method", c0277gd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
