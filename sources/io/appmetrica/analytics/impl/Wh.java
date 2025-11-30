package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* loaded from: classes5.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f741a;
    public final /* synthetic */ C0301hi b;

    public Wh(C0301hi c0301hi, ModuleEvent moduleEvent) {
        this.b = c0301hi;
        this.f741a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportEvent(this.f741a);
    }
}
