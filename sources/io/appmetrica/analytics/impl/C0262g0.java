package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.g0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0262g0 implements InterfaceC0260fo {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0288h0 f987a;

    public C0262g0(C0288h0 c0288h0) {
        this.f987a = c0288h0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260fo
    public final Thread a() {
        return this.f987a.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260fo
    public final StackTraceElement[] b() {
        C0288h0 c0288h0 = this.f987a;
        return (StackTraceElement[]) c0288h0.f1003a.get(c0288h0.b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0260fo
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f987a.f1003a;
    }
}
