package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class J6 implements InterfaceC0249fb {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f511a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(Throwable th, U u) {
        Iterator it = this.f511a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0249fb) it.next()).a(th, u);
        }
    }

    public final void a(InterfaceC0249fb... interfaceC0249fbArr) {
        CollectionsKt.addAll(this.f511a, interfaceC0249fbArr);
    }

    public final void a(List<? extends InterfaceC0249fb> list) {
        this.f511a.addAll(list);
    }

    public final void a() {
        this.f511a.clear();
    }
}
