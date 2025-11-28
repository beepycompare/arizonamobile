package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0498pc {

    /* renamed from: a  reason: collision with root package name */
    public int f1056a = 5;
    public final C0204e b;

    public C0498pc(InterfaceC0257g0 interfaceC0257g0) {
        this.b = new C0204e(new Kb(interfaceC0257g0));
    }

    public static final void b(AnrListener anrListener) {
        anrListener.onAppNotResponding();
    }

    public final void a(final AnrListener anrListener) {
        C0204e c0204e = this.b;
        c0204e.f852a.add(new InterfaceC0153c() { // from class: io.appmetrica.analytics.impl.pc$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0153c
            public final void onAppNotResponding() {
                C0498pc.b(AnrListener.this);
            }
        });
    }
}
