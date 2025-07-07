package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public abstract class Nn {
    public static final Kn a(Throwable th, U u, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        An a2 = th != null ? Bn.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Al((StackTraceElement) it.next()));
            }
        }
        return new Kn(a2, u, arrayList, null, null, null, str, bool);
    }
}
