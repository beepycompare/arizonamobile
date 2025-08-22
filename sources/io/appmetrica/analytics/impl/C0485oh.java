package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0485oh extends AbstractC0358jh {
    public final zo b;

    public C0485oh(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        C0572s5 c0572s5 = this.f925a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            H9 h9 = c0572s5.n;
            h9.c.b(C0399l6.a(c0399l6, EnumC0728yb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        zo zoVar = this.b;
        synchronized (zoVar) {
            Ao ao = zoVar.f1187a;
            ao.a(ao.a().put("first_event_done", true));
        }
        return false;
    }

    public C0485oh(C0572s5 c0572s5, zo zoVar) {
        super(c0572s5);
        this.b = zoVar;
    }
}
