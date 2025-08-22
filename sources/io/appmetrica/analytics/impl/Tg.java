package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Tg implements Vl, InterfaceC0198db {

    /* renamed from: a  reason: collision with root package name */
    public final Context f663a;
    public final C0398l5 b;
    public final C0423m5 c;
    public final Gm d;
    public final InterfaceC0429mb e;

    public Tg(Context context, C0398l5 c0398l5, K4 k4, InterfaceC0597t5 interfaceC0597t5, C0423m5 c0423m5, Ml ml) {
        this.f663a = context;
        this.b = c0398l5;
        this.c = c0423m5;
        Gm a2 = ml.a(context, c0398l5, k4.f524a);
        this.d = a2;
        this.e = interfaceC0597t5.a(context, c0398l5, k4.b, a2);
        ml.a(c0398l5, this);
    }

    public final C0398l5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f663a;
    }

    public final void a(A4 a4) {
        this.c.f964a.add(a4);
    }

    public final void b(A4 a4) {
        this.c.f964a.remove(a4);
    }

    @Override // io.appmetrica.analytics.impl.Vl
    public final void a(C0389km c0389km) {
        this.e.a(c0389km);
    }

    @Override // io.appmetrica.analytics.impl.Vl
    public final void a(Ol ol, C0389km c0389km) {
        ((C0572s5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0198db
    public final void a(K4 k4) {
        this.d.a(k4.f524a);
        this.e.a(k4.b);
    }

    public final void a(C0399l6 c0399l6, K4 k4) {
        if (!T9.c.contains(EnumC0728yb.a(c0399l6.d))) {
            this.e.a(k4.b);
        }
        ((C0572s5) this.e).a(c0399l6);
    }

    public Tg(Context context, C0398l5 c0398l5, K4 k4, InterfaceC0597t5 interfaceC0597t5) {
        this(context, c0398l5, k4, interfaceC0597t5, new C0423m5(), Ml.a());
    }
}
