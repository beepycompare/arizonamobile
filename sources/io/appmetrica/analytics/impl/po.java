package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes4.dex */
public final class po implements InterfaceC0301hb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0301hb
    public final String a(Context context) {
        ProtobufStateStorage<Object> a2;
        C0490om c0490om;
        try {
            Wm a3 = Vm.a(C0490om.class);
            if (a3 == null || (a2 = a3.a(context, a3.c(context))) == null || (c0490om = (C0490om) a2.read()) == null) {
                return null;
            }
            return c0490om.f1002a;
        } catch (Throwable unused) {
            return null;
        }
    }
}
