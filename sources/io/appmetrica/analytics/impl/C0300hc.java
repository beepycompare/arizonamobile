package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.hc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0300hc {

    /* renamed from: a  reason: collision with root package name */
    public final C0136b3 f1014a;
    public final C0600t2 b;
    public final ArrayList c;

    public C0300hc(C0136b3 c0136b3, C0600t2 c0600t2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f1014a = c0136b3;
        arrayList.add(c0136b3);
        this.b = c0600t2;
        arrayList.add(c0600t2);
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
