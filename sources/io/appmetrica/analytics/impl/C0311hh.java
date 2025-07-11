package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0311hh extends AbstractC0185ch {
    public final ro b;

    public C0311hh(C0572s5 c0572s5) {
        this(c0572s5, c0572s5.t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        C0572s5 c0572s5 = this.f786a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            C9 c9 = c0572s5.n;
            c9.c.b(C0325i6.a(c0325i6, EnumC0628ub.EVENT_TYPE_FIRST_ACTIVATION));
        }
        ro roVar = this.b;
        synchronized (roVar) {
            so soVar = roVar.f1034a;
            soVar.a(soVar.a().put("first_event_done", true));
        }
        return false;
    }

    public C0311hh(C0572s5 c0572s5, ro roVar) {
        super(c0572s5);
        this.b = roVar;
    }
}
