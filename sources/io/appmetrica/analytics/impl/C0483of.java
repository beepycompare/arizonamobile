package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0483of {

    /* renamed from: a  reason: collision with root package name */
    public final String f974a;
    public final JSONObject b;
    public final EnumC0327i8 c;

    public C0483of(String str, JSONObject jSONObject, EnumC0327i8 enumC0327i8) {
        this.f974a = str;
        this.b = jSONObject;
        this.c = enumC0327i8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f974a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
