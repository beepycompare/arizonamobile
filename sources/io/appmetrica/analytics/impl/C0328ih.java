package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0328ih extends M5 {
    public final X4 b;
    public final InterfaceC0303hh c;
    public final C3 d;

    public C0328ih(X4 x4, InterfaceC0303hh interfaceC0303hh) {
        this(x4, interfaceC0303hh, new C3());
    }

    @Override // io.appmetrica.analytics.impl.M5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0380kh load(L5 l5) {
        C0380kh c0380kh = (C0380kh) super.load(l5);
        c0380kh.m = ((C0251fh) l5.componentArguments).f995a;
        c0380kh.r = this.b.t.a();
        c0380kh.w = this.b.q.a();
        C0251fh c0251fh = (C0251fh) l5.componentArguments;
        c0380kh.d = c0251fh.b;
        c0380kh.e = c0251fh.c;
        c0380kh.f = c0251fh.d;
        c0380kh.i = c0251fh.e;
        c0380kh.g = c0251fh.f;
        c0380kh.h = c0251fh.g;
        Boolean valueOf = Boolean.valueOf(c0251fh.h);
        InterfaceC0303hh interfaceC0303hh = this.c;
        c0380kh.j = valueOf;
        c0380kh.k = interfaceC0303hh;
        C0251fh c0251fh2 = (C0251fh) l5.componentArguments;
        c0380kh.v = c0251fh2.j;
        C0256fm c0256fm = l5.f671a;
        C0392l4 c0392l4 = c0256fm.n;
        c0380kh.n = c0392l4.f1090a;
        C0701xe c0701xe = c0256fm.s;
        if (c0701xe != null) {
            c0380kh.s = c0701xe.f1305a;
            c0380kh.t = c0701xe.b;
        }
        c0380kh.o = c0392l4.b;
        c0380kh.q = c0256fm.e;
        c0380kh.p = c0256fm.k;
        C3 c3 = this.d;
        Map<String, String> map = c0251fh2.i;
        C0740z3 f = C0448na.I.f();
        c3.getClass();
        c0380kh.u = C3.a(map, c0256fm, f);
        c0380kh.x = this.b.v.e.keySet();
        return c0380kh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0380kh(this.b);
    }

    public C0328ih(X4 x4, InterfaceC0303hh interfaceC0303hh, C3 c3) {
        super(x4.getContext(), x4.b().c());
        this.b = x4;
        this.c = interfaceC0303hh;
        this.d = c3;
    }

    public final C0380kh a() {
        return new C0380kh(this.b);
    }
}
