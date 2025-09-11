package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0686wf {

    /* renamed from: a  reason: collision with root package name */
    public final String f1139a;
    public final JSONObject b;
    public final EnumC0530q8 c;

    public C0686wf(String str, JSONObject jSONObject, EnumC0530q8 enumC0530q8) {
        this.f1139a = str;
        this.b = jSONObject;
        this.c = enumC0530q8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f1139a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
