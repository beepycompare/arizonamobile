package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wf  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0675wf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0625uf f1187a = new C0625uf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0526qf fromModel(C0650vf c0650vf) {
        C0526qf c0526qf = new C0526qf();
        if (!TextUtils.isEmpty(c0650vf.f1171a)) {
            c0526qf.f1074a = c0650vf.f1171a;
        }
        c0526qf.b = c0650vf.b.toString();
        c0526qf.c = c0650vf.c;
        c0526qf.d = c0650vf.d;
        c0526qf.e = this.f1187a.fromModel(c0650vf.e).intValue();
        return c0526qf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0650vf toModel(C0526qf c0526qf) {
        JSONObject jSONObject;
        String str = c0526qf.f1074a;
        String str2 = c0526qf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0650vf(str, jSONObject, c0526qf.c, c0526qf.d, this.f1187a.toModel(Integer.valueOf(c0526qf.e)));
        }
        jSONObject = new JSONObject();
        return new C0650vf(str, jSONObject, c0526qf.c, c0526qf.d, this.f1187a.toModel(Integer.valueOf(c0526qf.e)));
    }
}
