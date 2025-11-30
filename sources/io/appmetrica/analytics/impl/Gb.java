package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Gb {

    /* renamed from: a  reason: collision with root package name */
    public final P2 f491a;
    public final C0285h2 b;
    public final ArrayList c;

    public Gb(P2 p2, C0285h2 c0285h2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f491a = p2;
        arrayList.add(p2);
        this.b = c0285h2;
        arrayList.add(c0285h2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0431mk) it.next()).onCreate();
        }
    }

    public final synchronized void a(C0446na c0446na) {
        this.c.add(c0446na);
    }
}
