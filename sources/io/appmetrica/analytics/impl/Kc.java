package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes5.dex */
public final class Kc {

    /* renamed from: a  reason: collision with root package name */
    public int f629a = 5;
    public final C0207e b;

    public Kc(InterfaceC0312i0 interfaceC0312i0) {
        this.b = new C0207e(new C0246fc(interfaceC0312i0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0207e c0207e = this.b;
        c0207e.f954a.add(new InterfaceC0156c() { // from class: io.appmetrica.analytics.impl.Kc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0156c
            public final void onAppNotResponding() {
                Kc.b(AnrListener.this);
            }
        });
    }
}
