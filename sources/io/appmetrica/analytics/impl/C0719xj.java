package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0719xj extends AbstractC0303hh {
    public final Tf b;

    public C0719xj(C0446n5 c0446n5) {
        this(c0446n5, Na.k().t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0240f6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Qf.a(jSONObject));
        return false;
    }

    public C0719xj(C0446n5 c0446n5, Tf tf) {
        super(c0446n5);
        this.b = tf;
    }
}
