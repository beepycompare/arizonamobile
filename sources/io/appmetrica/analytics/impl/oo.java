package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class oo implements La {
    @Override // io.appmetrica.analytics.impl.La
    public final String a(Context context) {
        C0381km c0381km;
        try {
            Rm a2 = Qm.a(C0381km.class);
            if (a2 != null) {
                Sm sm = (Sm) a2;
                ProtobufStateStorage<Object> a3 = sm.a(context, sm.a(context));
                if (a3 == null || (c0381km = (C0381km) a3.read()) == null) {
                    return null;
                }
                return c0381km.f1078a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
