package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Lc implements E4 {
    @Override // io.appmetrica.analytics.impl.E4
    /* renamed from: b */
    public final Mc a(Context context, B5 b5, C0475o4 c0475o4, N4 n4) {
        Xg xg;
        Nc nc = new Nc(c0475o4.b, c0475o4.f1016a);
        Yg yg = new Yg(new Qc());
        synchronized (b5) {
            xg = (Xg) b5.a(nc, n4, yg, b5.f364a);
        }
        return new Mc(context, xg);
    }
}
