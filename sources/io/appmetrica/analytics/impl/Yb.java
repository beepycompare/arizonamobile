package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Yb {

    /* renamed from: a  reason: collision with root package name */
    public final C0145b3 f720a;
    public final C0420m2 b;
    public final ArrayList c;

    public Yb(C0145b3 c0145b3, C0420m2 c0420m2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f720a = c0145b3;
        arrayList.add(c0145b3);
        this.b = c0420m2;
        arrayList.add(c0420m2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0513pk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Fa fa) {
        this.c.add(fa);
    }
}
