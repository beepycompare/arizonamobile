package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.g0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0255g0 implements InterfaceC0253fo {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0281h0 f993a;

    public C0255g0(C0281h0 c0281h0) {
        this.f993a = c0281h0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0253fo
    public final Thread a() {
        return this.f993a.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0253fo
    public final StackTraceElement[] b() {
        C0281h0 c0281h0 = this.f993a;
        return (StackTraceElement[]) c0281h0.f1009a.get(c0281h0.b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0253fo
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f993a.f1009a;
    }
}
