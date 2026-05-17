package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0120af implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0503pf f909a;

    public C0120af() {
        this(new C0503pf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0428mf fromModel(C0172cf c0172cf) {
        C0428mf c0428mf = new C0428mf();
        if (!TextUtils.isEmpty(c0172cf.f943a)) {
            c0428mf.f1122a = c0172cf.f943a;
        }
        c0428mf.b = c0172cf.b.toString();
        c0428mf.c = this.f909a.fromModel(c0172cf.c).intValue();
        return c0428mf;
    }

    public C0120af(C0503pf c0503pf) {
        this.f909a = c0503pf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0172cf toModel(C0428mf c0428mf) {
        JSONObject jSONObject;
        String str = c0428mf.f1122a;
        String str2 = c0428mf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0172cf(str, jSONObject, this.f909a.toModel(Integer.valueOf(c0428mf.c)));
        }
        jSONObject = new JSONObject();
        return new C0172cf(str, jSONObject, this.f909a.toModel(Integer.valueOf(c0428mf.c)));
    }
}
