package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Rk implements InterfaceC0345jd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0345jd
    public final void a(Context context) {
        AbstractC0614tn abstractC0614tn = (AbstractC0614tn) C0562rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0614tn.a(context, abstractC0614tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
    }
}
