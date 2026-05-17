package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0121ag implements Wf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0224eg f910a;

    public C0121ag(C0224eg c0224eg) {
        this.f910a = c0224eg;
    }

    @Override // io.appmetrica.analytics.impl.Wf
    public final void a() {
        C0224eg c0224eg = this.f910a;
        ArrayList arrayList = c0224eg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0454ng c0454ng = (C0454ng) next;
            c0224eg.c.getClass();
            String str = c0454ng != null ? c0454ng.f1142a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0224eg.a(c0224eg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
