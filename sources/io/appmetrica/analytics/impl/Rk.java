package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Rk implements InterfaceC0350jd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0350jd
    public final void a(Context context) {
        AbstractC0619tn abstractC0619tn = (AbstractC0619tn) C0567rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0619tn.a(context, abstractC0619tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
    }
}
