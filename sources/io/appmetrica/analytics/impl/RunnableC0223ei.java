package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0223ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0301hi f873a;

    public RunnableC0223ei(C0301hi c0301hi) {
        this.f873a = c0301hi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.f873a;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).clearAppEnvironment();
    }
}
