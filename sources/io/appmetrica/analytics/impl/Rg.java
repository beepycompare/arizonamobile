package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Rg implements InterfaceC0592sm, InterfaceC0323ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f750a;
    public final C0265g5 b;
    public final C0291h5 c;
    public final C0180cn d;
    public final InterfaceC0452nb e;

    public Rg(Context context, C0265g5 c0265g5, G4 g4, InterfaceC0472o5 interfaceC0472o5, C0291h5 c0291h5, C0359jm c0359jm) {
        this.f750a = context;
        this.b = c0265g5;
        this.c = c0291h5;
        C0180cn a2 = c0359jm.a(context, c0265g5, g4.f559a);
        this.d = a2;
        this.e = interfaceC0472o5.a(context, c0265g5, g4.b, a2);
        c0359jm.a(c0265g5, this);
    }

    public final C0265g5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f750a;
    }

    public final void a(InterfaceC0678w4 interfaceC0678w4) {
        this.c.f1009a.add(interfaceC0678w4);
    }

    public final void b(InterfaceC0678w4 interfaceC0678w4) {
        this.c.f1009a.remove(interfaceC0678w4);
        if (this.c.f1009a.isEmpty()) {
            ((InterfaceC0271gb) this.e).c();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0592sm
    public final void a(Hm hm) {
        ((C0446n5) this.e).a(hm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0592sm
    public final void a(EnumC0411lm enumC0411lm, Hm hm) {
        ((C0446n5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0323ib
    public final void a(G4 g4) {
        this.d.a(g4.f559a);
        this.e.a(g4.b);
    }

    public final void a(C0240f6 c0240f6, G4 g4) {
        if (!Q9.c.contains(Db.a(c0240f6.d))) {
            this.e.a(g4.b);
        }
        ((C0446n5) this.e).a(c0240f6);
    }

    public Rg(Context context, C0265g5 c0265g5, G4 g4, InterfaceC0472o5 interfaceC0472o5) {
        this(context, c0265g5, g4, interfaceC0472o5, new C0291h5(), C0359jm.a());
    }
}
