package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class Ue implements InterfaceC0426m9, Ve {

    /* renamed from: a  reason: collision with root package name */
    public final C0166c7 f791a;
    public final AtomicLong b;

    public Ue(C0166c7 c0166c7) {
        this.f791a = c0166c7;
        this.b = new AtomicLong(c0166c7.a());
        c0166c7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0426m9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0426m9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0426m9
    public final void a() {
        this.b.set(this.f791a.a());
    }

    public final long b() {
        return this.b.get();
    }
}
