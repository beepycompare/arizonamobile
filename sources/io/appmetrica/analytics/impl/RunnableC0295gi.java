package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0295gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f856a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0295gi(C0568ri c0568ri, ModuleEvent moduleEvent) {
        this.b = c0568ri;
        this.f856a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).reportEvent(this.f856a);
    }
}
