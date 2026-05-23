package io.appmetrica.analytics.impl;

import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0721xj extends AbstractC0305hh {
    public final Tf b;

    public C0721xj(C0448n5 c0448n5) {
        this(c0448n5, Na.k().t());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(c0242f6.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObject = null;
        }
        this.b.b(Qf.a(jSONObject));
        return false;
    }

    public C0721xj(C0448n5 c0448n5, Tf tf) {
        super(c0448n5);
        this.b = tf;
    }
}
