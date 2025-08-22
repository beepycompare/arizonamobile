package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public final class Th extends F6 {
    public final Yn d;

    public Th(Context context, Yn yn, E6 e6, ICrashTransformer iCrashTransformer) {
        this(yn, e6, iCrashTransformer, new C0351ja(context));
    }

    public Th(Yn yn, E6 e6, ICrashTransformer iCrashTransformer, C0351ja c0351ja) {
        super(e6, iCrashTransformer, c0351ja);
        this.d = yn;
    }
}
