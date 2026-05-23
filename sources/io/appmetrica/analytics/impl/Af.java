package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Af implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Pf f458a;

    public Af() {
        this(new Pf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Mf fromModel(Cf cf) {
        Mf mf = new Mf();
        if (!StringUtils.isNullOrEmpty(cf.f496a)) {
            mf.f663a = cf.f496a;
        }
        mf.b = cf.b.toString();
        mf.c = this.f458a.fromModel(cf.c).intValue();
        return mf;
    }

    public Af(Pf pf) {
        this.f458a = pf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cf toModel(Mf mf) {
        JSONObject jSONObject;
        String str = mf.f663a;
        String str2 = mf.b;
        if (!StringUtils.isNullOrEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Cf(str, jSONObject, this.f458a.toModel(Integer.valueOf(mf.c)));
        }
        jSONObject = new JSONObject();
        return new Cf(str, jSONObject, this.f458a.toModel(Integer.valueOf(mf.c)));
    }
}
