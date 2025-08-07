package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Og implements Ql, InterfaceC0154bb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f580a;
    public final C0401l5 b;
    public final C0426m5 c;
    public final Bm d;
    public final InterfaceC0382kb e;

    public Og(Context context, C0401l5 c0401l5, K4 k4, InterfaceC0600t5 interfaceC0600t5, C0426m5 c0426m5, Hl hl) {
        this.f580a = context;
        this.b = c0401l5;
        this.c = c0426m5;
        Bm a2 = hl.a(context, c0401l5, k4.f515a);
        this.d = a2;
        this.e = interfaceC0600t5.a(context, c0401l5, k4.b, a2);
        hl.a(c0401l5, this);
    }

    public final C0401l5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f580a;
    }

    public final void a(A4 a4) {
        this.c.f949a.add(a4);
    }

    public final void b(A4 a4) {
        this.c.f949a.remove(a4);
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(C0268fm c0268fm) {
        this.e.a(c0268fm);
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0268fm c0268fm) {
        ((C0575s5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0154bb
    public final void a(K4 k4) {
        this.d.a(k4.f515a);
        this.e.a(k4.b);
    }

    public final void a(C0402l6 c0402l6, K4 k4) {
        if (!R9.c.contains(EnumC0681wb.a(c0402l6.d))) {
            this.e.a(k4.b);
        }
        ((C0575s5) this.e).a(c0402l6);
    }

    public Og(Context context, C0401l5 c0401l5, K4 k4, InterfaceC0600t5 interfaceC0600t5) {
        this(context, c0401l5, k4, interfaceC0600t5, new C0426m5(), Hl.a());
    }
}
