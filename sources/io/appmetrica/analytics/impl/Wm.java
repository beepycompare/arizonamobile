package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Wm implements InterfaceC0232eo {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f844a;

    public Wm(String str, List<String> list, int i, Ln ln, so soVar, J2 j2) {
        List take = CollectionsKt.take(CollectionsKt.toList(CollectionsKt.toSet(list)), i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        int i2 = 0;
        for (Object obj : take) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new Ym(str + '_' + i2, (String) obj, ln, soVar, j2));
            i2 = i3;
        }
        this.f844a = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0232eo
    public final void a(Cdo cdo) {
        Iterator it = this.f844a.iterator();
        while (it.hasNext()) {
            ((Ym) it.next()).a(cdo);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0232eo
    public final void a(PublicLogger publicLogger) {
        Iterator it = this.f844a.iterator();
        while (it.hasNext()) {
            ((Ym) it.next()).e = publicLogger;
        }
    }
}
