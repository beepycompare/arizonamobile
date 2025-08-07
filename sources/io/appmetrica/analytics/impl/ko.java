package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class ko implements InterfaceC0257fb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0257fb
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0368jm c0368jm;
        try {
            Rm a3 = Qm.a(C0368jm.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0368jm = (C0368jm) a2.read()) == null) {
                return null;
            }
            return c0368jm.f917a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
