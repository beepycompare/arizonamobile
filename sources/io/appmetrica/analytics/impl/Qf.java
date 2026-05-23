package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Qf implements InterfaceC0425m8 {

    /* renamed from: a  reason: collision with root package name */
    public final String f732a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final EnumC0399l8 e;

    public Qf(String str, JSONObject jSONObject, boolean z, boolean z2, EnumC0399l8 enumC0399l8) {
        this.f732a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = enumC0399l8;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m8
    public final EnumC0399l8 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (this.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("trackingId", this.f732a);
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
            jSONObject.put("trackingId", this.f732a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.f1075a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.f732a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static Qf a(JSONObject jSONObject) {
        EnumC0399l8 enumC0399l8;
        String optStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject optJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean optBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean optBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String optStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        EnumC0399l8.b.getClass();
        EnumC0399l8[] values = EnumC0399l8.values();
        int length = values.length;
        while (true) {
            if (i >= length) {
                enumC0399l8 = null;
                break;
            }
            enumC0399l8 = values[i];
            if (Intrinsics.areEqual(enumC0399l8.f1075a, optStringOrNull2)) {
                break;
            }
            i++;
        }
        if (enumC0399l8 == null) {
            enumC0399l8 = EnumC0399l8.c;
        }
        return new Qf(optStringOrNull, optJsonObjectOrDefault, optBooleanOrDefault, optBooleanOrDefault2, enumC0399l8);
    }
}
