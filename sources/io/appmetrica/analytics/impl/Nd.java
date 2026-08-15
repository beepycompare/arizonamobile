package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Nd {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f685a;
    public final Fd b;
    public final Ud c;
    public final IHandlerExecutor d;

    public Nd() {
        B0 d = C0575s4.l().d();
        this.f685a = d;
        this.b = new Fd(d);
        this.c = new Ud();
        this.d = C0575s4.l().g().a();
    }

    public static final InterfaceC0375kb a(Nd nd) {
        nd.f685a.getClass();
        A0 a0 = A0.e;
        Intrinsics.checkNotNull(a0);
        Lc i = a0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f647a;
    }
}
