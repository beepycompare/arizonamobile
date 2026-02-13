package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Fb {

    /* renamed from: a  reason: collision with root package name */
    public final O2 f579a;
    public final C0263g2 b;
    public final ArrayList c;

    public Fb(O2 o2, C0263g2 c0263g2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f579a = o2;
        arrayList.add(o2);
        this.b = c0263g2;
        arrayList.add(c0263g2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0409lk) it.next()).onCreate();
        }
    }

    public final synchronized void a(C0424ma c0424ma) {
        this.c.add(c0424ma);
    }
}
