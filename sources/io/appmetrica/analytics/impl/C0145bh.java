package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0145bh extends Wg {
    public final zo b;

    public C0145bh(C0210e5 c0210e5) {
        this(c0210e5, c0210e5.u());
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        C0210e5 c0210e5 = this.f744a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            C0544r9 c0544r9 = c0210e5.n;
            c0544r9.c.b(W5.a(w5, EnumC0320ib.EVENT_TYPE_FIRST_ACTIVATION));
        }
        zo zoVar = this.b;
        synchronized (zoVar) {
            Ao ao = zoVar.f1238a;
            ao.a(ao.a().put("first_event_done", true));
        }
        return false;
    }

    public C0145bh(C0210e5 c0210e5, zo zoVar) {
        super(c0210e5);
        this.b = zoVar;
    }
}
