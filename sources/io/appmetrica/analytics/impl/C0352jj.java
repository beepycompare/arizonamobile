package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.jj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0352jj implements InterfaceC0286h4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0286h4
    /* renamed from: b */
    public final C0326ij a(Context context, C0209e5 c0209e5, Q3 q3, C0514q4 c0514q4) {
        Cg cg;
        C0472oc c0472oc = new C0472oc(q3.b, q3.f744a);
        synchronized (c0209e5) {
            cg = (Cg) c0209e5.f962a.get(c0472oc.toString());
        }
        return new C0326ij(cg);
    }
}
