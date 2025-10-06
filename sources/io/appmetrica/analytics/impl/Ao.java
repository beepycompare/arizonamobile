package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ao implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0119a9 f358a;

    public Ao() {
        this(new C0119a9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0403l9 c0403l9, Gh gh) {
        if (!((C0652v5) gh.l).B() && !TextUtils.isEmpty(c0403l9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0403l9.b);
                jSONObject.remove("preloadInfo");
                c0403l9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f358a.a(c0403l9, gh);
    }

    public Ao(C0119a9 c0119a9) {
        this.f358a = c0119a9;
    }
}
