package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.g0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0261g0 implements InterfaceC0259fo {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0287h0 f990a;

    public C0261g0(C0287h0 c0287h0) {
        this.f990a = c0287h0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0259fo
    public final Thread a() {
        return this.f990a.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0259fo
    public final StackTraceElement[] b() {
        C0287h0 c0287h0 = this.f990a;
        return (StackTraceElement[]) c0287h0.f1006a.get(c0287h0.b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0259fo
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f990a.f1006a;
    }
}
