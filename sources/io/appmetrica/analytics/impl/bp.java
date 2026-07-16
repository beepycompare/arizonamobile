package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bp {

    /* renamed from: a  reason: collision with root package name */
    public final ep f916a;
    public final ep b;
    public final cp c;
    public JSONObject d;

    public bp(ep epVar, ep epVar2, cp cpVar) {
        this.f916a = epVar;
        this.b = epVar2;
        this.c = cpVar;
    }

    public static JSONObject b(ep epVar) {
        try {
            String b = epVar.b();
            return b != null ? new JSONObject(b) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        if (this.d == null) {
            JSONObject a2 = this.c.a(b(this.f916a), b(this.b));
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

    public final synchronized void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        try {
            this.f916a.a(jSONObject2);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(jSONObject2);
        } catch (Throwable unused2) {
        }
    }

    public static void a(ep epVar) {
        try {
            epVar.flushAsync();
        } catch (Throwable unused) {
        }
    }
}
