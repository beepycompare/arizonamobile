package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.k6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0370k6 implements Fa {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1077a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Fa
    public final void a(Throwable th, V v) {
        Iterator it = this.f1077a.iterator();
        while (it.hasNext()) {
            ((Fa) it.next()).a(th, v);
        }
    }

    public final void a(Fa... faArr) {
        CollectionsKt.addAll(this.f1077a, faArr);
    }

    public final void a(List<? extends Fa> list) {
        this.f1077a.addAll(list);
    }

    public final void a() {
        this.f1077a.clear();
    }
}
