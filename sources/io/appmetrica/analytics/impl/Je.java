package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class Je implements InterfaceC0452n9, Ke {

    /* renamed from: a  reason: collision with root package name */
    public final C0297h7 f515a;
    public final AtomicLong b;

    public Je(C0297h7 c0297h7) {
        this.f515a = c0297h7;
        this.b = new AtomicLong(c0297h7.b());
        c0297h7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0452n9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0452n9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0452n9
    public final void a() {
        this.b.set(this.f515a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
