package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class Ue implements InterfaceC0425m9, Ve {

    /* renamed from: a  reason: collision with root package name */
    public final C0165c7 f794a;
    public final AtomicLong b;

    public Ue(C0165c7 c0165c7) {
        this.f794a = c0165c7;
        this.b = new AtomicLong(c0165c7.a());
        c0165c7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m9
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m9
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m9
    public final void a() {
        this.b.set(this.f794a.a());
    }

    public final long b() {
        return this.b.get();
    }
}
