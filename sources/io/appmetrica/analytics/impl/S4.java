package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class S4 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f755a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0260g4 interfaceC0260g4) {
        this.f755a.add(interfaceC0260g4);
    }

    public final void b(InterfaceC0260g4 interfaceC0260g4) {
        this.f755a.remove(interfaceC0260g4);
    }

    public final List<InterfaceC0260g4> a() {
        return this.f755a;
    }
}
