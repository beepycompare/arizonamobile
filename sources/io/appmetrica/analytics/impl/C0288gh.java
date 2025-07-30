package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0288gh extends AbstractC0236eh {
    public final IReporter b;

    public C0288gh(C0574s5 c0574s5, IReporter iReporter) {
        super(c0574s5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        C0155bd c0155bd = (C0155bd) C0155bd.c.get(c0401l6.d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", c0155bd.f783a);
        hashMap.put("delivery_method", c0155bd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
