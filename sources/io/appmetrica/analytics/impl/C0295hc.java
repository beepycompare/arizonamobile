package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.hc  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0295hc implements InterfaceC0440n4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0440n4
    /* renamed from: b */
    public final B4 a(Context context, C0365k5 c0365k5, X3 x3, C0664w4 c0664w4) {
        E4 e4;
        C4 c4 = new C4(x3.b);
        F4 f4 = new F4();
        synchronized (c0365k5) {
            e4 = (E4) c0365k5.a(c4, c0664w4, f4, c0365k5.b);
        }
        return new B4(context, e4, c0664w4);
    }
}
