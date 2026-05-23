package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0513pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f1147a;
    public final /* synthetic */ Ai b;

    public RunnableC0513pi(Ai ai, ModuleEvent moduleEvent) {
        this.b = ai;
        this.f1147a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f460a, ai.d, ai.e).reportEvent(this.f1147a);
    }
}
