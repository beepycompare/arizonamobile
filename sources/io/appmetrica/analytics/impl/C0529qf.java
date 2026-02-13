package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.qf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0529qf implements T7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1189a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final S7 e;

    public C0529qf(String str, JSONObject jSONObject, boolean z, boolean z2, S7 s7) {
        this.f1189a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = s7;
    }

    @Override // io.appmetrica.analytics.impl.T7
    public final S7 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (this.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("trackingId", this.f1189a);
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
            jSONObject.put("trackingId", this.f1189a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.f778a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.f1189a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static C0529qf a(JSONObject jSONObject) {
        S7 s7;
        String optStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject optJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean optBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean optBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String optStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        S7[] values = S7.values();
        int length = values.length;
        while (true) {
            if (i >= length) {
                s7 = null;
                break;
            }
            s7 = values[i];
            if (Intrinsics.areEqual(s7.f778a, optStringOrNull2)) {
                break;
            }
            i++;
        }
        if (s7 == null) {
            s7 = S7.b;
        }
        return new C0529qf(optStringOrNull, optJsonObjectOrDefault, optBooleanOrDefault, optBooleanOrDefault2, s7);
    }
}
