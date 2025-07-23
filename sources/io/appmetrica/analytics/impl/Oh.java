package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public final class Oh extends F6 {
    public final Tn d;

    public Oh(Context context, Tn tn, E6 e6, ICrashTransformer iCrashTransformer) {
        this(tn, e6, iCrashTransformer, new C0306ha(context));
    }

    public Oh(Tn tn, E6 e6, ICrashTransformer iCrashTransformer, C0306ha c0306ha) {
        super(e6, iCrashTransformer, c0306ha);
        this.d = tn;
    }
}
