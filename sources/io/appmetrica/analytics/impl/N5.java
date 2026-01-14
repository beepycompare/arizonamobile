package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class N5 extends BaseRequestConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f706a;
    public String b;
    public C0257fm c;

    public final String b() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public String toString() {
        return "CoreRequestConfig{mAppDebuggable='" + this.f706a + "', mAppSystem='" + this.b + "', startupState=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public final String a() {
        return this.f706a;
    }
}
