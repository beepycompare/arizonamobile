package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes5.dex */
public final class Kc {

    /* renamed from: a  reason: collision with root package name */
    public int f632a = 5;
    public final C0202e b;

    public Kc(InterfaceC0307i0 interfaceC0307i0) {
        this.b = new C0202e(new C0241fc(interfaceC0307i0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0202e c0202e = this.b;
        c0202e.f957a.add(new InterfaceC0151c() { // from class: io.appmetrica.analytics.impl.Kc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0151c
            public final void onAppNotResponding() {
                Kc.b(AnrListener.this);
            }
        });
    }
}
