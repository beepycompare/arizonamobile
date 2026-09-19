package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.rn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0567rn {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1188a;

    public C0567rn() {
        HashMap hashMap = new HashMap();
        this.f1188a = hashMap;
        C0412ln c0412ln = new C0412ln();
        C0438mn c0438mn = new C0438mn();
        C0464nn c0464nn = new C0464nn();
        C0490on c0490on = new C0490on();
        hashMap.put(Lm.class, c0412ln);
        hashMap.put(C0262g2.class, c0438mn);
        hashMap.put(Df.class, c0464nn);
        hashMap.put(J3.class, c0490on);
    }

    public static InterfaceC0593sn a(Class cls) {
        return (InterfaceC0593sn) AbstractC0542qn.f1173a.f1188a.get(cls);
    }
}
