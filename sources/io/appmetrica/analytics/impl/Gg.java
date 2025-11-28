package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Gg implements Ul, Na {

    /* renamed from: a  reason: collision with root package name */
    public final Context f493a;
    public final X4 b;
    public final Y4 c;
    public final Em d;
    public final Wa e;

    public Gg(Context context, X4 x4, C0664w4 c0664w4, InterfaceC0236f5 interfaceC0236f5, Y4 y4, Ll ll) {
        this.f493a = context;
        this.b = x4;
        this.c = y4;
        Em a2 = ll.a(context, x4, c0664w4.f1178a);
        this.d = a2;
        this.e = interfaceC0236f5.a(context, x4, c0664w4.b, a2);
        ll.a(x4, this);
    }

    public final X4 a() {
        return this.b;
    }

    public final Context b() {
        return this.f493a;
    }

    public final void a(InterfaceC0415m4 interfaceC0415m4) {
        this.c.f765a.add(interfaceC0415m4);
    }

    public final void b(InterfaceC0415m4 interfaceC0415m4) {
        this.c.f765a.remove(interfaceC0415m4);
    }

    @Override // io.appmetrica.analytics.impl.Ul
    public final void a(C0356jm c0356jm) {
        ((C0210e5) this.e).a(c0356jm);
    }

    @Override // io.appmetrica.analytics.impl.Ul
    public final void a(Nl nl, C0356jm c0356jm) {
        ((C0210e5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Na
    public final void a(C0664w4 c0664w4) {
        this.d.a(c0664w4.f1178a);
        this.e.a(c0664w4.b);
    }

    public final void a(W5 w5, C0664w4 c0664w4) {
        if (!D9.c.contains(EnumC0320ib.a(w5.d))) {
            this.e.a(c0664w4.b);
        }
        ((C0210e5) this.e).a(w5);
    }

    public Gg(Context context, X4 x4, C0664w4 c0664w4, InterfaceC0236f5 interfaceC0236f5) {
        this(context, x4, c0664w4, interfaceC0236f5, new Y4(), Ll.a());
    }
}
