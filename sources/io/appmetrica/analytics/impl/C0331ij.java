package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.ij  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0331ij implements InterfaceC0265g4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0265g4
    /* renamed from: b */
    public final C0306hj a(Context context, C0189d5 c0189d5, P3 p3, C0493p4 c0493p4) {
        Bg bg;
        C0451nc c0451nc = new C0451nc(p3.b, p3.f735a);
        synchronized (c0189d5) {
            bg = (Bg) c0189d5.f952a.get(c0451nc.toString());
        }
        return new C0306hj(bg);
    }
}
