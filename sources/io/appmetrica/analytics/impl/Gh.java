package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes5.dex */
public final class Gh extends AbstractC0517q6 {
    public final Yn d;

    public Gh(Context context, Yn yn, InterfaceC0492p6 interfaceC0492p6, ICrashTransformer iCrashTransformer) {
        this(yn, interfaceC0492p6, iCrashTransformer, new T9(context));
    }

    public Gh(Yn yn, InterfaceC0492p6 interfaceC0492p6, ICrashTransformer iCrashTransformer, T9 t9) {
        super(interfaceC0492p6, iCrashTransformer, t9);
        this.d = yn;
    }
}
