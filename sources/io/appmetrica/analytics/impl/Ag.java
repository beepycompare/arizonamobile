package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class Ag {
    public static /* synthetic */ String a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return "rustore";
                    }
                    throw null;
                }
                return "hms-content-provider";
            }
            return "gpl";
        }
        return "unknown";
    }

    public static /* synthetic */ String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractJsonLexerKt.NULL : "RS" : "HMS" : "GP" : "UNKNOWN";
    }
}
