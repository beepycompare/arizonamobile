package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Bc {

    /* renamed from: a  reason: collision with root package name */
    public int f354a = 5;
    public final C0218e b;

    public Bc(InterfaceC0219e0 interfaceC0219e0) {
        this.b = new C0218e(new Wb(interfaceC0219e0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0218e c0218e = this.b;
        c0218e.f813a.add(new InterfaceC0167c() { // from class: io.appmetrica.analytics.impl.Bc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0167c
            public final void onAppNotResponding() {
                Bc.b(AnrListener.this);
            }
        });
    }
}
