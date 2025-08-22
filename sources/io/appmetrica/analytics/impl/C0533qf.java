package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.qf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0533qf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ff f1027a;

    public C0533qf() {
        this(new Ff());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cf fromModel(C0582sf c0582sf) {
        Cf cf = new Cf();
        if (!TextUtils.isEmpty(c0582sf.f1061a)) {
            cf.f381a = c0582sf.f1061a;
        }
        cf.b = c0582sf.b.toString();
        cf.c = this.f1027a.fromModel(c0582sf.c).intValue();
        return cf;
    }

    public C0533qf(Ff ff) {
        this.f1027a = ff;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0582sf toModel(Cf cf) {
        JSONObject jSONObject;
        String str = cf.f381a;
        String str2 = cf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0582sf(str, jSONObject, this.f1027a.toModel(Integer.valueOf(cf.c)));
        }
        jSONObject = new JSONObject();
        return new C0582sf(str, jSONObject, this.f1027a.toModel(Integer.valueOf(cf.c)));
    }
}
