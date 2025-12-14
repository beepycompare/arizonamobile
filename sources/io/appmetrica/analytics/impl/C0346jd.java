package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.jd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0346jd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0473od f1053a;
    public final /* synthetic */ ModuleEvent b;

    public C0346jd(C0473od c0473od, ModuleEvent moduleEvent) {
        this.f1053a = c0473od;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0473od.a(this.f1053a).reportEvent(this.b);
    }
}
