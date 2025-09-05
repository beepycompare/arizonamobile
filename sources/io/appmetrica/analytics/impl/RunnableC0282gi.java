package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0282gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f894a;

    public RunnableC0282gi(Ci ci) {
        this.f894a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f894a;
        Ci.a(ci.f388a, ci.d, ci.e).resumeSession();
    }
}
