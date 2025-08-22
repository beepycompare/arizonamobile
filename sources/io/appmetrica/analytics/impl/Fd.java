package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Fd {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f434a;
    public final C0730yd b;
    public final Ld c;
    public final IHandlerExecutor d;

    public Fd() {
        C0617u0 d = C0696x4.l().d();
        this.f434a = d;
        this.b = new C0730yd(d);
        this.c = new Ld();
        this.d = C0696x4.l().g().a();
    }

    public static final InterfaceC0249fb a(Fd fd) {
        fd.f434a.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Gc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f455a;
    }
}
