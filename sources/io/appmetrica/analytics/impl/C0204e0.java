package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.e0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0204e0 implements Dn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0230f0 f958a;

    public C0204e0(C0230f0 c0230f0) {
        this.f958a = c0230f0;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Thread a() {
        return this.f958a.b;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final StackTraceElement[] b() {
        C0230f0 c0230f0 = this.f958a;
        return (StackTraceElement[]) c0230f0.f977a.get(c0230f0.b);
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f958a.f977a;
    }
}
