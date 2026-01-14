package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.e0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0209e0 implements Cn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0235f0 f967a;

    public C0209e0(C0235f0 c0235f0) {
        this.f967a = c0235f0;
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final Thread a() {
        return this.f967a.b;
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final StackTraceElement[] b() {
        C0235f0 c0235f0 = this.f967a;
        return (StackTraceElement[]) c0235f0.f987a.get(c0235f0.b);
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f967a.f987a;
    }
}
