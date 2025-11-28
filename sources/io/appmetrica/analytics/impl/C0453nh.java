package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0453nh extends T5 {
    public final C0210e5 b;
    public final InterfaceC0428mh c;
    public final K3 d;

    public C0453nh(C0210e5 c0210e5, InterfaceC0428mh interfaceC0428mh) {
        this(c0210e5, interfaceC0428mh, new K3());
    }

    @Override // io.appmetrica.analytics.impl.T5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0503ph load(S5 s5) {
        C0503ph c0503ph = (C0503ph) super.load(s5);
        c0503ph.m = ((C0377kh) s5.componentArguments).f974a;
        c0503ph.r = this.b.t.a();
        c0503ph.w = this.b.q.a();
        C0377kh c0377kh = (C0377kh) s5.componentArguments;
        c0503ph.d = c0377kh.b;
        c0503ph.e = c0377kh.c;
        c0503ph.f = c0377kh.d;
        c0503ph.i = c0377kh.e;
        c0503ph.g = c0377kh.f;
        c0503ph.h = c0377kh.g;
        Boolean valueOf = Boolean.valueOf(c0377kh.h);
        InterfaceC0428mh interfaceC0428mh = this.c;
        c0503ph.j = valueOf;
        c0503ph.k = interfaceC0428mh;
        C0377kh c0377kh2 = (C0377kh) s5.componentArguments;
        c0503ph.v = c0377kh2.j;
        C0356jm c0356jm = s5.f677a;
        C0564s4 c0564s4 = c0356jm.n;
        c0503ph.n = c0564s4.f1105a;
        De de = c0356jm.s;
        if (de != null) {
            c0503ph.s = de.f441a;
            c0503ph.t = de.b;
        }
        c0503ph.o = c0564s4.b;
        c0503ph.q = c0356jm.e;
        c0503ph.p = c0356jm.k;
        K3 k3 = this.d;
        Map<String, String> map = c0377kh2.i;
        H3 f = C0620ua.H.f();
        k3.getClass();
        c0503ph.u = K3.a(map, c0356jm, f);
        c0503ph.x = this.b.v.e.keySet();
        return c0503ph;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0503ph(this.b);
    }

    public C0453nh(C0210e5 c0210e5, InterfaceC0428mh interfaceC0428mh, K3 k3) {
        super(c0210e5.getContext(), c0210e5.b().c());
        this.b = c0210e5;
        this.c = interfaceC0428mh;
        this.d = k3;
    }

    public final C0503ph a() {
        return new C0503ph(this.b);
    }
}
