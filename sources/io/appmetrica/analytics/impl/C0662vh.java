package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.vh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0662vh extends AbstractC0328i6 {
    public final C0575s5 b;
    public final InterfaceC0637uh c;
    public final Y3 d;

    public C0662vh(C0575s5 c0575s5, InterfaceC0637uh interfaceC0637uh) {
        this(c0575s5, interfaceC0637uh, new Y3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0328i6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0712xh load(C0303h6 c0303h6) {
        C0712xh c0712xh = (C0712xh) super.load(c0303h6);
        c0712xh.m = ((C0587sh) c0303h6.componentArguments).f1053a;
        c0712xh.r = this.b.t.a();
        c0712xh.w = this.b.q.a();
        C0587sh c0587sh = (C0587sh) c0303h6.componentArguments;
        c0712xh.d = c0587sh.b;
        c0712xh.e = c0587sh.c;
        c0712xh.f = c0587sh.d;
        c0712xh.i = c0587sh.e;
        c0712xh.g = c0587sh.f;
        c0712xh.h = c0587sh.g;
        Boolean valueOf = Boolean.valueOf(c0587sh.h);
        InterfaceC0637uh interfaceC0637uh = this.c;
        c0712xh.j = valueOf;
        c0712xh.k = interfaceC0637uh;
        C0587sh c0587sh2 = (C0587sh) c0303h6.componentArguments;
        c0712xh.v = c0587sh2.j;
        C0268fm c0268fm = c0303h6.f878a;
        G4 g4 = c0268fm.n;
        c0712xh.n = g4.f446a;
        Le le = c0268fm.s;
        if (le != null) {
            c0712xh.s = le.f532a;
            c0712xh.t = le.b;
        }
        c0712xh.o = g4.b;
        c0712xh.q = c0268fm.e;
        c0712xh.p = c0268fm.k;
        Y3 y3 = this.d;
        Map<String, String> map = c0587sh2.i;
        V3 e = Ia.F.e();
        y3.getClass();
        c0712xh.u = Y3.a(map, c0268fm, e);
        return c0712xh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0712xh(this.b);
    }

    public C0662vh(C0575s5 c0575s5, InterfaceC0637uh interfaceC0637uh, Y3 y3) {
        super(c0575s5.getContext(), c0575s5.b().c());
        this.b = c0575s5;
        this.c = interfaceC0637uh;
        this.d = y3;
    }

    public final C0712xh a() {
        return new C0712xh(this.b);
    }
}
