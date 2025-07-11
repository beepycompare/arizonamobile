package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Mg implements Nl, Za {

    /* renamed from: a  reason: collision with root package name */
    public final Context f538a;
    public final C0398l5 b;
    public final C0423m5 c;
    public final C0739ym d;
    public final InterfaceC0330ib e;

    public Mg(Context context, C0398l5 c0398l5, K4 k4, InterfaceC0597t5 interfaceC0597t5, C0423m5 c0423m5, El el) {
        this.f538a = context;
        this.b = c0398l5;
        this.c = c0423m5;
        C0739ym a2 = el.a(context, c0398l5, k4.f501a);
        this.d = a2;
        this.e = interfaceC0597t5.a(context, c0398l5, k4.b, a2);
        el.a(c0398l5, this);
    }

    public final C0398l5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f538a;
    }

    public final void a(A4 a4) {
        this.c.f934a.add(a4);
    }

    public final void b(A4 a4) {
        this.c.f934a.remove(a4);
    }

    @Override // io.appmetrica.analytics.impl.Nl
    public final void a(C0190cm c0190cm) {
        this.e.a(c0190cm);
    }

    @Override // io.appmetrica.analytics.impl.Nl
    public final void a(Gl gl, C0190cm c0190cm) {
        ((C0572s5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final void a(K4 k4) {
        this.d.a(k4.f501a);
        this.e.a(k4.b);
    }

    public final void a(C0325i6 c0325i6, K4 k4) {
        if (!O9.c.contains(EnumC0628ub.a(c0325i6.d))) {
            this.e.a(k4.b);
        }
        ((C0572s5) this.e).a(c0325i6);
    }

    public Mg(Context context, C0398l5 c0398l5, K4 k4, InterfaceC0597t5 interfaceC0597t5) {
        this(context, c0398l5, k4, interfaceC0597t5, new C0423m5(), El.a());
    }
}
