package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class oo implements no {

    /* renamed from: a  reason: collision with root package name */
    public final S8 f982a;

    public oo() {
        this(new S8());
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0203d9 c0203d9, C0659vh c0659vh) {
        if (!((C0572s5) c0659vh.l).A() && !TextUtils.isEmpty(c0203d9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0203d9.b);
                jSONObject.remove("preloadInfo");
                c0203d9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f982a.a(c0203d9, c0659vh);
    }

    public oo(S8 s8) {
        this.f982a = s8;
    }
}
