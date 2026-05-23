package io.appmetrica.analytics.impl;

import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Uo implements Vo {
    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(List<To> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (To to : list) {
            if (!to.f781a) {
                linkedList.add(to.b);
                z = false;
            }
        }
        if (z) {
            return new To(this, true, "");
        }
        return new To(this, false, CollectionsKt.joinToString(linkedList, ", ", "", "", -1, "", null));
    }
}
