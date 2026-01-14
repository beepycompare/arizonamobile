package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public abstract class Tn {
    public static final Qn a(Throwable th, V v, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        Gn a2 = th != null ? Hn.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Dl((StackTraceElement) it.next()));
            }
        }
        return new Qn(a2, v, arrayList, null, null, null, str, bool);
    }
}
