package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class to implements InterfaceC0379kb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0379kb
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0594sm c0594sm;
        try {
            AbstractC0133an a3 = Zm.a(C0594sm.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0594sm = (C0594sm) a2.read()) == null) {
                return null;
            }
            return c0594sm.f1085a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
