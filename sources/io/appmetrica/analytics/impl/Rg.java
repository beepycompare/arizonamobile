package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Rg implements InterfaceC0593sm, InterfaceC0324ib {

    /* renamed from: a  reason: collision with root package name */
    public final Context f750a;
    public final C0266g5 b;
    public final C0292h5 c;
    public final C0181cn d;
    public final InterfaceC0453nb e;

    public Rg(Context context, C0266g5 c0266g5, G4 g4, InterfaceC0473o5 interfaceC0473o5, C0292h5 c0292h5, C0360jm c0360jm) {
        this.f750a = context;
        this.b = c0266g5;
        this.c = c0292h5;
        C0181cn a2 = c0360jm.a(context, c0266g5, g4.f559a);
        this.d = a2;
        this.e = interfaceC0473o5.a(context, c0266g5, g4.b, a2);
        c0360jm.a(c0266g5, this);
    }

    public final C0266g5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f750a;
    }

    public final void a(InterfaceC0679w4 interfaceC0679w4) {
        this.c.f1009a.add(interfaceC0679w4);
    }

    public final void b(InterfaceC0679w4 interfaceC0679w4) {
        this.c.f1009a.remove(interfaceC0679w4);
        if (this.c.f1009a.isEmpty()) {
            ((InterfaceC0272gb) this.e).c();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0593sm
    public final void a(Hm hm) {
        ((C0447n5) this.e).a(hm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0593sm
    public final void a(EnumC0412lm enumC0412lm, Hm hm) {
        ((C0447n5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0324ib
    public final void a(G4 g4) {
        this.d.a(g4.f559a);
        this.e.a(g4.b);
    }

    public final void a(C0241f6 c0241f6, G4 g4) {
        if (!Q9.c.contains(Db.a(c0241f6.d))) {
            this.e.a(g4.b);
        }
        ((C0447n5) this.e).a(c0241f6);
    }

    public Rg(Context context, C0266g5 c0266g5, G4 g4, InterfaceC0473o5 interfaceC0473o5) {
        this(context, c0266g5, g4, interfaceC0473o5, new C0292h5(), C0360jm.a());
    }
}
