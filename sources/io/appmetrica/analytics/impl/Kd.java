package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class Kd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nd f627a;
    public final /* synthetic */ boolean b;

    public Kd(Nd nd, boolean z) {
        this.f627a = nd;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Nd.a(this.f627a).a(this.b, false);
    }
}
