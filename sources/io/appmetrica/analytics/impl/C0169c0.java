package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0169c0 implements InterfaceC0768zn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0195d0 f789a;

    public C0169c0(C0195d0 c0195d0) {
        this.f789a = c0195d0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0768zn
    public final Thread a() {
        return this.f789a.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0768zn
    public final StackTraceElement[] b() {
        C0195d0 c0195d0 = this.f789a;
        return (StackTraceElement[]) c0195d0.f807a.get(c0195d0.b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0768zn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f789a.f807a;
    }
}
