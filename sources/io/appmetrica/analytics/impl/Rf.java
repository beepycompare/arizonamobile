package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Rf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Pf f746a = new Pf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Lf fromModel(Qf qf) {
        Lf lf = new Lf();
        if (!StringUtils.isNullOrEmpty(qf.f732a)) {
            lf.f646a = qf.f732a;
        }
        lf.b = qf.b.toString();
        lf.c = qf.c;
        lf.d = qf.d;
        lf.e = this.f746a.fromModel(qf.e).intValue();
        return lf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qf toModel(Lf lf) {
        JSONObject jSONObject;
        String str = lf.f646a;
        String str2 = lf.b;
        if (!StringUtils.isNullOrEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Qf(str, jSONObject, lf.c, lf.d, this.f746a.toModel(Integer.valueOf(lf.e)));
        }
        jSONObject = new JSONObject();
        return new Qf(str, jSONObject, lf.c, lf.d, this.f746a.toModel(Integer.valueOf(lf.e)));
    }
}
