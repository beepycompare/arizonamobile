package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ec implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Fc a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Mg mg;
        Gc gc = new Gc(c0397l4.b, c0397l4.f917a);
        Ng ng = new Ng(new Jc());
        synchronized (c0722y5) {
            mg = (Mg) c0722y5.a(gc, k4, ng, c0722y5.f1140a);
        }
        return new Fc(context, mg);
    }
}
