package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* renamed from: io.appmetrica.analytics.impl.ze  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0749ze implements X8, Ae {

    /* renamed from: a  reason: collision with root package name */
    public final S6 f1230a;
    public final AtomicLong b;

    public C0749ze(S6 s6) {
        this.f1230a = s6;
        this.b = new AtomicLong(s6.b());
        s6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.X8
    public final void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.X8
    public final void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // io.appmetrica.analytics.impl.X8
    public final void a() {
        this.b.set(this.f1230a.b());
    }

    public final long b() {
        return this.b.get();
    }
}
