package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.e0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0205e0 implements Dn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0231f0 f860a;

    public C0205e0(C0231f0 c0231f0) {
        this.f860a = c0231f0;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Thread a() {
        return this.f860a.b;
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final StackTraceElement[] b() {
        C0231f0 c0231f0 = this.f860a;
        return (StackTraceElement[]) c0231f0.f879a.get(c0231f0.b);
    }

    @Override // io.appmetrica.analytics.impl.Dn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f860a.f879a;
    }
}
