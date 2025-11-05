package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes3.dex */
public final class Zc {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f784a = new ArrayList();

    public final synchronized List a() {
        ArrayList arrayList;
        ArrayList arrayList2 = this.f784a;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Yc) it.next()).a());
        }
        arrayList = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (((String) next).length() > 0) {
                arrayList.add(next);
            }
        }
        return CollectionsKt.distinct(arrayList);
    }

    public final synchronized void a(Yc... ycArr) {
        CollectionsKt.addAll(this.f784a, ycArr);
    }
}
