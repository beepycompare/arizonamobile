package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Dh implements InterfaceC0286h4 {

    /* renamed from: a  reason: collision with root package name */
    public final Z4 f544a;

    public Dh(Z4 z4) {
        this.f544a = z4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0286h4
    /* renamed from: b */
    public final Bg a(Context context, C0209e5 c0209e5, Q3 q3, C0514q4 c0514q4) {
        Cg cg;
        R4 r4 = new R4(q3.b, q3.f745a);
        Dg dg = new Dg(this.f544a);
        synchronized (c0209e5) {
            cg = (Cg) c0209e5.a(r4, c0514q4, dg, c0209e5.f963a);
        }
        return new Bg(context, cg);
    }
}
