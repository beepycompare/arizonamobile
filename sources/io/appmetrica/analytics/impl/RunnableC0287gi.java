package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0287gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f857a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0287gi(C0560ri c0560ri, ModuleEvent moduleEvent) {
        this.b = c0560ri;
        this.f857a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportEvent(this.f857a);
    }
}
