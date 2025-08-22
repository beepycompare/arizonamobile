package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Bd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fd f362a;
    public final /* synthetic */ ModuleEvent b;

    public Bd(Fd fd, ModuleEvent moduleEvent) {
        this.f362a = fd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Fd.a(this.f362a).reportEvent(this.b);
    }
}
