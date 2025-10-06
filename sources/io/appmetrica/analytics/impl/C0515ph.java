package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ph  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0515ph extends AbstractC0463nh {
    public final IReporter b;

    public C0515ph(C0652v5 c0652v5, IReporter iReporter) {
        super(c0652v5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        C0278gd c0278gd = (C0278gd) C0278gd.c.get(c0478o6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0278gd.f895a);
        hashMap.put("delivery_method", c0278gd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
