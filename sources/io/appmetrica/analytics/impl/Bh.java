package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes5.dex */
public final class Bh extends AbstractC0343j6 {
    public final Wn d;

    public Bh(Context context, Wn wn, InterfaceC0318i6 interfaceC0318i6, ICrashTransformer iCrashTransformer) {
        this(wn, interfaceC0318i6, iCrashTransformer, new M9(context));
    }

    public Bh(Wn wn, InterfaceC0318i6 interfaceC0318i6, ICrashTransformer iCrashTransformer, M9 m9) {
        super(interfaceC0318i6, iCrashTransformer, m9);
        this.d = wn;
    }
}
