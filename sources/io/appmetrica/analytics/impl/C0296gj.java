package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0296gj extends AbstractC0193ch {
    public final Ff b;

    public C0296gj(C0580s5 c0580s5) {
        this(c0580s5, Ga.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0333i6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Cf.a(jSONObject));
        return false;
    }

    public C0296gj(C0580s5 c0580s5, Ff ff) {
        super(c0580s5);
        this.b = ff;
    }
}
