package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ni  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0461ni implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f985a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0461ni(C0735yi c0735yi, ModuleEvent moduleEvent) {
        this.b = c0735yi;
        this.f985a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportEvent(this.f985a);
    }
}
