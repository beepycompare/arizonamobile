package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.tc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0604tc implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final P4 a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        S4 s4;
        Q4 q4 = new Q4(c0397l4.b);
        T4 t4 = new T4();
        synchronized (c0722y5) {
            s4 = (S4) c0722y5.a(q4, k4, t4, c0722y5.b);
        }
        return new P4(context, s4, k4);
    }
}
