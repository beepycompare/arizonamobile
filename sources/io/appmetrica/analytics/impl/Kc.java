package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes5.dex */
public final class Kc {

    /* renamed from: a  reason: collision with root package name */
    public int f627a = 5;
    public final C0209e b;

    public Kc(InterfaceC0314i0 interfaceC0314i0) {
        this.b = new C0209e(new C0248fc(interfaceC0314i0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0209e c0209e = this.b;
        c0209e.f952a.add(new InterfaceC0158c() { // from class: io.appmetrica.analytics.impl.Kc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0158c
            public final void onAppNotResponding() {
                Kc.b(AnrListener.this);
            }
        });
    }
}
