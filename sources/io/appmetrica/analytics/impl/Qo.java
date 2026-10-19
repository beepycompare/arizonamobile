package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Qo implements InterfaceC0421mb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0421mb
    public final String a(Context context) {
        Lm lm;
        try {
            InterfaceC0588sn a2 = C0562rn.a(Lm.class);
            if (a2 != null) {
                AbstractC0614tn abstractC0614tn = (AbstractC0614tn) a2;
                ProtobufStateStorage<Object> a3 = abstractC0614tn.a(context, abstractC0614tn.a(context));
                if (a3 == null || (lm = (Lm) a3.read()) == null) {
                    return null;
                }
                return lm.f656a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
