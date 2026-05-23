package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Xo implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final V8 f844a;

    public Xo() {
        this(new V8());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0297h9 c0297h9, Eh eh) {
        if (!((C0448n5) eh.l).B() && !TextUtils.isEmpty(c0297h9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0297h9.b);
                jSONObject.remove("preloadInfo");
                c0297h9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f844a.a(c0297h9, eh);
    }

    public Xo(V8 v8) {
        this.f844a = v8;
    }
}
