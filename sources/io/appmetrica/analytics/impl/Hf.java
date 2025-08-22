package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Hf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ff f477a = new Ff();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Bf fromModel(Gf gf) {
        Bf bf = new Bf();
        if (!TextUtils.isEmpty(gf.f457a)) {
            bf.f364a = gf.f457a;
        }
        bf.b = gf.b.toString();
        bf.c = gf.c;
        bf.d = gf.d;
        bf.e = this.f477a.fromModel(gf.e).intValue();
        return bf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Gf toModel(Bf bf) {
        JSONObject jSONObject;
        String str = bf.f364a;
        String str2 = bf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Gf(str, jSONObject, bf.c, bf.d, this.f477a.toModel(Integer.valueOf(bf.e)));
        }
        jSONObject = new JSONObject();
        return new Gf(str, jSONObject, bf.c, bf.d, this.f477a.toModel(Integer.valueOf(bf.e)));
    }
}
