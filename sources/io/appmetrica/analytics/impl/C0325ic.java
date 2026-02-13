package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.ic  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0325ic {

    /* renamed from: a  reason: collision with root package name */
    public int f1043a = 5;
    public final C0208e b;

    public C0325ic(InterfaceC0261g0 interfaceC0261g0) {
        this.b = new C0208e(new Db(interfaceC0261g0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0208e c0208e = this.b;
        c0208e.f965a.add(new InterfaceC0157c() { // from class: io.appmetrica.analytics.impl.ic$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0157c
            public final void onAppNotResponding() {
                C0325ic.b(AnrListener.this);
            }
        });
    }
}
