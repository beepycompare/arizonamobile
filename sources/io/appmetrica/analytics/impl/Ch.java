package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes5.dex */
public final class Ch extends AbstractC0366k6 {
    public final Xn d;

    public Ch(Context context, Xn xn, InterfaceC0340j6 interfaceC0340j6, ICrashTransformer iCrashTransformer) {
        this(xn, interfaceC0340j6, iCrashTransformer, new N9(context));
    }

    public Ch(Xn xn, InterfaceC0340j6 interfaceC0340j6, ICrashTransformer iCrashTransformer, N9 n9) {
        super(interfaceC0340j6, iCrashTransformer, n9);
        this.d = xn;
    }
}
