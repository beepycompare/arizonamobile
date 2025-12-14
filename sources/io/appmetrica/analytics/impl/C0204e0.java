package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.e0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0204e0 implements Dn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0230f0 f957a;

    public C0204e0(C0230f0 c0230f0) {
        this.f957a = c0230f0;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Thread a() {
        return this.f957a.b;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final StackTraceElement[] b() {
        C0230f0 c0230f0 = this.f957a;
        return (StackTraceElement[]) c0230f0.f976a.get(c0230f0.b);
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f957a.f976a;
    }
}
