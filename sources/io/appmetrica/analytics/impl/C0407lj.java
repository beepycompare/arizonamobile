package io.appmetrica.analytics.impl;

import android.content.Context;
/* renamed from: io.appmetrica.analytics.impl.lj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0407lj implements InterfaceC0264g4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0264g4
    /* renamed from: b */
    public final C0305hj a(Context context, C0188d5 c0188d5, P3 p3, C0492p4 c0492p4) {
        Bg bg;
        Q4 q4 = new Q4(p3.b, p3.f740a);
        synchronized (c0188d5) {
            bg = (Bg) c0188d5.f957a.get(q4.toString());
        }
        return new C0305hj(bg);
    }
}
