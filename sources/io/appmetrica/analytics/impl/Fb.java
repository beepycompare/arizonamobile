package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Fb {

    /* renamed from: a  reason: collision with root package name */
    public final O2 f584a;
    public final C0262g2 b;
    public final ArrayList c;

    public Fb(O2 o2, C0262g2 c0262g2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f584a = o2;
        arrayList.add(o2);
        this.b = c0262g2;
        arrayList.add(c0262g2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0408lk) it.next()).onCreate();
        }
    }

    public final synchronized void a(C0423ma c0423ma) {
        this.c.add(c0423ma);
    }
}
