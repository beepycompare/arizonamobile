package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class Ue implements InterfaceC0419m9, Ve {

    /* renamed from: a  reason: collision with root package name */
    public final C0159c7 f797a;
    public final AtomicLong b;

    public Ue(C0159c7 c0159c7) {
        this.f797a = c0159c7;
        this.b = new AtomicLong(c0159c7.a());
        c0159c7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0419m9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0419m9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0419m9
    public final void a() {
        this.b.set(this.f797a.a());
    }

    public final long b() {
        return this.b.get();
    }
}
