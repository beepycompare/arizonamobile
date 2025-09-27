package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Eh extends AbstractC0399l6 {
    public final C0651v5 b;
    public final Dh c;
    public final C0139b4 d;

    public Eh(C0651v5 c0651v5, Dh dh) {
        this(c0651v5, dh, new C0139b4());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0399l6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final Gh load(C0373k6 c0373k6) {
        Gh gh = (Gh) super.load(c0373k6);
        gh.m = ((Bh) c0373k6.componentArguments).f373a;
        gh.r = this.b.t.a();
        gh.w = this.b.q.a();
        Bh bh = (Bh) c0373k6.componentArguments;
        gh.d = bh.b;
        gh.e = bh.c;
        gh.f = bh.d;
        gh.i = bh.e;
        gh.g = bh.f;
        gh.h = bh.g;
        Boolean valueOf = Boolean.valueOf(bh.h);
        Dh dh = this.c;
        gh.j = valueOf;
        gh.k = dh;
        Bh bh2 = (Bh) c0373k6.componentArguments;
        gh.v = bh2.j;
        C0493om c0493om = c0373k6.f950a;
        J4 j4 = c0493om.n;
        gh.n = j4.f510a;
        Re re = c0493om.s;
        if (re != null) {
            gh.s = re.f656a;
            gh.t = re.b;
        }
        gh.o = j4.b;
        gh.q = c0493om.e;
        gh.p = c0493om.k;
        C0139b4 c0139b4 = this.d;
        Map<String, String> map = bh2.i;
        Y3 e = Na.F.e();
        c0139b4.getClass();
        gh.u = C0139b4.a(map, c0493om, e);
        gh.x = this.b.v.e.keySet();
        return gh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Gh(this.b);
    }

    public Eh(C0651v5 c0651v5, Dh dh, C0139b4 c0139b4) {
        super(c0651v5.getContext(), c0651v5.b().c());
        this.b = c0651v5;
        this.c = dh;
        this.d = c0139b4;
    }

    public final Gh a() {
        return new Gh(this.b);
    }
}
