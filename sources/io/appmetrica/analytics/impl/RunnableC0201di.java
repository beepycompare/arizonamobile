package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0201di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0278gi f960a;

    public RunnableC0201di(C0278gi c0278gi) {
        this.f960a = c0278gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.f960a;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).clearAppEnvironment();
    }
}
