package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0458nh extends AbstractC0303hh {
    public final ap b;

    public C0458nh(C0446n5 c0446n5) {
        this(c0446n5, c0446n5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        C0446n5 c0446n5 = this.f1019a;
        if (!this.b.c()) {
            if (!this.b.d()) {
                E9 e9 = c0446n5.n;
                e9.c.b(C0240f6.a(c0240f6, Db.EVENT_TYPE_FIRST_ACTIVATION));
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

    public C0458nh(C0446n5 c0446n5, ap apVar) {
        super(c0446n5);
        this.b = apVar;
    }
}
