package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Ch implements InterfaceC0265g4 {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f535a;

    public Ch(Y4 y4) {
        this.f535a = y4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0265g4
    /* renamed from: b */
    public final Ag a(Context context, C0189d5 c0189d5, P3 p3, C0493p4 c0493p4) {
        Bg bg;
        Q4 q4 = new Q4(p3.b, p3.f735a);
        Cg cg = new Cg(this.f535a);
        synchronized (c0189d5) {
            bg = (Bg) c0189d5.a(q4, c0493p4, cg, c0189d5.f952a);
        }
        return new Ag(context, bg);
    }
}
