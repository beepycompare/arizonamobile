package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class C9 {

    /* renamed from: a  reason: collision with root package name */
    public final Cif f371a;
    public final ro b;
    public final Pk c;
    public final C0201d7 d;
    public final X8 e;
    public final Hk f;
    public final C0294h0 g;
    public final C0352j9 h;
    public final C0622u5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public C9(Cif cif, ro roVar, Pk pk, C0201d7 c0201d7, C0294h0 c0294h0, X8 x8, Hk hk, int i, C0622u5 c0622u5, C0352j9 c0352j9, SystemTimeProvider systemTimeProvider) {
        this.f371a = cif;
        this.b = roVar;
        this.c = pk;
        this.d = c0201d7;
        this.g = c0294h0;
        this.e = x8;
        this.f = hk;
        this.k = i;
        this.h = c0352j9;
        this.j = systemTimeProvider;
        this.i = c0622u5;
        this.l = cif.h();
        this.m = cif.g();
    }

    public final void a(C0325i6 c0325i6, Rk rk) {
        Map map = c0325i6.p;
        Hk hk = this.f;
        hk.getClass();
        map.putAll(new HashMap(hk.b));
        c0325i6.c(this.f371a.i());
        c0325i6.o = Integer.valueOf(this.b.b());
        C0269g0 a2 = this.g.a();
        X8 x8 = this.e;
        x8.getClass();
        EnumC0628ub a3 = EnumC0628ub.a(c0325i6.d);
        C0201d7 c0201d7 = this.d;
        P8 a4 = ((W8) x8.b.a(a3)).a(c0325i6);
        int i = c0325i6.d;
        C0352j9 c0352j9 = this.h;
        A7 a7 = new A7(c0201d7.g, rk, i, c0352j9, a4, (C0659vh) c0201d7.h.k.a(), a2);
        Long valueOf = Long.valueOf(rk.f615a);
        Tk tk = rk.d;
        Long valueOf2 = Long.valueOf(rk.b);
        EnumC0628ub a5 = EnumC0628ub.a(a7.h.d);
        long j = 0;
        if (!O9.g.contains(EnumC0628ub.a(i))) {
            ro roVar = c0352j9.b;
            synchronized (roVar) {
                j = roVar.f1034a.a().optLong("global_number", 0L);
            }
            c0352j9.b.b(1 + j);
        }
        c0201d7.a(c0201d7.l.fromModel(new C0699x7(valueOf, tk, valueOf2, a5, Long.valueOf(j), Long.valueOf(rk.c), a7.a())));
        this.i.f1068a.h();
    }
}
