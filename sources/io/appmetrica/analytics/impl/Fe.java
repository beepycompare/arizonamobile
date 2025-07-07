package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class Fe implements InterfaceC0336i9, Ge {

    /* renamed from: a  reason: collision with root package name */
    public final C0209d7 f429a;
    public final AtomicLong b;

    public Fe(C0209d7 c0209d7) {
        this.f429a = c0209d7;
        this.b = new AtomicLong(c0209d7.b());
        c0209d7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0336i9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0336i9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0336i9
    public final void a() {
        this.b.set(this.f429a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
