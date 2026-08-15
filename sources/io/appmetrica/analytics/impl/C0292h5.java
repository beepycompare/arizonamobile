package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.h5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0292h5 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1009a = new CopyOnWriteArrayList();

    public final void a(InterfaceC0679w4 interfaceC0679w4) {
        this.f1009a.add(interfaceC0679w4);
    }

    public final void b(InterfaceC0679w4 interfaceC0679w4) {
        this.f1009a.remove(interfaceC0679w4);
    }

    public final List<InterfaceC0679w4> a() {
        return this.f1009a;
    }
}
