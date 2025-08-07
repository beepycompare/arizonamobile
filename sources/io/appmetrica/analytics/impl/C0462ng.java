package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ng  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0462ng implements InterfaceC0362jg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561rg f970a;

    public C0462ng(C0561rg c0561rg) {
        this.f970a = c0561rg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jg
    public final void a() {
        C0561rg c0561rg = this.f970a;
        ArrayList arrayList = c0561rg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Ag ag = (Ag) next;
            c0561rg.c.getClass();
            String str = ag != null ? ag.f339a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0561rg.a(c0561rg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
