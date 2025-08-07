package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Dc {

    /* renamed from: a  reason: collision with root package name */
    public int f395a = 5;
    public final C0219e b;

    public Dc(InterfaceC0220e0 interfaceC0220e0) {
        this.b = new C0219e(new Yb(interfaceC0220e0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0219e c0219e = this.b;
        c0219e.f822a.add(new InterfaceC0168c() { // from class: io.appmetrica.analytics.impl.Dc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0168c
            public final void onAppNotResponding() {
                Dc.b(AnrListener.this);
            }
        });
    }
}
