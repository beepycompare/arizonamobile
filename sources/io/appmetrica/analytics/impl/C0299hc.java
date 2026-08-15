package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.hc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0299hc {

    /* renamed from: a  reason: collision with root package name */
    public final C0135b3 f1014a;
    public final C0599t2 b;
    public final ArrayList c;

    public C0299hc(C0135b3 c0135b3, C0599t2 c0599t2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f1014a = c0135b3;
        arrayList.add(c0135b3);
        this.b = c0599t2;
        arrayList.add(c0599t2);
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
