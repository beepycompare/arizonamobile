package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.lc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0400lc implements InterfaceC0264g4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0264g4
    /* renamed from: b */
    public final C0425mc a(Context context, C0188d5 c0188d5, P3 p3, C0492p4 c0492p4) {
        Bg bg;
        C0450nc c0450nc = new C0450nc(p3.b, p3.f740a);
        Cg cg = new Cg(new C0525qc());
        synchronized (c0188d5) {
            bg = (Bg) c0188d5.a(c0450nc, c0492p4, cg, c0188d5.f957a);
        }
        return new C0425mc(context, bg);
    }
}
