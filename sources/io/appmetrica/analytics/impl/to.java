package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class to implements InterfaceC0378kb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0378kb
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0593sm c0593sm;
        try {
            AbstractC0132an a3 = Zm.a(C0593sm.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0593sm = (C0593sm) a2.read()) == null) {
                return null;
            }
            return c0593sm.f1084a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
