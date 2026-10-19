package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Rg implements InterfaceC0587sm, InterfaceC0318ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f753a;
    public final C0260g5 b;
    public final C0286h5 c;
    public final C0175cn d;
    public final InterfaceC0447nb e;

    public Rg(Context context, C0260g5 c0260g5, G4 g4, InterfaceC0467o5 interfaceC0467o5, C0286h5 c0286h5, C0354jm c0354jm) {
        this.f753a = context;
        this.b = c0260g5;
        this.c = c0286h5;
        C0175cn a2 = c0354jm.a(context, c0260g5, g4.f562a);
        this.d = a2;
        this.e = interfaceC0467o5.a(context, c0260g5, g4.b, a2);
        c0354jm.a(c0260g5, this);
    }

    public final C0260g5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f753a;
    }

    public final void a(InterfaceC0673w4 interfaceC0673w4) {
        this.c.f1012a.add(interfaceC0673w4);
    }

    public final void b(InterfaceC0673w4 interfaceC0673w4) {
        this.c.f1012a.remove(interfaceC0673w4);
        if (this.c.f1012a.isEmpty()) {
            ((InterfaceC0266gb) this.e).c();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587sm
    public final void a(Hm hm) {
        ((C0441n5) this.e).a(hm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587sm
    public final void a(EnumC0406lm enumC0406lm, Hm hm) {
        ((C0441n5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0318ib
    public final void a(G4 g4) {
        this.d.a(g4.f562a);
        this.e.a(g4.b);
    }

    public final void a(C0235f6 c0235f6, G4 g4) {
        if (!Q9.c.contains(Db.a(c0235f6.d))) {
            this.e.a(g4.b);
        }
        ((C0441n5) this.e).a(c0235f6);
    }

    public Rg(Context context, C0260g5 c0260g5, G4 g4, InterfaceC0467o5 interfaceC0467o5) {
        this(context, c0260g5, g4, interfaceC0467o5, new C0286h5(), C0354jm.a());
    }
}
