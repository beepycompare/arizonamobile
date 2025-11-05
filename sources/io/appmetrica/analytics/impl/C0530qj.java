package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0530qj implements InterfaceC0440n4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0440n4
    /* renamed from: b */
    public final C0430mj a(Context context, C0365k5 c0365k5, X3 x3, C0664w4 c0664w4) {
        Gg gg;
        X4 x4 = new X4(x3.b, x3.f751a);
        synchronized (c0365k5) {
            gg = (Gg) c0365k5.f967a.get(x4.toString());
        }
        return new C0430mj(gg);
    }
}
