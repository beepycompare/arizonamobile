package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0120ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f804a;
    public final /* synthetic */ C0404li b;

    public RunnableC0120ai(C0404li c0404li, ModuleEvent moduleEvent) {
        this.b = c0404li;
        this.f804a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportEvent(this.f804a);
    }
}
