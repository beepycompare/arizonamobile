package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Dc {

    /* renamed from: a  reason: collision with root package name */
    public int f396a = 5;
    public final C0218e b;

    public Dc(InterfaceC0219e0 interfaceC0219e0) {
        this.b = new C0218e(new Yb(interfaceC0219e0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0218e c0218e = this.b;
        c0218e.f823a.add(new InterfaceC0167c() { // from class: io.appmetrica.analytics.impl.Dc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0167c
            public final void onAppNotResponding() {
                Dc.b(AnrListener.this);
            }
        });
    }
}
