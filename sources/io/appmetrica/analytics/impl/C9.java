package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class C9 {

    /* renamed from: a  reason: collision with root package name */
    public final Cif f370a;
    public final ro b;
    public final Pk c;
    public final C0209d7 d;
    public final X8 e;
    public final Hk f;
    public final C0302h0 g;
    public final C0360j9 h;
    public final C0630u5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public C9(Cif cif, ro roVar, Pk pk, C0209d7 c0209d7, C0302h0 c0302h0, X8 x8, Hk hk, int i, C0630u5 c0630u5, C0360j9 c0360j9, SystemTimeProvider systemTimeProvider) {
        this.f370a = cif;
        this.b = roVar;
        this.c = pk;
        this.d = c0209d7;
        this.g = c0302h0;
        this.e = x8;
        this.f = hk;
        this.k = i;
        this.h = c0360j9;
        this.j = systemTimeProvider;
        this.i = c0630u5;
        this.l = cif.h();
        this.m = cif.g();
    }

    public final void a(C0333i6 c0333i6, Rk rk) {
        Map map = c0333i6.p;
        Hk hk = this.f;
        hk.getClass();
        map.putAll(new HashMap(hk.b));
        c0333i6.c(this.f370a.i());
        c0333i6.o = Integer.valueOf(this.b.b());
        C0277g0 a2 = this.g.a();
        X8 x8 = this.e;
        x8.getClass();
        EnumC0636ub a3 = EnumC0636ub.a(c0333i6.d);
        C0209d7 c0209d7 = this.d;
        P8 a4 = ((W8) x8.b.a(a3)).a(c0333i6);
        int i = c0333i6.d;
        C0360j9 c0360j9 = this.h;
        A7 a7 = new A7(c0209d7.g, rk, i, c0360j9, a4, (C0667vh) c0209d7.h.k.a(), a2);
        Long valueOf = Long.valueOf(rk.f614a);
        Tk tk = rk.d;
        Long valueOf2 = Long.valueOf(rk.b);
        EnumC0636ub a5 = EnumC0636ub.a(a7.h.d);
        long j = 0;
        if (!O9.g.contains(EnumC0636ub.a(i))) {
            ro roVar = c0360j9.b;
            synchronized (roVar) {
                j = roVar.f1033a.a().optLong("global_number", 0L);
            }
            c0360j9.b.b(1 + j);
        }
        c0209d7.a(c0209d7.l.fromModel(new C0707x7(valueOf, tk, valueOf2, a5, Long.valueOf(j), Long.valueOf(rk.c), a7.a())));
        this.i.f1067a.h();
    }
}
