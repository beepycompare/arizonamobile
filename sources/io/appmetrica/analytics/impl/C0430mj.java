package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.mj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0430mj implements InterfaceC0287h4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0287h4
    /* renamed from: b */
    public final C0327ij a(Context context, C0210e5 c0210e5, Q3 q3, C0515q4 c0515q4) {
        Cg cg;
        R4 r4 = new R4(q3.b, q3.f647a);
        synchronized (c0210e5) {
            cg = (Cg) c0210e5.f865a.get(r4.toString());
        }
        return new C0327ij(cg);
    }
}
