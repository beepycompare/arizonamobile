package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Qm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f753a;

    public Qm() {
        HashMap hashMap = new HashMap();
        this.f753a = hashMap;
        Km km = new Km();
        Lm lm = new Lm();
        Mm mm = new Mm();
        Nm nm = new Nm();
        hashMap.put(C0381km.class, km);
        hashMap.put(U1.class, lm);
        hashMap.put(C0219ef.class, mm);
        hashMap.put(C0587t3.class, nm);
    }

    public static Rm a(Class cls) {
        return (Rm) Pm.f739a.f753a.get(cls);
    }
}
