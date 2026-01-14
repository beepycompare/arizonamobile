package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Pm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f744a;

    public Pm() {
        HashMap hashMap = new HashMap();
        this.f744a = hashMap;
        Jm jm = new Jm();
        Km km = new Km();
        Lm lm = new Lm();
        Mm mm = new Mm();
        hashMap.put(C0360jm.class, jm);
        hashMap.put(T1.class, km);
        hashMap.put(C0199df.class, lm);
        hashMap.put(C0566s3.class, mm);
    }

    public static Qm a(Class cls) {
        return (Qm) Om.f731a.f744a.get(cls);
    }
}
