package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.yn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0751yn implements Ho {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1302a;

    public C0751yn(String str, List<String> list, int i, InterfaceC0493oo interfaceC0493oo, Vo vo, W2 w2) {
        List take = CollectionsKt.take(CollectionsKt.toList(CollectionsKt.toSet(list)), i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        int i2 = 0;
        for (Object obj : take) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new An(str + '_' + i2, (String) obj, interfaceC0493oo, vo, w2));
            i2 = i3;
        }
        this.f1302a = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(Go go) {
        Iterator it = this.f1302a.iterator();
        while (it.hasNext()) {
            ((An) it.next()).a(go);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(PublicLogger publicLogger) {
        Iterator it = this.f1302a.iterator();
        while (it.hasNext()) {
            ((An) it.next()).e = publicLogger;
        }
    }
}
