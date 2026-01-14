package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* renamed from: io.appmetrica.analytics.impl.te  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0602te implements S8, InterfaceC0627ue {

    /* renamed from: a  reason: collision with root package name */
    public final L6 f1238a;
    public final AtomicLong b;

    public C0602te(L6 l6) {
        this.f1238a = l6;
        this.b = new AtomicLong(l6.a());
        l6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.S8
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.S8
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.S8
    public final void a() {
        this.b.set(this.f1238a.a());
    }

    public final long b() {
        return this.b.get();
    }
}
