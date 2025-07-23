package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0338ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f902a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0338ii(C0612ti c0612ti, ModuleEvent moduleEvent) {
        this.b = c0612ti;
        this.f902a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).reportEvent(this.f902a);
    }
}
