package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.hf  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0298hf {

    /* renamed from: a  reason: collision with root package name */
    public final String f911a;
    public final JSONObject b;
    public final Y7 c;

    public C0298hf(String str, JSONObject jSONObject, Y7 y7) {
        this.f911a = str;
        this.b = jSONObject;
        this.c = y7;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f911a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
