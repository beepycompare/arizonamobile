package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.uf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0636uf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Jf f1107a;

    public C0636uf() {
        this(new Jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Gf fromModel(C0686wf c0686wf) {
        Gf gf = new Gf();
        if (!TextUtils.isEmpty(c0686wf.f1135a)) {
            gf.f457a = c0686wf.f1135a;
        }
        gf.b = c0686wf.b.toString();
        gf.c = this.f1107a.fromModel(c0686wf.c).intValue();
        return gf;
    }

    public C0636uf(Jf jf) {
        this.f1107a = jf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0686wf toModel(Gf gf) {
        JSONObject jSONObject;
        String str = gf.f457a;
        String str2 = gf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0686wf(str, jSONObject, this.f1107a.toModel(Integer.valueOf(gf.c)));
        }
        jSONObject = new JSONObject();
        return new C0686wf(str, jSONObject, this.f1107a.toModel(Integer.valueOf(gf.c)));
    }
}
