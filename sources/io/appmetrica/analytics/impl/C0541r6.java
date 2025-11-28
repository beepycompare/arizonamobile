package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.r6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0541r6 implements Ma {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1088a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Ma
    public final void a(Throwable th, V v) {
        Iterator it = this.f1088a.iterator();
        while (it.hasNext()) {
            ((Ma) it.next()).a(th, v);
        }
    }

    public final void a(Ma... maArr) {
        CollectionsKt.addAll(this.f1088a, maArr);
    }

    public final void a(List<? extends Ma> list) {
        this.f1088a.addAll(list);
    }

    public final void a() {
        this.f1088a.clear();
    }
}
