package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.jj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0364jj extends AbstractC0236eh {
    public final Hf b;

    public C0364jj(C0574s5 c0574s5) {
        this(c0574s5, Ia.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0401l6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Ef.a(jSONObject));
        return false;
    }

    public C0364jj(C0574s5 c0574s5, Hf hf) {
        super(c0574s5);
        this.b = hf;
    }
}
