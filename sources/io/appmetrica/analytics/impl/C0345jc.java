package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.jc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0345jc {

    /* renamed from: a  reason: collision with root package name */
    public int f1052a = 5;
    public final C0203e b;

    public C0345jc(InterfaceC0256g0 interfaceC0256g0) {
        this.b = new C0203e(new Eb(interfaceC0256g0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0203e c0203e = this.b;
        c0203e.f956a.add(new InterfaceC0152c() { // from class: io.appmetrica.analytics.impl.jc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0152c
            public final void onAppNotResponding() {
                C0345jc.b(AnrListener.this);
            }
        });
    }
}
