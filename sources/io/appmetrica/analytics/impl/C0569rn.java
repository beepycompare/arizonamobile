package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.rn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0569rn {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1185a;

    public C0569rn() {
        HashMap hashMap = new HashMap();
        this.f1185a = hashMap;
        C0414ln c0414ln = new C0414ln();
        C0440mn c0440mn = new C0440mn();
        C0466nn c0466nn = new C0466nn();
        C0492on c0492on = new C0492on();
        hashMap.put(Lm.class, c0414ln);
        hashMap.put(C0264g2.class, c0440mn);
        hashMap.put(Df.class, c0466nn);
        hashMap.put(J3.class, c0492on);
    }

    public static InterfaceC0595sn a(Class cls) {
        return (InterfaceC0595sn) AbstractC0544qn.f1170a.f1185a.get(cls);
    }
}
