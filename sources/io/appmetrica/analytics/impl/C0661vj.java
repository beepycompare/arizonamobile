package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.vj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0661vj implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final C0561rj a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Mg mg;
        C0398l5 c0398l5 = new C0398l5(c0397l4.b, c0397l4.f917a);
        synchronized (c0722y5) {
            mg = (Mg) c0722y5.f1140a.get(c0398l5.toString());
        }
        return new C0561rj(mg);
    }
}
