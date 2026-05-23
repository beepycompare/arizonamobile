package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.h5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0293h5 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1006a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0680w4 interfaceC0680w4) {
        this.f1006a.add(interfaceC0680w4);
    }

    public final void b(InterfaceC0680w4 interfaceC0680w4) {
        this.f1006a.remove(interfaceC0680w4);
    }

    public final List<InterfaceC0680w4> a() {
        return this.f1006a;
    }
}
