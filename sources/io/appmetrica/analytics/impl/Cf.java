package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Cf {

    /* renamed from: a  reason: collision with root package name */
    public final String f499a;
    public final JSONObject b;
    public final EnumC0398l8 c;

    public Cf(String str, JSONObject jSONObject, EnumC0398l8 enumC0398l8) {
        this.f499a = str;
        this.b = jSONObject;
        this.c = enumC0398l8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f499a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
