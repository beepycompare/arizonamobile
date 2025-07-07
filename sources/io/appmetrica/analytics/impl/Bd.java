package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Bd {

    /* renamed from: a  reason: collision with root package name */
    public final C0625u0 f354a;
    public final C0638ud b;
    public final Hd c;
    public final IHandlerExecutor d;

    public Bd() {
        C0625u0 d = C0704x4.l().d();
        this.f354a = d;
        this.b = new C0638ud(d);
        this.c = new Hd();
        this.d = C0704x4.l().g().a();
    }

    public static final InterfaceC0161bb a(Bd bd) {
        bd.f354a.getClass();
        C0600t0 c0600t0 = C0600t0.e;
        Intrinsics.checkNotNull(c0600t0);
        Cc i = c0600t0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f372a;
    }
}
