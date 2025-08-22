package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ic implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Jc a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Tg tg;
        Kc kc = new Kc(c0397l4.b, c0397l4.f948a);
        Ug ug = new Ug(new Nc());
        synchronized (c0722y5) {
            tg = (Tg) c0722y5.a(kc, k4, ug, c0722y5.f1152a);
        }
        return new Jc(context, tg);
    }
}
