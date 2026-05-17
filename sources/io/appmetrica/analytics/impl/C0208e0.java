package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.e0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0208e0 implements Cn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0234f0 f971a;

    public C0208e0(C0234f0 c0234f0) {
        this.f971a = c0234f0;
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final Thread a() {
        return this.f971a.b;
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final StackTraceElement[] b() {
        C0234f0 c0234f0 = this.f971a;
        return (StackTraceElement[]) c0234f0.f991a.get(c0234f0.b);
    }

    @Override // io.appmetrica.analytics.impl.Cn
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f971a.f991a;
    }
}
