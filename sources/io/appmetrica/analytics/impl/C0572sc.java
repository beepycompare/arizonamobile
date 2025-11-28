package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0572sc implements InterfaceC0440n4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0440n4
    /* renamed from: b */
    public final C0597tc a(Context context, C0365k5 c0365k5, X3 x3, C0664w4 c0664w4) {
        Gg gg;
        C0622uc c0622uc = new C0622uc(x3.b, x3.f751a);
        Hg hg = new Hg(new C0697xc());
        synchronized (c0365k5) {
            gg = (Gg) c0365k5.a(c0622uc, c0664w4, hg, c0365k5.f967a);
        }
        return new C0597tc(context, gg);
    }
}
