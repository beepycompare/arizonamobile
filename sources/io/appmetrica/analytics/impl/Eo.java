package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Eo {

    /* renamed from: a  reason: collision with root package name */
    public final Ho f429a;
    public final Ho b;
    public final Fo c;
    public JSONObject d;

    public Eo(Ho ho, Ho ho2, Fo fo) {
        this.f429a = ho;
        this.b = ho2;
        this.c = fo;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        if (this.d == null) {
            JSONObject a2 = this.c.a(a(this.f429a), a(this.b));
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

    public static JSONObject a(Ho ho) {
        try {
            String a2 = ho.a();
            return a2 != null ? new JSONObject(a2) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        try {
            this.f429a.a(jSONObject2);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(jSONObject2);
        } catch (Throwable unused2) {
        }
    }
}
