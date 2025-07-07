package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0417lg implements InterfaceC0318hg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0517pg f923a;

    public C0417lg(C0517pg c0517pg) {
        this.f923a = c0517pg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0318hg
    public final void a() {
        C0517pg c0517pg = this.f923a;
        ArrayList arrayList = c0517pg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0741yg c0741yg = (C0741yg) next;
            c0517pg.c.getClass();
            String str = c0741yg != null ? c0741yg.f1146a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0517pg.a(c0517pg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
