package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class R4 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f761a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0239f4 interfaceC0239f4) {
        this.f761a.add(interfaceC0239f4);
    }

    public final void b(InterfaceC0239f4 interfaceC0239f4) {
        this.f761a.remove(interfaceC0239f4);
    }

    public final List<InterfaceC0239f4> a() {
        return this.f761a;
    }
}
