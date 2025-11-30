package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0531qk implements Jc {
    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(Context context) {
        Sm sm = (Sm) Qm.a(C0382km.class);
        ProtobufStateStorage<Object> a2 = sm.a(context, sm.b(context));
        C0382km c0382km = (C0382km) a2.read();
        C0356jm a3 = c0382km.a(c0382km.m);
        a3.o = 0L;
        a2.save(new C0382km(a3));
    }
}
