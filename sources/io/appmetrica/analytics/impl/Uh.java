package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Uh implements B4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0597t5 f679a;

    public Uh(InterfaceC0597t5 interfaceC0597t5) {
        this.f679a = interfaceC0597t5;
    }

    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Sg a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Tg tg;
        C0398l5 c0398l5 = new C0398l5(c0397l4.b, c0397l4.f948a);
        Ug ug = new Ug(this.f679a);
        synchronized (c0722y5) {
            tg = (Tg) c0722y5.a(c0398l5, k4, ug, c0722y5.f1152a);
        }
        return new Sg(context, tg);
    }
}
