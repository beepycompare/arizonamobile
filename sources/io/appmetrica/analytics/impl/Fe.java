package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class Fe implements InterfaceC0328i9, Ge {

    /* renamed from: a  reason: collision with root package name */
    public final C0201d7 f430a;
    public final AtomicLong b;

    public Fe(C0201d7 c0201d7) {
        this.f430a = c0201d7;
        this.b = new AtomicLong(c0201d7.b());
        c0201d7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0328i9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0328i9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0328i9
    public final void a() {
        this.b.set(this.f430a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
