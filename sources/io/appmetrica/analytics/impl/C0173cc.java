package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.cc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0173cc {

    /* renamed from: a  reason: collision with root package name */
    public final C0138b3 f809a;
    public final C0420m2 b;
    public final ArrayList c;

    public C0173cc(C0138b3 c0138b3, C0420m2 c0420m2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f809a = c0138b3;
        arrayList.add(c0138b3);
        this.b = c0420m2;
        arrayList.add(c0420m2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0712xk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Ja ja) {
        this.c.add(ja);
    }
}
