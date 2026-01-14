package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.pk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0509pk implements Ic {
    @Override // io.appmetrica.analytics.impl.Ic
    public final void a(Context context) {
        Rm rm = (Rm) Pm.a(C0360jm.class);
        ProtobufStateStorage<Object> a2 = rm.a(context, rm.b(context));
        C0360jm c0360jm = (C0360jm) a2.read();
        C0334im a3 = c0360jm.a(c0360jm.m);
        a3.o = 0L;
        a2.save(new C0360jm(a3));
    }
}
