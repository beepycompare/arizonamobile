package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class so {

    /* renamed from: a  reason: collision with root package name */
    public final vo f1050a;
    public final vo b;
    public final to c;
    public JSONObject d;

    public so(vo voVar, vo voVar2, to toVar) {
        this.f1050a = voVar;
        this.b = voVar2;
        this.c = toVar;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        if (this.d == null) {
            JSONObject a2 = this.c.a(a(this.f1050a), a(this.b));
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

    public static JSONObject a(vo voVar) {
        try {
            String a2 = voVar.a();
            return a2 != null ? new JSONObject(a2) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        try {
            this.f1050a.a(jSONObject2);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(jSONObject2);
        } catch (Throwable unused2) {
        }
    }
}
