package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ph implements B4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0600t5 f597a;

    public Ph(InterfaceC0600t5 interfaceC0600t5) {
        this.f597a = interfaceC0600t5;
    }

    @Override // io.appmetrica.analytics.impl.B4
    /* renamed from: b */
    public final Ng a(Context context, C0725y5 c0725y5, C0400l4 c0400l4, K4 k4) {
        Og og;
        C0401l5 c0401l5 = new C0401l5(c0400l4.b, c0400l4.f933a);
        Pg pg = new Pg(this.f597a);
        synchronized (c0725y5) {
            og = (Og) c0725y5.a(c0401l5, k4, pg, c0725y5.f1148a);
        }
        return new Ng(context, og);
    }
}
