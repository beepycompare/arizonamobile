package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.fc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0251fc {

    /* renamed from: a  reason: collision with root package name */
    public final C0216e3 f877a;
    public final C0474o2 b;
    public final ArrayList c;

    public C0251fc(C0216e3 c0216e3, C0474o2 c0474o2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f877a = c0216e3;
        arrayList.add(c0216e3);
        this.b = c0474o2;
        arrayList.add(c0474o2);
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
