package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Cf {

    /* renamed from: a  reason: collision with root package name */
    public final String f502a;
    public final JSONObject b;
    public final EnumC0392l8 c;

    public Cf(String str, JSONObject jSONObject, EnumC0392l8 enumC0392l8) {
        this.f502a = str;
        this.b = jSONObject;
        this.c = enumC0392l8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f502a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
