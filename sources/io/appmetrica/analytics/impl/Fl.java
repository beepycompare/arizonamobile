package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Fl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Hl f589a;

    public Fl(Hl hl) {
        this.f589a = hl;
    }

    public final void a(String str, Jl jl, C0256fm c0256fm) {
        ArrayList arrayList;
        synchronized (this.f589a.b) {
            Collection collection = (Collection) this.f589a.f623a.f1177a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ql) it.next()).a(jl, c0256fm);
        }
    }
}
