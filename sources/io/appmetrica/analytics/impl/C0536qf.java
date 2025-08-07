package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.qf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0536qf {

    /* renamed from: a  reason: collision with root package name */
    public final String f1019a;
    public final JSONObject b;
    public final EnumC0404l8 c;

    public C0536qf(String str, JSONObject jSONObject, EnumC0404l8 enumC0404l8) {
        this.f1019a = str;
        this.b = jSONObject;
        this.c = enumC0404l8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f1019a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
