package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Qo implements InterfaceC0427mb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0427mb
    public final String a(Context context) {
        Lm lm;
        try {
            InterfaceC0594sn a2 = C0568rn.a(Lm.class);
            if (a2 != null) {
                AbstractC0620tn abstractC0620tn = (AbstractC0620tn) a2;
                ProtobufStateStorage<Object> a3 = abstractC0620tn.a(context, abstractC0620tn.a(context));
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
