package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Xg implements Zl, InterfaceC0275gb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f744a;
    public final C0476o5 b;
    public final C0502p5 c;
    public final Km d;
    public final InterfaceC0508pb e;

    public Xg(Context context, C0476o5 c0476o5, N4 n4, InterfaceC0676w5 interfaceC0676w5, C0502p5 c0502p5, Ql ql) {
        this.f744a = context;
        this.b = c0476o5;
        this.c = c0502p5;
        Km a2 = ql.a(context, c0476o5, n4.f588a);
        this.d = a2;
        this.e = interfaceC0676w5.a(context, c0476o5, n4.b, a2);
        ql.a(c0476o5, this);
    }

    public final C0476o5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f744a;
    }

    public final void a(D4 d4) {
        this.c.f1031a.add(d4);
    }

    public final void b(D4 d4) {
        this.c.f1031a.remove(d4);
    }

    @Override // io.appmetrica.analytics.impl.Zl
    public final void a(C0493om c0493om) {
        this.e.a(c0493om);
    }

    @Override // io.appmetrica.analytics.impl.Zl
    public final void a(Sl sl, C0493om c0493om) {
        ((C0651v5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0275gb
    public final void a(N4 n4) {
        this.d.a(n4.f588a);
        this.e.a(n4.b);
    }

    public final void a(C0477o6 c0477o6, N4 n4) {
        if (!W9.c.contains(Bb.a(c0477o6.d))) {
            this.e.a(n4.b);
        }
        ((C0651v5) this.e).a(c0477o6);
    }

    public Xg(Context context, C0476o5 c0476o5, N4 n4, InterfaceC0676w5 interfaceC0676w5) {
        this(context, c0476o5, n4, interfaceC0676w5, new C0502p5(), Ql.a());
    }
}
