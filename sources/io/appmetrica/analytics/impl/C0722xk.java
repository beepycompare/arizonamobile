package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0722xk extends AbstractC0305hh {
    public C0722xk(C0448n5 c0448n5) {
        super(c0448n5);
    }

    public static final void b(C0722xk c0722xk) {
        ap apVar = c0722xk.f1016a.t;
        synchronized (apVar) {
            JSONObject a2 = apVar.f893a.a();
            if (!a2.optBoolean("referrer_handled", false)) {
                apVar.f893a.a(a2.put("referrer_handled", true));
            }
            bp bpVar = apVar.f893a;
            bp.a(bpVar.f913a);
            bp.a(bpVar.b);
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        if (b()) {
            return false;
        }
        Fg u = Na.I.u();
        C0696wk c0696wk = new C0696wk(this);
        u.getClass();
        u.f546a.a(new C0514pj(c0696wk));
        return false;
    }

    public final boolean b() {
        boolean optBoolean;
        ap apVar = this.f1016a.t;
        synchronized (apVar) {
            optBoolean = apVar.f893a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }
}
