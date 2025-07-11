package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Nh implements B4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0597t5 f556a;

    public Nh(InterfaceC0597t5 interfaceC0597t5) {
        this.f556a = interfaceC0597t5;
    }

    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Lg a(Context context, C0722y5 c0722y5, C0397l4 c0397l4, K4 k4) {
        Mg mg;
        C0398l5 c0398l5 = new C0398l5(c0397l4.b, c0397l4.f917a);
        Ng ng = new Ng(this.f556a);
        synchronized (c0722y5) {
            mg = (Mg) c0722y5.a(c0398l5, k4, ng, c0722y5.f1140a);
        }
        return new Lg(context, mg);
    }
}
