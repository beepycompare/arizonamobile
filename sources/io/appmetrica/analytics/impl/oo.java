package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class oo implements La {
    @Override // io.appmetrica.analytics.impl.La
    public final String a(Context context) {
        C0382km c0382km;
        try {
            Rm a2 = Qm.a(C0382km.class);
            if (a2 != null) {
                Sm sm = (Sm) a2;
                ProtobufStateStorage<Object> a3 = sm.a(context, sm.a(context));
                if (a3 == null || (c0382km = (C0382km) a3.read()) == null) {
                    return null;
                }
                return c0382km.f981a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
