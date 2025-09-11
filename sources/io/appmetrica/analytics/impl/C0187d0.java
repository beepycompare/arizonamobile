package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0187d0 implements In {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0212e0 f832a;

    public C0187d0(C0212e0 c0212e0) {
        this.f832a = c0212e0;
    }

    @Override // io.appmetrica.analytics.impl.In
    public final Thread a() {
        return this.f832a.b;
    }

    @Override // io.appmetrica.analytics.impl.In
    public final StackTraceElement[] b() {
        C0212e0 c0212e0 = this.f832a;
        return (StackTraceElement[]) c0212e0.f852a.get(c0212e0.b);
    }

    @Override // io.appmetrica.analytics.impl.In
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f832a.f852a;
    }
}
