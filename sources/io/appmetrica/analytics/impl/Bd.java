package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Bd {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f355a;
    public final C0630ud b;
    public final Hd c;
    public final IHandlerExecutor d;

    public Bd() {
        C0617u0 d = C0696x4.l().d();
        this.f355a = d;
        this.b = new C0630ud(d);
        this.c = new Hd();
        this.d = C0696x4.l().g().a();
    }

    public static final InterfaceC0153bb a(Bd bd) {
        bd.f355a.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Cc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f373a;
    }
}
