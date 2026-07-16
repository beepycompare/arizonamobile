package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.d6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0191d6 extends BaseRequestConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f941a;
    public String b;
    public Hm c;

    public final String b() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public String toString() {
        return "CoreRequestConfig{mAppDebuggable='" + this.f941a + "', mAppSystem='" + this.b + "', startupState=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public final String a() {
        return this.f941a;
    }
}
