package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.rn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0562rn {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1191a;

    public C0562rn() {
        HashMap hashMap = new HashMap();
        this.f1191a = hashMap;
        C0407ln c0407ln = new C0407ln();
        C0433mn c0433mn = new C0433mn();
        C0459nn c0459nn = new C0459nn();
        C0485on c0485on = new C0485on();
        hashMap.put(Lm.class, c0407ln);
        hashMap.put(C0257g2.class, c0433mn);
        hashMap.put(Df.class, c0459nn);
        hashMap.put(J3.class, c0485on);
    }

    public static InterfaceC0588sn a(Class cls) {
        return (InterfaceC0588sn) AbstractC0537qn.f1176a.f1191a.get(cls);
    }
}
