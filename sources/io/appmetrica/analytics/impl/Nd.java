package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Nd {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f688a;
    public final Fd b;
    public final Ud c;
    public final IHandlerExecutor d;

    public Nd() {
        B0 d = C0569s4.l().d();
        this.f688a = d;
        this.b = new Fd(d);
        this.c = new Ud();
        this.d = C0569s4.l().g().a();
    }

    public static final InterfaceC0369kb a(Nd nd) {
        nd.f688a.getClass();
        A0 a0 = A0.e;
        Intrinsics.checkNotNull(a0);
        Lc i = a0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f650a;
    }
}
