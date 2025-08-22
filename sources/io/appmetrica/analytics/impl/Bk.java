package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class Bk implements InterfaceC0251fd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0251fd
    public final void a(Context context) {
        Wm a2 = Vm.a(C0490om.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0490om c0490om = (C0490om) a3.read();
        C0465nm a4 = c0490om.a(c0490om.m);
        a4.o = 0L;
        a3.save(new C0490om(a4));
    }
}
