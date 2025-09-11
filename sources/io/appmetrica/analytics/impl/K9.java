package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class K9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0537qf f536a;
    public final Do b;
    public final C0156bl c;
    public final C0374k7 d;
    public final C0247f9 e;
    public final Tk f;
    public final C0316i0 g;
    public final C0555r9 h;
    public final C0701x5 i;
    public final TimeProvider j;
    public final int k;
    public long l;
    public int m;

    public K9(C0537qf c0537qf, Do r2, C0156bl c0156bl, C0374k7 c0374k7, C0316i0 c0316i0, C0247f9 c0247f9, Tk tk, int i, C0701x5 c0701x5, C0555r9 c0555r9, SystemTimeProvider systemTimeProvider) {
        this.f536a = c0537qf;
        this.b = r2;
        this.c = c0156bl;
        this.d = c0374k7;
        this.g = c0316i0;
        this.e = c0247f9;
        this.f = tk;
        this.k = i;
        this.h = c0555r9;
        this.j = systemTimeProvider;
        this.i = c0701x5;
        this.l = c0537qf.i();
        this.m = c0537qf.h();
    }

    public final void a(C0477o6 c0477o6, C0208dl c0208dl) {
        Map map = c0477o6.p;
        Tk tk = this.f;
        tk.getClass();
        map.putAll(new HashMap(tk.b));
        c0477o6.c(this.f536a.j());
        c0477o6.o = Integer.valueOf(this.b.b());
        C0290h0 a2 = this.g.a();
        C0247f9 c0247f9 = this.e;
        c0247f9.getClass();
        Bb a3 = Bb.a(c0477o6.d);
        C0374k7 c0374k7 = this.d;
        X8 a4 = ((InterfaceC0221e9) c0247f9.b.a(a3)).a(c0477o6);
        int i = c0477o6.d;
        C0555r9 c0555r9 = this.h;
        H7 h7 = new H7(c0374k7.g, c0208dl, i, c0555r9, a4, (Gh) c0374k7.h.k.a(), a2);
        Long valueOf = Long.valueOf(c0208dl.f849a);
        EnumC0259fl enumC0259fl = c0208dl.d;
        Long valueOf2 = Long.valueOf(c0208dl.b);
        Bb a5 = Bb.a(h7.h.d);
        long j = 0;
        if (!W9.g.contains(Bb.a(i))) {
            Do r3 = c0555r9.b;
            synchronized (r3) {
                j = r3.f417a.a().optLong("global_number", 0L);
            }
            c0555r9.b.b(1 + j);
        }
        c0374k7.a(c0374k7.l.fromModel(new E7(valueOf, enumC0259fl, valueOf2, a5, Long.valueOf(j), Long.valueOf(c0208dl.c), h7.a())));
        this.i.f1149a.h();
    }
}
