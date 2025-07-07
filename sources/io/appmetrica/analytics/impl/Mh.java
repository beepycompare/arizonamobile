package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public final class Mh extends C6 {
    public final Qn d;

    public Mh(Context context, Qn qn, B6 b6, ICrashTransformer iCrashTransformer) {
        this(qn, b6, iCrashTransformer, new C0262fa(context));
    }

    public Mh(Qn qn, B6 b6, ICrashTransformer iCrashTransformer, C0262fa c0262fa) {
        super(b6, iCrashTransformer, c0262fa);
        this.d = qn;
    }
}
