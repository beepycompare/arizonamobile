package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Dh implements InterfaceC0287h4 {

    /* renamed from: a  reason: collision with root package name */
    public final Z4 f446a;

    public Dh(Z4 z4) {
        this.f446a = z4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0287h4
    /* renamed from: b */
    public final Bg a(Context context, C0210e5 c0210e5, Q3 q3, C0515q4 c0515q4) {
        Cg cg;
        R4 r4 = new R4(q3.b, q3.f647a);
        Dg dg = new Dg(this.f446a);
        synchronized (c0210e5) {
            cg = (Cg) c0210e5.a(r4, c0515q4, dg, c0210e5.f865a);
        }
        return new Bg(context, cg);
    }
}
