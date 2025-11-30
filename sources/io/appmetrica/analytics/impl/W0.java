package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class W0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0611u1 f730a;

    public W0(C0611u1 c0611u1) {
        this.f730a = c0611u1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.f730a).sendEventsBuffer();
    }
}
