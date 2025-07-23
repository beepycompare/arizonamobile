package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public abstract class Qn {
    public static final Nn a(Throwable th, U u, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        Dn a2 = th != null ? En.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Dl((StackTraceElement) it.next()));
            }
        }
        return new Nn(a2, u, arrayList, null, null, null, str, bool);
    }
}
