package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0399ld extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0474od f993a;
    public final /* synthetic */ boolean b;

    public C0399ld(C0474od c0474od, boolean z) {
        this.f993a = c0474od;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0474od.a(this.f993a).a(this.b, false);
    }
}
