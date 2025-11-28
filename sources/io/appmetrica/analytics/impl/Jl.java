package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Jl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ll f550a;

    public Jl(Ll ll) {
        this.f550a = ll;
    }

    public final void a(String str, Nl nl, C0356jm c0356jm) {
        ArrayList arrayList;
        synchronized (this.f550a.b) {
            Collection collection = (Collection) this.f550a.f580a.f1183a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ul) it.next()).a(nl, c0356jm);
        }
    }
}
