package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.hc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0298hc {

    /* renamed from: a  reason: collision with root package name */
    public final C0134b3 f1014a;
    public final C0598t2 b;
    public final ArrayList c;

    public C0298hc(C0134b3 c0134b3, C0598t2 c0598t2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f1014a = c0134b3;
        arrayList.add(c0134b3);
        this.b = c0598t2;
        arrayList.add(c0598t2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((Nk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Ma ma) {
        this.c.add(ma);
    }
}
