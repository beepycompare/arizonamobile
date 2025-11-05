package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class wo implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final H8 f1194a;

    public wo() {
        this(new H8());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        if (!((C0210e5) c0503ph.l).B() && !TextUtils.isEmpty(s8.b)) {
            try {
                JSONObject jSONObject = new JSONObject(s8.b);
                jSONObject.remove("preloadInfo");
                s8.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1194a.a(s8, c0503ph);
    }

    public wo(H8 h8) {
        this.f1194a = h8;
    }
}
