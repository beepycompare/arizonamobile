package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class D6 implements Ya {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f384a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Ya
    public final void a(Throwable th, U u) {
        Iterator it = this.f384a.iterator();
        while (it.hasNext()) {
            ((Ya) it.next()).a(th, u);
        }
    }

    public final void a(Ya... yaArr) {
        CollectionsKt.addAll(this.f384a, yaArr);
    }

    public final void a(List<? extends Ya> list) {
        this.f384a.addAll(list);
    }

    public final void a() {
        this.f384a.clear();
    }
}
