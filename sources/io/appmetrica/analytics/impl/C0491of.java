package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0491of {

    /* renamed from: a  reason: collision with root package name */
    public final String f973a;
    public final JSONObject b;
    public final EnumC0335i8 c;

    public C0491of(String str, JSONObject jSONObject, EnumC0335i8 enumC0335i8) {
        this.f973a = str;
        this.b = jSONObject;
        this.c = enumC0335i8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f973a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
