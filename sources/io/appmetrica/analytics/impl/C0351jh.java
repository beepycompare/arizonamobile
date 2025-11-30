package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0351jh extends N5 {
    public final Y4 b;
    public final InterfaceC0325ih c;
    public final D3 d;

    public C0351jh(Y4 y4, InterfaceC0325ih interfaceC0325ih) {
        this(y4, interfaceC0325ih, new D3());
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0403lh load(M5 m5) {
        C0403lh c0403lh = (C0403lh) super.load(m5);
        c0403lh.m = ((C0274gh) m5.componentArguments).f907a;
        c0403lh.r = this.b.t.a();
        c0403lh.w = this.b.q.a();
        C0274gh c0274gh = (C0274gh) m5.componentArguments;
        c0403lh.d = c0274gh.b;
        c0403lh.e = c0274gh.c;
        c0403lh.f = c0274gh.d;
        c0403lh.i = c0274gh.e;
        c0403lh.g = c0274gh.f;
        c0403lh.h = c0274gh.g;
        Boolean valueOf = Boolean.valueOf(c0274gh.h);
        InterfaceC0325ih interfaceC0325ih = this.c;
        c0403lh.j = valueOf;
        c0403lh.k = interfaceC0325ih;
        C0274gh c0274gh2 = (C0274gh) m5.componentArguments;
        c0403lh.v = c0274gh2.j;
        C0279gm c0279gm = m5.f583a;
        C0415m4 c0415m4 = c0279gm.n;
        c0403lh.n = c0415m4.f1003a;
        C0724ye c0724ye = c0279gm.s;
        if (c0724ye != null) {
            c0403lh.s = c0724ye.f1218a;
            c0403lh.t = c0724ye.b;
        }
        c0403lh.o = c0415m4.b;
        c0403lh.q = c0279gm.e;
        c0403lh.p = c0279gm.k;
        D3 d3 = this.d;
        Map<String, String> map = c0274gh2.i;
        A3 f = C0471oa.I.f();
        d3.getClass();
        c0403lh.u = D3.a(map, c0279gm, f);
        c0403lh.x = this.b.v.e.keySet();
        return c0403lh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0403lh(this.b);
    }

    public C0351jh(Y4 y4, InterfaceC0325ih interfaceC0325ih, D3 d3) {
        super(y4.getContext(), y4.b().c());
        this.b = y4;
        this.c = interfaceC0325ih;
        this.d = d3;
    }

    public final C0403lh a() {
        return new C0403lh(this.b);
    }
}
