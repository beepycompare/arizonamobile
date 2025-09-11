package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Zm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f779a;

    public Zm() {
        HashMap hashMap = new HashMap();
        this.f779a = hashMap;
        Tm tm = new Tm();
        Um um = new Um();
        Vm vm = new Vm();
        Wm wm = new Wm();
        Xm xm = new Xm();
        hashMap.put(C0593sm.class, tm);
        hashMap.put(C0137b2.class, um);
        hashMap.put(C0711xf.class, vm);
        hashMap.put(C0748z2.class, wm);
        hashMap.put(R3.class, xm);
    }

    public static AbstractC0132an a(Class cls) {
        return (AbstractC0132an) Ym.f762a.f779a.get(cls);
    }
}
