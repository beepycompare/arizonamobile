package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.mc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0422mc implements InterfaceC0286h4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0286h4
    /* renamed from: b */
    public final C0447nc a(Context context, C0209e5 c0209e5, Q3 q3, C0514q4 c0514q4) {
        Cg cg;
        C0472oc c0472oc = new C0472oc(q3.b, q3.f745a);
        Dg dg = new Dg(new C0546rc());
        synchronized (c0209e5) {
            cg = (Cg) c0209e5.a(c0472oc, c0514q4, dg, c0209e5.f963a);
        }
        return new C0447nc(context, cg);
    }
}
