package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0714xj extends AbstractC0298hh {
    public final Tf b;

    public C0714xj(C0441n5 c0441n5) {
        this(c0441n5, Na.k().t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0235f6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Qf.a(jSONObject));
        return false;
    }

    public C0714xj(C0441n5 c0441n5, Tf tf) {
        super(c0441n5);
        this.b = tf;
    }
}
