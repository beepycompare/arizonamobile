package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Xg implements Zl, InterfaceC0276gb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f745a;
    public final C0477o5 b;
    public final C0503p5 c;
    public final Km d;
    public final InterfaceC0509pb e;

    public Xg(Context context, C0477o5 c0477o5, N4 n4, InterfaceC0677w5 interfaceC0677w5, C0503p5 c0503p5, Ql ql) {
        this.f745a = context;
        this.b = c0477o5;
        this.c = c0503p5;
        Km a2 = ql.a(context, c0477o5, n4.f589a);
        this.d = a2;
        this.e = interfaceC0677w5.a(context, c0477o5, n4.b, a2);
        ql.a(c0477o5, this);
    }

    public final C0477o5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f745a;
    }

    public final void a(D4 d4) {
        this.c.f1032a.add(d4);
    }

    public final void b(D4 d4) {
        this.c.f1032a.remove(d4);
    }

    @Override // io.appmetrica.analytics.impl.Zl
    public final void a(C0494om c0494om) {
        this.e.a(c0494om);
    }

    @Override // io.appmetrica.analytics.impl.Zl
    public final void a(Sl sl, C0494om c0494om) {
        ((C0652v5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0276gb
    public final void a(N4 n4) {
        this.d.a(n4.f589a);
        this.e.a(n4.b);
    }

    public final void a(C0478o6 c0478o6, N4 n4) {
        if (!W9.c.contains(Bb.a(c0478o6.d))) {
            this.e.a(n4.b);
        }
        ((C0652v5) this.e).a(c0478o6);
    }

    public Xg(Context context, C0477o5 c0477o5, N4 n4, InterfaceC0677w5 interfaceC0677w5) {
        this(context, c0477o5, n4, interfaceC0677w5, new C0503p5(), Ql.a());
    }
}
