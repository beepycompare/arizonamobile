package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public abstract /* synthetic */ class G {
    public static /* synthetic */ String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractJsonLexerKt.NULL : "UNKNOWN" : "FORBIDDEN_BY_REMOTE_CONFIG" : "FORBIDDEN_BY_CLIENT_CONFIG" : "ALLOWED";
    }
}
