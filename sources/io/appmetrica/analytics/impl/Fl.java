package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Fl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Hl f585a;

    public Fl(Hl hl) {
        this.f585a = hl;
    }

    public final void a(String str, Jl jl, C0257fm c0257fm) {
        ArrayList arrayList;
        synchronized (this.f585a.b) {
            Collection collection = (Collection) this.f585a.f619a.f1173a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(jl, c0257fm);
        }
    }
}
