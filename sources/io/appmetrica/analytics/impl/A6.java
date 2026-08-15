package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class A6 implements InterfaceC0298hb {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f454a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0298hb
    public final void a(Throwable th, X x) {
        Iterator it = this.f454a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0298hb) it.next()).a(th, x);
        }
    }

    public final void a(InterfaceC0298hb... interfaceC0298hbArr) {
        CollectionsKt.addAll(this.f454a, interfaceC0298hbArr);
    }

    public final void a(List<? extends InterfaceC0298hb> list) {
        this.f454a.addAll(list);
    }

    public final void a() {
        this.f454a.clear();
    }
}
