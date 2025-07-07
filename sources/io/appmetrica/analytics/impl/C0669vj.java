package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.vj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0669vj implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final C0569rj a(Context context, C0730y5 c0730y5, C0405l4 c0405l4, K4 k4) {
        Mg mg;
        C0406l5 c0406l5 = new C0406l5(c0405l4.b, c0405l4.f916a);
        synchronized (c0730y5) {
            mg = (Mg) c0730y5.f1139a.get(c0406l5.toString());
        }
        return new C0569rj(mg);
    }
}
