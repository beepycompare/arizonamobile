package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0122ag implements Wf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0225eg f905a;

    public C0122ag(C0225eg c0225eg) {
        this.f905a = c0225eg;
    }

    @Override // io.appmetrica.analytics.impl.Wf
    public final void a() {
        C0225eg c0225eg = this.f905a;
        ArrayList arrayList = c0225eg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0455ng c0455ng = (C0455ng) next;
            c0225eg.c.getClass();
            String str = c0455ng != null ? c0455ng.f1137a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0225eg.a(c0225eg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
