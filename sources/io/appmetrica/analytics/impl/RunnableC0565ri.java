package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ri  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0565ri implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f1069a;
    public final /* synthetic */ Ci b;

    public RunnableC0565ri(Ci ci, ModuleEvent moduleEvent) {
        this.b = ci;
        this.f1069a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f393a, ci.d, ci.e).reportEvent(this.f1069a);
    }
}
