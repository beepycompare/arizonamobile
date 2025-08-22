package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class wo implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final X8 f1130a;

    public wo() {
        this(new X8());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        if (!((C0572s5) ch.l).A() && !TextUtils.isEmpty(c0325i9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0325i9.b);
                jSONObject.remove("preloadInfo");
                c0325i9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1130a.a(c0325i9, ch);
    }

    public wo(X8 x8) {
        this.f1130a = x8;
    }
}
