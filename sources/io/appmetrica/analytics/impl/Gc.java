package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Gc implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Hc a(Context context, C0724y5 c0724y5, C0399l4 c0399l4, K4 k4) {
        Og og;
        Ic ic = new Ic(c0399l4.b, c0399l4.f933a);
        Pg pg = new Pg(new Lc());
        synchronized (c0724y5) {
            og = (Og) c0724y5.a(ic, k4, pg, c0724y5.f1148a);
        }
        return new Hc(context, og);
    }
}
