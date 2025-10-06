package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class Ne implements InterfaceC0532q9, Oe {

    /* renamed from: a  reason: collision with root package name */
    public final C0375k7 f596a;
    public final AtomicLong b;

    public Ne(C0375k7 c0375k7) {
        this.f596a = c0375k7;
        this.b = new AtomicLong(c0375k7.b());
        c0375k7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532q9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532q9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532q9
    public final void a() {
        this.b.set(this.f596a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
