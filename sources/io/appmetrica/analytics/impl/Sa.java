package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class Sa {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f765a;
    public final boolean b;

    public Sa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f765a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f765a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f765a.toString();
    }

    public Sa(boolean z) {
        this.f765a = new HashMap();
        this.b = z;
    }
}
