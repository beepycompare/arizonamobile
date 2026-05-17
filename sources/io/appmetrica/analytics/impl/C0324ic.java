package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.ic  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0324ic {

    /* renamed from: a  reason: collision with root package name */
    public int f1048a = 5;
    public final C0207e b;

    public C0324ic(InterfaceC0260g0 interfaceC0260g0) {
        this.b = new C0207e(new Db(interfaceC0260g0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0207e c0207e = this.b;
        c0207e.f970a.add(new InterfaceC0156c() { // from class: io.appmetrica.analytics.impl.ic$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0156c
            public final void onAppNotResponding() {
                C0324ic.b(AnrListener.this);
            }
        });
    }
}
