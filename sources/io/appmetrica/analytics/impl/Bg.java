package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Bg implements Ql, Ga {

    /* renamed from: a  reason: collision with root package name */
    public final Context f522a;
    public final Q4 b;
    public final R4 c;
    public final Am d;
    public final Pa e;

    public Bg(Context context, Q4 q4, C0493p4 c0493p4, Y4 y4, R4 r4, Hl hl) {
        this.f522a = context;
        this.b = q4;
        this.c = r4;
        Am a2 = hl.a(context, q4, c0493p4.f1168a);
        this.d = a2;
        this.e = y4.a(context, q4, c0493p4.b, a2);
        hl.a(q4, this);
    }

    public final Q4 a() {
        return this.b;
    }

    public final Context b() {
        return this.f522a;
    }

    public final void a(InterfaceC0239f4 interfaceC0239f4) {
        this.c.f761a.add(interfaceC0239f4);
    }

    public final void b(InterfaceC0239f4 interfaceC0239f4) {
        this.c.f761a.remove(interfaceC0239f4);
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(C0257fm c0257fm) {
        ((X4) this.e).a(c0257fm);
    }

    @Override // io.appmetrica.analytics.impl.Ql
    public final void a(Jl jl, C0257fm c0257fm) {
        ((X4) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Ga
    public final void a(C0493p4 c0493p4) {
        this.d.a(c0493p4.f1168a);
        this.e.a(c0493p4.b);
    }

    public final void a(P5 p5, C0493p4 c0493p4) {
        if (!AbstractC0672w9.c.contains(EnumC0143bb.a(p5.d))) {
            this.e.a(c0493p4.b);
        }
        ((X4) this.e).a(p5);
    }

    public Bg(Context context, Q4 q4, C0493p4 c0493p4, Y4 y4) {
        this(context, q4, c0493p4, y4, new R4(), Hl.a());
    }
}
