package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0552rf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0503pf f1212a = new C0503pf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0403lf fromModel(C0528qf c0528qf) {
        C0403lf c0403lf = new C0403lf();
        if (!TextUtils.isEmpty(c0528qf.f1194a)) {
            c0403lf.f1103a = c0528qf.f1194a;
        }
        c0403lf.b = c0528qf.b.toString();
        c0403lf.c = c0528qf.c;
        c0403lf.d = c0528qf.d;
        c0403lf.e = this.f1212a.fromModel(c0528qf.e).intValue();
        return c0403lf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0528qf toModel(C0403lf c0403lf) {
        JSONObject jSONObject;
        String str = c0403lf.f1103a;
        String str2 = c0403lf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0528qf(str, jSONObject, c0403lf.c, c0403lf.d, this.f1212a.toModel(Integer.valueOf(c0403lf.e)));
        }
        jSONObject = new JSONObject();
        return new C0528qf(str, jSONObject, c0403lf.c, c0403lf.d, this.f1212a.toModel(Integer.valueOf(c0403lf.e)));
    }
}
