package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.wo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0693wo {
    public static final C0615to a(Throwable th, X x, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        C0356jo a2 = th != null ? AbstractC0382ko.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C0251fm((StackTraceElement) it.next()));
            }
        }
        return new C0615to(a2, x, arrayList, null, null, null, str, bool);
    }
}
