package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Cl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ El f377a;

    public Cl(El el) {
        this.f377a = el;
    }

    public final void a(String str, Gl gl, C0198cm c0198cm) {
        ArrayList arrayList;
        synchronized (this.f377a.b) {
            Collection collection = (Collection) this.f377a.f414a.f473a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Nl) it.next()).a(gl, c0198cm);
        }
    }
}
