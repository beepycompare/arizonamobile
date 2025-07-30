package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class F9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0385kf f435a;
    public final uo b;
    public final Sk c;
    public final C0278g7 d;
    public final C0125a9 e;
    public final Kk f;
    public final C0296h0 g;
    public final C0429m9 h;
    public final C0624u5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public F9(C0385kf c0385kf, uo uoVar, Sk sk, C0278g7 c0278g7, C0296h0 c0296h0, C0125a9 c0125a9, Kk kk, int i, C0624u5 c0624u5, C0429m9 c0429m9, SystemTimeProvider systemTimeProvider) {
        this.f435a = c0385kf;
        this.b = uoVar;
        this.c = sk;
        this.d = c0278g7;
        this.g = c0296h0;
        this.e = c0125a9;
        this.f = kk;
        this.k = i;
        this.h = c0429m9;
        this.j = systemTimeProvider;
        this.i = c0624u5;
        this.l = c0385kf.h();
        this.m = c0385kf.g();
    }

    public final void a(C0401l6 c0401l6, Uk uk) {
        Map map = c0401l6.p;
        Kk kk = this.f;
        kk.getClass();
        map.putAll(new HashMap(kk.b));
        c0401l6.c(this.f435a.i());
        c0401l6.o = Integer.valueOf(this.b.b());
        C0271g0 a2 = this.g.a();
        C0125a9 c0125a9 = this.e;
        c0125a9.getClass();
        EnumC0680wb a3 = EnumC0680wb.a(c0401l6.d);
        C0278g7 c0278g7 = this.d;
        S8 a4 = ((Z8) c0125a9.b.a(a3)).a(c0401l6);
        int i = c0401l6.d;
        C0429m9 c0429m9 = this.h;
        D7 d7 = new D7(c0278g7.g, uk, i, c0429m9, a4, (C0711xh) c0278g7.h.k.a(), a2);
        Long valueOf = Long.valueOf(uk.f676a);
        Wk wk = uk.d;
        Long valueOf2 = Long.valueOf(uk.b);
        EnumC0680wb a5 = EnumC0680wb.a(d7.h.d);
        long j = 0;
        if (!R9.g.contains(EnumC0680wb.a(i))) {
            uo uoVar = c0429m9.b;
            synchronized (uoVar) {
                j = uoVar.f1092a.a().optLong("global_number", 0L);
            }
            c0429m9.b.b(1 + j);
        }
        c0278g7.a(c0278g7.l.fromModel(new A7(valueOf, wk, valueOf2, a5, Long.valueOf(j), Long.valueOf(uk.c), d7.a())));
        this.i.f1078a.h();
    }
}
