package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.xd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0705xd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bd f1124a;
    public final /* synthetic */ ModuleEvent b;

    public C0705xd(Bd bd, ModuleEvent moduleEvent) {
        this.f1124a = bd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Bd.a(this.f1124a).reportEvent(this.b);
    }
}
