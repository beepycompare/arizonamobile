package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Ka {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f519a;
    public final boolean b;

    public Ka() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f519a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f519a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f519a.toString();
    }

    public Ka(boolean z) {
        this.f519a = new HashMap();
        this.b = z;
    }
}
