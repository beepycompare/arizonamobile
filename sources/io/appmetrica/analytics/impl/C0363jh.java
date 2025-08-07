package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0363jh extends AbstractC0237eh {
    public final uo b;

    public C0363jh(C0575s5 c0575s5) {
        this(c0575s5, c0575s5.t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        C0575s5 c0575s5 = this.f831a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            F9 f9 = c0575s5.n;
            f9.c.b(C0402l6.a(c0402l6, EnumC0681wb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        uo uoVar = this.b;
        synchronized (uoVar) {
            vo voVar = uoVar.f1091a;
            voVar.a(voVar.a().put("first_event_done", true));
        }
        return false;
    }

    public C0363jh(C0575s5 c0575s5, uo uoVar) {
        super(c0575s5);
        this.b = uoVar;
    }
}
