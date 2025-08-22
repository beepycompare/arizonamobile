package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Kl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ml f533a;

    public Kl(Ml ml) {
        this.f533a = ml;
    }

    public final void a(String str, Ol ol, C0389km c0389km) {
        ArrayList arrayList;
        synchronized (this.f533a.b) {
            Collection collection = (Collection) this.f533a.f565a.f558a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Vl) it.next()).a(ol, c0389km);
        }
    }
}
