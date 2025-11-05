package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0605tk implements Pc {
    @Override // io.appmetrica.analytics.impl.Pc
    public final void a(Context context) {
        Vm vm = (Vm) Tm.a(C0458nm.class);
        ProtobufStateStorage<Object> a2 = vm.a(context, vm.b(context));
        C0458nm c0458nm = (C0458nm) a2.read();
        C0433mm a3 = c0458nm.a(c0458nm.m);
        a3.o = 0L;
        a2.save(new C0458nm(a3));
    }
}
