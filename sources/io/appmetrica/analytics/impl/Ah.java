package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ah extends AbstractC0322i6 {
    public final C0572s5 b;
    public final InterfaceC0759zh c;
    public final Y3 d;

    public Ah(C0572s5 c0572s5, InterfaceC0759zh interfaceC0759zh) {
        this(c0572s5, interfaceC0759zh, new Y3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0322i6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final Ch load(C0296h6 c0296h6) {
        Ch ch = (Ch) super.load(c0296h6);
        ch.m = ((C0709xh) c0296h6.componentArguments).f1142a;
        ch.r = this.b.t.a();
        ch.w = this.b.q.a();
        C0709xh c0709xh = (C0709xh) c0296h6.componentArguments;
        ch.d = c0709xh.b;
        ch.e = c0709xh.c;
        ch.f = c0709xh.d;
        ch.i = c0709xh.e;
        ch.g = c0709xh.f;
        ch.h = c0709xh.g;
        Boolean valueOf = Boolean.valueOf(c0709xh.h);
        InterfaceC0759zh interfaceC0759zh = this.c;
        ch.j = valueOf;
        ch.k = interfaceC0759zh;
        C0709xh c0709xh2 = (C0709xh) c0296h6.componentArguments;
        ch.v = c0709xh2.j;
        C0389km c0389km = c0296h6.f882a;
        G4 g4 = c0389km.n;
        ch.n = g4.f448a;
        Ne ne = c0389km.s;
        if (ne != null) {
            ch.s = ne.f578a;
            ch.t = ne.b;
        }
        ch.o = g4.b;
        ch.q = c0389km.e;
        ch.p = c0389km.k;
        Y3 y3 = this.d;
        Map<String, String> map = c0709xh2.i;
        V3 e = Ka.F.e();
        y3.getClass();
        ch.u = Y3.a(map, c0389km, e);
        return ch;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new Ch(this.b);
    }

    public Ah(C0572s5 c0572s5, InterfaceC0759zh interfaceC0759zh, Y3 y3) {
        super(c0572s5.getContext(), c0572s5.b().c());
        this.b = c0572s5;
        this.c = interfaceC0759zh;
        this.d = y3;
    }

    public final Ch a() {
        return new Ch(this.b);
    }
}
