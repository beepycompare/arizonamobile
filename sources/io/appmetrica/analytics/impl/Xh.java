package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public final class Xh extends I6 {
    public final AbstractC0186co d;

    public Xh(Context context, AbstractC0186co abstractC0186co, H6 h6, ICrashTransformer iCrashTransformer) {
        this(abstractC0186co, h6, iCrashTransformer, new C0430ma(context));
    }

    public Xh(AbstractC0186co abstractC0186co, H6 h6, ICrashTransformer iCrashTransformer, C0430ma c0430ma) {
        super(h6, iCrashTransformer, c0430ma);
        this.d = abstractC0186co;
    }
}
