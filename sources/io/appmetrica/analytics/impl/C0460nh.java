package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.nh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0460nh extends AbstractC0305hh {
    public final ap b;

    public C0460nh(C0448n5 c0448n5) {
        this(c0448n5, c0448n5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        C0448n5 c0448n5 = this.f1016a;
        if (!this.b.c()) {
            if (!this.b.d()) {
                E9 e9 = c0448n5.n;
                e9.c.b(C0242f6.a(c0242f6, Db.EVENT_TYPE_FIRST_ACTIVATION));
            }
            ap apVar = this.b;
            synchronized (apVar) {
                JSONObject a2 = apVar.f893a.a();
                if (!a2.optBoolean("first_event_done", false)) {
                    apVar.f893a.a(a2.put("first_event_done", true));
                }
                bp bpVar = apVar.f893a;
                bp.a(bpVar.f913a);
                bp.a(bpVar.b);
            }
        }
        return false;
    }

    public C0460nh(C0448n5 c0448n5, ap apVar) {
        super(c0448n5);
        this.b = apVar;
    }
}
