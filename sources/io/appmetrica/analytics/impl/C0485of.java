package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0485of implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Df f987a;

    public C0485of() {
        this(new Df());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Af fromModel(C0535qf c0535qf) {
        Af af = new Af();
        if (!TextUtils.isEmpty(c0535qf.f1019a)) {
            af.f338a = c0535qf.f1019a;
        }
        af.b = c0535qf.b.toString();
        af.c = this.f987a.fromModel(c0535qf.c).intValue();
        return af;
    }

    public C0485of(Df df) {
        this.f987a = df;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0535qf toModel(Af af) {
        JSONObject jSONObject;
        String str = af.f338a;
        String str2 = af.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0535qf(str, jSONObject, this.f987a.toModel(Integer.valueOf(af.c)));
        }
        jSONObject = new JSONObject();
        return new C0535qf(str, jSONObject, this.f987a.toModel(Integer.valueOf(af.c)));
    }
}
