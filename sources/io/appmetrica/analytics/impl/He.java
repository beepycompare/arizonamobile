package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class He implements InterfaceC0404l9, Ie {

    /* renamed from: a  reason: collision with root package name */
    public final C0278g7 f471a;
    public final AtomicLong b;

    public He(C0278g7 c0278g7) {
        this.f471a = c0278g7;
        this.b = new AtomicLong(c0278g7.b());
        c0278g7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404l9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404l9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404l9
    public final void a() {
        this.b.set(this.f471a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
