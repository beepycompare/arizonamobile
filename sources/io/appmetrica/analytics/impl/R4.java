package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class R4 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f765a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0238f4 interfaceC0238f4) {
        this.f765a.add(interfaceC0238f4);
    }

    public final void b(InterfaceC0238f4 interfaceC0238f4) {
        this.f765a.remove(interfaceC0238f4);
    }

    public final List<InterfaceC0238f4> a() {
        return this.f765a;
    }
}
