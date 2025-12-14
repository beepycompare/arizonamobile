package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0398ld extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0473od f1090a;
    public final /* synthetic */ boolean b;

    public C0398ld(C0473od c0473od, boolean z) {
        this.f1090a = c0473od;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0473od.a(this.f1090a).a(this.b, false);
    }
}
