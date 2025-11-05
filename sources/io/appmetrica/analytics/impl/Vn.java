package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes3.dex */
public abstract class Vn {
    public static final Sn a(Throwable th, V v, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        In a2 = th != null ? Jn.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Hl((StackTraceElement) it.next()));
            }
        }
        return new Sn(a2, v, arrayList, null, null, null, str, bool);
    }
}
