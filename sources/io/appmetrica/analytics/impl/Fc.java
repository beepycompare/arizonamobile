package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Fc {

    /* renamed from: a  reason: collision with root package name */
    public int f433a = 5;
    public final C0211e b;

    public Fc(InterfaceC0212e0 interfaceC0212e0) {
        this.b = new C0211e(new C0121ac(interfaceC0212e0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0211e c0211e = this.b;
        c0211e.f835a.add(new InterfaceC0160c() { // from class: io.appmetrica.analytics.impl.Fc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0160c
            public final void onAppNotResponding() {
                Fc.b(AnrListener.this);
            }
        });
    }
}
