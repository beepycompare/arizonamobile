package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0689wk implements InterfaceC0207dd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0207dd
    public final void a(Context context) {
        Rm a2 = Qm.a(C0367jm.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0367jm c0367jm = (C0367jm) a3.read();
        C0342im a4 = c0367jm.a(c0367jm.m);
        a4.o = 0L;
        a3.save(new C0367jm(a4));
    }
}
