package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class Pa {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f624a;
    public final boolean b;

    public Pa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f624a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f624a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f624a.toString();
    }

    public Pa(boolean z) {
        this.f624a = new HashMap();
        this.b = z;
    }
}
