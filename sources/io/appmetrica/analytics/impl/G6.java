package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class G6 implements InterfaceC0127ab {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f448a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0127ab
    public final void a(Throwable th, U u) {
        Iterator it = this.f448a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0127ab) it.next()).a(th, u);
        }
    }

    public final void a(InterfaceC0127ab... interfaceC0127abArr) {
        CollectionsKt.addAll(this.f448a, interfaceC0127abArr);
    }

    public final void a(List<? extends InterfaceC0127ab> list) {
        this.f448a.addAll(list);
    }

    public final void a() {
        this.f448a.clear();
    }
}
