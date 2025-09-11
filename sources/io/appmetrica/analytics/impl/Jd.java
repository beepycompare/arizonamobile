package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Jd {

    /* renamed from: a  reason: collision with root package name */
    public final C0671w0 f517a;
    public final Bd b;
    public final Pd c;
    public final IHandlerExecutor d;

    public Jd() {
        C0671w0 d = A4.l().d();
        this.f517a = d;
        this.b = new Bd(d);
        this.c = new Pd();
        this.d = A4.l().g().a();
    }

    public static final InterfaceC0327ib a(Jd jd) {
        jd.f517a.getClass();
        C0646v0 c0646v0 = C0646v0.e;
        Intrinsics.checkNotNull(c0646v0);
        Jc i = c0646v0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f516a;
    }
}
