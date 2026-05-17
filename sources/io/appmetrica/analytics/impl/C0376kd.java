package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.kd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0376kd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0451nd f1086a;
    public final /* synthetic */ boolean b;

    public C0376kd(C0451nd c0451nd, boolean z) {
        this.f1086a = c0451nd;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0451nd.a(this.f1086a).a(this.b, false);
    }
}
