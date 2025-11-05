package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes3.dex */
public final class Tm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f711a;

    public Tm() {
        HashMap hashMap = new HashMap();
        this.f711a = hashMap;
        Nm nm = new Nm();
        Om om = new Om();
        Pm pm = new Pm();
        Qm qm = new Qm();
        hashMap.put(C0458nm.class, nm);
        hashMap.put(C0156c2.class, om);
        hashMap.put(Cif.class, pm);
        hashMap.put(A3.class, qm);
    }

    public static Um a(Class cls) {
        return (Um) Sm.f690a.f711a.get(cls);
    }
}
