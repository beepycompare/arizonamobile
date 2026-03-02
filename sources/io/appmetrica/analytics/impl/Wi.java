package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Wi extends Rg {
    public final C0602tf b;

    public Wi(X4 x4) {
        this(x4, C0448na.k().t());
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(p5.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(C0528qf.a(jSONObject));
        return false;
    }

    public Wi(X4 x4, C0602tf c0602tf) {
        super(x4);
        this.b = c0602tf;
    }
}
