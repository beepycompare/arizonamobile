package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Pm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f743a;

    public Pm() {
        HashMap hashMap = new HashMap();
        this.f743a = hashMap;
        Jm jm = new Jm();
        Km km = new Km();
        Lm lm = new Lm();
        Mm mm = new Mm();
        hashMap.put(C0359jm.class, jm);
        hashMap.put(T1.class, km);
        hashMap.put(C0198df.class, lm);
        hashMap.put(C0565s3.class, mm);
    }

    public static Qm a(Class cls) {
        return (Qm) Om.f730a.f743a.get(cls);
    }
}
