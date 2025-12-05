package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.sf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0574sf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0525qf f1202a = new C0525qf();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0425mf fromModel(C0549rf c0549rf) {
        C0425mf c0425mf = new C0425mf();
        if (!TextUtils.isEmpty(c0549rf.f1185a)) {
            c0425mf.f1094a = c0549rf.f1185a;
        }
        c0425mf.b = c0549rf.b.toString();
        c0425mf.c = c0549rf.c;
        c0425mf.d = c0549rf.d;
        c0425mf.e = this.f1202a.fromModel(c0549rf.e).intValue();
        return c0425mf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0549rf toModel(C0425mf c0425mf) {
        JSONObject jSONObject;
        String str = c0425mf.f1094a;
        String str2 = c0425mf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0549rf(str, jSONObject, c0425mf.c, c0425mf.d, this.f1202a.toModel(Integer.valueOf(c0425mf.e)));
        }
        jSONObject = new JSONObject();
        return new C0549rf(str, jSONObject, c0425mf.c, c0425mf.d, this.f1202a.toModel(Integer.valueOf(c0425mf.e)));
    }
}
