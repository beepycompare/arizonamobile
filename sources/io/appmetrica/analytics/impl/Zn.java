package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public abstract class Zn {
    public static final Wn a(Throwable th, U u, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        Mn a2 = th != null ? Nn.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Ml((StackTraceElement) it.next()));
            }
        }
        return new Wn(a2, u, arrayList, null, null, null, str, bool);
    }
}
