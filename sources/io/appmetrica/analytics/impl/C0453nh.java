package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0453nh extends AbstractC0298hh {
    public final ap b;

    public C0453nh(C0441n5 c0441n5) {
        this(c0441n5, c0441n5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        C0441n5 c0441n5 = this.f1022a;
        if (!this.b.c()) {
            if (!this.b.d()) {
                E9 e9 = c0441n5.n;
                e9.c.b(C0235f6.a(c0235f6, Db.EVENT_TYPE_FIRST_ACTIVATION));
            }
            ap apVar = this.b;
            synchronized (apVar) {
                JSONObject a2 = apVar.f899a.a();
                if (!a2.optBoolean("first_event_done", false)) {
                    apVar.f899a.a(a2.put("first_event_done", true));
                }
                bp bpVar = apVar.f899a;
                bp.a(bpVar.f919a);
                bp.a(bpVar.b);
            }
        }
        return false;
    }

    public C0453nh(C0441n5 c0441n5, ap apVar) {
        super(c0441n5);
        this.b = apVar;
    }
}
