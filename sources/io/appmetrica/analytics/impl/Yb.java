package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Yb {

    /* renamed from: a  reason: collision with root package name */
    public final C0153b3 f719a;
    public final C0428m2 b;
    public final ArrayList c;

    public Yb(C0153b3 c0153b3, C0428m2 c0428m2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f719a = c0153b3;
        arrayList.add(c0153b3);
        this.b = c0428m2;
        arrayList.add(c0428m2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0521pk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Fa fa) {
        this.c.add(fa);
    }
}
