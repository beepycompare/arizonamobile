package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class Id extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nd f596a;
    public final /* synthetic */ ModuleEvent b;

    public Id(Nd nd, ModuleEvent moduleEvent) {
        this.f596a = nd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Nd.a(this.f596a).reportEvent(this.b);
    }
}
