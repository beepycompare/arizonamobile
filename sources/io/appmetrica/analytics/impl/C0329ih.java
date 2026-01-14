package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0329ih extends M5 {
    public final X4 b;
    public final InterfaceC0304hh c;
    public final C3 d;

    public C0329ih(X4 x4, InterfaceC0304hh interfaceC0304hh) {
        this(x4, interfaceC0304hh, new C3());
    }

    @Override // io.appmetrica.analytics.impl.M5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0381kh load(L5 l5) {
        C0381kh c0381kh = (C0381kh) super.load(l5);
        c0381kh.m = ((C0252fh) l5.componentArguments).f996a;
        c0381kh.r = this.b.t.a();
        c0381kh.w = this.b.q.a();
        C0252fh c0252fh = (C0252fh) l5.componentArguments;
        c0381kh.d = c0252fh.b;
        c0381kh.e = c0252fh.c;
        c0381kh.f = c0252fh.d;
        c0381kh.i = c0252fh.e;
        c0381kh.g = c0252fh.f;
        c0381kh.h = c0252fh.g;
        Boolean valueOf = Boolean.valueOf(c0252fh.h);
        InterfaceC0304hh interfaceC0304hh = this.c;
        c0381kh.j = valueOf;
        c0381kh.k = interfaceC0304hh;
        C0252fh c0252fh2 = (C0252fh) l5.componentArguments;
        c0381kh.v = c0252fh2.j;
        C0257fm c0257fm = l5.f672a;
        C0393l4 c0393l4 = c0257fm.n;
        c0381kh.n = c0393l4.f1091a;
        C0702xe c0702xe = c0257fm.s;
        if (c0702xe != null) {
            c0381kh.s = c0702xe.f1306a;
            c0381kh.t = c0702xe.b;
        }
        c0381kh.o = c0393l4.b;
        c0381kh.q = c0257fm.e;
        c0381kh.p = c0257fm.k;
        C3 c3 = this.d;
        Map<String, String> map = c0252fh2.i;
        C0741z3 f = C0449na.I.f();
        c3.getClass();
        c0381kh.u = C3.a(map, c0257fm, f);
        c0381kh.x = this.b.v.e.keySet();
        return c0381kh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0381kh(this.b);
    }

    public C0329ih(X4 x4, InterfaceC0304hh interfaceC0304hh, C3 c3) {
        super(x4.getContext(), x4.b().c());
        this.b = x4;
        this.c = interfaceC0304hh;
        this.d = c3;
    }

    public final C0381kh a() {
        return new C0381kh(this.b);
    }
}
