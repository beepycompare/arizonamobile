package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0494p1 f601a;

    public R0(C0494p1 c0494p1) {
        this.f601a = c0494p1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.f601a).sendEventsBuffer();
    }
}
