package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0176c0 implements InterfaceC0698wn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0202d0 f775a;

    public C0176c0(C0202d0 c0202d0) {
        this.f775a = c0202d0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0698wn
    public final Thread a() {
        return this.f775a.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0698wn
    public final StackTraceElement[] b() {
        C0202d0 c0202d0 = this.f775a;
        return (StackTraceElement[]) c0202d0.f792a.get(c0202d0.b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0698wn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f775a.f792a;
    }
}
