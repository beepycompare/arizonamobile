package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0394l9 {

    /* renamed from: a  reason: collision with root package name */
    public final Xe f1074a;
    public final yo b;
    public final Sk c;
    public final M6 d;
    public final I8 e;
    public final Kk f;
    public final C0333j0 g;
    public final C0106a5 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public C0394l9(Xe xe, yo yoVar, Sk sk, M6 m6, C0333j0 c0333j0, I8 i8, Kk kk, int i, C0106a5 c0106a5, SystemTimeProvider systemTimeProvider) {
        this.f1074a = xe;
        this.b = yoVar;
        this.c = sk;
        this.d = m6;
        this.g = c0333j0;
        this.e = i8;
        this.f = kk;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = c0106a5;
        this.k = xe.i();
        this.l = xe.h();
    }

    public final void a(Q5 q5, Uk uk) {
        long optLong;
        Map map = q5.p;
        Kk kk = this.f;
        kk.getClass();
        map.putAll(new HashMap(kk.b));
        q5.c(this.f1074a.j());
        q5.o = Integer.valueOf(this.b.b());
        C0308i0 a2 = this.g.a();
        I8 i8 = this.e;
        i8.getClass();
        EnumC0164cb a3 = EnumC0164cb.a(q5.d);
        M6 m6 = this.d;
        A8 a4 = ((H8) i8.b.a(a3)).a(q5);
        int i = q5.d;
        yo yoVar = this.b;
        C0315i7 c0315i7 = new C0315i7(m6.g, uk, i, yoVar, a4, (C0402lh) m6.h.k.a(), a2);
        Long valueOf = Long.valueOf(uk.f797a);
        Wk wk = uk.d;
        Long valueOf2 = Long.valueOf(uk.b);
        EnumC0164cb a5 = EnumC0164cb.a(c0315i7.h.d);
        long j = 0;
        if (!AbstractC0693x9.g.contains(EnumC0164cb.a(i))) {
            synchronized (yoVar) {
                JSONObject a6 = yoVar.f1308a.a();
                optLong = a6.optLong("global_number", 0L);
                yoVar.f1308a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        m6.a(m6.l.fromModel(new C0237f7(valueOf, wk, valueOf2, a5, Long.valueOf(j), Long.valueOf(uk.c), c0315i7.a())));
        this.h.f874a.h();
    }
}
