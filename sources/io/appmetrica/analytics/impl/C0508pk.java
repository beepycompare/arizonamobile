package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.pk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0508pk implements Ic {
    @Override // io.appmetrica.analytics.impl.Ic
    public final void a(Context context) {
        Rm rm = (Rm) Pm.a(C0359jm.class);
        ProtobufStateStorage<Object> a2 = rm.a(context, rm.b(context));
        C0359jm c0359jm = (C0359jm) a2.read();
        C0333im a3 = c0359jm.a(c0359jm.m);
        a3.o = 0L;
        a2.save(new C0359jm(a3));
    }
}
