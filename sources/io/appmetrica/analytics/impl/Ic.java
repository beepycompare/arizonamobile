package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Ic {

    /* renamed from: a  reason: collision with root package name */
    public int f496a = 5;
    public final C0211e b;

    public Ic(InterfaceC0238f0 interfaceC0238f0) {
        this.b = new C0211e(new C0199dc(interfaceC0238f0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0211e c0211e = this.b;
        c0211e.f852a.add(new InterfaceC0160c() { // from class: io.appmetrica.analytics.impl.Ic$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0160c
            public final void onAppNotResponding() {
                Ic.b(AnrListener.this);
            }
        });
    }
}
