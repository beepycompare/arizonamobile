package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Ch extends AbstractC0163c6 {
    public final C0446n5 b;
    public final Bh c;
    public final T3 d;

    public Ch(C0446n5 c0446n5, Bh bh) {
        this(c0446n5, bh, new T3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0163c6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final Eh load(C0137b6 c0137b6) {
        Eh eh = (Eh) super.load(c0137b6);
        eh.m = ((C0769zh) c0137b6.componentArguments).f1319a;
        eh.r = this.b.t.a();
        eh.w = this.b.q.a();
        C0769zh c0769zh = (C0769zh) c0137b6.componentArguments;
        eh.d = c0769zh.b;
        eh.e = c0769zh.c;
        eh.f = c0769zh.d;
        eh.i = c0769zh.e;
        eh.g = c0769zh.f;
        eh.h = c0769zh.g;
        Boolean valueOf = Boolean.valueOf(c0769zh.h);
        Bh bh = this.c;
        eh.j = valueOf;
        eh.k = bh;
        C0769zh c0769zh2 = (C0769zh) c0137b6.componentArguments;
        eh.v = c0769zh2.j;
        Hm hm = c0137b6.f904a;
        C4 c4 = hm.n;
        eh.n = c4.f489a;
        Ye ye = hm.s;
        if (ye != null) {
            eh.s = ye.f858a;
            eh.t = ye.b;
        }
        eh.o = c4.b;
        eh.q = hm.e;
        eh.p = hm.k;
        T3 t3 = this.d;
        Map<String, String> map = c0769zh2.i;
        Q3 f = Na.I.f();
        t3.getClass();
        eh.u = T3.a(map, hm, f);
        eh.x = this.b.v.e.keySet();
        eh.y = this.b.b() == CounterConfigurationReporterType.MAIN;
        return eh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Eh(this.b);
    }

    public Ch(C0446n5 c0446n5, Bh bh, T3 t3) {
        super(c0446n5.getContext(), c0446n5.a().c());
        this.b = c0446n5;
        this.c = bh;
        this.d = t3;
    }

    public final Eh a() {
        return new Eh(this.b);
    }
}
