package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0283gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ci f899a;

    public RunnableC0283gi(Ci ci) {
        this.f899a = ci;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.f899a;
        Ci.a(ci.f393a, ci.d, ci.e).resumeSession();
    }
}
