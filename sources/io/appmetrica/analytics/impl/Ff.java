package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ff implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Df f437a = new Df();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0760zf fromModel(Ef ef) {
        C0760zf c0760zf = new C0760zf();
        if (!TextUtils.isEmpty(ef.f418a)) {
            c0760zf.f1171a = ef.f418a;
        }
        c0760zf.b = ef.b.toString();
        c0760zf.c = ef.c;
        c0760zf.d = ef.d;
        c0760zf.e = this.f437a.fromModel(ef.e).intValue();
        return c0760zf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ef toModel(C0760zf c0760zf) {
        JSONObject jSONObject;
        String str = c0760zf.f1171a;
        String str2 = c0760zf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Ef(str, jSONObject, c0760zf.c, c0760zf.d, this.f437a.toModel(Integer.valueOf(c0760zf.e)));
        }
        jSONObject = new JSONObject();
        return new Ef(str, jSONObject, c0760zf.c, c0760zf.d, this.f437a.toModel(Integer.valueOf(c0760zf.e)));
    }
}
