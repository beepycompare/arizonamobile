package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Xi extends Sg {
    public final C0625uf b;

    public Xi(Y4 y4) {
        this(y4, C0471oa.k().t());
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(q5.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(C0550rf.a(jSONObject));
        return false;
    }

    public Xi(Y4 y4, C0625uf c0625uf) {
        super(y4);
        this.b = c0625uf;
    }
}
