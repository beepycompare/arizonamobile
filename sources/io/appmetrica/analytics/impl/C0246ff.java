package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ff  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0246ff implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0625uf f877a;

    public C0246ff() {
        this(new C0625uf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0550rf fromModel(C0298hf c0298hf) {
        C0550rf c0550rf = new C0550rf();
        if (!TextUtils.isEmpty(c0298hf.f911a)) {
            c0550rf.f1095a = c0298hf.f911a;
        }
        c0550rf.b = c0298hf.b.toString();
        c0550rf.c = this.f877a.fromModel(c0298hf.c).intValue();
        return c0550rf;
    }

    public C0246ff(C0625uf c0625uf) {
        this.f877a = c0625uf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0298hf toModel(C0550rf c0550rf) {
        JSONObject jSONObject;
        String str = c0550rf.f1095a;
        String str2 = c0550rf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0298hf(str, jSONObject, this.f877a.toModel(Integer.valueOf(c0550rf.c)));
        }
        jSONObject = new JSONObject();
        return new C0298hf(str, jSONObject, this.f877a.toModel(Integer.valueOf(c0550rf.c)));
    }
}
