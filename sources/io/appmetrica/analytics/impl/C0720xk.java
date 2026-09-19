package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0720xk extends AbstractC0303hh {
    public C0720xk(C0446n5 c0446n5) {
        super(c0446n5);
    }

    public static final void b(C0720xk c0720xk) {
        ap apVar = c0720xk.f1019a.t;
        synchronized (apVar) {
            JSONObject a2 = apVar.f896a.a();
            if (!a2.optBoolean("referrer_handled", false)) {
                apVar.f896a.a(a2.put("referrer_handled", true));
            }
            bp bpVar = apVar.f896a;
            bp.a(bpVar.f916a);
            bp.a(bpVar.b);
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        if (b()) {
            return false;
        }
        Fg u = Na.I.u();
        C0694wk c0694wk = new C0694wk(this);
        u.getClass();
        u.f549a.a(new C0512pj(c0694wk));
        return false;
    }

    public final boolean b() {
        boolean optBoolean;
        ap apVar = this.f1019a.t;
        synchronized (apVar) {
            optBoolean = apVar.f896a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }
}
