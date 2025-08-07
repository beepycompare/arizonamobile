package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0739yj implements B4 {
    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final C0639uj a(Context context, C0725y5 c0725y5, C0400l4 c0400l4, K4 k4) {
        Og og;
        C0401l5 c0401l5 = new C0401l5(c0400l4.b, c0400l4.f933a);
        synchronized (c0725y5) {
            og = (Og) c0725y5.f1148a.get(c0401l5.toString());
        }
        return new C0639uj(og);
    }
}
