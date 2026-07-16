package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Rg implements InterfaceC0594sm, InterfaceC0325ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f750a;
    public final C0267g5 b;
    public final C0293h5 c;
    public final C0182cn d;
    public final InterfaceC0454nb e;

    public Rg(Context context, C0267g5 c0267g5, G4 g4, InterfaceC0474o5 interfaceC0474o5, C0293h5 c0293h5, C0361jm c0361jm) {
        this.f750a = context;
        this.b = c0267g5;
        this.c = c0293h5;
        C0182cn a2 = c0361jm.a(context, c0267g5, g4.f559a);
        this.d = a2;
        this.e = interfaceC0474o5.a(context, c0267g5, g4.b, a2);
        c0361jm.a(c0267g5, this);
    }

    public final C0267g5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f750a;
    }

    public final void a(InterfaceC0680w4 interfaceC0680w4) {
        this.c.f1009a.add(interfaceC0680w4);
    }

    public final void b(InterfaceC0680w4 interfaceC0680w4) {
        this.c.f1009a.remove(interfaceC0680w4);
        if (this.c.f1009a.isEmpty()) {
            ((InterfaceC0273gb) this.e).c();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0594sm
    public final void a(Hm hm) {
        ((C0448n5) this.e).a(hm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0594sm
    public final void a(EnumC0413lm enumC0413lm, Hm hm) {
        ((C0448n5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0325ib
    public final void a(G4 g4) {
        this.d.a(g4.f559a);
        this.e.a(g4.b);
    }

    public final void a(C0242f6 c0242f6, G4 g4) {
        if (!Q9.c.contains(Db.a(c0242f6.d))) {
            this.e.a(g4.b);
        }
        ((C0448n5) this.e).a(c0242f6);
    }

    public Rg(Context context, C0267g5 c0267g5, G4 g4, InterfaceC0474o5 interfaceC0474o5) {
        this(context, c0267g5, g4, interfaceC0474o5, new C0293h5(), C0361jm.a());
    }
}
