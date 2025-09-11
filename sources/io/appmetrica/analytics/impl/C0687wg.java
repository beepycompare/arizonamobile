package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0687wg implements InterfaceC0587sg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ag f1140a;

    public C0687wg(Ag ag) {
        this.f1140a = ag;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587sg
    public final void a() {
        Ag ag = this.f1140a;
        ArrayList arrayList = ag.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Jg jg = (Jg) next;
            ag.c.getClass();
            String str = jg != null ? jg.f519a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        ag.a(ag.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
