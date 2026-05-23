package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Cc implements InterfaceC0706x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0706x4
    /* renamed from: b */
    public final L4 a(Context context, C0603t5 c0603t5, C0266g4 c0266g4, G4 g4) {
        N4 n4;
        M4 m4 = new M4(c0266g4.b);
        O4 o4 = new O4();
        synchronized (c0603t5) {
            n4 = (N4) c0603t5.a(m4, g4, o4, c0603t5.b);
        }
        return new L4(context, n4, g4);
    }
}
