package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Nm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f560a;

    public Nm() {
        HashMap hashMap = new HashMap();
        this.f560a = hashMap;
        Hm hm = new Hm();
        Im im = new Im();
        Jm jm = new Jm();
        Km km = new Km();
        Lm lm = new Lm();
        hashMap.put(C0291gm.class, hm);
        hashMap.put(Z1.class, im);
        hashMap.put(C0508pf.class, jm);
        hashMap.put(C0669w2.class, km);
        hashMap.put(O3.class, lm);
    }

    public static Om a(Class cls) {
        return (Om) Mm.f542a.f560a.get(cls);
    }
}
