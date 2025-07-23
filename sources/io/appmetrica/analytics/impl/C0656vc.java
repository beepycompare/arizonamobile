package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.vc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0656vc implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final P4 a(Context context, C0724y5 c0724y5, C0399l4 c0399l4, K4 k4) {
        S4 s4;
        Q4 q4 = new Q4(c0399l4.b);
        T4 t4 = new T4();
        synchronized (c0724y5) {
            s4 = (S4) c0724y5.a(q4, k4, t4, c0724y5.b);
        }
        return new P4(context, s4, k4);
    }
}
