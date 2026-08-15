package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes5.dex */
public final class Kc {

    /* renamed from: a  reason: collision with root package name */
    public int f629a = 5;
    public final C0208e b;

    public Kc(InterfaceC0313i0 interfaceC0313i0) {
        this.b = new C0208e(new C0247fc(interfaceC0313i0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0208e c0208e = this.b;
        c0208e.f954a.add(new InterfaceC0157c() { // from class: io.appmetrica.analytics.impl.Kc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0157c
            public final void onAppNotResponding() {
                Kc.b(AnrListener.this);
            }
        });
    }
}
