package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.pd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0499pd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0623ud f1057a;
    public final /* synthetic */ ModuleEvent b;

    public C0499pd(C0623ud c0623ud, ModuleEvent moduleEvent) {
        this.f1057a = c0623ud;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0623ud.a(this.f1057a).reportEvent(this.b);
    }
}
