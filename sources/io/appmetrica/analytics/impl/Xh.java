package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public final class Xh extends I6 {
    public final AbstractC0185co d;

    public Xh(Context context, AbstractC0185co abstractC0185co, H6 h6, ICrashTransformer iCrashTransformer) {
        this(abstractC0185co, h6, iCrashTransformer, new C0429ma(context));
    }

    public Xh(AbstractC0185co abstractC0185co, H6 h6, ICrashTransformer iCrashTransformer, C0429ma c0429ma) {
        super(h6, iCrashTransformer, c0429ma);
        this.d = abstractC0185co;
    }
}
