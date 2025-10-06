package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Hj implements E4 {
    @Override // io.appmetrica.analytics.impl.E4
    /* renamed from: b */
    public final Dj a(Context context, B5 b5, C0476o4 c0476o4, N4 n4) {
        Xg xg;
        C0477o5 c0477o5 = new C0477o5(c0476o4.b, c0476o4.f1016a);
        synchronized (b5) {
            xg = (Xg) b5.f364a.get(c0477o5.toString());
        }
        return new Dj(xg);
    }
}
