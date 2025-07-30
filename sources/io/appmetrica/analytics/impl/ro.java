package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ro implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final V8 f1045a;

    public ro() {
        this(new V8());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        if (!((C0574s5) c0711xh.l).A() && !TextUtils.isEmpty(c0280g9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0280g9.b);
                jSONObject.remove("preloadInfo");
                c0280g9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f1045a.a(c0280g9, c0711xh);
    }

    public ro(V8 v8) {
        this.f1045a = v8;
    }
}
