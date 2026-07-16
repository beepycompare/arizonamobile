package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Qo implements InterfaceC0428mb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0428mb
    public final String a(Context context) {
        Lm lm;
        try {
            InterfaceC0595sn a2 = C0569rn.a(Lm.class);
            if (a2 != null) {
                AbstractC0621tn abstractC0621tn = (AbstractC0621tn) a2;
                ProtobufStateStorage<Object> a3 = abstractC0621tn.a(context, abstractC0621tn.a(context));
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
