package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.qf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0535qf {

    /* renamed from: a  reason: collision with root package name */
    public final String f1020a;
    public final JSONObject b;
    public final EnumC0403l8 c;

    public C0535qf(String str, JSONObject jSONObject, EnumC0403l8 enumC0403l8) {
        this.f1020a = str;
        this.b = jSONObject;
        this.c = enumC0403l8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f1020a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
