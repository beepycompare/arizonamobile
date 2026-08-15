package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Rk implements InterfaceC0351jd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0351jd
    public final void a(Context context) {
        AbstractC0620tn abstractC0620tn = (AbstractC0620tn) C0568rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0620tn.a(context, abstractC0620tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
    }
}
