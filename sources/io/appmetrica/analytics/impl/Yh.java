package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Yh implements E4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0676w5 f754a;

    public Yh(InterfaceC0676w5 interfaceC0676w5) {
        this.f754a = interfaceC0676w5;
    }

    @Override // io.appmetrica.analytics.impl.E4
    /* renamed from: b */
    public final Wg a(Context context, B5 b5, C0475o4 c0475o4, N4 n4) {
        Xg xg;
        C0476o5 c0476o5 = new C0476o5(c0475o4.b, c0475o4.f1011a);
        Yg yg = new Yg(this.f754a);
        synchronized (b5) {
            xg = (Xg) b5.a(c0476o5, n4, yg, b5.f359a);
        }
        return new Wg(context, xg);
    }
}
