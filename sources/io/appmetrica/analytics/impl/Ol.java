package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Ol {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ql f609a;

    public Ol(Ql ql) {
        this.f609a = ql;
    }

    public final void a(String str, Sl sl, C0493om c0493om) {
        ArrayList arrayList;
        synchronized (this.f609a.b) {
            Collection collection = (Collection) this.f609a.f640a.f619a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Zl) it.next()).a(sl, c0493om);
        }
    }
}
