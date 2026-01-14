package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0121af implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0504pf f905a;

    public C0121af() {
        this(new C0504pf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0429mf fromModel(C0173cf c0173cf) {
        C0429mf c0429mf = new C0429mf();
        if (!TextUtils.isEmpty(c0173cf.f939a)) {
            c0429mf.f1118a = c0173cf.f939a;
        }
        c0429mf.b = c0173cf.b.toString();
        c0429mf.c = this.f905a.fromModel(c0173cf.c).intValue();
        return c0429mf;
    }

    public C0121af(C0504pf c0504pf) {
        this.f905a = c0504pf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0173cf toModel(C0429mf c0429mf) {
        JSONObject jSONObject;
        String str = c0429mf.f1118a;
        String str2 = c0429mf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0173cf(str, jSONObject, this.f905a.toModel(Integer.valueOf(c0429mf.c)));
        }
        jSONObject = new JSONObject();
        return new C0173cf(str, jSONObject, this.f905a.toModel(Integer.valueOf(c0429mf.c)));
    }
}
