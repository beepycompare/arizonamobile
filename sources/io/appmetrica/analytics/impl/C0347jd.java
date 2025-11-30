package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.jd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0347jd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0474od f956a;
    public final /* synthetic */ ModuleEvent b;

    public C0347jd(C0474od c0474od, ModuleEvent moduleEvent) {
        this.f956a = c0474od;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0474od.a(this.f956a).reportEvent(this.b);
    }
}
