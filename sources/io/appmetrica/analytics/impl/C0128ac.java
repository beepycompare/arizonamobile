package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0128ac {

    /* renamed from: a  reason: collision with root package name */
    public final C0145b3 f767a;
    public final C0422m2 b;
    public final ArrayList c;

    public C0128ac(C0145b3 c0145b3, C0422m2 c0422m2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f767a = c0145b3;
        arrayList.add(c0145b3);
        this.b = c0422m2;
        arrayList.add(c0422m2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0589sk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Ha ha) {
        this.c.add(ha);
    }
}
