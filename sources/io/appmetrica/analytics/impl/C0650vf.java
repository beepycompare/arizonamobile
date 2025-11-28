package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0650vf implements Z7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1171a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final Y7 e;

    public C0650vf(String str, JSONObject jSONObject, boolean z, boolean z2, Y7 y7) {
        this.f1171a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = y7;
    }

    @Override // io.appmetrica.analytics.impl.Z7
    public final Y7 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (this.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("trackingId", this.f1171a);
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
            jSONObject.put("trackingId", this.f1171a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.f767a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.f1171a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static C0650vf a(JSONObject jSONObject) {
        Y7 y7;
        String optStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject optJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean optBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean optBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String optStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        Y7[] values = Y7.values();
        int length = values.length;
        while (true) {
            if (i >= length) {
                y7 = null;
                break;
            }
            y7 = values[i];
            if (Intrinsics.areEqual(y7.f767a, optStringOrNull2)) {
                break;
            }
            i++;
        }
        if (y7 == null) {
            y7 = Y7.b;
        }
        return new C0650vf(optStringOrNull, optJsonObjectOrDefault, optBooleanOrDefault, optBooleanOrDefault2, y7);
    }
}
