package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Rk implements InterfaceC0352jd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0352jd
    public final void a(Context context) {
        AbstractC0621tn abstractC0621tn = (AbstractC0621tn) C0569rn.a(Lm.class);
        ProtobufStateStorage<Object> a2 = abstractC0621tn.a(context, abstractC0621tn.b(context));
        Lm lm = (Lm) a2.read();
        Km a3 = lm.a(lm.m);
        a3.o = 0L;
        a2.save(new Lm(a3));
    }
}
