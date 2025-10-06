package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0589sh extends AbstractC0463nh {
    public final Do b;

    public C0589sh(C0652v5 c0652v5) {
        this(c0652v5, c0652v5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        C0652v5 c0652v5 = this.f1006a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            K9 k9 = c0652v5.n;
            k9.c.b(C0478o6.a(c0478o6, Bb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        Do r5 = this.b;
        synchronized (r5) {
            Eo eo = r5.f418a;
            eo.a(eo.a().put("first_event_done", true));
        }
        return false;
    }

    public C0589sh(C0652v5 c0652v5, Do r2) {
        super(c0652v5);
        this.b = r2;
    }
}
