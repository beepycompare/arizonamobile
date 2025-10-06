package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Ic {

    /* renamed from: a  reason: collision with root package name */
    public int f496a = 5;
    public final C0212e b;

    public Ic(InterfaceC0239f0 interfaceC0239f0) {
        this.b = new C0212e(new C0200dc(interfaceC0239f0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0212e c0212e = this.b;
        c0212e.f852a.add(new InterfaceC0161c() { // from class: io.appmetrica.analytics.impl.Ic$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0161c
            public final void onAppNotResponding() {
                Ic.b(AnrListener.this);
            }
        });
    }
}
