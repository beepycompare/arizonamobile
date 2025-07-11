package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0168c0 implements InterfaceC0690wn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0194d0 f776a;

    public C0168c0(C0194d0 c0194d0) {
        this.f776a = c0194d0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0690wn
    public final Thread a() {
        return this.f776a.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0690wn
    public final StackTraceElement[] b() {
        C0194d0 c0194d0 = this.f776a;
        return (StackTraceElement[]) c0194d0.f793a.get(c0194d0.b);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0690wn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f776a.f793a;
    }
}
