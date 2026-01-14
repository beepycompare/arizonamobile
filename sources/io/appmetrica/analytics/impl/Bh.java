package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes5.dex */
public final class Bh extends AbstractC0344j6 {
    public final Wn d;

    public Bh(Context context, Wn wn, InterfaceC0319i6 interfaceC0319i6, ICrashTransformer iCrashTransformer) {
        this(wn, interfaceC0319i6, iCrashTransformer, new M9(context));
    }

    public Bh(Wn wn, InterfaceC0319i6 interfaceC0319i6, ICrashTransformer iCrashTransformer, M9 m9) {
        super(interfaceC0319i6, iCrashTransformer, m9);
        this.d = wn;
    }
}
