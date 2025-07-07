package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* loaded from: classes4.dex */
public final class Bc {

    /* renamed from: a  reason: collision with root package name */
    public int f353a = 5;
    public final C0226e b;

    public Bc(InterfaceC0227e0 interfaceC0227e0) {
        this.b = new C0226e(new Wb(interfaceC0227e0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0226e c0226e = this.b;
        c0226e.f812a.add(new InterfaceC0175c() { // from class: io.appmetrica.analytics.impl.Bc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0175c
            public final void onAppNotResponding() {
                Bc.b(AnrListener.this);
            }
        });
    }
}
