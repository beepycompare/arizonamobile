package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Ol {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ql f614a;

    public Ol(Ql ql) {
        this.f614a = ql;
    }

    public final void a(String str, Sl sl, C0494om c0494om) {
        ArrayList arrayList;
        synchronized (this.f614a.b) {
            Collection collection = (Collection) this.f614a.f645a.f624a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Zl) it.next()).a(sl, c0494om);
        }
    }
}
