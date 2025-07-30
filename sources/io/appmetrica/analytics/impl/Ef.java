package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Ef implements InterfaceC0428m8 {

    /* renamed from: a  reason: collision with root package name */
    public final String f419a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final EnumC0403l8 e;

    public Ef(String str, JSONObject jSONObject, boolean z, boolean z2, EnumC0403l8 enumC0403l8) {
        this.f419a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = enumC0403l8;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0428m8
    public final EnumC0403l8 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (this.c) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("trackingId", this.f419a);
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
            jSONObject.put("trackingId", this.f419a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.f937a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.f419a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static Ef a(JSONObject jSONObject) {
        EnumC0403l8 enumC0403l8;
        String optStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject optJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean optBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean optBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String optStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        EnumC0403l8[] values = EnumC0403l8.values();
        int length = values.length;
        while (true) {
            if (i >= length) {
                enumC0403l8 = null;
                break;
            }
            enumC0403l8 = values[i];
            if (Intrinsics.areEqual(enumC0403l8.f937a, optStringOrNull2)) {
                break;
            }
            i++;
        }
        if (enumC0403l8 == null) {
            enumC0403l8 = EnumC0403l8.b;
        }
        return new Ef(optStringOrNull, optJsonObjectOrDefault, optBooleanOrDefault, optBooleanOrDefault2, enumC0403l8);
    }
}
