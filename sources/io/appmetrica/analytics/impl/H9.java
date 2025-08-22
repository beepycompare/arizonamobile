package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class H9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0433mf f474a;
    public final zo b;
    public final Xk c;
    public final C0297h7 d;
    public final C0170c9 e;
    public final Pk f;
    public final C0290h0 g;
    public final C0477o9 h;
    public final C0622u5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public H9(C0433mf c0433mf, zo zoVar, Xk xk, C0297h7 c0297h7, C0290h0 c0290h0, C0170c9 c0170c9, Pk pk, int i, C0622u5 c0622u5, C0477o9 c0477o9, SystemTimeProvider systemTimeProvider) {
        this.f474a = c0433mf;
        this.b = zoVar;
        this.c = xk;
        this.d = c0297h7;
        this.g = c0290h0;
        this.e = c0170c9;
        this.f = pk;
        this.k = i;
        this.h = c0477o9;
        this.j = systemTimeProvider;
        this.i = c0622u5;
        this.l = c0433mf.h();
        this.m = c0433mf.g();
    }

    public final void a(C0399l6 c0399l6, Zk zk) {
        Map map = c0399l6.p;
        Pk pk = this.f;
        pk.getClass();
        map.putAll(new HashMap(pk.b));
        c0399l6.c(this.f474a.i());
        c0399l6.o = Integer.valueOf(this.b.b());
        C0264g0 a2 = this.g.a();
        C0170c9 c0170c9 = this.e;
        c0170c9.getClass();
        EnumC0728yb a3 = EnumC0728yb.a(c0399l6.d);
        C0297h7 c0297h7 = this.d;
        U8 a4 = ((InterfaceC0144b9) c0170c9.b.a(a3)).a(c0399l6);
        int i = c0399l6.d;
        C0477o9 c0477o9 = this.h;
        E7 e7 = new E7(c0297h7.g, zk, i, c0477o9, a4, (Ch) c0297h7.h.k.a(), a2);
        Long valueOf = Long.valueOf(zk.f763a);
        EnumC0156bl enumC0156bl = zk.d;
        Long valueOf2 = Long.valueOf(zk.b);
        EnumC0728yb a5 = EnumC0728yb.a(e7.h.d);
        long j = 0;
        if (!T9.g.contains(EnumC0728yb.a(i))) {
            zo zoVar = c0477o9.b;
            synchronized (zoVar) {
                j = zoVar.f1187a.a().optLong("global_number", 0L);
            }
            c0477o9.b.b(1 + j);
        }
        c0297h7.a(c0297h7.l.fromModel(new B7(valueOf, enumC0156bl, valueOf2, a5, Long.valueOf(j), Long.valueOf(zk.c), e7.a())));
        this.i.f1082a.h();
    }
}
