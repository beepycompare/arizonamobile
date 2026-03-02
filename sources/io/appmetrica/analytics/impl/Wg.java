package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Wg extends Rg {
    public final xo b;

    public Wg(X4 x4) {
        this(x4, x4.u());
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        X4 x4 = this.f767a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            C0372k9 c0372k9 = x4.n;
            c0372k9.c.b(P5.a(p5, EnumC0142bb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        xo xoVar = this.b;
        synchronized (xoVar) {
            yo yoVar = xoVar.f1312a;
            yoVar.a(yoVar.a().put("first_event_done", true));
        }
        return false;
    }

    public Wg(X4 x4, xo xoVar) {
        super(x4);
        this.b = xoVar;
    }
}
