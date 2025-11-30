package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0143bf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0526qf f817a;

    public C0143bf() {
        this(new C0526qf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0451nf fromModel(C0195df c0195df) {
        C0451nf c0451nf = new C0451nf();
        if (!TextUtils.isEmpty(c0195df.f851a)) {
            c0451nf.f1030a = c0195df.f851a;
        }
        c0451nf.b = c0195df.b.toString();
        c0451nf.c = this.f817a.fromModel(c0195df.c).intValue();
        return c0451nf;
    }

    public C0143bf(C0526qf c0526qf) {
        this.f817a = c0526qf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0195df toModel(C0451nf c0451nf) {
        JSONObject jSONObject;
        String str = c0451nf.f1030a;
        String str2 = c0451nf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0195df(str, jSONObject, this.f817a.toModel(Integer.valueOf(c0451nf.c)));
        }
        jSONObject = new JSONObject();
        return new C0195df(str, jSONObject, this.f817a.toModel(Integer.valueOf(c0451nf.c)));
    }
}
