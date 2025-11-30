package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.sf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0575sf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0526qf f1119a = new C0526qf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0426mf fromModel(C0550rf c0550rf) {
        C0426mf c0426mf = new C0426mf();
        if (!TextUtils.isEmpty(c0550rf.f1102a)) {
            c0426mf.f1011a = c0550rf.f1102a;
        }
        c0426mf.b = c0550rf.b.toString();
        c0426mf.c = c0550rf.c;
        c0426mf.d = c0550rf.d;
        c0426mf.e = this.f1119a.fromModel(c0550rf.e).intValue();
        return c0426mf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0550rf toModel(C0426mf c0426mf) {
        JSONObject jSONObject;
        String str = c0426mf.f1011a;
        String str2 = c0426mf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0550rf(str, jSONObject, c0426mf.c, c0426mf.d, this.f1119a.toModel(Integer.valueOf(c0426mf.e)));
        }
        jSONObject = new JSONObject();
        return new C0550rf(str, jSONObject, c0426mf.c, c0426mf.d, this.f1119a.toModel(Integer.valueOf(c0426mf.e)));
    }
}
