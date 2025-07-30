package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Bd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dd f357a;
    public final /* synthetic */ boolean b;

    public Bd(Dd dd, boolean z) {
        this.f357a = dd;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Dd.a(this.f357a).b(this.b);
    }
}
