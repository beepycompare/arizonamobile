package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0288gj extends AbstractC0185ch {
    public final Ff b;

    public C0288gj(C0572s5 c0572s5) {
        this(c0572s5, Ga.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0325i6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Cf.a(jSONObject));
        return false;
    }

    public C0288gj(C0572s5 c0572s5, Ff ff) {
        super(c0572s5);
        this.b = ff;
    }
}
