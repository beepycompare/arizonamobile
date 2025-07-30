package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ff implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Df f438a = new Df();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0759zf fromModel(Ef ef) {
        C0759zf c0759zf = new C0759zf();
        if (!TextUtils.isEmpty(ef.f419a)) {
            c0759zf.f1172a = ef.f419a;
        }
        c0759zf.b = ef.b.toString();
        c0759zf.c = ef.c;
        c0759zf.d = ef.d;
        c0759zf.e = this.f438a.fromModel(ef.e).intValue();
        return c0759zf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ef toModel(C0759zf c0759zf) {
        JSONObject jSONObject;
        String str = c0759zf.f1172a;
        String str2 = c0759zf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new Ef(str, jSONObject, c0759zf.c, c0759zf.d, this.f438a.toModel(Integer.valueOf(c0759zf.e)));
        }
        jSONObject = new JSONObject();
        return new Ef(str, jSONObject, c0759zf.c, c0759zf.d, this.f438a.toModel(Integer.valueOf(c0759zf.e)));
    }
}
