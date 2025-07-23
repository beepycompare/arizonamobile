package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Fl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Hl f440a;

    public Fl(Hl hl) {
        this.f440a = hl;
    }

    public final void a(String str, Jl jl, C0267fm c0267fm) {
        ArrayList arrayList;
        synchronized (this.f440a.b) {
            Collection collection = (Collection) this.f440a.f476a.f519a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(jl, c0267fm);
        }
    }
}
