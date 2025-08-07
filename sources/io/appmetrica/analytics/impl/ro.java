package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ro implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final V8 f1044a;

    public ro() {
        this(new V8());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0281g9 c0281g9, C0712xh c0712xh) {
        if (!((C0575s5) c0712xh.l).A() && !TextUtils.isEmpty(c0281g9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0281g9.b);
                jSONObject.remove("preloadInfo");
                c0281g9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1044a.a(c0281g9, c0712xh);
    }

    public ro(V8 v8) {
        this.f1044a = v8;
    }
}
