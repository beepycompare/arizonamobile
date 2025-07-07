package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Mg implements Nl, Za {

    /* renamed from: a  reason: collision with root package name */
    public final Context f537a;
    public final C0406l5 b;
    public final C0431m5 c;
    public final C0747ym d;
    public final InterfaceC0338ib e;

    public Mg(Context context, C0406l5 c0406l5, K4 k4, InterfaceC0605t5 interfaceC0605t5, C0431m5 c0431m5, El el) {
        this.f537a = context;
        this.b = c0406l5;
        this.c = c0431m5;
        C0747ym a2 = el.a(context, c0406l5, k4.f500a);
        this.d = a2;
        this.e = interfaceC0605t5.a(context, c0406l5, k4.b, a2);
        el.a(c0406l5, this);
    }

    public final C0406l5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f537a;
    }

    public final void a(A4 a4) {
        this.c.f933a.add(a4);
    }

    public final void b(A4 a4) {
        this.c.f933a.remove(a4);
    }

    @Override // io.appmetrica.analytics.impl.Nl
    public final void a(C0198cm c0198cm) {
        this.e.a(c0198cm);
    }

    @Override // io.appmetrica.analytics.impl.Nl
    public final void a(Gl gl, C0198cm c0198cm) {
        ((C0580s5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(K4 k4) {
        this.d.a(k4.f500a);
        this.e.a(k4.b);
    }

    public final void a(C0333i6 c0333i6, K4 k4) {
        if (!O9.c.contains(EnumC0636ub.a(c0333i6.d))) {
            this.e.a(k4.b);
        }
        ((C0580s5) this.e).a(c0333i6);
    }

    public Mg(Context context, C0406l5 c0406l5, K4 k4, InterfaceC0605t5 interfaceC0605t5) {
        this(context, c0406l5, k4, interfaceC0605t5, new C0431m5(), El.a());
    }
}
