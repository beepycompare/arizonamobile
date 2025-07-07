package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ec implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Fc a(Context context, C0730y5 c0730y5, C0405l4 c0405l4, K4 k4) {
        Mg mg;
        Gc gc = new Gc(c0405l4.b, c0405l4.f916a);
        Ng ng = new Ng(new Jc());
        synchronized (c0730y5) {
            mg = (Mg) c0730y5.a(gc, k4, ng, c0730y5.f1139a);
        }
        return new Fc(context, mg);
    }
}
