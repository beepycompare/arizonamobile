package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0409lg implements InterfaceC0310hg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0509pg f924a;

    public C0409lg(C0509pg c0509pg) {
        this.f924a = c0509pg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0310hg
    public final void a() {
        C0509pg c0509pg = this.f924a;
        ArrayList arrayList = c0509pg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0733yg c0733yg = (C0733yg) next;
            c0509pg.c.getClass();
            String str = c0733yg != null ? c0733yg.f1147a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0509pg.a(c0509pg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
