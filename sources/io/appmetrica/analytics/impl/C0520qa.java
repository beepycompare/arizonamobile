package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0520qa {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1168a;
    public final boolean b;

    public C0520qa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f1168a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f1168a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f1168a.toString();
    }

    public C0520qa(boolean z) {
        this.f1168a = new HashMap();
        this.b = z;
    }
}
