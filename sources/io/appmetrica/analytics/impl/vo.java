package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class vo implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final D8 f1176a;

    public vo() {
        this(new D8());
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0403lh c0403lh) {
        if (!((Y4) c0403lh.l).B() && !TextUtils.isEmpty(o8.b)) {
            try {
                JSONObject jSONObject = new JSONObject(o8.b);
                jSONObject.remove("preloadInfo");
                o8.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1176a.a(o8, c0403lh);
    }

    public vo(D8 d8) {
        this.f1176a = d8;
    }
}
