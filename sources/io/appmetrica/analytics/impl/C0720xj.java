package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0720xj extends AbstractC0304hh {
    public final Tf b;

    public C0720xj(C0447n5 c0447n5) {
        this(c0447n5, Na.k().t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0241f6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Qf.a(jSONObject));
        return false;
    }

    public C0720xj(C0447n5 c0447n5, Tf tf) {
        super(c0447n5);
        this.b = tf;
    }
}
