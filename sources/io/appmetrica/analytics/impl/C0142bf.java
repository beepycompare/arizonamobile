package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0142bf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0525qf f914a;

    public C0142bf() {
        this(new C0525qf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0450nf fromModel(C0194df c0194df) {
        C0450nf c0450nf = new C0450nf();
        if (!TextUtils.isEmpty(c0194df.f948a)) {
            c0450nf.f1127a = c0194df.f948a;
        }
        c0450nf.b = c0194df.b.toString();
        c0450nf.c = this.f914a.fromModel(c0194df.c).intValue();
        return c0450nf;
    }

    public C0142bf(C0525qf c0525qf) {
        this.f914a = c0525qf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0194df toModel(C0450nf c0450nf) {
        JSONObject jSONObject;
        String str = c0450nf.f1127a;
        String str2 = c0450nf.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
            return new C0194df(str, jSONObject, this.f914a.toModel(Integer.valueOf(c0450nf.c)));
        }
        jSONObject = new JSONObject();
        return new C0194df(str, jSONObject, this.f914a.toModel(Integer.valueOf(c0450nf.c)));
    }
}
