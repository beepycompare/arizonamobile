package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Cg implements Rl, Ha {

    /* renamed from: a  reason: collision with root package name */
    public final Context f516a;
    public final R4 b;
    public final S4 c;
    public final Bm d;
    public final Qa e;

    public Cg(Context context, R4 r4, C0514q4 c0514q4, Z4 z4, S4 s4, Il il) {
        this.f516a = context;
        this.b = r4;
        this.c = s4;
        Bm a2 = il.a(context, r4, c0514q4.f1163a);
        this.d = a2;
        this.e = z4.a(context, r4, c0514q4.b, a2);
        il.a(r4, this);
    }

    public final R4 a() {
        return this.b;
    }

    public final Context b() {
        return this.f516a;
    }

    public final void a(InterfaceC0260g4 interfaceC0260g4) {
        this.c.f755a.add(interfaceC0260g4);
    }

    public final void b(InterfaceC0260g4 interfaceC0260g4) {
        this.c.f755a.remove(interfaceC0260g4);
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final void a(C0278gm c0278gm) {
        ((Y4) this.e).a(c0278gm);
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final void a(Kl kl, C0278gm c0278gm) {
        ((Y4) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final void a(C0514q4 c0514q4) {
        this.d.a(c0514q4.f1163a);
        this.e.a(c0514q4.b);
    }

    public final void a(Q5 q5, C0514q4 c0514q4) {
        if (!AbstractC0693x9.c.contains(EnumC0164cb.a(q5.d))) {
            this.e.a(c0514q4.b);
        }
        ((Y4) this.e).a(q5);
    }

    public Cg(Context context, R4 r4, C0514q4 c0514q4, Z4 z4) {
        this(context, r4, c0514q4, z4, new S4(), Il.a());
    }
}
