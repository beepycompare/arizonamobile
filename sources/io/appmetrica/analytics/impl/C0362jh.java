package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0362jh extends AbstractC0236eh {
    public final uo b;

    public C0362jh(C0574s5 c0574s5) {
        this(c0574s5, c0574s5.t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        C0574s5 c0574s5 = this.f832a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            F9 f9 = c0574s5.n;
            f9.c.b(C0401l6.a(c0401l6, EnumC0680wb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        uo uoVar = this.b;
        synchronized (uoVar) {
            vo voVar = uoVar.f1092a;
            voVar.a(voVar.a().put("first_event_done", true));
        }
        return false;
    }

    public C0362jh(C0574s5 c0574s5, uo uoVar) {
        super(c0574s5);
        this.b = uoVar;
    }
}
