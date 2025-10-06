package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class K9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0538qf f537a;
    public final Do b;
    public final C0157bl c;
    public final C0375k7 d;
    public final C0248f9 e;
    public final Tk f;
    public final C0317i0 g;
    public final C0556r9 h;
    public final C0702x5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public K9(C0538qf c0538qf, Do r2, C0157bl c0157bl, C0375k7 c0375k7, C0317i0 c0317i0, C0248f9 c0248f9, Tk tk, int i, C0702x5 c0702x5, C0556r9 c0556r9, SystemTimeProvider systemTimeProvider) {
        this.f537a = c0538qf;
        this.b = r2;
        this.c = c0157bl;
        this.d = c0375k7;
        this.g = c0317i0;
        this.e = c0248f9;
        this.f = tk;
        this.k = i;
        this.h = c0556r9;
        this.j = systemTimeProvider;
        this.i = c0702x5;
        this.l = c0538qf.i();
        this.m = c0538qf.h();
    }

    public final void a(C0478o6 c0478o6, C0209dl c0209dl) {
        Map map = c0478o6.p;
        Tk tk = this.f;
        tk.getClass();
        map.putAll(new HashMap(tk.b));
        c0478o6.c(this.f537a.j());
        c0478o6.o = Integer.valueOf(this.b.b());
        C0291h0 a2 = this.g.a();
        C0248f9 c0248f9 = this.e;
        c0248f9.getClass();
        Bb a3 = Bb.a(c0478o6.d);
        C0375k7 c0375k7 = this.d;
        X8 a4 = ((InterfaceC0222e9) c0248f9.b.a(a3)).a(c0478o6);
        int i = c0478o6.d;
        C0556r9 c0556r9 = this.h;
        H7 h7 = new H7(c0375k7.g, c0209dl, i, c0556r9, a4, (Gh) c0375k7.h.k.a(), a2);
        Long valueOf = Long.valueOf(c0209dl.f850a);
        EnumC0260fl enumC0260fl = c0209dl.d;
        Long valueOf2 = Long.valueOf(c0209dl.b);
        Bb a5 = Bb.a(h7.h.d);
        long j = 0;
        if (!W9.g.contains(Bb.a(i))) {
            Do r3 = c0556r9.b;
            synchronized (r3) {
                j = r3.f418a.a().optLong("global_number", 0L);
            }
            c0556r9.b.b(1 + j);
        }
        c0375k7.a(c0375k7.l.fromModel(new E7(valueOf, enumC0260fl, valueOf2, a5, Long.valueOf(j), Long.valueOf(c0209dl.c), h7.a())));
        this.i.f1150a.h();
    }
}
