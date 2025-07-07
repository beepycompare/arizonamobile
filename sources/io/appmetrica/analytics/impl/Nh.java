package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Nh implements B4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0605t5 f555a;

    public Nh(InterfaceC0605t5 interfaceC0605t5) {
        this.f555a = interfaceC0605t5;
    }

    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Lg a(Context context, C0730y5 c0730y5, C0405l4 c0405l4, K4 k4) {
        Mg mg;
        C0406l5 c0406l5 = new C0406l5(c0405l4.b, c0405l4.f916a);
        Ng ng = new Ng(this.f555a);
        synchronized (c0730y5) {
            mg = (Mg) c0730y5.a(c0406l5, k4, ng, c0730y5.f1139a);
        }
        return new Lg(context, mg);
    }
}
