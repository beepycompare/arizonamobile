package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Qo implements InterfaceC0426mb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0426mb
    public final String a(Context context) {
        Lm lm;
        try {
            InterfaceC0593sn a2 = C0567rn.a(Lm.class);
            if (a2 != null) {
                AbstractC0619tn abstractC0619tn = (AbstractC0619tn) a2;
                ProtobufStateStorage<Object> a3 = abstractC0619tn.a(context, abstractC0619tn.a(context));
                if (a3 == null || (lm = (Lm) a3.read()) == null) {
                    return null;
                }
                return lm.f653a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
