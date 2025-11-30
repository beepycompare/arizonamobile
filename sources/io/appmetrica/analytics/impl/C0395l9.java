package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0395l9 {

    /* renamed from: a  reason: collision with root package name */
    public final Xe f991a;
    public final yo b;
    public final Sk c;
    public final M6 d;
    public final I8 e;
    public final Kk f;
    public final C0334j0 g;
    public final C0107a5 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public C0395l9(Xe xe, yo yoVar, Sk sk, M6 m6, C0334j0 c0334j0, I8 i8, Kk kk, int i, C0107a5 c0107a5, SystemTimeProvider systemTimeProvider) {
        this.f991a = xe;
        this.b = yoVar;
        this.c = sk;
        this.d = m6;
        this.g = c0334j0;
        this.e = i8;
        this.f = kk;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = c0107a5;
        this.k = xe.i();
        this.l = xe.h();
    }

    public final void a(Q5 q5, Uk uk) {
        long optLong;
        Map map = q5.p;
        Kk kk = this.f;
        kk.getClass();
        map.putAll(new HashMap(kk.b));
        q5.c(this.f991a.j());
        q5.o = Integer.valueOf(this.b.b());
        C0309i0 a2 = this.g.a();
        I8 i8 = this.e;
        i8.getClass();
        EnumC0165cb a3 = EnumC0165cb.a(q5.d);
        M6 m6 = this.d;
        A8 a4 = ((H8) i8.b.a(a3)).a(q5);
        int i = q5.d;
        yo yoVar = this.b;
        C0316i7 c0316i7 = new C0316i7(m6.g, uk, i, yoVar, a4, (C0403lh) m6.h.k.a(), a2);
        Long valueOf = Long.valueOf(uk.f714a);
        Wk wk = uk.d;
        Long valueOf2 = Long.valueOf(uk.b);
        EnumC0165cb a5 = EnumC0165cb.a(c0316i7.h.d);
        long j = 0;
        if (!AbstractC0694x9.g.contains(EnumC0165cb.a(i))) {
            synchronized (yoVar) {
                JSONObject a6 = yoVar.f1225a.a();
                optLong = a6.optLong("global_number", 0L);
                yoVar.f1225a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        m6.a(m6.l.fromModel(new C0238f7(valueOf, wk, valueOf2, a5, Long.valueOf(j), Long.valueOf(uk.c), c0316i7.a())));
        this.h.f791a.h();
    }
}
