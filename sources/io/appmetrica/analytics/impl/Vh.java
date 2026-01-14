package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f830a;
    public final /* synthetic */ C0279gi b;

    public Vh(C0279gi c0279gi, ModuleEvent moduleEvent) {
        this.b = c0279gi;
        this.f830a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).reportEvent(this.f830a);
    }
}
