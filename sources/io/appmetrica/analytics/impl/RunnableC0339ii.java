package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ii  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0339ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f902a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0339ii(C0613ti c0613ti, ModuleEvent moduleEvent) {
        this.b = c0613ti;
        this.f902a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportEvent(this.f902a);
    }
}
