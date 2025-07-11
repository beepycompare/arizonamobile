package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public final class Mh extends C6 {
    public final Qn d;

    public Mh(Context context, Qn qn, B6 b6, ICrashTransformer iCrashTransformer) {
        this(qn, b6, iCrashTransformer, new C0254fa(context));
    }

    public Mh(Qn qn, B6 b6, ICrashTransformer iCrashTransformer, C0254fa c0254fa) {
        super(b6, iCrashTransformer, c0254fa);
        this.d = qn;
    }
}
