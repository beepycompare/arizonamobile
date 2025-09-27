package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ao implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0118a9 f358a;

    public Ao() {
        this(new C0118a9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        if (!((C0651v5) gh.l).B() && !TextUtils.isEmpty(c0402l9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0402l9.b);
                jSONObject.remove("preloadInfo");
                c0402l9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f358a.a(c0402l9, gh);
    }

    public Ao(C0118a9 c0118a9) {
        this.f358a = c0118a9;
    }
}
