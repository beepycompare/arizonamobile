package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0764zi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f1193a;

    public RunnableC0764zi(Ci ci) {
        this.f1193a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f1193a;
        Ci.a(ci.f392a, ci.d, ci.e).clearAppEnvironment();
    }
}
