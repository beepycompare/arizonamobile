package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0738yj implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final C0638uj a(Context context, C0724y5 c0724y5, C0399l4 c0399l4, K4 k4) {
        Og og;
        C0400l5 c0400l5 = new C0400l5(c0399l4.b, c0399l4.f934a);
        synchronized (c0724y5) {
            og = (Og) c0724y5.f1149a.get(c0400l5.toString());
        }
        return new C0638uj(og);
    }
}
