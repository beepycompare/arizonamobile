package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.sj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0590sj extends AbstractC0462nh {
    public final Nf b;

    public C0590sj(C0651v5 c0651v5) {
        this(c0651v5, Na.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0477o6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Kf.a(jSONObject));
        return false;
    }

    public C0590sj(C0651v5 c0651v5, Nf nf) {
        super(c0651v5);
        this.b = nf;
    }
}
