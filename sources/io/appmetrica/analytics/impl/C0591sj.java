package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.sj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0591sj extends AbstractC0463nh {
    public final Nf b;

    public C0591sj(C0652v5 c0652v5) {
        this(c0652v5, Na.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0478o6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Kf.a(jSONObject));
        return false;
    }

    public C0591sj(C0652v5 c0652v5, Nf nf) {
        super(c0652v5);
        this.b = nf;
    }
}
