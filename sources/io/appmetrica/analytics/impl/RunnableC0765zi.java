package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0765zi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f1194a;

    public RunnableC0765zi(Ci ci) {
        this.f1194a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f1194a;
        Ci.a(ci.f393a, ci.d, ci.e).clearAppEnvironment();
    }
}
