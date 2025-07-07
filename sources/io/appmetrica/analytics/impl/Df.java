package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Df implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bf f390a = new Bf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0715xf fromModel(Cf cf) {
        C0715xf c0715xf = new C0715xf();
        if (!TextUtils.isEmpty(cf.f374a)) {
            c0715xf.f1125a = cf.f374a;
        }
        c0715xf.b = cf.b.toString();
        c0715xf.c = cf.c;
        c0715xf.d = cf.d;
        c0715xf.e = this.f390a.fromModel(cf.e).intValue();
        return c0715xf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cf toModel(C0715xf c0715xf) {
        JSONObject jSONObject;
        String str = c0715xf.f1125a;
        String str2 = c0715xf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Cf(str, jSONObject, c0715xf.c, c0715xf.d, this.f390a.toModel(Integer.valueOf(c0715xf.e)));
        }
        jSONObject = new JSONObject();
        return new Cf(str, jSONObject, c0715xf.c, c0715xf.d, this.f390a.toModel(Integer.valueOf(c0715xf.e)));
    }
}
