package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Vm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f700a;

    public Vm() {
        HashMap hashMap = new HashMap();
        this.f700a = hashMap;
        Pm pm = new Pm();
        Qm qm = new Qm();
        Rm rm = new Rm();
        Sm sm = new Sm();
        Tm tm = new Tm();
        hashMap.put(C0490om.class, pm);
        hashMap.put(Z1.class, qm);
        hashMap.put(C0607tf.class, rm);
        hashMap.put(C0669w2.class, sm);
        hashMap.put(O3.class, tm);
    }

    public static Wm a(Class cls) {
        return (Wm) Um.f683a.f700a.get(cls);
    }
}
