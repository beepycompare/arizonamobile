package io.appmetrica.analytics.idsync.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public abstract /* synthetic */ class z {
    public static /* synthetic */ String a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return "failure";
                    }
                    throw null;
                }
                return "incompatible_precondition";
            }
            return FirebaseAnalytics.Param.SUCCESS;
        }
        return "none";
    }

    public static /* synthetic */ String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractJsonLexerKt.NULL : "FAILURE" : "INCOMPATIBLE_PRECONDITION" : "SUCCESS" : "NONE";
    }
}
