package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class ko implements InterfaceC0256fb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0256fb
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0367jm c0367jm;
        try {
            Rm a3 = Qm.a(C0367jm.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0367jm = (C0367jm) a2.read()) == null) {
                return null;
            }
            return c0367jm.f917a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
