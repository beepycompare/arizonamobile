package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.wa  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0670wa {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1183a;
    public final boolean b;

    public C0670wa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        ArrayList arrayList;
        Collection collection = (Collection) this.f1183a.get(obj);
        if (collection == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(collection);
        }
        arrayList.add(obj2);
        Collection collection2 = (Collection) this.f1183a.put(obj, arrayList);
    }

    public final String toString() {
        return this.f1183a.toString();
    }

    public C0670wa(boolean z) {
        this.f1183a = new HashMap();
        this.b = z;
    }
}
