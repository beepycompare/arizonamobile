package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Jd {

    /* renamed from: a  reason: collision with root package name */
    public final C0672w0 f518a;
    public final Bd b;
    public final Pd c;
    public final IHandlerExecutor d;

    public Jd() {
        C0672w0 d = A4.l().d();
        this.f518a = d;
        this.b = new Bd(d);
        this.c = new Pd();
        this.d = A4.l().g().a();
    }

    public static final InterfaceC0328ib a(Jd jd) {
        jd.f518a.getClass();
        C0647v0 c0647v0 = C0647v0.e;
        Intrinsics.checkNotNull(c0647v0);
        Jc i = c0647v0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f517a;
    }
}
