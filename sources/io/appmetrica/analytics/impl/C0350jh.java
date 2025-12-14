package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0350jh extends N5 {
    public final Y4 b;
    public final InterfaceC0324ih c;
    public final D3 d;

    public C0350jh(Y4 y4, InterfaceC0324ih interfaceC0324ih) {
        this(y4, interfaceC0324ih, new D3());
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0402lh load(M5 m5) {
        C0402lh c0402lh = (C0402lh) super.load(m5);
        c0402lh.m = ((C0273gh) m5.componentArguments).f1004a;
        c0402lh.r = this.b.t.a();
        c0402lh.w = this.b.q.a();
        C0273gh c0273gh = (C0273gh) m5.componentArguments;
        c0402lh.d = c0273gh.b;
        c0402lh.e = c0273gh.c;
        c0402lh.f = c0273gh.d;
        c0402lh.i = c0273gh.e;
        c0402lh.g = c0273gh.f;
        c0402lh.h = c0273gh.g;
        Boolean valueOf = Boolean.valueOf(c0273gh.h);
        InterfaceC0324ih interfaceC0324ih = this.c;
        c0402lh.j = valueOf;
        c0402lh.k = interfaceC0324ih;
        C0273gh c0273gh2 = (C0273gh) m5.componentArguments;
        c0402lh.v = c0273gh2.j;
        C0278gm c0278gm = m5.f680a;
        C0414m4 c0414m4 = c0278gm.n;
        c0402lh.n = c0414m4.f1100a;
        C0723ye c0723ye = c0278gm.s;
        if (c0723ye != null) {
            c0402lh.s = c0723ye.f1315a;
            c0402lh.t = c0723ye.b;
        }
        c0402lh.o = c0414m4.b;
        c0402lh.q = c0278gm.e;
        c0402lh.p = c0278gm.k;
        D3 d3 = this.d;
        Map<String, String> map = c0273gh2.i;
        A3 f = C0470oa.I.f();
        d3.getClass();
        c0402lh.u = D3.a(map, c0278gm, f);
        c0402lh.x = this.b.v.e.keySet();
        return c0402lh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0402lh(this.b);
    }

    public C0350jh(Y4 y4, InterfaceC0324ih interfaceC0324ih, D3 d3) {
        super(y4.getContext(), y4.b().c());
        this.b = y4;
        this.c = interfaceC0324ih;
        this.d = d3;
    }

    public final C0402lh a() {
        return new C0402lh(this.b);
    }
}
