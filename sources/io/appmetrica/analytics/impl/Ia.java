package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ia {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f474a;
    public final boolean b;

    public Ia() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f474a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f474a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f474a.toString();
    }

    public Ia(boolean z) {
        this.f474a = new HashMap();
        this.b = z;
    }
}
