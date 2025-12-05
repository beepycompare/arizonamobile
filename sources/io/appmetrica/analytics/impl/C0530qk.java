package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0530qk implements Jc {
    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(Context context) {
        Sm sm = (Sm) Qm.a(C0381km.class);
        ProtobufStateStorage<Object> a2 = sm.a(context, sm.b(context));
        C0381km c0381km = (C0381km) a2.read();
        C0355jm a3 = c0381km.a(c0381km.m);
        a3.o = 0L;
        a2.save(new C0381km(a3));
    }
}
