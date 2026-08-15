package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0721xk extends AbstractC0304hh {
    public C0721xk(C0447n5 c0447n5) {
        super(c0447n5);
    }

    public static final void b(C0721xk c0721xk) {
        ap apVar = c0721xk.f1019a.t;
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

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        if (b()) {
            return false;
        }
        Fg u = Na.I.u();
        C0695wk c0695wk = new C0695wk(this);
        u.getClass();
        u.f549a.a(new C0513pj(c0695wk));
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
