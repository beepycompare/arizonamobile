package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class Y4 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f765a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0415m4 interfaceC0415m4) {
        this.f765a.add(interfaceC0415m4);
    }

    public final void b(InterfaceC0415m4 interfaceC0415m4) {
        this.f765a.remove(interfaceC0415m4);
    }

    public final List<InterfaceC0415m4> a() {
        return this.f765a;
    }
}
