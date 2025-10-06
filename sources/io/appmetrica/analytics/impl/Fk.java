package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class Fk implements InterfaceC0330id {
    @Override // io.appmetrica.analytics.impl.InterfaceC0330id
    public final void a(Context context) {
        AbstractC0133an a2 = Zm.a(C0594sm.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0594sm c0594sm = (C0594sm) a3.read();
        C0569rm a4 = c0594sm.a(c0594sm.m);
        a4.o = 0L;
        a3.save(new C0594sm(a4));
    }
}
