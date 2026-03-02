package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f829a;
    public final /* synthetic */ C0278gi b;

    public Vh(C0278gi c0278gi, ModuleEvent moduleEvent) {
        this.b = c0278gi;
        this.f829a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).reportEvent(this.f829a);
    }
}
