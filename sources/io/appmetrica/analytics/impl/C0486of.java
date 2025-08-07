package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0486of implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Df f987a;

    public C0486of() {
        this(new Df());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Af fromModel(C0536qf c0536qf) {
        Af af = new Af();
        if (!TextUtils.isEmpty(c0536qf.f1019a)) {
            af.f338a = c0536qf.f1019a;
        }
        af.b = c0536qf.b.toString();
        af.c = this.f987a.fromModel(c0536qf.c).intValue();
        return af;
    }

    public C0486of(Df df) {
        this.f987a = df;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0536qf toModel(Af af) {
        JSONObject jSONObject;
        String str = af.f338a;
        String str2 = af.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0536qf(str, jSONObject, this.f987a.toModel(Integer.valueOf(af.c)));
        }
        jSONObject = new JSONObject();
        return new C0536qf(str, jSONObject, this.f987a.toModel(Integer.valueOf(af.c)));
    }
}
