package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0620tk implements InterfaceC0163bd {
    @Override // io.appmetrica.analytics.impl.InterfaceC0163bd
    public final void a(Context context) {
        Om a2 = Nm.a(C0299gm.class);
        ProtobufStateStorage<Object> a3 = a2.a(context, a2.d(context));
        C0299gm c0299gm = (C0299gm) a3.read();
        C0274fm a4 = c0299gm.a(c0299gm.m);
        a4.o = 0L;
        a3.save(new C0299gm(a4));
    }
}
