package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.oj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0487oj extends AbstractC0358jh {
    public final Jf b;

    public C0487oj(C0572s5 c0572s5) {
        this(c0572s5, Ka.j().s());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0399l6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Gf.a(jSONObject));
        return false;
    }

    public C0487oj(C0572s5 c0572s5, Jf jf) {
        super(c0572s5);
        this.b = jf;
    }
}
