package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class A6 implements InterfaceC0292hb {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f457a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0292hb
    public final void a(Throwable th, X x) {
        Iterator it = this.f457a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0292hb) it.next()).a(th, x);
        }
    }

    public final void a(InterfaceC0292hb... interfaceC0292hbArr) {
        CollectionsKt.addAll(this.f457a, interfaceC0292hbArr);
    }

    public final void a(List<? extends InterfaceC0292hb> list) {
        this.f457a.addAll(list);
    }

    public final void a() {
        this.f457a.clear();
    }
}
