package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.bg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0143bg implements Xf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0246fg f901a;

    public C0143bg(C0246fg c0246fg) {
        this.f901a = c0246fg;
    }

    @Override // io.appmetrica.analytics.impl.Xf
    public final void a() {
        C0246fg c0246fg = this.f901a;
        ArrayList arrayList = c0246fg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0476og c0476og = (C0476og) next;
            c0246fg.c.getClass();
            String str = c0476og != null ? c0476og.f1133a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0246fg.a(c0246fg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
