package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0308hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f907a;

    public RunnableC0308hi(Ci ci) {
        this.f907a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f907a;
        Ci.a(ci.f388a, ci.d, ci.e).pauseSession();
    }
}
