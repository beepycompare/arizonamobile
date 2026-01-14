package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0173cf {

    /* renamed from: a  reason: collision with root package name */
    public final String f939a;
    public final JSONObject b;
    public final S7 c;

    public C0173cf(String str, JSONObject jSONObject, S7 s7) {
        this.f939a = str;
        this.b = jSONObject;
        this.c = s7;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f939a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
