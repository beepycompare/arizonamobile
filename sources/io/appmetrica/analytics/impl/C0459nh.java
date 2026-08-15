package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0459nh extends AbstractC0304hh {
    public final ap b;

    public C0459nh(C0447n5 c0447n5) {
        this(c0447n5, c0447n5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0447n5 c0447n5 = this.f1019a;
        if (!this.b.c()) {
            if (!this.b.d()) {
                E9 e9 = c0447n5.n;
                e9.c.b(C0241f6.a(c0241f6, Db.EVENT_TYPE_FIRST_ACTIVATION));
            }
            ap apVar = this.b;
            synchronized (apVar) {
                JSONObject a2 = apVar.f896a.a();
                if (!a2.optBoolean("first_event_done", false)) {
                    apVar.f896a.a(a2.put("first_event_done", true));
                }
                bp bpVar = apVar.f896a;
                bp.a(bpVar.f916a);
                bp.a(bpVar.b);
            }
        }
        return false;
    }

    public C0459nh(C0447n5 c0447n5, ap apVar) {
        super(c0447n5);
        this.b = apVar;
    }
}
