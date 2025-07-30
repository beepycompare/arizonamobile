package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.vh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0661vh extends AbstractC0327i6 {
    public final C0574s5 b;
    public final InterfaceC0636uh c;
    public final Y3 d;

    public C0661vh(C0574s5 c0574s5, InterfaceC0636uh interfaceC0636uh) {
        this(c0574s5, interfaceC0636uh, new Y3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0327i6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0711xh load(C0302h6 c0302h6) {
        C0711xh c0711xh = (C0711xh) super.load(c0302h6);
        c0711xh.m = ((C0586sh) c0302h6.componentArguments).f1054a;
        c0711xh.r = this.b.t.a();
        c0711xh.w = this.b.q.a();
        C0586sh c0586sh = (C0586sh) c0302h6.componentArguments;
        c0711xh.d = c0586sh.b;
        c0711xh.e = c0586sh.c;
        c0711xh.f = c0586sh.d;
        c0711xh.i = c0586sh.e;
        c0711xh.g = c0586sh.f;
        c0711xh.h = c0586sh.g;
        Boolean valueOf = Boolean.valueOf(c0586sh.h);
        InterfaceC0636uh interfaceC0636uh = this.c;
        c0711xh.j = valueOf;
        c0711xh.k = interfaceC0636uh;
        C0586sh c0586sh2 = (C0586sh) c0302h6.componentArguments;
        c0711xh.v = c0586sh2.j;
        C0267fm c0267fm = c0302h6.f879a;
        G4 g4 = c0267fm.n;
        c0711xh.n = g4.f447a;
        Le le = c0267fm.s;
        if (le != null) {
            c0711xh.s = le.f533a;
            c0711xh.t = le.b;
        }
        c0711xh.o = g4.b;
        c0711xh.q = c0267fm.e;
        c0711xh.p = c0267fm.k;
        Y3 y3 = this.d;
        Map<String, String> map = c0586sh2.i;
        V3 e = Ia.F.e();
        y3.getClass();
        c0711xh.u = Y3.a(map, c0267fm, e);
        return c0711xh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0711xh(this.b);
    }

    public C0661vh(C0574s5 c0574s5, InterfaceC0636uh interfaceC0636uh, Y3 y3) {
        super(c0574s5.getContext(), c0574s5.b().c());
        this.b = c0574s5;
        this.c = interfaceC0636uh;
        this.d = y3;
    }

    public final C0711xh a() {
        return new C0711xh(this.b);
    }
}
