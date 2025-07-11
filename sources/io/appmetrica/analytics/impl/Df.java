package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Df implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bf f391a = new Bf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0707xf fromModel(Cf cf) {
        C0707xf c0707xf = new C0707xf();
        if (!TextUtils.isEmpty(cf.f375a)) {
            c0707xf.f1126a = cf.f375a;
        }
        c0707xf.b = cf.b.toString();
        c0707xf.c = cf.c;
        c0707xf.d = cf.d;
        c0707xf.e = this.f391a.fromModel(cf.e).intValue();
        return c0707xf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cf toModel(C0707xf c0707xf) {
        JSONObject jSONObject;
        String str = c0707xf.f1126a;
        String str2 = c0707xf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Cf(str, jSONObject, c0707xf.c, c0707xf.d, this.f391a.toModel(Integer.valueOf(c0707xf.e)));
        }
        jSONObject = new JSONObject();
        return new Cf(str, jSONObject, c0707xf.c, c0707xf.d, this.f391a.toModel(Integer.valueOf(c0707xf.e)));
    }
}
