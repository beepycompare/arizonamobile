package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.sg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0583sg implements InterfaceC0484og {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0683wg f1062a;

    public C0583sg(C0683wg c0683wg) {
        this.f1062a = c0683wg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0484og
    public final void a() {
        C0683wg c0683wg = this.f1062a;
        ArrayList arrayList = c0683wg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Fg fg = (Fg) next;
            c0683wg.c.getClass();
            String str = fg != null ? fg.f436a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0683wg.a(c0683wg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
