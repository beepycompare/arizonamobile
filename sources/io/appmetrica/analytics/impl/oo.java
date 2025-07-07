package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class oo implements no {

    /* renamed from: a  reason: collision with root package name */
    public final S8 f981a;

    public oo() {
        this(new S8());
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0211d9 c0211d9, C0667vh c0667vh) {
        if (!((C0580s5) c0667vh.l).A() && !TextUtils.isEmpty(c0211d9.b)) {
            try {
                JSONObject jSONObject = new JSONObject(c0211d9.b);
                jSONObject.remove("preloadInfo");
                c0211d9.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.f981a.a(c0211d9, c0667vh);
    }

    public oo(S8 s8) {
        this.f981a = s8;
    }
}
