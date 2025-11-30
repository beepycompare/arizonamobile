package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0521qa {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1085a;
    public final boolean b;

    public C0521qa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f1085a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f1085a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f1085a.toString();
    }

    public C0521qa(boolean z) {
        this.f1085a = new HashMap();
        this.b = z;
    }
}
