package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class J6 implements InterfaceC0250fb {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f512a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0250fb
    public final void a(Throwable th, U u) {
        Iterator it = this.f512a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0250fb) it.next()).a(th, u);
        }
    }

    public final void a(InterfaceC0250fb... interfaceC0250fbArr) {
        CollectionsKt.addAll(this.f512a, interfaceC0250fbArr);
    }

    public final void a(List<? extends InterfaceC0250fb> list) {
        this.f512a.addAll(list);
    }

    public final void a() {
        this.f512a.clear();
    }
}
