package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Hh implements InterfaceC0440n4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0236f5 f508a;

    public Hh(InterfaceC0236f5 interfaceC0236f5) {
        this.f508a = interfaceC0236f5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0440n4
    /* renamed from: b */
    public final Fg a(Context context, C0365k5 c0365k5, X3 x3, C0664w4 c0664w4) {
        Gg gg;
        X4 x4 = new X4(x3.b, x3.f751a);
        Hg hg = new Hg(this.f508a);
        synchronized (c0365k5) {
            gg = (Gg) c0365k5.a(x4, c0664w4, hg, c0365k5.f967a);
        }
        return new Fg(context, gg);
    }
}
