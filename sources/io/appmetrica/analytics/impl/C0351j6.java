package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.j6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0351j6 extends BaseRequestConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f915a;
    public String b;
    public C0267fm c;

    public final String b() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public String toString() {
        return "CoreRequestConfig{mAppDebuggable='" + this.f915a + "', mAppSystem='" + this.b + "', startupState=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public final String a() {
        return this.f915a;
    }
}
