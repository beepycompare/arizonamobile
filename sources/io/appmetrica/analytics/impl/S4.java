package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class S4 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f672a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0261g4 interfaceC0261g4) {
        this.f672a.add(interfaceC0261g4);
    }

    public final void b(InterfaceC0261g4 interfaceC0261g4) {
        this.f672a.remove(interfaceC0261g4);
    }

    public final List<InterfaceC0261g4> a() {
        return this.f672a;
    }
}
