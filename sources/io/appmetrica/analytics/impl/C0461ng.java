package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ng  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0461ng implements InterfaceC0361jg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560rg f970a;

    public C0461ng(C0560rg c0560rg) {
        this.f970a = c0560rg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0361jg
    public final void a() {
        C0560rg c0560rg = this.f970a;
        ArrayList arrayList = c0560rg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Ag ag = (Ag) next;
            c0560rg.c.getClass();
            String str = ag != null ? ag.f339a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0560rg.a(c0560rg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
