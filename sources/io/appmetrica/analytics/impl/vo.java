package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class vo implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final D8 f1274a;

    public vo() {
        this(new D8());
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0402lh c0402lh) {
        if (!((Y4) c0402lh.l).B() && !TextUtils.isEmpty(o8.b)) {
            try {
                JSONObject jSONObject = new JSONObject(o8.b);
                jSONObject.remove("preloadInfo");
                o8.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1274a.a(o8, c0402lh);
    }

    public vo(D8 d8) {
        this.f1274a = d8;
    }
}
