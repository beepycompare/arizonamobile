package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.th  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0609th extends AbstractC0250f6 {
    public final C0572s5 b;
    public final InterfaceC0584sh c;
    public final Y3 d;

    public C0609th(C0572s5 c0572s5, InterfaceC0584sh interfaceC0584sh) {
        this(c0572s5, interfaceC0584sh, new Y3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0250f6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0659vh load(C0225e6 c0225e6) {
        C0659vh c0659vh = (C0659vh) super.load(c0225e6);
        c0659vh.m = ((C0535qh) c0225e6.componentArguments).f1007a;
        c0659vh.r = this.b.t.a();
        c0659vh.w = this.b.q.a();
        C0535qh c0535qh = (C0535qh) c0225e6.componentArguments;
        c0659vh.d = c0535qh.b;
        c0659vh.e = c0535qh.c;
        c0659vh.f = c0535qh.d;
        c0659vh.i = c0535qh.e;
        c0659vh.g = c0535qh.f;
        c0659vh.h = c0535qh.g;
        Boolean valueOf = Boolean.valueOf(c0535qh.h);
        InterfaceC0584sh interfaceC0584sh = this.c;
        c0659vh.j = valueOf;
        c0659vh.k = interfaceC0584sh;
        C0535qh c0535qh2 = (C0535qh) c0225e6.componentArguments;
        c0659vh.v = c0535qh2.j;
        C0190cm c0190cm = c0225e6.f817a;
        G4 g4 = c0190cm.n;
        c0659vh.n = g4.f438a;
        Je je = c0190cm.s;
        if (je != null) {
            c0659vh.s = je.f492a;
            c0659vh.t = je.b;
        }
        c0659vh.o = g4.b;
        c0659vh.q = c0190cm.e;
        c0659vh.p = c0190cm.k;
        Y3 y3 = this.d;
        Map<String, String> map = c0535qh2.i;
        V3 e = Ga.F.e();
        y3.getClass();
        c0659vh.u = Y3.a(map, c0190cm, e);
        return c0659vh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0659vh(this.b);
    }

    public C0609th(C0572s5 c0572s5, InterfaceC0584sh interfaceC0584sh, Y3 y3) {
        super(c0572s5.getContext(), c0572s5.b().c());
        this.b = c0572s5;
        this.c = interfaceC0584sh;
        this.d = y3;
    }

    public final C0659vh a() {
        return new C0659vh(this.b);
    }
}
