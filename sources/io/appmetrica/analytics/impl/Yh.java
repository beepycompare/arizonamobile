package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Yh implements E4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0677w5 f759a;

    public Yh(InterfaceC0677w5 interfaceC0677w5) {
        this.f759a = interfaceC0677w5;
    }

    @Override // io.appmetrica.analytics.impl.E4
    /* renamed from: b */
    public final Wg a(Context context, B5 b5, C0476o4 c0476o4, N4 n4) {
        Xg xg;
        C0477o5 c0477o5 = new C0477o5(c0476o4.b, c0476o4.f1016a);
        Yg yg = new Yg(this.f759a);
        synchronized (b5) {
            xg = (Xg) b5.a(c0477o5, n4, yg, b5.f364a);
        }
        return new Wg(context, xg);
    }
}
