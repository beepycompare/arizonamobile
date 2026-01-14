package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0202di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0279gi f961a;

    public RunnableC0202di(C0279gi c0279gi) {
        this.f961a = c0279gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.f961a;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).clearAppEnvironment();
    }
}
