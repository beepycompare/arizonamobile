package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0433mf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bf f940a;

    public C0433mf() {
        this(new Bf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0732yf fromModel(C0483of c0483of) {
        C0732yf c0732yf = new C0732yf();
        if (!TextUtils.isEmpty(c0483of.f974a)) {
            c0732yf.f1146a = c0483of.f974a;
        }
        c0732yf.b = c0483of.b.toString();
        c0732yf.c = this.f940a.fromModel(c0483of.c).intValue();
        return c0732yf;
    }

    public C0433mf(Bf bf) {
        this.f940a = bf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0483of toModel(C0732yf c0732yf) {
        JSONObject jSONObject;
        String str = c0732yf.f1146a;
        String str2 = c0732yf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0483of(str, jSONObject, this.f940a.toModel(Integer.valueOf(c0732yf.c)));
        }
        jSONObject = new JSONObject();
        return new C0483of(str, jSONObject, this.f940a.toModel(Integer.valueOf(c0732yf.c)));
    }
}
