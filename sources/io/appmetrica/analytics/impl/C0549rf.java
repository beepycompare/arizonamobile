package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0549rf implements U7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1199a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final T7 e;

    public C0549rf(String str, JSONObject jSONObject, boolean z, boolean z2, T7 t7) {
        this.f1199a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = t7;
    }

    @Override // io.appmetrica.analytics.impl.U7
    public final T7 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (this.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("trackingId", this.f1199a);
                if (this.b.length() > 0) {
                    jSONObject.put("additionalParams", this.b);
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
        return null;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.f1199a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.f787a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.f1199a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static C0549rf a(JSONObject jSONObject) {
        T7 t7;
        String optStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject optJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean optBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean optBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String optStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        T7[] values = T7.values();
        int length = values.length;
        while (true) {
            if (i >= length) {
                t7 = null;
                break;
            }
            t7 = values[i];
            if (Intrinsics.areEqual(t7.f787a, optStringOrNull2)) {
                break;
            }
            i++;
        }
        if (t7 == null) {
            t7 = T7.b;
        }
        return new C0549rf(optStringOrNull, optJsonObjectOrDefault, optBooleanOrDefault, optBooleanOrDefault2, t7);
    }
}
