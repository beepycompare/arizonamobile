package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.pa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0498pa {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1177a;
    public final boolean b;

    public C0498pa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f1177a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f1177a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f1177a.toString();
    }

    public C0498pa(boolean z) {
        this.f1177a = new HashMap();
        this.b = z;
    }
}
