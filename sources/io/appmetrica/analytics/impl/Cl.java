package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Cl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ El f378a;

    public Cl(El el) {
        this.f378a = el;
    }

    public final void a(String str, Gl gl, C0190cm c0190cm) {
        ArrayList arrayList;
        synchronized (this.f378a.b) {
            Collection collection = (Collection) this.f378a.f415a.f474a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Nl) it.next()).a(gl, c0190cm);
        }
    }
}
