package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0129ac {

    /* renamed from: a  reason: collision with root package name */
    public final C0146b3 f766a;
    public final C0423m2 b;
    public final ArrayList c;

    public C0129ac(C0146b3 c0146b3, C0423m2 c0423m2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f766a = c0146b3;
        arrayList.add(c0146b3);
        this.b = c0423m2;
        arrayList.add(c0423m2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC0590sk) it.next()).onCreate();
        }
    }

    public final synchronized void a(Ha ha) {
        this.c.add(ha);
    }
}
