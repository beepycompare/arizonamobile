package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Qm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f615a;

    public Qm() {
        HashMap hashMap = new HashMap();
        this.f615a = hashMap;
        Km km = new Km();
        Lm lm = new Lm();
        Mm mm = new Mm();
        Nm nm = new Nm();
        Om om = new Om();
        hashMap.put(C0368jm.class, km);
        hashMap.put(Z1.class, lm);
        hashMap.put(C0560rf.class, mm);
        hashMap.put(C0672w2.class, nm);
        hashMap.put(O3.class, om);
    }

    public static Rm a(Class cls) {
        return (Rm) Pm.f601a.f615a.get(cls);
    }
}
