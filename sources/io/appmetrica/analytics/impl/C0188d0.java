package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0188d0 implements In {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0213e0 f833a;

    public C0188d0(C0213e0 c0213e0) {
        this.f833a = c0213e0;
    }

    @Override // io.appmetrica.analytics.impl.In
    public final Thread a() {
        return this.f833a.b;
    }

    @Override // io.appmetrica.analytics.impl.In
    public final StackTraceElement[] b() {
        C0213e0 c0213e0 = this.f833a;
        return (StackTraceElement[]) c0213e0.f853a.get(c0213e0.b);
    }

    @Override // io.appmetrica.analytics.impl.In
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f833a.f853a;
    }
}
