package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0441mf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bf f939a;

    public C0441mf() {
        this(new Bf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0740yf fromModel(C0491of c0491of) {
        C0740yf c0740yf = new C0740yf();
        if (!TextUtils.isEmpty(c0491of.f973a)) {
            c0740yf.f1145a = c0491of.f973a;
        }
        c0740yf.b = c0491of.b.toString();
        c0740yf.c = this.f939a.fromModel(c0491of.c).intValue();
        return c0740yf;
    }

    public C0441mf(Bf bf) {
        this.f939a = bf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0491of toModel(C0740yf c0740yf) {
        JSONObject jSONObject;
        String str = c0740yf.f1145a;
        String str2 = c0740yf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0491of(str, jSONObject, this.f939a.toModel(Integer.valueOf(c0740yf.c)));
        }
        jSONObject = new JSONObject();
        return new C0491of(str, jSONObject, this.f939a.toModel(Integer.valueOf(c0740yf.c)));
    }
}
