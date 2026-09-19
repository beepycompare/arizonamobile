package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.h5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0291h5 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1009a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0678w4 interfaceC0678w4) {
        this.f1009a.add(interfaceC0678w4);
    }

    public final void b(InterfaceC0678w4 interfaceC0678w4) {
        this.f1009a.remove(interfaceC0678w4);
    }

    public final List<InterfaceC0678w4> a() {
        return this.f1009a;
    }
}
