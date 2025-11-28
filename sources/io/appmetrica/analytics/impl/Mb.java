package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Mb {

    /* renamed from: a  reason: collision with root package name */
    public final W2 f589a;
    public final C0488p2 b;
    public final ArrayList c;

    public Mb(W2 w2, C0488p2 c0488p2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f589a = w2;
        arrayList.add(w2);
        this.b = c0488p2;
        arrayList.add(c0488p2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0506pk) it.next()).onCreate();
        }
    }

    public final synchronized void a(C0595ta c0595ta) {
        this.c.add(c0595ta);
    }
}
