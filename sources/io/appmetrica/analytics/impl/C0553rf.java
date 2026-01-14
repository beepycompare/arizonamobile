package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0553rf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0504pf f1208a = new C0504pf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0404lf fromModel(C0529qf c0529qf) {
        C0404lf c0404lf = new C0404lf();
        if (!TextUtils.isEmpty(c0529qf.f1190a)) {
            c0404lf.f1099a = c0529qf.f1190a;
        }
        c0404lf.b = c0529qf.b.toString();
        c0404lf.c = c0529qf.c;
        c0404lf.d = c0529qf.d;
        c0404lf.e = this.f1208a.fromModel(c0529qf.e).intValue();
        return c0404lf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0529qf toModel(C0404lf c0404lf) {
        JSONObject jSONObject;
        String str = c0404lf.f1099a;
        String str2 = c0404lf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0529qf(str, jSONObject, c0404lf.c, c0404lf.d, this.f1208a.toModel(Integer.valueOf(c0404lf.e)));
        }
        jSONObject = new JSONObject();
        return new C0529qf(str, jSONObject, c0404lf.c, c0404lf.d, this.f1208a.toModel(Integer.valueOf(c0404lf.e)));
    }
}
