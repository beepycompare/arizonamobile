package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class vo {

    /* renamed from: a  reason: collision with root package name */
    public final yo f1108a;
    public final yo b;
    public final wo c;
    public JSONObject d;

    public vo(yo yoVar, yo yoVar2, wo woVar) {
        this.f1108a = yoVar;
        this.b = yoVar2;
        this.c = woVar;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        if (this.d == null) {
            JSONObject a2 = this.c.a(a(this.f1108a), a(this.b));
            this.d = a2;
            a(a2);
        }
        jSONObject = this.d;
        if (jSONObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileContents");
            jSONObject = null;
        }
        return jSONObject;
    }

    public static JSONObject a(yo yoVar) {
        try {
            String a2 = yoVar.a();
            return a2 != null ? new JSONObject(a2) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        try {
            this.f1108a.a(jSONObject2);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(jSONObject2);
        } catch (Throwable unused2) {
        }
    }
}
