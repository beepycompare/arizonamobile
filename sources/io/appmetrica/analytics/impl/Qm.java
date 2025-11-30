package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Qm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f655a;

    public Qm() {
        HashMap hashMap = new HashMap();
        this.f655a = hashMap;
        Km km = new Km();
        Lm lm = new Lm();
        Mm mm = new Mm();
        Nm nm = new Nm();
        hashMap.put(C0382km.class, km);
        hashMap.put(U1.class, lm);
        hashMap.put(C0220ef.class, mm);
        hashMap.put(C0588t3.class, nm);
    }

    public static Rm a(Class cls) {
        return (Rm) Pm.f641a.f655a.get(cls);
    }
}
