package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.c0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0161c0 implements En {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0187d0 f801a;

    public C0161c0(C0187d0 c0187d0) {
        this.f801a = c0187d0;
    }

    @Override // io.appmetrica.analytics.impl.En
    public final Thread a() {
        return this.f801a.b;
    }

    @Override // io.appmetrica.analytics.impl.En
    public final StackTraceElement[] b() {
        C0187d0 c0187d0 = this.f801a;
        return (StackTraceElement[]) c0187d0.f819a.get(c0187d0.b);
    }

    @Override // io.appmetrica.analytics.impl.En
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f801a.f819a;
    }
}
