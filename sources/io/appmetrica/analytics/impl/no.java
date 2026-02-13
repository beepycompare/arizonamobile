package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class no implements Ka {
    @Override // io.appmetrica.analytics.impl.Ka
    public final String a(Context context) {
        C0360jm c0360jm;
        try {
            Qm a2 = Pm.a(C0360jm.class);
            if (a2 != null) {
                Rm rm = (Rm) a2;
                ProtobufStateStorage<Object> a3 = rm.a(context, rm.a(context));
                if (a3 == null || (c0360jm = (C0360jm) a3.read()) == null) {
                    return null;
                }
                return c0360jm.f1068a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
