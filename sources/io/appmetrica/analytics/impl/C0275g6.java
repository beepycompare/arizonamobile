package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.g6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0275g6 extends BaseRequestConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f852a;
    public String b;
    public C0190cm c;

    public final String b() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public String toString() {
        return "CoreRequestConfig{mAppDebuggable='" + this.f852a + "', mAppSystem='" + this.b + "', startupState=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public final String a() {
        return this.f852a;
    }
}
