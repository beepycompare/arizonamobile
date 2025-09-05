package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0588sh extends AbstractC0462nh {
    public final Do b;

    public C0588sh(C0651v5 c0651v5) {
        this(c0651v5, c0651v5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        C0651v5 c0651v5 = this.f1001a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            K9 k9 = c0651v5.n;
            k9.c.b(C0477o6.a(c0477o6, Bb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        Do r5 = this.b;
        synchronized (r5) {
            Eo eo = r5.f413a;
            eo.a(eo.a().put("first_event_done", true));
        }
        return false;
    }

    public C0588sh(C0651v5 c0651v5, Do r2) {
        super(c0651v5);
        this.b = r2;
    }
}
