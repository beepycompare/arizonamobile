package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0757zd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dd f1170a;
    public final /* synthetic */ ModuleEvent b;

    public C0757zd(Dd dd, ModuleEvent moduleEvent) {
        this.f1170a = dd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Dd.a(this.f1170a).reportEvent(this.b);
    }
}
