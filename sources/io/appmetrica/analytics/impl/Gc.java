package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Gc implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Hc a(Context context, C0725y5 c0725y5, C0400l4 c0400l4, K4 k4) {
        Og og;
        Ic ic = new Ic(c0400l4.b, c0400l4.f933a);
        Pg pg = new Pg(new Lc());
        synchronized (c0725y5) {
            og = (Og) c0725y5.a(ic, k4, pg, c0725y5.f1148a);
        }
        return new Hc(context, og);
    }
}
