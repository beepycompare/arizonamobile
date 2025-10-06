package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0309hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f912a;

    public RunnableC0309hi(Ci ci) {
        this.f912a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f912a;
        Ci.a(ci.f393a, ci.d, ci.e).pauseSession();
    }
}
