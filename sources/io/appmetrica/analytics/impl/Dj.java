package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Dj implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final C0761zj a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Tg tg;
        C0398l5 c0398l5 = new C0398l5(c0397l4.b, c0397l4.f948a);
        synchronized (c0722y5) {
            tg = (Tg) c0722y5.f1152a.get(c0398l5.toString());
        }
        return new C0761zj(tg);
    }
}
