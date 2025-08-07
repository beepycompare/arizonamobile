package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class F9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0386kf f434a;
    public final uo b;
    public final Sk c;
    public final C0279g7 d;
    public final C0126a9 e;
    public final Kk f;
    public final C0297h0 g;
    public final C0430m9 h;
    public final C0625u5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public F9(C0386kf c0386kf, uo uoVar, Sk sk, C0279g7 c0279g7, C0297h0 c0297h0, C0126a9 c0126a9, Kk kk, int i, C0625u5 c0625u5, C0430m9 c0430m9, SystemTimeProvider systemTimeProvider) {
        this.f434a = c0386kf;
        this.b = uoVar;
        this.c = sk;
        this.d = c0279g7;
        this.g = c0297h0;
        this.e = c0126a9;
        this.f = kk;
        this.k = i;
        this.h = c0430m9;
        this.j = systemTimeProvider;
        this.i = c0625u5;
        this.l = c0386kf.h();
        this.m = c0386kf.g();
    }

    public final void a(C0402l6 c0402l6, Uk uk) {
        Map map = c0402l6.p;
        Kk kk = this.f;
        kk.getClass();
        map.putAll(new HashMap(kk.b));
        c0402l6.c(this.f434a.i());
        c0402l6.o = Integer.valueOf(this.b.b());
        C0272g0 a2 = this.g.a();
        C0126a9 c0126a9 = this.e;
        c0126a9.getClass();
        EnumC0681wb a3 = EnumC0681wb.a(c0402l6.d);
        C0279g7 c0279g7 = this.d;
        S8 a4 = ((Z8) c0126a9.b.a(a3)).a(c0402l6);
        int i = c0402l6.d;
        C0430m9 c0430m9 = this.h;
        D7 d7 = new D7(c0279g7.g, uk, i, c0430m9, a4, (C0712xh) c0279g7.h.k.a(), a2);
        Long valueOf = Long.valueOf(uk.f675a);
        Wk wk = uk.d;
        Long valueOf2 = Long.valueOf(uk.b);
        EnumC0681wb a5 = EnumC0681wb.a(d7.h.d);
        long j = 0;
        if (!R9.g.contains(EnumC0681wb.a(i))) {
            uo uoVar = c0430m9.b;
            synchronized (uoVar) {
                j = uoVar.f1091a.a().optLong("global_number", 0L);
            }
            c0430m9.b.b(1 + j);
        }
        c0279g7.a(c0279g7.l.fromModel(new A7(valueOf, wk, valueOf2, a5, Long.valueOf(j), Long.valueOf(uk.c), d7.a())));
        this.i.f1077a.h();
    }
}
