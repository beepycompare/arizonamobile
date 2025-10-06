package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Zm {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f780a;

    public Zm() {
        HashMap hashMap = new HashMap();
        this.f780a = hashMap;
        Tm tm = new Tm();
        Um um = new Um();
        Vm vm = new Vm();
        Wm wm = new Wm();
        Xm xm = new Xm();
        hashMap.put(C0594sm.class, tm);
        hashMap.put(C0138b2.class, um);
        hashMap.put(C0712xf.class, vm);
        hashMap.put(C0749z2.class, wm);
        hashMap.put(R3.class, xm);
    }

    public static AbstractC0133an a(Class cls) {
        return (AbstractC0133an) Ym.f763a.f780a.get(cls);
    }
}
