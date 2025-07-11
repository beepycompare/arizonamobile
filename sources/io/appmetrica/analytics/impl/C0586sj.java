package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.sj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0586sj implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final C0561rj a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Mg mg;
        Gc gc = new Gc(c0397l4.b, c0397l4.f917a);
        synchronized (c0722y5) {
            mg = (Mg) c0722y5.f1140a.get(gc.toString());
        }
        return new C0561rj(mg);
    }
}
