package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class Ne implements InterfaceC0531q9, Oe {

    /* renamed from: a  reason: collision with root package name */
    public final C0374k7 f595a;
    public final AtomicLong b;

    public Ne(C0374k7 c0374k7) {
        this.f595a = c0374k7;
        this.b = new AtomicLong(c0374k7.b());
        c0374k7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531q9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531q9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531q9
    public final void a() {
        this.b.set(this.f595a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
