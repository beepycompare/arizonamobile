package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class Fk implements InterfaceC0329id {
    @Override // io.appmetrica.analytics.impl.InterfaceC0329id
    public final void a(Context context) {
        AbstractC0132an a2 = Zm.a(C0593sm.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0593sm c0593sm = (C0593sm) a3.read();
        C0568rm a4 = c0593sm.a(c0593sm.m);
        a4.o = 0L;
        a3.save(new C0593sm(a4));
    }
}
