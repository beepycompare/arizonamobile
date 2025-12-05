package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Xm implements InterfaceC0254fo {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f838a;

    public Xm(String str, List<String> list, int i, Mn mn, to toVar, K2 k2) {
        List take = CollectionsKt.take(CollectionsKt.toList(CollectionsKt.toSet(list)), i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        int i2 = 0;
        for (Object obj : take) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new Zm(str + '_' + i2, (String) obj, mn, toVar, k2));
            i2 = i3;
        }
        this.f838a = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0254fo
    public final void a(C0228eo c0228eo) {
        Iterator it = this.f838a.iterator();
        while (it.hasNext()) {
            ((Zm) it.next()).a(c0228eo);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0254fo
    public final void a(PublicLogger publicLogger) {
        Iterator it = this.f838a.iterator();
        while (it.hasNext()) {
            ((Zm) it.next()).e = publicLogger;
        }
    }
}
