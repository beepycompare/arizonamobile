package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Ch extends AbstractC0164c6 {
    public final C0447n5 b;
    public final Bh c;
    public final T3 d;

    public Ch(C0447n5 c0447n5, Bh bh) {
        this(c0447n5, bh, new T3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0164c6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final Eh load(C0138b6 c0138b6) {
        Eh eh = (Eh) super.load(c0138b6);
        eh.m = ((C0770zh) c0138b6.componentArguments).f1319a;
        eh.r = this.b.t.a();
        eh.w = this.b.q.a();
        C0770zh c0770zh = (C0770zh) c0138b6.componentArguments;
        eh.d = c0770zh.b;
        eh.e = c0770zh.c;
        eh.f = c0770zh.d;
        eh.i = c0770zh.e;
        eh.g = c0770zh.f;
        eh.h = c0770zh.g;
        Boolean valueOf = Boolean.valueOf(c0770zh.h);
        Bh bh = this.c;
        eh.j = valueOf;
        eh.k = bh;
        C0770zh c0770zh2 = (C0770zh) c0138b6.componentArguments;
        eh.v = c0770zh2.j;
        Hm hm = c0138b6.f904a;
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
        Map<String, String> map = c0770zh2.i;
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

    public Ch(C0447n5 c0447n5, Bh bh, T3 t3) {
        super(c0447n5.getContext(), c0447n5.a().c());
        this.b = c0447n5;
        this.c = bh;
        this.d = t3;
    }

    public final Eh a() {
        return new Eh(this.b);
    }
}
