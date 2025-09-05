package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Ed extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Jd f423a;
    public final /* synthetic */ ModuleEvent b;

    public Ed(Jd jd, ModuleEvent moduleEvent) {
        this.f423a = jd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Jd.a(this.f423a).reportEvent(this.b);
    }
}
