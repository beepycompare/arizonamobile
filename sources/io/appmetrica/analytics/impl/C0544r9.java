package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.r9  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0544r9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0143bf f1091a;
    public final zo b;
    public final Wk c;
    public final S6 d;
    public final M8 e;
    public final Ok f;
    public final C0334j0 g;
    public final Y8 h;
    public final C0262g5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public C0544r9(C0143bf c0143bf, zo zoVar, Wk wk, S6 s6, C0334j0 c0334j0, M8 m8, Ok ok, int i, C0262g5 c0262g5, Y8 y8, SystemTimeProvider systemTimeProvider) {
        this.f1091a = c0143bf;
        this.b = zoVar;
        this.c = wk;
        this.d = s6;
        this.g = c0334j0;
        this.e = m8;
        this.f = ok;
        this.k = i;
        this.h = y8;
        this.j = systemTimeProvider;
        this.i = c0262g5;
        this.l = c0143bf.i();
        this.m = c0143bf.h();
    }

    public final void a(W5 w5, Yk yk) {
        Map map = w5.p;
        Ok ok = this.f;
        ok.getClass();
        map.putAll(new HashMap(ok.b));
        w5.c(this.f1091a.j());
        w5.o = Integer.valueOf(this.b.b());
        C0309i0 a2 = this.g.a();
        M8 m8 = this.e;
        m8.getClass();
        EnumC0320ib a3 = EnumC0320ib.a(w5.d);
        S6 s6 = this.d;
        E8 a4 = ((L8) m8.b.a(a3)).a(w5);
        int i = w5.d;
        Y8 y8 = this.h;
        C0493p7 c0493p7 = new C0493p7(s6.g, yk, i, y8, a4, (C0503ph) s6.h.k.a(), a2);
        Long valueOf = Long.valueOf(yk.f774a);
        EnumC0123al enumC0123al = yk.d;
        Long valueOf2 = Long.valueOf(yk.b);
        EnumC0320ib a5 = EnumC0320ib.a(c0493p7.h.d);
        long j = 0;
        if (!D9.g.contains(EnumC0320ib.a(i))) {
            zo zoVar = y8.b;
            synchronized (zoVar) {
                j = zoVar.f1238a.a().optLong("global_number", 0L);
            }
            y8.b.b(1 + j);
        }
        s6.a(s6.l.fromModel(new C0418m7(valueOf, enumC0123al, valueOf2, a5, Long.valueOf(j), Long.valueOf(yk.c), c0493p7.a())));
        this.i.f887a.h();
    }
}
