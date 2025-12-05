package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f824a;
    public final /* synthetic */ C0300hi b;

    public Wh(C0300hi c0300hi, ModuleEvent moduleEvent) {
        this.b = c0300hi;
        this.f824a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).reportEvent(this.f824a);
    }
}
