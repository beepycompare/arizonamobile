package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes3.dex */
public final class po implements Ra {
    @Override // io.appmetrica.analytics.impl.Ra
    public final String a(Context context) {
        C0458nm c0458nm;
        try {
            Um a2 = Tm.a(C0458nm.class);
            if (a2 != null) {
                Vm vm = (Vm) a2;
                ProtobufStateStorage<Object> a3 = vm.a(context, vm.a(context));
                if (a3 == null || (c0458nm = (C0458nm) a3.read()) == null) {
                    return null;
                }
                return c0458nm.f1028a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
