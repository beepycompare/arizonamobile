package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Xg extends Sg {
    public final yo b;

    public Xg(Y4 y4) {
        this(y4, y4.u());
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Y4 y4 = this.f762a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            C0394l9 c0394l9 = y4.n;
            c0394l9.c.b(Q5.a(q5, EnumC0164cb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        yo yoVar = this.b;
        synchronized (yoVar) {
            zo zoVar = yoVar.f1308a;
            zoVar.a(zoVar.a().put("first_event_done", true));
        }
        return false;
    }

    public Xg(Y4 y4, yo yoVar) {
        super(y4);
        this.b = yoVar;
    }
}
