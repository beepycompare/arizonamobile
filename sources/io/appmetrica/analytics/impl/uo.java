package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class uo implements to {

    /* renamed from: a  reason: collision with root package name */
    public final C8 f1264a;

    public uo() {
        this(new C8());
    }

    @Override // io.appmetrica.analytics.impl.to
    public final byte[] a(N8 n8, C0381kh c0381kh) {
        if (!((X4) c0381kh.l).B() && !TextUtils.isEmpty(n8.b)) {
            try {
                JSONObject jSONObject = new JSONObject(n8.b);
                jSONObject.remove("preloadInfo");
                n8.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1264a.a(n8, c0381kh);
    }

    public uo(C8 c8) {
        this.f1264a = c8;
    }
}
