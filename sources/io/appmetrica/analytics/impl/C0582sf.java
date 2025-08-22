package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.sf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0582sf {

    /* renamed from: a  reason: collision with root package name */
    public final String f1061a;
    public final JSONObject b;
    public final EnumC0451n8 c;

    public C0582sf(String str, JSONObject jSONObject, EnumC0451n8 enumC0451n8) {
        this.f1061a = str;
        this.b = jSONObject;
        this.c = enumC0451n8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f1061a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
