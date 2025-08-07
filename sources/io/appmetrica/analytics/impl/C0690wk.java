package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0690wk implements InterfaceC0208dd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0208dd
    public final void a(Context context) {
        Rm a2 = Qm.a(C0368jm.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0368jm c0368jm = (C0368jm) a3.read();
        C0343im a4 = c0368jm.a(c0368jm.m);
        a4.o = 0L;
        a3.save(new C0368jm(a4));
    }
}
