package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.bj  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0147bj extends Wg {
    public final C0725yf b;

    public C0147bj(C0210e5 c0210e5) {
        this(c0210e5, C0620ua.k().t());
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(w5.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(C0650vf.a(jSONObject));
        return false;
    }

    public C0147bj(C0210e5 c0210e5, C0725yf c0725yf) {
        super(c0210e5);
        this.b = c0725yf;
    }
}
