package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0624ue implements T8, InterfaceC0649ve {

    /* renamed from: a  reason: collision with root package name */
    public final M6 f1150a;
    public final AtomicLong b;

    public C0624ue(M6 m6) {
        this.f1150a = m6;
        this.b = new AtomicLong(m6.b());
        m6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.T8
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.T8
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.T8
    public final void a() {
        this.b.set(this.f1150a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
