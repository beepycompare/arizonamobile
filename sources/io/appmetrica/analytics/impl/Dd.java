package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Dd {

    /* renamed from: a  reason: collision with root package name */
    public final C0620u0 f396a;
    public final C0683wd b;
    public final Jd c;
    public final IHandlerExecutor d;

    public Dd() {
        C0620u0 d = C0699x4.l().d();
        this.f396a = d;
        this.b = new C0683wd(d);
        this.c = new Jd();
        this.d = C0699x4.l().g().a();
    }

    public static final InterfaceC0206db a(Dd dd) {
        dd.f396a.getClass();
        C0595t0 c0595t0 = C0595t0.e;
        Intrinsics.checkNotNull(c0595t0);
        Ec i = c0595t0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f416a;
    }
}
