package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0612tk implements InterfaceC0155bd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0155bd
    public final void a(Context context) {
        Om a2 = Nm.a(C0291gm.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0291gm c0291gm = (C0291gm) a3.read();
        C0266fm a4 = c0291gm.a(c0291gm.m);
        a4.o = 0L;
        a3.save(new C0291gm(a4));
    }
}
