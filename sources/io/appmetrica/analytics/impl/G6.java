package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class G6 implements InterfaceC0172cb {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f450a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(Throwable th, U u) {
        Iterator it = this.f450a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0172cb) it.next()).a(th, u);
        }
    }

    public final void a(InterfaceC0172cb... interfaceC0172cbArr) {
        CollectionsKt.addAll(this.f450a, interfaceC0172cbArr);
    }

    public final void a(List<? extends InterfaceC0172cb> list) {
        this.f450a.addAll(list);
    }

    public final void a() {
        this.f450a.clear();
    }
}
