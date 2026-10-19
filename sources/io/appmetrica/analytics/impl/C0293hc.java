package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.hc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0293hc {

    /* renamed from: a  reason: collision with root package name */
    public final C0129b3 f1017a;
    public final C0593t2 b;
    public final ArrayList c;

    public C0293hc(C0129b3 c0129b3, C0593t2 c0593t2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f1017a = c0129b3;
        arrayList.add(c0129b3);
        this.b = c0593t2;
        arrayList.add(c0593t2);
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
