package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Lf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Jf f560a = new Jf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ff fromModel(Kf kf) {
        Ff ff = new Ff();
        if (!TextUtils.isEmpty(kf.f540a)) {
            ff.f447a = kf.f540a;
        }
        ff.b = kf.b.toString();
        ff.c = kf.c;
        ff.d = kf.d;
        ff.e = this.f560a.fromModel(kf.e).intValue();
        return ff;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Kf toModel(Ff ff) {
        JSONObject jSONObject;
        String str = ff.f447a;
        String str2 = ff.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Kf(str, jSONObject, ff.c, ff.d, this.f560a.toModel(Integer.valueOf(ff.e)));
        }
        jSONObject = new JSONObject();
        return new Kf(str, jSONObject, ff.c, ff.d, this.f560a.toModel(Integer.valueOf(ff.e)));
    }
}
