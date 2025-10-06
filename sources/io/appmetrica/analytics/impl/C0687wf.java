package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.wf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0687wf {

    /* renamed from: a  reason: collision with root package name */
    public final String f1140a;
    public final JSONObject b;
    public final EnumC0531q8 c;

    public C0687wf(String str, JSONObject jSONObject, EnumC0531q8 enumC0531q8) {
        this.f1140a = str;
        this.b = jSONObject;
        this.c = enumC0531q8;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f1140a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
