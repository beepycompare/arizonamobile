package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class yo {

    /* renamed from: a  reason: collision with root package name */
    public final Bo f1327a;
    public final Bo b;
    public final zo c;
    public JSONObject d;

    public yo(Bo bo, Bo bo2, zo zoVar) {
        this.f1327a = bo;
        this.b = bo2;
        this.c = zoVar;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        if (this.d == null) {
            JSONObject a2 = this.c.a(a(this.f1327a), a(this.b));
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

    public static JSONObject a(Bo bo) {
        try {
            String a2 = bo.a();
            return a2 != null ? new JSONObject(a2) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        try {
            this.f1327a.a(jSONObject2);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(jSONObject2);
        } catch (Throwable unused2) {
        }
    }
}
