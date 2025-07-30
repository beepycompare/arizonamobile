package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Dd {

    /* renamed from: a  reason: collision with root package name */
    public final C0619u0 f397a;
    public final C0682wd b;
    public final Jd c;
    public final IHandlerExecutor d;

    public Dd() {
        C0619u0 d = C0698x4.l().d();
        this.f397a = d;
        this.b = new C0682wd(d);
        this.c = new Jd();
        this.d = C0698x4.l().g().a();
    }

    public static final InterfaceC0205db a(Dd dd) {
        dd.f397a.getClass();
        C0594t0 c0594t0 = C0594t0.e;
        Intrinsics.checkNotNull(c0594t0);
        Ec i = c0594t0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f417a;
    }
}
