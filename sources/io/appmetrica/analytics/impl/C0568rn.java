package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.rn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0568rn {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1188a;

    public C0568rn() {
        HashMap hashMap = new HashMap();
        this.f1188a = hashMap;
        C0413ln c0413ln = new C0413ln();
        C0439mn c0439mn = new C0439mn();
        C0465nn c0465nn = new C0465nn();
        C0491on c0491on = new C0491on();
        hashMap.put(Lm.class, c0413ln);
        hashMap.put(C0263g2.class, c0439mn);
        hashMap.put(Df.class, c0465nn);
        hashMap.put(J3.class, c0491on);
    }

    public static InterfaceC0594sn a(Class cls) {
        return (InterfaceC0594sn) AbstractC0543qn.f1173a.f1188a.get(cls);
    }
}
