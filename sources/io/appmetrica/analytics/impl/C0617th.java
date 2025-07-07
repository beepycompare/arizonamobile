package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.th  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0617th extends AbstractC0258f6 {
    public final C0580s5 b;
    public final InterfaceC0592sh c;
    public final Y3 d;

    public C0617th(C0580s5 c0580s5, InterfaceC0592sh interfaceC0592sh) {
        this(c0580s5, interfaceC0592sh, new Y3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0258f6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: b */
    public final C0667vh load(C0233e6 c0233e6) {
        C0667vh c0667vh = (C0667vh) super.load(c0233e6);
        c0667vh.m = ((C0543qh) c0233e6.componentArguments).f1006a;
        c0667vh.r = this.b.t.a();
        c0667vh.w = this.b.q.a();
        C0543qh c0543qh = (C0543qh) c0233e6.componentArguments;
        c0667vh.d = c0543qh.b;
        c0667vh.e = c0543qh.c;
        c0667vh.f = c0543qh.d;
        c0667vh.i = c0543qh.e;
        c0667vh.g = c0543qh.f;
        c0667vh.h = c0543qh.g;
        Boolean valueOf = Boolean.valueOf(c0543qh.h);
        InterfaceC0592sh interfaceC0592sh = this.c;
        c0667vh.j = valueOf;
        c0667vh.k = interfaceC0592sh;
        C0543qh c0543qh2 = (C0543qh) c0233e6.componentArguments;
        c0667vh.v = c0543qh2.j;
        C0198cm c0198cm = c0233e6.f816a;
        G4 g4 = c0198cm.n;
        c0667vh.n = g4.f437a;
        Je je = c0198cm.s;
        if (je != null) {
            c0667vh.s = je.f491a;
            c0667vh.t = je.b;
        }
        c0667vh.o = g4.b;
        c0667vh.q = c0198cm.e;
        c0667vh.p = c0198cm.k;
        Y3 y3 = this.d;
        Map<String, String> map = c0543qh2.i;
        V3 e = Ga.F.e();
        y3.getClass();
        c0667vh.u = Y3.a(map, c0198cm, e);
        return c0667vh;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader
    public final BaseRequestConfig createBlankConfig() {
        return new C0667vh(this.b);
    }

    public C0617th(C0580s5 c0580s5, InterfaceC0592sh interfaceC0592sh, Y3 y3) {
        super(c0580s5.getContext(), c0580s5.b().c());
        this.b = c0580s5;
        this.c = interfaceC0592sh;
        this.d = y3;
    }

    public final C0667vh a() {
        return new C0667vh(this.b);
    }
}
