package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Cf {

    /* renamed from: a  reason: collision with root package name */
    public final String f496a;
    public final JSONObject b;
    public final EnumC0399l8 c;

    public Cf(String str, JSONObject jSONObject, EnumC0399l8 enumC0399l8) {
        this.f496a = str;
        this.b = jSONObject;
        this.c = enumC0399l8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f496a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
