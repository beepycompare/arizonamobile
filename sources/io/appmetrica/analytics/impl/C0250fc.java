package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.fc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0250fc {

    /* renamed from: a  reason: collision with root package name */
    public final C0215e3 f872a;
    public final C0473o2 b;
    public final ArrayList c;

    public C0250fc(C0215e3 c0215e3, C0473o2 c0473o2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f872a = c0215e3;
        arrayList.add(c0215e3);
        this.b = c0473o2;
        arrayList.add(c0473o2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((Bk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Ma ma) {
        this.c.add(ma);
    }
}
