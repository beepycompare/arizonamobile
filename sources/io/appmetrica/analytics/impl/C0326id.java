package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.id  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0326id extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0452nd f1044a;
    public final /* synthetic */ ModuleEvent b;

    public C0326id(C0452nd c0452nd, ModuleEvent moduleEvent) {
        this.f1044a = c0452nd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0452nd.a(this.f1044a).reportEvent(this.b);
    }
}
