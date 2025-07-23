package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0496p1 f616a;

    public R0(C0496p1 c0496p1) {
        this.f616a = c0496p1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.f616a).sendEventsBuffer();
    }
}
