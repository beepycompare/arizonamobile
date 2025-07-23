package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ph implements B4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0599t5 f597a;

    public Ph(InterfaceC0599t5 interfaceC0599t5) {
        this.f597a = interfaceC0599t5;
    }

    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Ng a(Context context, C0724y5 c0724y5, C0399l4 c0399l4, K4 k4) {
        Og og;
        C0400l5 c0400l5 = new C0400l5(c0399l4.b, c0399l4.f933a);
        Pg pg = new Pg(this.f597a);
        synchronized (c0724y5) {
            og = (Og) c0724y5.a(c0400l5, k4, pg, c0724y5.f1148a);
        }
        return new Ng(context, og);
    }
}
