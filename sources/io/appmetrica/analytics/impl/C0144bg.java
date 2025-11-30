package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.bg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0144bg implements Xf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0247fg f818a;

    public C0144bg(C0247fg c0247fg) {
        this.f818a = c0247fg;
    }

    @Override // io.appmetrica.analytics.impl.Xf
    public final void a() {
        C0247fg c0247fg = this.f818a;
        ArrayList arrayList = c0247fg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0477og c0477og = (C0477og) next;
            c0247fg.c.getClass();
            String str = c0477og != null ? c0477og.f1050a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0247fg.a(c0247fg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
