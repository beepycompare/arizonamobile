package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public abstract class Un {
    public static final Rn a(Throwable th, V v, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        Hn a2 = th != null ? In.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new El((StackTraceElement) it.next()));
            }
        }
        return new Rn(a2, v, arrayList, null, null, null, str, bool);
    }
}
