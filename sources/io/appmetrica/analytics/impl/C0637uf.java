package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.uf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0637uf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Jf f1112a;

    public C0637uf() {
        this(new Jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Gf fromModel(C0687wf c0687wf) {
        Gf gf = new Gf();
        if (!TextUtils.isEmpty(c0687wf.f1140a)) {
            gf.f462a = c0687wf.f1140a;
        }
        gf.b = c0687wf.b.toString();
        gf.c = this.f1112a.fromModel(c0687wf.c).intValue();
        return gf;
    }

    public C0637uf(Jf jf) {
        this.f1112a = jf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0687wf toModel(Gf gf) {
        JSONObject jSONObject;
        String str = gf.f462a;
        String str2 = gf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0687wf(str, jSONObject, this.f1112a.toModel(Integer.valueOf(gf.c)));
        }
        jSONObject = new JSONObject();
        return new C0687wf(str, jSONObject, this.f1112a.toModel(Integer.valueOf(gf.c)));
    }
}
