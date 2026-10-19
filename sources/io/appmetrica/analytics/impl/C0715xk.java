package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0715xk extends AbstractC0298hh {
    public C0715xk(C0441n5 c0441n5) {
        super(c0441n5);
    }

    public static final void b(C0715xk c0715xk) {
        ap apVar = c0715xk.f1022a.t;
        synchronized (apVar) {
            JSONObject a2 = apVar.f899a.a();
            if (!a2.optBoolean("referrer_handled", false)) {
                apVar.f899a.a(a2.put("referrer_handled", true));
            }
            bp bpVar = apVar.f899a;
            bp.a(bpVar.f919a);
            bp.a(bpVar.b);
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        if (b()) {
            return false;
        }
        Fg u = Na.I.u();
        C0689wk c0689wk = new C0689wk(this);
        u.getClass();
        u.f552a.a(new C0507pj(c0689wk));
        return false;
    }

    public final boolean b() {
        boolean optBoolean;
        ap apVar = this.f1022a.t;
        synchronized (apVar) {
            optBoolean = apVar.f899a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }
}
