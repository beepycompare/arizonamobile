package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Xo implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final V8 f850a;

    public Xo() {
        this(new V8());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0290h9 c0290h9, Eh eh) {
        if (!((C0441n5) eh.l).B() && !TextUtils.isEmpty(c0290h9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0290h9.b);
                jSONObject.remove("preloadInfo");
                c0290h9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f850a.a(c0290h9, eh);
    }

    public Xo(V8 v8) {
        this.f850a = v8;
    }
}
