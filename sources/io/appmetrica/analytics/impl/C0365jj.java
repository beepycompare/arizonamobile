package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.jj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0365jj extends AbstractC0237eh {
    public final Hf b;

    public C0365jj(C0575s5 c0575s5) {
        this(c0575s5, Ia.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0402l6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Ef.a(jSONObject));
        return false;
    }

    public C0365jj(C0575s5 c0575s5, Hf hf) {
        super(c0575s5);
        this.b = hf;
    }
}
