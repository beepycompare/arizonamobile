package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.l6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0391l6 implements Ga {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1085a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Ga
    public final void a(Throwable th, V v) {
        Iterator it = this.f1085a.iterator();
        while (it.hasNext()) {
            ((Ga) it.next()).a(th, v);
        }
    }

    public final void a(Ga... gaArr) {
        CollectionsKt.addAll(this.f1085a, gaArr);
    }

    public final void a(List<? extends Ga> list) {
        this.f1085a.addAll(list);
    }

    public final void a() {
        this.f1085a.clear();
    }
}
